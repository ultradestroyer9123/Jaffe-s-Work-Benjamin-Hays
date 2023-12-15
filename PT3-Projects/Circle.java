public class Circle implements Shape
{
    private int radius;
    private String color;
    
    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
    
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
    
    public double getCircuference() {
        return this.getPerimeter();
    }
    
    public String getColor() {
        return this.color;
    }
}
