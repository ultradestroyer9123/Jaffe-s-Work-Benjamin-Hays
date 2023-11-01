equation = input("equation (y = 5*x+3) > ").replace(" ","")


def create_graph(x,y):
    x *= 2
    if x % 2 == 0:
        x += 1
    if y % 2 == 0:
        y += 1
    graph = ""
    for a in range(y):
        a += 1
        if a == int(y/2+0.5):
            graph += "—"*int(x/2-0.5) + "+" + "—"*int(x/2-0.5)
        else:
            for b in range(x):
                b += 1
                if b == int(x/2+0.5):
                    graph += "|"
                else:
                    graph += " "
        graph += "\n"
    return graph

# def get_dimensions(graph = graph):
#     y = 0
#     x_ = 0
#     for x in graph:
#         if x == "\n": 
#             y += 1
#     for b in graph.split("\n")[0]:
#         if b == " " or b == "|":
#             x_ += 1

#     return (int((x_/2)-0.5),y)
        
# dimens = get_dimensions()

# def find_center(g=graph):
#     x_l = 0
#     y_l = 0
#     for char in g:
#         if char == "+":
#             break
#         if char == "\n":
#             y_l += 1
#             x_l -= x_l
#         else:
#             x_l += 1
#     return x_l,y_l

# center = find_center()
# print(center)

def edit_pos(lx,ly,graph):
    lx+11
    ly+11
    try:
        print(lx,ly)
        g = list(graph.split("\n")[ly-1])
        g[lx-1] = "#"
        newg = graph.split("\n")
        newg[ly-1] = ''.join(g)
        return "\n".join(newg)
    except:
        return graph

# if 'y' in equation and "x" in equation and "=" in equation:
#     for iteration in range(dimens[0]):
#         iteration += center[0]
#         try:
#             y_pos=eval(equation.split("=")[1].replace("x",str(iteration))) += center[1]
#             graph = edit_pos(iteration,round(y_pos))
#         except Exception as e:
#             print(e)
#             break
#     print(graph)
# else:
#     print("Error: Not an equation.")





y_eq = equation.split("=")[1]
array = []
y_arr = []
for x in range(-10,11,1):
    tup = x,round(eval(y_eq.replace("x",str(x))))
    array.append(tup)
    y_arr.append(tup[1])
    

    
graph = create_graph(20,20)

for x,y in array:
    graph = edit_pos(x*2,y,graph)
        
        
print(graph)
    
        
    

    




