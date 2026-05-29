//Task 2: Thread-safe
//Assuming ArrayList is not thread-safe,
// design a class that has methods for adding an element
// to an ArrayList collection, querying the size of the collection,
// and removing an element from the collection.
//The elements may be any objects of your choice, such as Strings.
//The class you design should be thread-safe.
//Design a class that you can use to test thread-safety of your class.

import java.util.ArrayList;

public class Task2{
    public static void main(String[] args){
        int threads = Runtime.getRuntime().availableProcessors();
        int count= 50;

        testArray(count,threads);
    }
    static void testArray(int amount, int threads){
        int completed =0;
        //this array will track which treads are in use
        ArrayList<Thread> occpdThreads = new ArrayList<>();
        while(completed < amount){
            if(occpdThreads.size() < threads){
                //get a random number that decides which action to do on the array.
                switch((int)(Math.random()*4)){
                    case 0:
                        occpdThreads.add(new arrayInsert(randomText()));
                        break;
                    case 1:
                        occpdThreads.add(new arrayRemove(randomText()));
                        break;
                    case 2:
                        occpdThreads.add(new arrayGet());
                        break;
                    case 3:
                        occpdThreads.add(new arraySize());
                }
                completed++;
            }

            if (!occpdThreads.isEmpty()){
                for (Thread thread : occpdThreads) {
                    //start threads that are not running
                    if(thread.getState() == Thread.State.NEW){
                        thread.start();
                    }
                }
            }
            //remove thread from occupied when finished
            occpdThreads.removeIf(thread -> !thread.isAlive());
        }
    }
    static String randomText(){
        return switch ((int)(Math.random()*3)) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            default -> "";
        };
    }
}
class arrayInsert extends Thread{
    String text;
    arrayInsert(String text){
        this.text = text;
    }
    public void run() {
        System.out.println(syncedArray.insert(text));
    }
}
class arrayRemove extends Thread{
    String text;
    arrayRemove(String text){
        this.text = text;
    }
    public void run() {
        System.out.println(syncedArray.remove(text));
    }
}
class arrayGet extends Thread{
    arrayGet(){}
    public void run() {
        System.out.println("Array: "+syncedArray.getArr());
    }
}
class arraySize extends Thread{
    arraySize(){}
    public void run() {
        System.out.println("Array size: "+syncedArray.size());
    }
}

class syncedArray extends Thread{
    static ArrayList<String> stringArr = new ArrayList<>();
    private syncedArray(){}

    public static synchronized String insert(String string){
        stringArr.add(string);
        return "Inserted "+string+" to "+ stringArr;
    }
    public static synchronized String remove(String string){
        if (stringArr.contains(string)){
            stringArr.remove(string);
            return "Removed "+string+" from "+ stringArr;
        }
        return string+" not present in "+ stringArr;
    }

    public static synchronized ArrayList<String> getArr(){
        return stringArr;
    }
    public static synchronized int size(){
        return stringArr.size();
    }
}