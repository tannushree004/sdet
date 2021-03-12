p1 = input("Enter Player1 name:")
p2 = input("enter player2 name:")

input1= input(p1 + ", do you want to choose rock, paper or scissors? ").lower()
input2= input(p2 + ", do you want to choose rock, paper or scissors? ").lower()

if input1==input2:
   print("its a tie")
elif input1=='rocks':
    if input2== 'scissors':
        print("rocks wins")
    else: 
         print("paper wins")
elif input1== 'paper':
    if input2== 'scissors':
        print("scissors wins!")
    else:
         print("rocks wins!")
elif input1== 'paper':
    if input2== 'rocks':
        print("paper wins")
    else:
         print("scissors wins!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")

    #Ask players if they wants to play again
repeat=input("Do you want to play again Yes/No:").lower()
if repeat == 'yes':
    pass
elif repeat == 'no':
    raise SystemExit
else:
    print("You entered an invalid option. Exiting now.")
    raise SystemExit
