number = int(input("Enter the number: "))
if number%2==0:
    txt = "{} is an Even number."
    print(txt.format(number))
else:
    txt = "{} is an Odd number."
    print(txt.format(number))