map = """
[0][0][0]
[0][1][0]
[0][0][0]"""

#Should yield ->
"""
[0][0][0][0][0]
[0][0][.5][0][0]
[0][.5][1][.5][0]
[0][0][.5][0][0]
[0][0][0][0][0]
"""

# 3 -> 2, 5 -> 4

def find_average(*nums):
    # 1-5 -> 3
    # 1-2 = 1.5
    y = 0
    for x in nums:
        y += x
    return y/len(nums)

def printRaw(string):
    print(string.replace("\n","\\n"))

def add1Between(array):
    offset = 0
    new = []
    arrayLength = (len(array)*2)-1
    for x in range(arrayLength):
        new.append("")
    for item in range(len(array)):
        new[item+offset] = array[item]
        offset += 1

    return new

def expand(map):
    if map[0] == "\n":
        map = map[1:]
    array = []
    for row in map.split("\n"):
        row2 = row.split("][")
        for character in range(len(row2)):
            row2[character] = row2[character].replace("[","").replace("]","")
        row2 = add1Between(row2)
        #LEFT OFF HERE 
        array.append(row2)
        
    return array



print(expand(map))