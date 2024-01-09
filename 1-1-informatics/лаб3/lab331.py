#368892 % 5 = 2
import re
def f(a):
    return str(int(a[0])*int(a[0])*4 - 7)
text = input("Ваш пример: ")
print(re.sub(r'(\d+)', f, text))
