x_i = [0.67, 0.76, 0.85, 0.94, 1.03, 1.12, 1.21, 1.3, 1.39]
x_i_plus_1 = [0.76, 0.85, 0.94, 1.03, 1.12, 1.21, 1.3, 1.39, 1.48]
for i in range(9):
    x_i.append(round(0.8 + i*0.2, 2))
    x_i_plus_1.append(round(x_i[i] + 0.2, 2))
print(x_i)
print(x_i_plus_1)

for i in range(9):
    x_i[i] = round((x_i[i] - 1.71)/0.49, 3)
    x_i_plus_1[i] = round((x_i_plus_1[i] - 1.71)/0.49, 3)
    print(x_i[i],  x_i_plus_1[i])