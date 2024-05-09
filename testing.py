# Ask user for name and surname and print

def ask_name():
    name = input("Enter your name: ")
    surname = input("Enter your surname: ")
    while not name or not surname:
        print("Name and surname cannot be empty. Please enter again.")
        name = input("Enter your name: ")
        surname = input("Enter your surname: ")
    return name, surname

def print_name_surname(name, surname):
    print(f"Tu nombre es {name} y tu apellido {surname}")

name, surname = ask_name()
print_name_surname(name, surname)
