import matplotlib.pyplot as plt
from scipy.interpolate import make_interp_spline, BSpline
import numpy as np
import math

y_list = np.array([2, 1, 3, 5, 5, 4])
list = [1.07, -1.02, -1.18, 1.34, 1.69, 0.31, 0.48, 0.11, 0.92, 0.04,
        1.42, -1.59, -0.08, -0.21, 0.65, 0.55, 0.66, 1.22, 0.46, 0.82]
old_list = list
list.sort()

# Вариационный ряд
print(f'-->Вариационный ряд<--\n{list}')
print()

max_value = max(list)
min_value = min(list)

# Величина интервала
h = (max_value-min_value)/math.ceil(1+math.log(len(list),2))
# Среднее значение
middle = sum(list)/len(list)
# Размах
razmah = round(max_value-min_value, 2)

print(f'Величина интервала - {h}')
print()

# Экстремальные значения и размах
print(f'-->Экстремальные значения и размах<-- \n'
      f'Максимальное значение - {max_value} \n'
      f'Минимальное значение - {min_value} \n'
      f'Размах - {razmah}')
print()

list_sum = sum(list)
elem_count = len(list)
math_wait = list_sum/elem_count

for_s = 0
for i in range(elem_count):
    for_s += (list[i]-math_wait)**2

s = math.sqrt((1/19)*for_s)

# Оценки математического ожидания и среднеквадратического отклонения
print(f'-->Оценка математического ожидания и среднеквадратического отклонения<--\n'
      f'Математическое ожидание - {math_wait}; srednee - {middle}\n'
      f'Среднеквадратическое отклонение - {s}')
print()

# Эмпирическая функция распределения и её график
ecdf = np.arange(1, len(list) + 1) / len(list)
print(f'-->Эмпирическая функция распределения<--\n{ecdf}')
plt.step(list, ecdf, label='ЭФР')
plt.xlabel('Значение')
plt.ylabel('ЭФР')
plt.title('Эмпирическая функция распределения')
plt.legend()
plt.grid(True)
plt.show()

# Гистограмма
repeater = []
plt.hist(old_list, bins=math.ceil(razmah/h), edgecolor='black', alpha=0.7)
# Полигон частот
interval = []
helper = min_value
for i in range(0, math.ceil(razmah/h)+1):
    interval.append(round(helper+h*i, 3))
dots = []
for i in range(0, len(interval)-1):
    amogus = (interval[i]+interval[i+1])/2
    dots.append(amogus)
dotsnp = np.array([])
dotsnp = np.append(dotsnp, dots)
spl = make_interp_spline(dots, y_list, k=3)
xnew = np.linspace(dotsnp.min(), dotsnp.max(), 200)
y_smooth = spl(xnew)

plt.plot(xnew, y_smooth, label='Полигон')
#plt.plot(dotsnp, y_list, label='z', color='red')
plt.xlabel('Значения')
plt.ylabel('Частоты')
plt.title('Гистограмма')
plt.grid(True)
plt.show()

# Полигон частостей
# Количество повторений

for i in range(len(list)):
    repeater.append(list.count(list[i])/len(list))
numlist = [i for i in range(1, 21)]
plt.plot(old_list, repeater)
plt.xlabel('x')
plt.ylabel('p')
plt.title('полигон')
plt.grid(True)
plt.show()
