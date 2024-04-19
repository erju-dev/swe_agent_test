#-- Imports --#
import sys
import os

#-- Functions
def main2():
    cara = int(input("Introduce cara para calcular area: "))
    area = cara * cara * cara
    print("El area es:", area)

def main3():
    tiempo = 20
    if tiempo > 30:
        print("Estamos a 30 grados")
    else:
        print("No estamos a 30 grados")

#-- Main --#
if __name__ == "__main__":
    os.system("cls" if os.name == "nt" else "clear")
    main2()
    main3()
