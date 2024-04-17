cypher = input("Enter a encrypted message >> ")
decypher = cypher

abc = {}
for x in 'abcdefghijklmnopqrstuvwxyz':
    abc[x] = "#"



def change_pos(string, pos,letterto):
    try:
        return string[pos-1] + letterto + string[pos+1:]
    except:
        try:
            return string[pos-1] + letterto
        except:
            return letterto + string[pos+1:]

def print_all():
    global abc
    global decypher
    global cypher

    temp = decypher
    for letter in range(len(cypher)):
        if abc[cypher[letter]] != "#":
            temp = change_pos(temp,letter,abc[cypher[letter]])
    final = ""
    print(temp + "\n")
    count = 0
    for x in abc.keys():
        count += 1
        final += x + " -> " + abc[x] + " | "
        if count == 13:
            final += "\n"
    print(final)

while True:
    print_all()
    inp = input("Enter a letter to change Ex: a,b or type reset/done\n -> ")
    
    if inp == "done":
        print("Started with:")
        print(cypher)
        print("\nFinal message:")
        print(decypher + "\n")
        break
    elif inp == "reset":
        decypher = cypher
    elif len(inp) == 3 and ',' in inp:
        abc[inp.split(",")[0]] = inp.split(",")[1]

    else:
        print("Unknown syntax.")