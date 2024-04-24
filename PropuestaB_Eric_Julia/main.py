############################################################
# 1. Librerias
############################################################
import base64
import sys
import os
import flask
import db
from models import Usuario, Serie, Pelicula, Favorito, Visto, RegistroForm, LoginForm
from sqlalchemy import and_, or_, text, func
from flask import Flask, render_template, url_for, redirect, request, Response
from flask_login import UserMixin, login_user, LoginManager, login_required, logout_user, current_user
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField
from wtforms.validators import Length, ValidationError
from flask_bcrypt import Bcrypt
from datetime import date, datetime, timezone
import pytz

import io
import random
from flask import Response
from matplotlib.backends.backend_agg import FigureCanvasAgg
from matplotlib.figure import Figure
import matplotlib.pyplot as plt


############################################################
# 2. Flask config objects
############################################################

app = Flask(__name__) # Objeto flask para levantar srv

# LoginManager class (para que app y flask_login trabajen juntos)
login_manager = LoginManager()
login_manager.init_app(app)
login_manager.login_view = 'login'
login_manager.login_message = r"Por favor, inicie sessión para ver el contenido"


############################################################
# 3. DB Config
############################################################

bcrypt = Bcrypt(app) # Objeto para encriptar las pwd
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///usuarios.db'
#app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.config['SECRET_KEY'] = os.urandom(12).hex()

#db = SQLAlchemy(app) delete


############################################################
# 4. Funciones
############################################################

# Gestion de usuario
@login_manager.user_loader
def load_user(user_id):
    #return Usuario.query.get(int(user_id)) delete
    return db.session.query(Usuario).get(int(user_id))

# Pagina Home
@app.route("/", methods=["GET", "POST"])
def home():
    return render_template("casahom.html")

# Pagina de login
@app.route('/login', methods=['GET', 'POST'])
def login():
    form = LoginForm()
    error_credencial = "" # inicializamod variable de control de error
    if form.validate_on_submit():
        #user = Usuario.query.filter_by(username=form.username.data).first() - delete
        user = db.session.query(Usuario).filter_by(username=form.username.data).first()
        #print(user.id)
        if user:
            if bcrypt.check_password_hash(user.password, form.password.data): # comparamos pwd introducida con pwd de db
                login_user(user)
                return redirect(url_for("index"))
            else:
                # Condicional para que si introducen el usuario admin, no de info
                # sensible del usuario administrador que hay en el sistema
                if form.username.data > "admin":
                    error_credencial = f"Usuario '{form.username.data}' no existe en la base de datos"
                else:
                    error_credencial = "La password introducida no es correcta"
        else:
                error_credencial = f"Usuario '{form.username.data}' no existe en la base de datos"
    return render_template("login.html", form=form, codigo_error=error_credencial)

# Pagina Index (logged in)
@app.route("/index", methods=["GET", "POST"])
@login_required
def index():
    #return render_template("index.html", pestana="series")
    return redirect(url_for("series"))

# Logout (las cookies se eliminan)
@app.route("/logout", methods=['GET', 'POST'])
@login_required
def logout():
    logout_user()
    return redirect(url_for("login"))

# Formulario para registro
@app.route("/registro", methods=["GET", "POST"])
def registro():
    form = RegistroForm()
    #print("funcio registro")

    if form.validate_on_submit(): # Check if it is a POST request and if it is valid
        #print("condicional validacio formulari")
        hashed_password = bcrypt.generate_password_hash(form.password.data)
        fecha_actual    = date.today()
        alta_usuario = Usuario(nombre=form.nombre.data,
                               apellidos=form.apellidos.data,
                               email=form.email.data,
                               username=form.username.data,
                               password=hashed_password,
                               fecha_alta=fecha_actual)
        db.session.add(alta_usuario)
        db.session.commit()
        #print("abans de fer el redirect al login")
        return redirect(url_for('login'))

    return render_template("registro.html", form=form)


# Menus del index.html una vez estamos logueados
# para ver el contenido de la web
@app.route("/buscador", methods=["POST"])
def buscador():
    string = request.form["texto"]
    if string:
        q_series = db.session.query(Serie).filter(Serie.nombre.contains(string))
        q_pelis  = db.session.query(Pelicula).filter(Pelicula.nombre.contains(string))
        contingut_buscador = []
        for serie in q_series:
            q_serie_detall = db.session.query(Serie).filter_by(nombre=serie.nombre).first()
            contingut_buscador.append(q_detall)
        for peli in q_pelis:
            q_peli_detall = db.session.query(Pelicula).filter_by(nombre=peli.nombre).first()
            contingut_buscador.append(q_detall)
        return render_template("index.html", pestana="buscador", contenido=contingut_buscador)
    else:
        return redirect(url_for("series"))

@app.route("/series", methods=["GET", "POST"])
def series():
    info_query = db.session.query(Serie).all()
    contenido = []
    for serie in info_query:  # creamos una lista de dict
        contenido.append(serie.__dict__)

    return render_template("index.html", pestana="series", tipo="general", contenido=contenido)

@app.route("/peliculas", methods=["GET", "POST"])
def peliculas():
    info_query = db.session.query(Pelicula).all()
    contenido = []
    for peli in info_query:  # creamos una lista de dict
        contenido.append(peli.__dict__)
    return render_template("index.html", pestana="peliculas", tipo="general", contenido=contenido)

@app.route("/favoritos/<usuario>", methods=["GET", "POST"])
def favoritos(usuario):
    #print(flask.request.method)
    #print(usuario)
    q_user = db.session.query(Usuario).filter_by(username=usuario).first()
    info_query = db.session.query(Favorito).filter_by(id_usuario=int(q_user.id)).all()
    contenido_all = []
    for favorito in info_query:  # creamos una lista de dict
        if favorito.id_serie:
            info_serie = db.session.query(Serie).filter_by(id=int(favorito.id_serie)).first()
            dict = {
                "id": info_serie.id,
                "nombre": info_serie.nombre,
                "tipo": "serie"
            }
            contenido_all.append(dict)
        if favorito.id_pelicula:
            info_peli = db.session.query(Pelicula).filter_by(id=int(favorito.id_pelicula)).first()
            dict = {
                "id": info_peli.id,
                "nombre": info_peli.nombre,
                "tipo": "peli"
            }
            contenido_all.append(dict)
    return render_template("index.html", pestana="favoritos", tipo="general", contenido=contenido_all)

@app.route("/add_favoritos/<usuario>/<tipo>/<id_streaming>", methods=["GET"])
def add_favoritos(usuario, tipo, id_streaming):
    #print(flask.request.method)

    if tipo == "serie":
        q_usuario  = db.session.query(Usuario).filter_by(username=str(usuario)).first() # sacamos el id
        q_favorito = db.session.query(Favorito).filter_by(id_serie=int(id_streaming), id_usuario=int(q_usuario.id)).first()

        if q_favorito: # SI existe entrada, la eliminamos
            db.session.delete(q_favorito)
            db.session.commit()
            db.session.close()
        else: # si NO existe entrada, la creamos
            anadir_favorito = Favorito(id_serie=int(id_streaming), id_pelicula=0, id_usuario=int(q_usuario.id))
            db.session.add(anadir_favorito)
            db.session.commit()
            db.session.close()

        return redirect(url_for("detalle_contenido", tipo="serie", id=int(id_streaming), usuario=usuario))
    else:  # peli
        q_usuario  = db.session.query(Usuario).filter_by(username=str(usuario)).first() # sacamos el id
        q_favorito = db.session.query(Favorito).filter_by(id_pelicula=int(id_streaming), id_usuario=int(q_usuario.id)).first()

        if q_favorito: # SI existe entrada, la eliminamos
            db.session.delete(q_favorito)
            db.session.commit()
            db.session.close()
        else: # si NO existe entrada, la creamos
            anadir_favorito = Favorito(id_serie=0, id_pelicula=int(id_streaming), id_usuario=int(q_usuario.id))
            db.session.add(anadir_favorito)
            db.session.commit()
            db.session.close()

        return redirect(url_for("detalle_contenido", tipo="peli", id=int(id_streaming), usuario=usuario))

@app.route("/vistos/<usuario>", methods=["GET", "POST"])
def vistos(usuario):
    #print(flask.request.method)
    #print(usuario)
    q_user = db.session.query(Usuario).filter_by(username=usuario).first()
    info_query = db.session.query(Visto).filter_by(id_usuario=int(q_user.id)).all()
    contenido_all = []
    #print(len(contenido_all))
    for visto in info_query:  # creamos una lista de dict
        if visto.id_serie:
            info_serie = db.session.query(Serie).filter_by(id=int(visto.id_serie)).first()
            dict = {
                "id": info_serie.id,
                "nombre": info_serie.nombre,
                "tipo": "serie"
            }
            contenido_all.append(dict)
        if visto.id_pelicula:
            info_peli = db.session.query(Pelicula).filter_by(id=int(visto.id_pelicula)).first()
            dict = {
                "id": info_peli.id,
                "nombre": info_peli.nombre,
                "tipo": "peli"
            }
            contenido_all.append(dict)
        #print(len(contenido_all))
        if visto.id_pelicula == "Pelicula":
            variable = "This if is for Serie values"
        else:
            variable = "This if is for Pelicula values"
    return render_template("index.html", pestana="vistos", tipo="general", contenido=contenido_all)

@app.route("/add_visto/<usuario>/<tipo>/<id_streaming>", methods=["GET"])
def add_visto(usuario, tipo, id_streaming):
    #print(flask.request.method)

    if tipo == "serie":
        q_usuario  = db.session.query(Usuario).filter_by(username=str(usuario)).first() # sacamos el id
        q_visto = db.session.query(Visto).filter_by(id_serie=int(id_streaming), id_usuario=int(q_usuario.id)).first()

        if q_visto: # SI existe entrada, la eliminamos
            db.session.delete(q_visto)
            db.session.commit()
            db.session.close()
        else: # si NO existe entrada, la creamos
            anadir_visto = Visto(id_serie=int(id_streaming), id_pelicula=0, id_usuario=int(q_usuario.id))
            db.session.add(anadir_visto)
            db.session.commit()
            db.session.close()

        return redirect(url_for("detalle_contenido", tipo="serie", id=int(id_streaming), usuario=usuario))
    else:  # peli
        q_usuario  = db.session.query(Usuario).filter_by(username=str(usuario)).first() # sacamos el id
        q_visto = db.session.query(Visto).filter_by(id_pelicula=int(id_streaming), id_usuario=int(q_usuario.id)).first()

        if q_visto: # SI existe entrada, la eliminamos
            db.session.delete(q_visto)
            db.session.commit()
            db.session.close()
        else: # si NO existe entrada, la creamos
            anadir_visto = Visto(id_serie=0, id_pelicula=int(id_streaming), id_usuario=int(q_usuario.id))
            db.session.add(anadir_visto)
            db.session.commit()
            db.session.close()

        return redirect(url_for("detalle_contenido", tipo="peli", id=int(id_streaming), usuario=usuario))

@app.route("/detalle_contenido/<tipo>/<id>/<usuario>", methods=["GET", "POST"])
def detalle_contenido(tipo, id, usuario):
    if tipo == "serie":
        info_query = db.session.query(Serie).filter_by(id=int(id)).first()
        # Revisamos si el contenido es favorito o no
        id_user  = db.session.query(Usuario).filter_by(username=str(usuario)).first()
        favorito = db.session.query(Favorito).filter_by(id_serie=id, id_usuario=id_user.id).first()
        visto    = db.session.query(Visto).filter_by(id_serie=id, id_usuario=id_user.id).first()
        return render_template("index.html", pestana="series", tipo="detalle", contenido=info_query, favorito=favorito, visto=visto)
    else: # peli
        info_query = db.session.query(Pelicula).filter_by(id=int(id)).first()
        # Revisamos si el contenido es favorito o no
        id_user  = db.session.query(Usuario).filter_by(username=str(usuario)).first()
        favorito = db.session.query(Favorito).filter_by(id_pelicula=id, id_usuario=id_user.id).first()
        visto    = db.session.query(Visto).filter_by(id_pelicula=id, id_usuario=id_user.id).first()
        return render_template("index.html", pestana="peliculas", tipo="detalle", contenido=info_query, favorito=favorito, visto=visto)

@app.route("/caratula/<tipo>/<id>", methods=["GET", "POST"])
def caratula(tipo, id):
    #print(id)
    if tipo == "serie":
        serie = db.session.query(Serie).filter_by(id=int(id)).first()
        caratula = serie.caratula
    else: # peli
        peli = db.session.query(Pelicula).filter_by(id=int(id)).first()
        caratula = peli.caratula
    return Response(caratula, mimetype="image/jpg")

@app.route("/usuarios", defaults={"mensaje_pantalla": ""}, methods=["GET", "POST"])
@app.route("/usuarios/<mensaje_pantalla>", methods=["GET", "POST"])
def usuarios(mensaje_pantalla):
    #print("---->", request.method)
    if request.method == "GET": # Cargar pestana formulario
        q_general = db.session.query(Usuario).all()
        contenido = []
        for user in q_general:  # creamos una lista de dict
            contenido.append(user.__dict__)
        return render_template("index.html", pestana="usuarios", tipo="general", contenido=contenido, mensaje_pantalla=mensaje_pantalla)
    if request.method == "POST": # Cargar detalle usuario enviado por form
        if request.form["usuario"] == "menu_form": # Para evitar error si user envia form con valor default
            q_general = db.session.query(Usuario).all()
            contenido = []
            for user in q_general:  # creamos una lista de dict
                contenido.append(user.__dict__)
            return render_template("index.html", pestana="usuarios", tipo="general", contenido=contenido)
        # Todos los users para hacer busqueda al formulario de la web
        q_general = db.session.query(Usuario).all()
        contenido = []
        for user in q_general:  # creamos una lista de dict
            contenido.append(user.__dict__)

        # Detalle del usuario que hemos solicitado
        #print(request.form["usuario"])
        #print(type(request.form["usuario"]))
        usuario = request.form["usuario"]
        usuario = usuario.replace(" ", "")
        #print(type(usuario))
        #print(f"({usuario})")
        q_detalle = db.session.query(Usuario).filter_by(username=usuario).first()
        #print(len(q_detalle.nombre))
        #print(type(q_detalle))
        #print(q_detalle.email)
        return render_template("index.html", pestana="usuarios", tipo="detalle", contenido=contenido, usuario=q_detalle.__dict__)

@app.route("/borrar_usuario", methods=["POST"])
def borrar_usuario():
    usuario = request.form["username"]
    usuario = usuario.replace(" ", "")
    #print("----------", usuario)
    q_usuario_borrar = db.session.query(Usuario).filter_by(username=usuario).first()
    db.session.delete(q_usuario_borrar)
    db.session.commit()
    db.session.close()
    return redirect(url_for("usuarios", mensaje_pantalla=f"Se ha borrado el usuario {usuario}"))

@app.route("/grafica/<tipo>/<user>", methods=["GET", "POST"])
def grafica(tipo, user):
    #print("Usuari rebut per la grafica---> ", user, "del tipus--> ", tipo)
    q_id_user = db.session.query(Usuario).filter_by(username=user).first()
    #print(q_id_user.id)

    if tipo == "serie":
        titulo   = f"Series de {user}"
        colores  = ['tab:blue', 'tab:green']

        # Queries favoritos
        q_series_favoritas = db.session.query(Favorito).filter_by(id_usuario = q_id_user.id).filter(Favorito.id_serie > 0)
        favorito_count = 0
        for num in q_series_favoritas:
            favorito_count += 1

        # Queries Vistas
        q_series_vistas = db.session.query(Visto).filter_by(id_usuario = q_id_user.id).filter(Visto.id_serie > 0)
        visto_count = 0
        for num in q_series_vistas:
            visto_count += 1
    else: # pelis
        titulo = f"Peliculas de {user}"
        colores = ['tab:grey', 'tab:orange']

        # Queries favoritos
        q_pelis_favoritas = db.session.query(Favorito).filter_by(id_usuario = q_id_user.id).filter(Favorito.id_pelicula > 0)
        favorito_count = 0
        for num in q_pelis_favoritas:
            favorito_count += 1

        # Queries vistas
        q_pelis_vistas = db.session.query(Visto).filter_by(id_usuario=q_id_user.id).filter(Visto.id_pelicula > 0)
        visto_count = 0
        for num in q_pelis_vistas:
            visto_count += 1

    def creamos_figura(favorito_count, visto_count):
        fig, ax = plt.subplots()

        tipo = ['favoritas', 'vistas']
        counts = [favorito_count, visto_count]
        bar_labels = ['favoritas', 'vistas']
        bar_colors = colores

        ax.bar(tipo, counts, label=bar_labels, color=bar_colors)

        ax.set_ylabel('cantidad')
        ax.set_title(titulo)
        ax.legend(title='Leyenda')
        return fig

    fig = creamos_figura(favorito_count, visto_count)
    output = io.BytesIO()
    FigureCanvas(fig).print_png(output)
    return Response(output.getvalue(), mimetype='image/png')

#@app.route("/contenido/", defaults={"mensaje_pantalla": "", "nivel": "", "contenido": ""}, methods=["GET", "POST"])
#@app.route("/contenido/<mensaje_pantalla>/", methods=["GET", "POST"]) # para gestionar contenido (CRUD)
@app.route("/contenido/", methods=["GET", "POST"]) # para gestionar contenido (CRUD)
def contenido():
    if request.method == "POST": # si le damos algun boton de accion accion (crear, editar, borrar o venimos de otra funcion del main.py)
        if request.form["tipo"] == "menu": # evitar que haga submit (y falle) con opcion seleccionada por defecto del form select
            return render_template("index.html", pestana="contenido")
        else:
            #print(request.form["accion"])

            q_series = db.session.query(Serie).all()
            contenido_serie = []
            for serie in q_series:
                contenido_serie.append(serie.__dict__)

            q_pelis  = db.session.query(Pelicula).all()
            contenido_peli = []
            for peli in q_pelis:
                contenido_peli.append(peli.__dict__)

            return render_template("index.html", pestana="contenido", tipo=request.form["tipo"], accion=request.form["accion"], contenido_serie=contenido_serie, contenido_peli=contenido_peli) # tipo: serie o peli / accion: crear, editar, borrar
    else: # si no, carga el menu inicial de la pestana Contenido
        return render_template("index.html", pestana="contenido")

    hipotenusa = math.sqrt((3.5/2) + (4.9**2))

@app.route("/crud/<tipo>/<accion>", methods=["POST"])
def crud(tipo, accion):
    if tipo == "serie":
        if accion == "crear":

            caratula = request.files["caratula"]
            #caratula = request.files.get("caratula")

            serie_obj = Serie(
                nombre=request.form["nombre"],
                descripcion=request.form["descripcion"],
                duracion=int(request.form["duracion"]),
                categoria=request.form["categoria"],
                url=f'https://www.youtube.com/embed/{request.form["url"]}',
                temporadas=int(request.form["temporadas"]),
                capitulos=int(request.form["capitulos"]),
                caratula=caratula.read()
            )
            db.session.add(serie_obj)
            db.session.commit()
            db.session.close()
            return render_template("index.html", pestana="contenido", mensaje_pantalla=f"Se ha creado la serie {request.form['nombre']}")
        elif accion == "editar":
            #print("inici_elif editar")
            #print(f'request.form["nivel"] --> ({request.form["nivel"]}) ({type(request.form["nivel"])})')
            if int(request.form["nivel"]) == 1:
                q_serie_editar = db.session.query(Serie).filter_by(nombre=request.form["serie_a_editar"]).first()
                return render_template("index.html", pestana="contenido", tipo="serie", accion="Editar", nivel=2, contenido=q_serie_editar)
            elif int(request.form["nivel"]) == 2:
                q_serie = db.session.query(Serie).filter_by(nombre=request.form["serie_a_editar"]).first()
                campos_actualizados = []
                if request.form["nombre"]:
                    q_serie.nombre = request.form["nombre"]
                    campos_actualizados.append("nombre")
                if request.form["descripcion"]:
                    q_serie.descripcion = request.form["descripcion"]
                    campos_actualizados.append("descripcion")
                if request.form["duracion"]:
                    q_serie.duracion = int(request.form["duracion"])
                    campos_actualizados.append("duracion")
                if request.form["categoria"]:
                    q_serie.categoria = request.form["categoria"]
                    campos_actualizados.append("categoria")
                if request.form["url"]:
                    q_serie.url = f'https://www.youtube.com/embed/{request.form["url"]}'
                    campos_actualizados.append("url")
                if request.form["temporadas"]:
                    q_serie.temporadas = int(request.form["temporadas"])
                    campos_actualizados.append("temporadas")
                if request.form["capitulos"]:
                    q_serie.capitulos = int(request.form["capitulos"])
                    campos_actualizados.append("capitulos")
                if request.files["caratula_edit"]:
                    q_serie.caratula = request.files["caratula_edit"].read()
                    campos_actualizados.append("caratula")
                db.session.commit()
                db.session.close()
                return render_template("index.html", pestana="contenido", mensaje_pantalla=f"Se ha editado la serie {request.form['serie_a_editar']} ({', '.join(campos_actualizados)}).")
        else: # borrar
            q_serie = db.session.query(Serie).filter_by(nombre=request.form["serie_a_borrar"]).first()
            db.session.delete(q_serie)
            db.session.commit()
            db.session.close()
            #return redirect(url_for("contenido", mensaje_pantalla=f"Se ha borrado la serie {request.form['serie_a_borrar']}"))
            return render_template("index.html", pestana="contenido", mensaje_pantalla=f"Se ha borrado la serie {request.form['serie_a_borrar']}")

    else: # peli
        if accion == "crear":

            caratula = request.files["caratula"]
            #caratula = request.files.get("caratula")

            peli_obj = Pelicula(
                nombre=request.form["nombre"],
                descripcion=request.form["descripcion"],
                duracion=int(request.form["duracion"]),
                categoria=request.form["categoria"],
                url=f'https://www.youtube.com/embed/{request.form["url"]}',
                caratula=caratula.read()
            )
            db.session.add(peli)
            db.session.commit()
            db.session.close()
            return render_template("index.html", pestana="contenido", mensaje_pantalla=f"Se ha creado la pelicula {request.form['nombre']}")
        elif accion == "editar":
            if int(request.form["nivel"]) == 1:
                q_peli_editar = db.session.query(Pelicula).filter_by(nombre=request.form["peli_a_editar"]).first()
                return render_template("index.html", pestana="contenido", tipo="peli", accion="Editar", nivel=2, contenido=q_peli_editar)
            elif int(request.form["nivel"]) == 2:
                q_peli = db.session.query(Pelicula).filter_by(nombre=request.form["peli_a_editar"]).first()
                campos_actualizados = []
                if request.form["nombre"]:
                    q_peli.nombre = request.form["nombre"]
                    campos_actualizados.append("nombre")
                if request.form["descripcion"]:
                    q_peli.descripcion = request.form["descripcion"]
                    campos_actualizados.append("descripcion")
                if request.form["duracion"]:
                    q_peli.duracion = int(request.form["duracion"])
                    campos_actualizados.append("duracion")
                if request.form["categoria"]:
                    q_peli.categoria = request.form["categoria"]
                    campos_actualizados.append("categoria")
                if request.form["url"]:
                    q_peli.url = f'https://www.youtube.com/embed/{request.form["url"]}'
                    campos_actualizados.append("url")
                if request.files["caratula_edit"]:
                    q_peli.caratula=request.files["caratula_edit"].read()
                    campos_actualizados.append("caratula")
                db.session.commit()
                db.session.close()
                return render_template("index.html", pestana="contenido", mensaje_pantalla=f"Se ha editado la pelicula {request.form['peli_a_editar']} ({', '.join(campos_actualizados)}).")
        else: # borrar
            q_peli = db.session.query(Pelicula).filter_by(nombre=request.form["peli_a_borrar"]).first()
            db.session.delete(q_peli)
            db.session.commit
            db.session.close
            return render_template("index.html", pestana="contenido",
                                   mensaje_pantalla=f"Se ha borrado la pelicula {request.form['peli_a_borrar']}")


############################################################
# 5. Main
############################################################

if __name__ == '__main__':

    # Elimina la db (si existe). Usado solo en fase test, luego se elimina
    #db.Base.metadata.drop_all(bind=db.engine, checkfirst=True)

    # SQLAlchemy creara (si no existen) las tablas de de todos
    # los modelos que encuentre en models.py
    db.Base.metadata.create_all(db.engine)

    # Arrancamos app
    app.run(debug=True) # True: modo DES, False: modo PROD

    # Creamos tabla
    #with app.app_context():
    #    db.create_all()
