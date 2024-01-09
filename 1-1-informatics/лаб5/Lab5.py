import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("usi.csv", delimiter=";", encoding='utf-8')
df.boxplot()
plt.xticks(rotation=90, fontsize=10)
plt.show()