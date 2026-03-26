import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        String[] first = {"Matti","Pekka","Anna","Julia"," Heidi"};
        String[] last = {"Peltonen","Hokkarainen","Tapiola"};

        Scanner scan = new Scanner(System.in);

        boolean loop =true;
        while (loop){
            System.out.println("How many names would you like to generate? (e to exit)");
            try {
                String exit = scan.nextLine();
                if (exit.equals("e")){
                    loop = false;
                    continue;
                }
                int amount = Integer.parseInt(exit);
                for (int i = 0; i < amount; i++) {
                    int randFirst = (int) (Math.random()*first.length);
                    int randLast = (int) (Math.random()*last.length);
                    String randomName = first[randFirst] +
                            " " +
                            last[randLast];
                    System.out.println(randomName);
                }
            } catch (Throwable err){
                System.out.println("Invalid number.");
            }
        }
    }
}