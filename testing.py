# Ask user for name and surname and print

def ask_name():
    name = input("Enter your name: ")
    surname = input("Enter your surname: ")
    
    return name, surname 

name, surname = ask_name()

print("Your name is " + name + " and your surname is " + surname)
