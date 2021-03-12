Fruits = {
    "banana" : 45,
    "apple"  : 100,
    "pineapple" : 90,
    "watermelon" : 120
}

fruit_check = input("which fruit u want to check:").lower()
if (fruit_check in Fruits):
    print("yes," ,fruit_check ,"is available")
else:
    print("No," ,fruit_check ,"is not available")