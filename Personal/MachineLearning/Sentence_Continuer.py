import os, requests, random
url_dict = "https://api.dictionaryapi.dev/api/v2/entries/en/WORD_HERE"

os.chdir(os.path.dirname(__file__))

sentence = input("Start out a sentence > \n")

def print_all(*args):
    for x in args:
        print(x)

subjects = {
    "FirstPerson":False,
    "SecondPerson":False,
    "ThirdPerson":False,
    "Plural":False
}

subjects_determines = {
    "FirstPerson":['i','myself','me','my'],
    "SecondPerson":['you','yourself','your','youre','yall','yours','yalls'],
    "ThirdPerson":['we','our','ourself','us','ours'],
    "Plural":['our','yall','ours','yalls']
}

tense = {
    "past":False,
    "present":False,
    "future":False
}

words = sentence.split(" ")
simplified = sentence.lower()
for punct in ',.?;:\"\'[]{}-`!$%*':
    simplified = simplified.replace(punct,"")

print_all(words,simplified)