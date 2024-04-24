from sqlalchemy import Column, Integer, String, Boolean, Date, BLOB, LargeBinary
import db
from flask import Flask, render_template, request, redirect, url_for, Blueprint, abort, flash
from flask_login import LoginManager, login_user, login_required, UserMixin, logout_user, current_user
from flask_sqlalchemy import SQLAlchemy
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, DateField, FileField
from wtforms.validators import InputRequired, Length, ValidationError, Optional
from flask_bcrypt import Bcrypt
from datetime import date, datetime, timezone


class Usuario(db.Base, UserMixin):

    # Nombre de la tabla
    __tablename__ = "usuario"

    # (opcional) Autoincrementa la PK de la tabla
    __table_args__ = {'sqlite_autoincrement': True}

    # Atributos
    id          = Column(Integer, primary_key=True)
    nombre      = Column(String(50), nullable=False) # not null (vacio)
    apellidos   = Column(String(200), nullable=False)
    email       = Column(String(50), nullable=False)
    username    = Column(String(20), nullable=False)
    password    = Column(String(80), nullable=False)
    fecha_alta  = Column(Date)

class Pelicula(db.Base): # Heredamos de la clase Padre: Base

    # Nombre de la tabla
    __tablename__  = "pelicula"

    # (opcional) Autoincrementa la PK de la tabla
    __table_args__ = {'sqlite_autoincrement': True}

    # Atributos
    id          = Column(Integer, primary_key=True)
    nombre      = Column(String(80), nullable=False)  # not null (vacio)
    descripcion = Column(String(1000), nullable=True)
    duracion    = Column(Integer, nullable=False) # en minutos
    categoria   = Column(String(15), nullable=False)
    url         = Column(String(100), nullable=True)
    caratula    = Column(BLOB) # https://sqlalchemy-media.dobisel.com/tutorials/image.html

    # Constructor
    def __init__(self, nombre, descripcion, duracion, categoria, url, caratula):
        self.nombre      = nombre
        self.descripcion = descripcion
        self.duracion    = duracion
        self.categoria   = categoria
        self.url         = url
        self.caratula    = caratula

    # Metodo string
    def __str__(self):
        return f"id: {self.id}" \
               f"nombre: {self.nombre}" \
               f"descripcion: {self.descripcion}" \
               f"duracion: {self.duracion}" \
               f"categoria: {self.categoria}" \
               f"url: {self.url}" \
               f"caratula: {self.caratula}"

class Serie(db.Base): # Heredamos de la clase Padre: Base

    # Nombre de la tabla
    __tablename__  = "serie"

    # (opcional) Autoincrementa la PK de la tabla
    __table_args__ = {'sqlite_autoincrement': True}

    # Atributos
    id          = Column(Integer, primary_key=True)
    nombre      = Column(String(80), nullable=False)  # not null (vacio)
    descripcion = Column(String(1000), nullable=True)
    duracion    = Column(Integer, nullable=False) # en minutos
    temporadas  = Column(Integer, nullable=True)
    capitulos   = Column(Integer, nullable=False)
    categoria   = Column(String(15), nullable=False)
    url         = Column(String(100), nullable=True)
    caratula    = Column(LargeBinary) # https://sqlalchemy-media.dobisel.com/tutorials/image.html

    # Constructor
    def __init__(self, nombre, descripcion, duracion, temporadas, capitulos, categoria, url, caratula):
        self.nombre      = nombre
        self.descripcion = descripcion
        self.duracion    = duracion
        self.temporadas  = temporadas
        self.capitulos   = capitulos
        self.categoria   = categoria
        self.url         = url
        self.caratula    = caratula

    # Metodo string
    def __str__(self):
        return f"id: {self.id}" \
               f"nombre: {self.nombre}" \
               f"descripcion: {self.descripcion}" \
               f"duracion: {self.duracion}" \
               f"temporadas: {self.temporadas}" \
               f"capitulos: {self.capitulos}" \
               f"categoria: {self.categoria}" \
               f"url: {self.url}" \
               f"caratula: {self.caratula}"

class Favorito(db.Base): # Heredamos de la clase Padre: Base

    # Nombre de la tabla
    __tablename__  = "favorito"

    # (opcional) Autoincrementa la PK de la tabla
    __table_args__ = {'sqlite_autoincrement': True}

    # Atributos
    id          = Column(Integer, primary_key=True)
    id_serie    = Column(Integer, nullable=False)  # not null (vacio)
    id_pelicula = Column(Integer, nullable=False)
    id_usuario  = Column(Integer, nullable=True)

    # Constructor
    def __init__(self, id_serie, id_pelicula, id_usuario):
        self.id_serie    = id_serie
        self.id_pelicula = id_pelicula
        self.id_usuario  = id_usuario

    # Metodo string
    def __str__(self):
        return f"id: {self.id}" \
               f"id_serie: {self.id_serie}" \
               f"id_pelicula: {self.id_pelicula}" \
               f"id_usuario: {self.id_usuario}"

class Visto(db.Base): # Heredamos de la clase Padre: Base

    # Nombre de la tabla
    __tablename__  = "visto"

    # (opcional) Autoincrementa la PK de la tabla
    __table_args__ = {'sqlite_autoincrement': True}

    # Atributos
    id          = Column(Integer, primary_key=True)
    id_serie    = Column(Integer, nullable=False)  # not null (vacio)
    id_pelicula = Column(Integer, nullable=False)
    id_usuario  = Column(Integer, nullable=True)

    # Constructor
    def __init__(self, id_serie, id_pelicula, id_usuario):
        self.id_serie    = id_serie
        self.id_pelicula = id_pelicula
        self.id_usuario  = id_usuario

    # Metodo string
    def __str__(self):
        return f"id: {self.id}" \
               f"id_serie: {self.id_serie}" \
               f"id_pelicula: {self.id_pelicula}" \
               f"id_usuario: {self.id_usuario}"

class RegistroForm(FlaskForm):
    nombre    = StringField(validators=[
                            InputRequired(), Length(min=2, max=20)], render_kw={"placeholder": "Nombre"})

    apellidos = StringField(validators=[
                            InputRequired(), Length(min=5, max=50)], render_kw={"placeholder": "Apellidos"})

    email = StringField(validators=[
                        InputRequired(), Length(min=5, max=50)], render_kw={"placeholder": "Correo electronico"})

    username  = StringField(validators=[
                           InputRequired(), Length(min=4, max=20)], render_kw={"placeholder": "Username"})

    password  = PasswordField(validators=[
                             InputRequired(), Length(min=8, max=20)], render_kw={"placeholder": "Password"})

    # Tipo Optional para que el formulario no de error al enviarlo via POST, luego en el py le añadimos fecha
    fecha_alta = DateField(validators=[
                            Optional(), Length(min=5, max=200)], render_kw={"placeholder": "Apellidos"})

    submit = SubmitField('Registrarse')

    def validate_username(self, username):
        #existing_user_username = Usuario.query.filter_by(
        #    username=username.data).first() - delete
        existing_user_username = db.session.query(Usuario).filter_by(username=username.data).first()
        if existing_user_username:
            if existing_user_username.username == "admin":
                raise ValidationError(
                    'Usuario no valido')
            else:
                raise ValidationError(
                    'Usuario existente')

class LoginForm(FlaskForm):
    username = StringField(validators=[
                           InputRequired(), Length(min=4, max=20)], render_kw={"placeholder": "Username"})

    password = PasswordField(validators=[
                             InputRequired(), Length(min=8, max=20)], render_kw={"placeholder": "Password"})

    submit = SubmitField('Entrar')