import java.lang.Math;
public class Dodecagon implements Shape
{
    private double sideLength;
    private int sides = 12;
    private String color;
    
    public Dodecagon(double sideLength, String color) {
        this.sideLength = sideLength;
        this.color = color;
    }
    
    public double getArea() {
        double radius = (sideLength/2) * Math.cos(360/sides);
        double apothem = Math.sqrt(Math.pow(radius,2) - Math.pow(sideLength/2,2));
        return Math.round(0.5 * apothem * this.getPerimeter());
    }
    
    public double getPerimeter() {
        // If you think of it like a right triangle,
        // the apothem is side B. C is the Radius, and A is shape sidelength.
        // double angle = 360/sides;
        // double sidelength = 2 * apothem * Math.tan(Math.toRadians(angle));
        return sideLength * sides;
    }
    
    public String getColor() {
        return this.color;
    }
}
