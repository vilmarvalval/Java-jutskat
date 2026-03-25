import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        boolean loop=true;
        float a = 0;
        float b = 0;
        float c = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nThis is a quadratic equation calculator. (In form of: ax^2 + bx + c = 0)");
        while (loop){
            System.out.println("Enter a:");
            try {
                a = Float.parseFloat(scan.nextLine());
                while (loop) {
                    System.out.println("Enter b:");
                    try {
                        b = Float.parseFloat(scan.nextLine());
                        while (loop){
                            System.out.println("Enter c:");
                            try{
                                c = Float.parseFloat(scan.nextLine());
                                try {
                                    double dscrmnt = (b*b - 4*a*c);
                                    if (a==0){
                                        if (b==0){
                                            if (c==0){
                                                System.out.println("\nInfinite solutions.\n");
                                            } else {
                                                System.out.println("\n No solution.\n");
                                            }
                                        } else {
                                            double root = -c/b;
                                            System.out.format("\nLinear root = %.2f\n",root);
                                        }
                                    } else if (dscrmnt < 0) {
                                        System.out.println("\nNo real roots\n");
                                    } else if (dscrmnt == 0) {
                                        double sqrt = Math.sqrt(dscrmnt);
                                        double first = (-b + sqrt) / (2*a);
                                        System.out.format("\nRoot= %.2f\n",first);
                                    } else {
                                        double sqrt = Math.sqrt(dscrmnt);
                                        double first = (-b + sqrt) / (2*a);
                                        double second = (-b - sqrt) / (2*a);
                                        System.out.format("\nRoot= %.2f or %.2f \n", first, second);
                                    }
                                } catch (Throwable err){
                                    System.out.println(err);
                                }
                                loop = false;
                            }catch (Throwable err){
                                System.out.println("Invalid number.");
                            }
                        }
                    } catch (Throwable err) {
                        System.out.println("Invalid number.");
                    }
                }
            } catch (Throwable err){
                System.out.println("Invalid number.");
            }
        }
    }
}