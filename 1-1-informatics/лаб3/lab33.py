#368892 % 5 = 2
import re

text = input("Ваш пример: ")
alf = re.sub(r'(\d+)\s[-+*/]\s(\d+)\s=\s(\d+)', r'\1...\2...\3', text).split()
res = []
for i in alf:
    a = int(i)
    b = 4*a*a - 7
    res.append(str(b))
print(re.sub(r'(\d+)\s[-+*/]\s(\d+)\s=\s(\d+)', " ".join(res), text))