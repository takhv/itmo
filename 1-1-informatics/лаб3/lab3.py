import re

input_pattern = re.escape(input('Ваш смайл: '))
input_test = input('Ваш текст: ')
print(f'Кол-во смайликов {len(re.findall(input_pattern, input_test))}')
