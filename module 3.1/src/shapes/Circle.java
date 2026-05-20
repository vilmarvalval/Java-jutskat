package shapes;

public class Circle extends Shape{
    private final double r;
    public Circle(double r, String color){
        this.r = r;
        this.color=color;
        super.name="Circle";
        super.r=r;
    }
    public double calculateArea(){
        return Math.PI*r*r;
    }
}