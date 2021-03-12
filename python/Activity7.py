values = input("Input some comma seprated numbers : ")
list = values.split(",")
print('List : ',list)
sum=0
for i in list:
    sum =sum + int(i)
print(sum)
