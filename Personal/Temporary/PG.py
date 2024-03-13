import math, time
from datetime import datetime


def getSeconds():
    seconds = 0
    currentTime = datetime.now().strftime("%H:%M:%S.%f")
    currentTime = currentTime.split(":")
    seconds += float(currentTime[2])
    seconds += float(currentTime[1])*60
    seconds += float(currentTime[0])*60*60
    return seconds


#Vocab
#ab = abc, ns = numbers, gn = giantnumber, c1-c9 = current1 - current9

ab = "abcdefghijklmnopqrstuvwxyz"
ns = "0123456789"
cap_AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
# 0 = aaa000aaA
# 1 = aaa000aAa
# 2 = aaa000Aaa
# 3 = aaA000aaa
# 4 = aAa000aaa
# 5 = Aaa000aaa
# 6 = aaa000aaB
# 7 = aaa000aAb
# (ab[26 ^ 0][26 ^ 1])



def findIndexInStr(letter, string):
    letter = letter.lower()
    num = -1
    for x in string:
        num += 1
        if letter == x:
            return num
    print("ERROR: ", letter, string)

def pToNum(p):
    num = 0
    for character in p:
        if character in cap_AB:
            break
        if character not in ns:
            num += 1

    num += findIndexInStr(p[0], ab) * 6
    num += findIndexInStr(p[1], ab) * 6 * 26
    num += findIndexInStr(p[2], ab) * 6 * 26 * 26
    num += findIndexInStr(p[3], ns) * 6 * 26 * 26 * 26
    num += findIndexInStr(p[4], ns) * 6 * 26 * 26 * 26 * 10
    num += findIndexInStr(p[5], ns) * 6 * 26 * 26 * 26 * 10 * 10
    num += findIndexInStr(p[6], ab) * 6 * 26 * 26 * 26 * 10 * 10 * 10
    num += findIndexInStr(p[7], ab) * 6 * 26 * 26 * 26 * 10 * 10 * 10 * 26
    num += findIndexInStr(p[8], ab) * 6 * 26 * 26 * 26 * 10 * 10 * 10 * 26 * 26
    return num

def countLetterUp(n):
    c1 = n // 6
    c2 = c1 // 26
    c3 = c2 // 26
    c4 = c3 // 26
    c5 = c4 // 10
    c6 = c5 // 10
    c7 = c6 // 10
    c8 = c7 // 26
    c9 = c8 // 26
    p = [ab[c1 % 26], ab[c2 % 26], ab[c3 % 26], ns[c4 % 10], ns[c5 % 10], ns[c6 % 10], ab[c7 % 26], ab[c8 % 26], ab[c9 % 26]]
    n2 = n % 6
    if n2 <= 2:
        p[n2] = p[n2].upper()
    else:
        n2 += 3
        p[n2] = p[n2].upper()
    return ''.join(p)

# 1.8534947e+12 -> 1853494700000
# gn 
gn = 6*26*26*26*10*10*10*26*26*26
gn = 6
# for x in range(0,gn,1):
#     b = countLetterUp(x)
#     # if x % 500000 == 0:
#     #     print(x, "-", b)
#     print(x, "-", b)
# pToNum("bAa000aaa")
# for x in range(1200000*90,1200000*100000,1):
#     p = countLetterUp(x)
#     n = pToNum(p)
#     print(x,p,n)

tm = getSeconds()
time.sleep(1)
print(getSeconds()-tm)