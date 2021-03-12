values = input("Input some comma seprated numbers : ")
list = values.split(",")
print('List : ',list)
firstelement = list[0] # first element
lastelement = list[-1] # last element
if firstelement == lastelement:
    print(True)
else:
    print(False)