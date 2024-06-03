import os, math, time

game_dimension = 9 # x by x
os.chdir(os.path.dirname(__file__) + "/currentGame")
print(f"file://{os.path.dirname(__file__)}/textures/wall.png")
def make_map(dimens):
    count = 0
    for x in range(dimens):
        for y in range(dimens):
            count += 1
            os.system(f"touch {str(count)}")
            if x == 0 or x == game_dimension-1 or y == 0 or y == game_dimension-1:
                os.system(f'gio set "{str(count)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/wall.png"')

                
def add_snake(front,rear):
    os.system(f'gio set "{str(front)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snakehead.png"')
    os.system(f'gio set "{str(rear)}" metadata::custom-icon "file://{os.path.dirname(__file__)}/textures/snake.png"')

def move()

for thing in os.listdir():
    os.remove(thing)

#make_map(game_dimension)
# Cleanup: Remove all files in current_dir
for thing in os.listdir():
    os.remove(os.path.join(current_dir, thing))

make_map(game_dimension)

mid_point = round((game_dimension**2)/2)
half_minus_one = math.floor(game_dimension/2)
snake_rear = mid_point-half_minus_one+2
snake_front = snake_rear + 1
add_snake(snake_front,snake_rear)
print(snake_front)



facing = "east"
snake = [snake_rear,snake_front]
while True:
    time.sleep(1)
    global facing
    global snake
    if facing == "east":

    



