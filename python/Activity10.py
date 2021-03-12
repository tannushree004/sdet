myTuple = int(input("enter the tuple length:"))
List = []
for i in range(myTuple):
    List.append(int(input("Enter current number:")))

print(List)
tempTuple = tuple(List)
print(tempTuple)
for i in tempTuple:
    if (i % 5 == 0):
        print(i)