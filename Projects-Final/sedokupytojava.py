import random
grid = ["#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",]

new_grid = []
nums = "123456789"

def return_aval_column(column): # 0-8
    new_nums = nums
    for row in grid:
        new_nums = new_nums.replace(row[column],"")
    return new_nums

def get_random_num(num):
    return num[random.randint(0,len(num)-1)]

for row in grid:
    current_col = 0
    new_row = ""
    for column in row:
        new_row += get_random_num(return_aval_column(current_col))
        current_col += 1
    new_grid.append(new_row)
print(new_grid)