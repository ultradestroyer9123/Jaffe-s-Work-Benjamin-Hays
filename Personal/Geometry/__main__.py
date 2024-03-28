import turtle
import math


# Entered Values
sideAmount = 50
sideLength = 30

# Solved Values
angle = 360/sideAmount
angleWanted = angle/2
apothem = math.tan(math.radians(angleWanted)) * (sideLength/2)
radius = math.sqrt((apothem**2) + ((sideLength/2)**2))

# Function to draw a square
def drawShape(sideAmount,sideLength=50):
    for _ in range(sideAmount):
        turtle.forward(sideLength)  # Adjust the size of the square as needed
        turtle.right(360/sideAmount)

# Main function
def main(sideAmount,sideLength):
    turtle.speed(1)  # Set the speed of the turtle (1 is the slowest)
    turtle.penup()   # Lift the pen up
    turtle.goto(-apothem, -apothem)  # Set starting position
    turtle.pendown()  # Put the pen down
    drawShape(sideAmount,sideLength)  # Call the function to draw a square
    turtle.done()  # Finish the drawing

if __name__ == "__main__":
    main(sideAmount,sideLength)
