#-- Imports --#
import sys
import os

#-- Functions --#
def calculadora_suma(num1, num2):
    return num1 + num2

def main():
    if len(sys.argv) != 3:
        print("Usage: python eric_error.py <num1> <num2>")
        sys.exit(1)
    num1 = int(sys.argv[1])
    num2 = int(sys.argv[2])
    print(f"El resultado es: {calculadora_suma(num1, num2)}")
    print("Script completed successfully, no errors.")
#-- Main --#
if __name__ == "__main__":
    os.system('cls' if os.name == 'nt' else 'clear')
    main()
