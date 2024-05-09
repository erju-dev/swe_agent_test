# Ask user for name and surname and print

def ask_name():
    name = input("Enter your name: ")
    surname = input("Enter your surname: ")
    
    return name, surname

name, surname = ask_name()

print(f"Tu nombre es es es {name } y tu apellido {surname}")
