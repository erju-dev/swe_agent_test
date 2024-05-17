# Imports
import os
import pymysql
from dbconection import conecto_db
import requests
import pandas as pd
from openpyxl.workbook import Workbook

# Variables
datos = []

# Funciones
def limpiar_pantalla():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

def pedimos_datos():
    while True:
        limpiar_pantalla()
        # Creamos menu en castellano donde pedimos nombre, telef, cargo en la empresa e email
        print("Ingresa tu nombre")
        nombre = input()
        print("Ingresa tu telefono")
        telefono = input()
        print("Ingresa tu cargo")
        cargo = input()
        print("Ingresa tu email")
        email = input()
        """# Creamos un diccionario con los datos
        datos.append({"nombre": nombre, "telefono": telefono, "cargo": cargo, "email": email})"""
        # Insert variables "datos" into database
        guardar_en_db(nombre, telefono, cargo, email)

        # Imprimimos los datos
        print("Los datos son", datos)
        print("¿Quieres seguir? (s/n)")
        seguir = input()
        if seguir == "n":
            break
    return datos

def modificamos_datos(datos):
    while True:
        limpiar_pantalla()
        print("Opción 1: Modificar nombre")
        print("Opción 2: Modificar telef")
        print("Opción 3: Modificar cargo")
        print("Opción 4: Modificar email")
        print("Opción 5: Terminar")
        print()
        print("¿Que quieres hacer?")
        opcion = input()
        if opcion == "1":
            print("Ingresa tu nuevo nombre")
            nombre = input()
            datos["nombre"] = nombre
        elif opcion == "2":
            print("Ingresa tu nuevo telef")
            telefono = input()
            datos["telefono"] = telefono
        elif opcion == "3":
            print("Ingresa tu nuevo cargo")
        elif opcion == "4":
            print("Ingresa tu nuevo email")
        elif opcion == "5":
            break
    return datos

# function to show our data
def mostrar_db(db):
    cursor = db.cursor()
    sql = "SELECT * FROM datos"
    cursor.execute(sql)
    results = cursor.fetchall()
    # TODO: convertimos la variable en una lista
    return results


def conectar_api_guardar_excel(url, filename):
    """
    Conecta a una API, convierte el JSON en un diccionario, crea un dataframe, y guarda los datos en un archivo de Excel.
    
    Parámetros:
    url (str): La URL de la API.
    filename (str): El nombre del archivo de Excel donde se guardarán los datos.
    
    Retorno:
    None
    """
    # conectamos a la API
    response = requests.get(url)
    # convertimos el json en un diccionario
    datos = response.json()
    # creamos un dataframe con los datos
    df = pd.DataFrame(datos)
    # guardamos los datos en un excel
    df.to_excel(filename, index=False)


def mostramos_datos(datos): 
    limpiar_pantalla()
    if datos == []:
        print("No hay datos")
    else:
        print("Los datos son:")
        for i in datos:
            print(i)
        input("Pulsa una tecla para continuar")

def borramos_datos(datos):
    limpiar_pantalla()
    datos.clear()
    print("Los datos han sido borrados")
    return datos

def guardar_en_db(nombre, telefono, cargo, email):
    limpiar_pantalla()
    # conection to the data base localhost:3306
    db, cursor = conecto_db()
    sql = "INSERT INTO datos (nombre, telefono, cargo, email) VALUES ({nombre}, {telefono}, {cargo}, {email})"
    cursor.executemany(sql, datos)
    db.commit()
    print("Los datos han sido guardados")
    db.close()
    input("Pulsa una tecla para continuar")


def main():
    global datos
    while True:
        # Creamos menu para pedir al usuario si quiere introducir datos, modificar, 
        # mostrar, borrar o terminar
        limpiar_pantalla()
        print("Opción 1: Introducir datos")
        print("Opción 2: Modificar datos")
        print("Opción 3: Mostrar datos")
        print("Opción 4: Borrar datos")
        print("Opción 5: Terminar")
        print()
        print("¿Que quieres hacer?")
        opcion = input()
        if opcion == "1":
            pedimos_datos()
        elif opcion == "2":
            datos = modificamos_datos(datos)
        elif opcion == "3":
            mostramos_datos(datos)
        elif opcion == "4":
            borramos_datos(datos)
        elif opcion == "5":
            limpiar_pantalla()
            print("Hasta pronto")
            break
        else:
            print("Opción no disponible")

# Main
if __name__ == "__main__":
    #main()
    #http://api.open-notify.org/astros
    conectar_api_guardar_excel("https://jsonplaceholder.typicode.com/users", "proyecto_acn/datos.xlsx")
