/*
    *
   ***
  *****
 *******
 */
import java.util.Scanner;

public class Task02 {

    // check if input is an integer to avoid crashing.
    public static boolean isInt(String x){
         try {
             Integer.parseInt(x);
             return true;
         } catch (NumberFormatException ex) {
             return false;
         }
    }

    public static void main(String[] args){
        int amountN=0;
        while (amountN<=0){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter tree size: ");
            String amount = input.nextLine();

            if (isInt(amount)) {
                amountN = Integer.parseInt(amount);
                if (amountN <=0){
                    System.out.println("Tree size must be a number and greater than 0.");
                }
            } else {
                System.out.println("Tree size must be a number and greater than 0.");
            }
        }

        //System.out.println("Tree size will be "+ amountN);
        for (int i=0; i<=amountN; i++){
            String spaces = new String(new char[(amountN-i)]).replace("\0", " ");
            String stars = new String(new char[i*2+1]).replace("\0", "*");
            System.out.println(spaces+stars);
        }
    }
}