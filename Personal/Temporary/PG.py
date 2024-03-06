import math

abc = "abcdefghijklmnopqrstuvwxyz"
num = "0123456789"

# 0 = aaa000aaA
# 1 = aaa000aAa
# 2 = aaa000Aaa
# 3 = aaA000aaa
# 4 = aAa000aaa
# 5 = Aaa000aaa
# 6 = aaa000aaB
# 7 = aaa000aAb
# (abc[26 ^ 0][26 ^ 1])
def capitalize(p,num): # 0 - 5
    p = list(p.lower())
    if num <= 2:
        p[num] = p[num].upper()
    else:
        num += 3
        p[num] = p[num].upper()
    return ''.join(p)

def capitalizeByindex(p,num):
    return capitalize(p, num % 6)

def countLetterUp(num):
    
    current = math.trunc(num/6)
    current2 = (current*6) % 26
    print(current)
    p = abc[current % 26] + abc[current % (26)] + "a000aaa"
    
    p = capitalizeByindex(p,num)
    print(num,p)

x = -1
while x < 156:
    x += 1
    countLetterUp(x)