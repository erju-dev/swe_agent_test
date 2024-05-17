import pymysql

# function to conecto to our data base and show our data
def conecto_db():
    """
    Función para conectarse a la base de datos y obtener un cursor para realizar consultas.
    No recibe parámetros.
    Retorna una conexión a la base de datos y un cursor para ejecutar consultas.
    """
    print("Conectado a la base de datos")
    localhost = "localhost"
    puerto = 3306
    bd = "proyecto_acn"
    db = pymysql.connect(host=localhost, user='root', password='**', db=bd, port=puerto)
    cursor = db.cursor()
    return db, cursor
