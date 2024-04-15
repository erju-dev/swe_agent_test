#-- Imports --#
import sys
import os


#-- Functions
def calculadora_suma(num1, num2):
    return num1 + num2

def main():
    print("Bienvenidos a la calculadora de sumas")
    #num1 = int(input("Introduce numero 1: "))
    #num2 = int(input("Introduce numero 2: "))
    num1 = 3
    num2 = 3
    print()
    print(f"El resultado es: {calculadora_suma(num1, num2)}")

#-- Main --#
if __name__ == "__main__":
    os.system("cls")
    main()
