package shapes;

public class Rectangle extends Shape {
    private final double w;
    private final double h;
    public Rectangle(double w, double h, String color){
        this.w = w;
        this.h=h;
        this.color=color;
        super.name="Rectangle";
        super.h=h;
        super.w=w;
    }
    public double calculateArea(){
        return w*h;
    }
}