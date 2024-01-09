def main():
    number1 = str(input("Введите первое число в 2ой системе: "))
    number2 = str(input("Введите второе число в 2ой системе: "))
    print('Что сделать с числами? Выбери цифру действия: '
          '1 - Сложение\n'
          '2 - Вычитание\n'
          '3 - Деление с остатком\n'
          '4 - Деление без остатка\n'
          '5 - Умножение\n'
          '6 - Выход\n')
    action = int(input())
    if action == 1:
        intSum = int(number1, 2) + int(number2, 2)
        result = bin(intSum)[2:]
        print('Результат:', result)
        main()
    if action == 2:
        intVich = int(number1, 2) - int(number2, 2)
        result = bin(intVich)[2:]
        print('Результат:', result)
        main()
    if action == 3:
        intdelost = int(number1, 2) / int(number2, 2)
        result = bin(delost)[2:]
        print('Результат:', result)
        main()
    if action == 4:
        intdelbez = int(number1, 2) // int(number2, 2)
        result = bin(delbez)[2:]
        print('Результат:', result)
        main()
    if action == 5:
        intymn = int(number1, 2) * int(number2, 2)
        result = bin(intymn)[2:]
        print('Результат:', result)
        main()
    if action == 6:
        quit()
main()
