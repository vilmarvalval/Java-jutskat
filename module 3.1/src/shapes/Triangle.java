package shapes;

public class Triangle extends Shape {
    private final double w;
    private final double h;
    public Triangle(double w, double h, String color){
        this.w = w;
        this.h = h;
        this.color=color;
        super.name="Triangle";
        super.h=h;
        super.w=w;
    }

    public double calculateArea(){
        return (w*h)/2;
    }
}