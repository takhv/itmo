number = str(input("Число которое надо перевести в другую СС:"))
ss = int(input("СС вашего числа:"))
result = int(input("Нужная СС:"))
hren = [3,4,5,6,7,9]
specStr = ""
specCalc = 0

if ss != -10 and result == 10:
    calc = int(number, ss)
elif result == 2:
    a = int(number,ss)
    calc = bin(a)[2:]
elif result == 8:
    a = int(number,ss)
    calc = oct(a)[2:]
elif result == 16:
    a = int(number,ss)
    calc = hex(a)[2:]
elif result in hren:
    a = int(number,ss)
    while a > 0:
        specStr = str(a%result) + specStr
        a = a // result
    calc = specStr
elif ss == -10:
    numberInt = int(number)
    while numberInt > 0:
        for i in range(len(str(number))):
            specCalc += (numberInt % 10) * (-10)**i
            i += 1
            numberInt //= 10
    calc = specCalc
else:
    print("error")
print(calc)
