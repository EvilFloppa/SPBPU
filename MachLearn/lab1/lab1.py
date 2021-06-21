# общие импорты
import pandas as pd
import numpy as np

# Задание 1
# крестики-нолики наивным байесовским классификатором
# размер тестовой выборки для каждого класса
test_size = 20

# доля используемой тренировочной выборки [0.0; 1.0]
used_sample = 1.

# имена столбцов для переименовывания
col_names = ['x11', 'x12', 'x13', 'x21', 'x22', 'x23', 'x31', 'x32', 'x33', 'res']

# шаблон для подсчёта статистики
stat_patt = pos_stat = pd.DataFrame({'x': [0, 0, 0, 0, 0, 0, 0, 0, 0],
                                     'o': [0, 0, 0, 0, 0, 0, 0, 0, 0],
                                     'b': [0, 0, 0, 0, 0, 0, 0, 0, 0]}).T
stat_patt.columns = col_names[:-1]

# чтение данных
data = pd.read_csv('lab1_data/tic_tac_toe.txt', sep=',', header=None)
data.columns = col_names

# формирование тренировочной выборки 
train_data = data[data['res'] == 'positive'][20:].sample(frac=used_sample)
train_data = train_data.append(data[data['res'] == 'negative'][20:].sample(frac=used_sample))

# формирование тестовой выборки
test_data = data[data['res'] == 'positive'][0:20]
test_data = test_data.append(data[data['res'] == 'negative'][0:20])

# классы для предсказаний
classes = data['res'].unique()


def train(data):
    classifier = []
    for cls in classes:
        curr_data = data[data['res'] == cls].loc[:, 'x11':'x33']
        # print (curr_data)
        stat = pd.DataFrame.copy(stat_patt)

        for _, row in curr_data.iterrows():
            for col in col_names:
                row
                stat.loc[row[col], col] += 1
        classifier.append((cls, stat))
    return classifier


print(train(train_data))
