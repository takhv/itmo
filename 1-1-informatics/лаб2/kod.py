message = input("Введите набор из 7 цифр без разделительных знаков: ")
zeroone = ["0","1"]
if len(message) == 7:
    for i in message:
        if i not in zeroone:
            print("Вы ошиблись...")
            quit()
    message = int(message)
else:
    print("Вы ошиблись...")
    quit()

messageArr = []
messageArr.append((message//1000000)%10)
messageArr.append((message//100000)%10)
messageArr.append((message//10000)%10)
messageArr.append((message//1000)%10)
messageArr.append((message//100)%10)
messageArr.append((message//10)%10)
messageArr.append(message%10)

totalxor = ""
totalxor = totalxor + str( messageArr[3] ^ messageArr[4] ^ messageArr[5] ^ messageArr[6] )
totalxor = totalxor + str( messageArr[1] ^ messageArr[2] ^ messageArr[5] ^ messageArr[6] )
totalxor = totalxor + str( messageArr[0] ^ messageArr[2] ^ messageArr[4] ^ messageArr[6] )

if totalxor == "000":
    print("Код верный!")
else:
    totalxor = int(totalxor, 2)
    print("У вас была ошибка в " + str(totalxor) + " бите")
    messageArr[totalxor-1] = abs(1 - messageArr[totalxor-1])
    a = "".join(str(i) for i in messageArr)
    print("Ваш исправленный набор: " + a)

qiut = input("print enter to quit")