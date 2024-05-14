# Imports
import os
import time

# Vars
articulos = []

# Functions
def limpiar_pantalla():
    """
    Borra la pantalla de la consola. Utiliza 'cls' en Windows y 'clear' en otros sistemas.
    """
    os.system('cls' if os.name == 'nt' else 'clear')

def insertar_articulo(articulos):
    """
    Función para insertar un nuevo artículo en una lista de artículos.
    Solicita al usuario que introduzca el nuevo artículo, lo añade a la lista de artículos y muestra un mensaje con los artículos insertados.
    Devuelve la lista de artículos actualizada.
    """
    limpiar_pantalla()
    new = input("Introduce el nuevo articulo: ")
    articulos.append(new)
    print()
    print("Articulos insertados: ", articulos)
    time.sleep(1)
    return articulos

def modificar_articulo(articulos):
    """
    Función para modificar un articulo de la lista de artículos.
    Solicita al usuario que introduzca el articulo que quiere modificar, lo modifica y muestra los artículos restantes.
    Devuelve la lista de artículos actualizada.
    """
    limpiar_pantalla()
    modify = input("Introduce el articulo que quieres modificar: ")
    new = input("Introduce el nuevo articulo: ")
    articulos.remove(modify)
    articulos.append(new)
    print()
    print("Articulos restantes: ", articulos)
    time.sleep(1)
    return articulos

def eliminar_articulo(articulos):
    """
    Función para eliminar un artículo de la lista de artículos.
    Solicita al usuario que introduzca el artículo a borrar, lo elimina de la lista y muestra los artículos restantes.
    Devuelve la lista de artículos actualizada.
    """
    limpiar_pantalla()
    delete = input("Introduce el articulo que quieres borrar: ")
    articulos.remove(delete)
    print()
    print("Articulos restantes: ", articulos)
    time.sleep(1)
    return articulos

def listar_articulos(articulos):
    """
    Función para listar los artículos presentes en la lista 'articulos'.
    Muestra cada artículo de la lista en la consola.
    No tiene parámetros de entrada.
    Devuelve la lista de artículos.
    """
    limpiar_pantalla()
    #print("Articulos\n")
    #for i in articulos:
    #    print(f"> {i}")
    print(", ".join(articulos))
    #print()
    time.sleep(1)
    return articulos

def main():
    """
    Función principal que se encarga de mostrar las opciones y
    manejar la lógica de las operaciones sobre la lista de artículos.
    """
    while True:
        limpiar_pantalla()
        print("1. Insertar articulo")
        print("2. Modificar articulo")
        print("3. Eliminar articulo")
        print("4. Listar articulos")
        print("5. Salir")
        print()
        option = int(input("Elige una opción: "))
        if option == 1:
            insertar_articulo(articulos)
        elif option == 2:
            modificar_articulo(articulos)
        elif option == 3:
            eliminar_articulo(articulos)
        elif option == 4:
            listar_articulos(articulos)
        elif option == 5:
            print("Adios")
            return False
        else:
            limpiar_pantalla()
            print("Opción incorrecta")
            time.sleep(1)

# Main
if __name__ == "__main__":
    limpiar_pantalla()
    main()