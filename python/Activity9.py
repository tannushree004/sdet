list1 = [10,18,23,55]
list2 = [5,10,20,80]
list3 = []
for num in list1:
    if(num % 2 != 0):
        list3.append(num)
for num in list2:
    if (num % 2 == 0):
        list3.append(num)
print(list3)