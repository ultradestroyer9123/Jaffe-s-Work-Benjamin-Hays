from PIL import Image
import os

os.chdir(os.path.dirname(__file__))

def invert(pixel):
    r = 255-int(pixel[0])
    g = 255-int(pixel[1])
    b = 255-int(pixel[2])
    return (r,g,b)

def readFile(fileName):
    file = Image.open(fileName)
    size = file.size
    mode = file.mode
    print("File Name:",fileName)
    print("File Size:",size)
    print("File Mode:",mode)
    pixels = file.load()
    for x in range(size[0]):
        for y in range(size[1]):
            pxl = file.getpixel((x,y))
            file.putpixel((x,y),invert(pxl))
    file.show('output.png')


readFile("python4.png")