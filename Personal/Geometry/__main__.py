import turtle
import math


# Entered Values
sideAmount = 4
sideLength = 30

# Solved Values
angle = 360/sideAmount
angleWanted = angle/2
apothem = math.tan(math.radians(angleWanted)) * (sideLength/2)
radius = math.sqrt((apothem**2) + ((sideLength/2)**2))

# Function to draw a square
def drawShape():
    for _ in range(4):
        turtle.forward(100)  # Adjust the size of the square as needed
        turtle.right(90)

# Main function
def main():
    turtle.speed(1)  # Set the speed of the turtle (1 is the slowest)
    turtle.penup()   # Lift the pen up
    turtle.goto(-apothem, -apothem)  # Set starting position
    turtle.pendown()  # Put the pen down
    draw_square()  # Call the function to draw a square
    turtle.done()  # Finish the drawing

if __name__ == "__main__":
    main()
