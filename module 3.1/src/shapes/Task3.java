//In this exercise, you will create a Java program that demonstrates the concept of polymorphism
// by implementing a shape hierarchy. You will define a base Shape class and derive various shapes such as
// Circle, Rectangle, and Triangle from it.
//The program will showcase the use of polymorphism to calculate and display the area of different shapes.


//Create a Java class named ShapeCalculator with a main method to demonstrate polymorphism.
// In the main method, perform the following actions:
//
//Create an array of Shape objects containing instances of Circle, Rectangle, and Triangle.
//Loop through the array and display the area of each shape.
//Example Output:
//
//Shape Calculator
//Area of Circle with radius 5.0: 78.53981633974483
//Area of Rectangle with width 4.0 and height 6.0: 24.0
//Area of Triangle with base 3.0 and height 8.0: 12.0
//Hint: You can print out the name of the shape
// and its parameters by overloading the toString() method in each shape class.
package shapes;
import java.util.Scanner;
public class Task3{
    static int count = 0;
    static int added = 0;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        while (count <1){
            System.out.println("Enter number of shapes:");
            try {
                count= Integer.parseInt(scan.nextLine());
            } catch (Throwable err){
                System.out.println("Invalid input");
            }
        }

        while(added < count){
            if (ShapeCalculator.addShape()){
                added++;
            }
        }

        ShapeCalculator.printShapes();
    }
}

//Use the previous task classes here.
// Add a property (e.g., Color) which is common to all subclasses:
// Circle, Rectangle, and Triangle. Add the display of color to the output of the Shape Calculator.