#-- Imports --#
import sys
import os

#-- Functions
def main2(cara):
    area = cara * cara  # Corrected area calculation for a square
    print("El area es:", area)

def main3():
    tiempo = 20
    if tiempo > 30:
        print("Estamos por encima de 30 grados")
    else:
        print("No estamos por encima de 30 grados")

#-- Main --#
if __name__ == "__main__":
    os.system("cls" if os.name == "nt" else "clear")
    if len(sys.argv) != 2:
        print("Usage: python logical_error.py <side_length>")
        sys.exit(1)
    main2(int(sys.argv[1]))
    main3()
    print("Script completed successfully, no errors.")
