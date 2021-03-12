list1=[5,25,76,13,50]
def list_sum(n):
    sum=0
    for num in n:
        sum=sum+num
    return sum
result = list_sum(list1)
	
print("The sum of all the elements is: " + str(result))