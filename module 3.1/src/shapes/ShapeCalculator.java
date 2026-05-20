package shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeCalculator {
    static List<Shape> shapeArray = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static boolean addShape(){
        System.out.println("Enter shape type(Circle, Rectangle, Triangle)");
        String shape = input.nextLine().toLowerCase();
        int h = 0;
        int w = 0;
        int r = 0;
        String color;
        switch (shape){
            case "rectangle":
                while (h==0) {
                    System.out.println("Enter height:");
                    h = checkInput(input.nextLine());
                }
                while (w==0) {
                    System.out.println("Enter width:");
                    w = checkInput(input.nextLine());
                }
                System.out.println("Enter color:");
                color = input.nextLine().toLowerCase();
                Shape rectangle = new Rectangle(h,w,color);
                shapeArray.add(rectangle);
                System.out.println("Added succesfully");
                return  true;
            case "circle":
                while (r==0) {
                    System.out.println("Enter radius:");
                    r = checkInput(input.nextLine());
                }
                System.out.println("Enter color:");
                color = input.nextLine().toLowerCase();
                Shape circle = new Circle(r,color);
                shapeArray.add(circle);
                System.out.println("Added succesfully");
                return  true;
            case "triangle":
                while (w==0) {
                    System.out.println("Enter width:");
                    w = checkInput(input.nextLine());
                }
                while (h==0) {
                    System.out.println("Enter height:");
                    h = checkInput(input.nextLine());
                }
                System.out.println("Enter color:");
                color = input.nextLine().toLowerCase();
                Shape triangle = new Triangle(w, h,color);
                shapeArray.add(triangle);
                System.out.println("Added succesfully");
                return true;
            default: System.out.println("Invalid shape"); return  false;
        }
    }

    public static int checkInput(String x){
        try{
            Integer.parseInt(x);
        } catch (Throwable err){
            System.out.println("Invalid input");
            return 0;
        }
        System.out.println("Valid input");
        return Integer.parseInt(x);
    }

    public static void printShapes(){
        for (Shape shape : shapeArray){
            switch (shape.name){
                case "Circle":
                    System.out.println("Area of "+shape.color+" "+shape.name+" with radius "+shape.r+": "+shape.calculateArea());
                    break;
                case "Rectangle":
                    System.out.println("Area of "+shape.color+" "+shape.name+" with width "+shape.w+" and height "+shape.h+": "+shape.calculateArea());
                    break;
                case "Triangle":
                    System.out.println("Area of "+shape.color+" "+shape.name+" with base "+shape.w+" and height "+shape.h+": "+shape.calculateArea());
                    break;
            }
        }
    }
}