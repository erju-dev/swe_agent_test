#-- Imports --#
import sys

#-- Functions
def main2():
    """
    Calculate the volume of a cube given the side length.

    :param cara: The side length of the cube.
    :type cara: int
    :return: None
    """
    cara = int(input("Introduce cara para calcular area: "))
    area = cara * cara  * cara
    print("El area es:", area)

def main3():
    """
    Print a message based on the temperature comparison to 30 degrees.

    :param tiempo: The current temperature.
    :type tiempo: int
    :return: None
    """
    tiempo = 20
    if tiempo > 30:
        print("Estamos a 30 grados")
    else:
        print("No estamos por encima de 30 grados")

#-- Main --#
if __name__ == "__main__":
    os.system("cls")
    main2()
    main3()
