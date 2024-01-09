#368892 % 6 = 0
import re

file = input("Введите ваш текст: ").split("/")
glas = r"([уеыаоэяиюёУЕЫАОЭЯИЮЁ])"
if len(file) == 3:
     if (len(re.findall(glas, file[0])) == 5) and (len(re.findall(glas, file[1])) == 7) and (len(re.findall(glas, file[2])) == 5):
          print("Хайку!")
     else:
          print("Не хайку.")
else:
     print("Не хайку. Должно быть 3 строки.")
