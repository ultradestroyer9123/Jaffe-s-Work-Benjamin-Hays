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

graph = create_graph(21,21)

def get_dimensions(graph = graph):
    y = 0
    x_ = 0
    for x in graph:
        if x == "\n": 
            y += 1
    for b in graph.split("\n")[0]:
        if b == " " or b == "|":
            x_ += 1

    return (int((x_/2)-0.5),y)
        
print(get_dimensions())

if 'y' in equation and "x" in equation and "=" in equation:
    x=eval(equation.split("=")[1])

else:
    print("Error: Not an equation.")