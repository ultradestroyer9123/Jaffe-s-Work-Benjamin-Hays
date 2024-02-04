import java.lang.Math;
public class Geometrics implements Shape
{
    private int apothem;
    private int sides;
    private String color;
    public Geometrics(int apothem, int sides, String color) {
        this.apothem = apothem;
        this.sides = sides;
        this.color = color;
    }
    
    public double getArea() {
        return Math.round(0.5 * this.apothem * this.getPerimeter());
    }
    
    public double getPerimeter() {
        // If you think of it like a right triangle,
        // the apothem is side B. C is the Radius, and A is shape sidelength.
        double angle = 360/sides;
        double sidelength = 2 * apothem * Math.tan(Math.toRadians(angle));
        return Math.round(sidelength * sides);
    }
    
    public String getColor() {
        return this.color;
    }
}
