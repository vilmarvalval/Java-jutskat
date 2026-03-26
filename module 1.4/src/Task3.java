import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    private static boolean isInArray(Integer[] arr, int key){
        for (Integer integer : arr) {
            if (integer != null) {
                if (integer == key) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String[] removeNull(Integer[] a){
        ArrayList<String> removedNull = new ArrayList<String>();
        for (Integer str : a)
            if (str != null)
                removedNull.add(String.valueOf(str));
        return removedNull.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("Enter size of array: (e to exit.)");
            String exit = scan.nextLine();
            if (exit.equals("e")){
                loop = false;
                continue;
            }
            try{
                int size = Integer.parseInt(exit);
                Integer[] array = new Integer[size];
                for (int i = 0; i < array.length; i++) {
                    boolean loop1 = true;
                    while (loop1){
                        System.out.println("Enter integer "+(i+1)+":");
                        try {
                            int intgr = Integer.parseInt(scan.nextLine());
                            array[i] = intgr;
                            loop1 = false;
                        } catch (Throwable err){
                            System.out.println("Invalid integer.");
                        }
                    }
                }
                System.out.println("Provided array:");
                System.out.println(Arrays.toString(array));
                Integer[] sorted = new Integer[size];
                for (int i = 0; i < array.length; i++) {
                    int comp = array[i];
                    if (!isInArray(sorted, comp)){
                        sorted[i] = comp;
                    }
                }
                String[] cleaned = removeNull(sorted);
                System.out.println("Array without duplicates:");
                System.out.println(Arrays.toString(cleaned));
            } catch (Throwable err){
                System.out.println("Invalid number.");
            }
        }
    }
}