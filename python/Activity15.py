try:
    print(invalidvariablename)
except NameError:
    print("Variable name was not defined")
finally:
    print("printing Finally block")