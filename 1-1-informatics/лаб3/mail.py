import re

mail = input("Ваша почта: ")
pattern = r"([a-zA-Z0-9._-]+)@([a-zA-Z0-9._-]+)\.([a-zA-Z]+)"
if re.fullmatch(pattern, mail):
    print("Почта.")
else:
    print("Не почта.")
