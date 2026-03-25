import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        //hexadecimal lookup table
        String[] hexArr= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        boolean loop= true;
        Scanner scan = new Scanner(System.in);
        System.out.println("This is a binary to decimal converter.");
        while (loop){
            System.out.println("Enter a binary number:  (or e to exit)");
            try {
                String binary = scan.nextLine().replaceAll("\\s+", "");
                if (binary.equals("e")){
                    loop = false;
                    continue;
                }
                //validate and formatting input
                if (!binary.matches("[01]*")){
                    System.out.println("Invalid binary.");
                    continue;
                };
                StringBuilder buildString = new StringBuilder();
                double total = 0;
                int add;
                //count binary to number
                for (int i = binary.length() - 1; i >= 0; i--) {
                    int number = binary.charAt(i);
                    if (number == 49) {
                        buildString.append(1);
                        add = (int) Math.pow(2, (binary.length() - 1 - i));
                        total += add;
                    } else if (number == 48) {
                        buildString.append(0);
                    } else {
                        System.out.println("NOT BINARY");
                    }
                    if (i % 4 == 0) {
                        buildString.append(" ");
                    }
                }
                //make array of string.
                String[] format = buildString.toString().split("");
                //flip array
                for (int i = 0; i < format.length / 2; i++) {
                    String temp = format[i];
                    format[i] = format[format.length - i - 1];
                    format[format.length - i - 1] = temp;
                }
                format[0] = "";
                binary = String.join("", format);
                String[] toDecimal = binary.split(" ");
                StringBuilder decimal = new StringBuilder();
                String[] chunk;

                for (String s : toDecimal) {
                    chunk = s.split("");
                    System.out.println(Arrays.toString(chunk));
                    add = 0;
                    System.out.println(add);
                    for (int j = 0; j < chunk.length; j++) {
                        int number = Integer.parseInt(chunk[j]);
                        if (number == 1) {
                            add += (int) Math.pow(2, chunk.length - j - 1);
                        }
                    }
                    System.out.println(add);
                    decimal.append(hexArr[add]);
                }
                System.out.println(binary + " (" + total + ") in decimal is: " + decimal);
            } catch (Throwable e){
                System.out.println("Invalid binary.");
            }
        }
    }
}