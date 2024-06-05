import os, math, time
import pydbus, subprocess, random
import threading

def refresh_currentGame():
    subprocess.run(["xdotool", "key", "Ctrl+r"])



walls = []

game_dimension = 9 # x by x
os.chdir(os.path.dirname(__file__) + "/currentGame")
print(f"file://{os.path.dirname(__file__)}/textures/wall.png")
def make_map(dimens):
    global walls
    count = 0
    for x in range(dimens):
        for y in range(dimens):
            count += 1
            os.system(f"touch {str(count)}")
            if x == 0 or x == game_dimension-1 or y == 0 or y == game_dimension-1:
                os.system(f'gio set "{str(count)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/wall.png"')
                walls.append(count)
    return walls

                

def add_snake(front,rear):
    os.system(f'gio set "{str(front)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snakehead.png"')
    os.system(f'gio set "{str(rear)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snake.png"')    

def change_pixel(number,typee="remove"):
    if typee == "remove":
        os.system(f'gio set -t unset "{str(number)}" metadata::custom-icon')
    elif typee == "apple":
        os.system(f'gio set "{str(number)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/apple.png"')
    elif typee == "wall":
        os.system(f'gio set "{str(number)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/wall.png"')
    elif typee == "snake":
        os.system(f'gio set "{str(number)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snake.png"')
    elif typee == "snakehead":
        os.system(f'gio set "{str(number)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snakehead.png"')

apple_location = None

def generate_apple(snake_array):
    global apple_location
    avaliable_spots = []
    for count in range(game_dimension**2):
        avaliable_spots.append(count + 1)
    for wall_b in walls:
        avaliable_spots.remove(wall_b)
    for part in snake_array:
        try:
            avaliable_spots.remove(int(part))
        except:
            pass
    apple_location = avaliable_spots[random.randint(0,len(avaliable_spots)-1)]
    change_pixel(apple_location, "apple")


def move(snake_array, direction):
    global game_dimension, walls, apple_location
    got_apple = False
    if apple_location == None:
        generate_apple(snake_array)
    change_pixel(snake_array[-1],"snake")


    if direction == "north":
        offset = -game_dimension
        change_pixel(snake_array[-1] + offset, "snakehead")
        snake_array.append(snake_array[-1] + offset)
    elif direction == "south":
        offset = game_dimension
        change_pixel(snake_array[-1] + offset, "snakehead")
        snake_array.append(snake_array[-1] + offset)
    elif direction == "east":
        offset = 1
        change_pixel(snake_array[-1] + offset, "snakehead")
        snake_array.append(snake_array[-1] + offset)
    elif direction == "west":
        offset = -1
        change_pixel(snake_array[-1] + offset, "snakehead")
        snake_array.append(snake_array[-1] + offset)
    if snake_array[-1] in walls:
        snake_array.append("lost")
    elif snake_array[-1] == apple_location:
        got_apple = True
    if not got_apple:
        change_pixel(snake_array[0])
        snake_array = snake_array[1:]
    else:
        generate_apple(snake_array)
    refresh_currentGame()
    return snake_array




for thing in os.listdir():
    os.remove(thing)

#make_map(game_dimension)
# Cleanup: Remove all files in current_dir
for thing in os.listdir():
    os.remove(os.path.join(current_dir, thing))

walls = make_map(game_dimension)
mid_point = round((game_dimension**2)/2)
half_minus_one = math.floor(game_dimension/2)
snake_rear = mid_point-half_minus_one+2
snake_front = snake_rear + 1
add_snake(snake_front,snake_rear)
refresh_currentGame()
print(snake_front)



direction = "east"
snake_array = [snake_rear,snake_front]

while True:
    time.sleep(1)
    snake_array = move(snake_array,direction)
    if snake_array[-1] == "lost":
        print(snake_array[len(snake_array)-2])
        print("You lost!")
        break


