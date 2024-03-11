import math

abc = "abcdefghijklmnopqrstuvwxyz"
nums = "0123456789"

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
    current2 = math.trunc(current/26)
    current3 = math.trunc(current2/26)
    current4 = math.trunc(current3/26)
    current5 = math.trunc(current4/10)
    current6 = math.trunc(current5/10)
    current7 = math.trunc(current6/10)
    current8 = math.trunc(current7/26)
    current9 = math.trunc(current8/26)
    p = abc[current % 26] + abc[current2 % 26] + abc[current3 % 26] + nums[current4 % 10] + nums[current5 % 10] + nums[current6 % 10] + abc[current7 % 26] + abc[current8 % 26] + abc[current9 % 26]
    return capitalizeByindex(p,num)

x = -1

# 1.8534947e+12 -> 1853494700000
while x < 6*26*26*26*10*10*10*26*26*26:
    x += 1
    b = countLetterUp(x)
    if x % 100000 == 0:
        print(str(x), "-", b)