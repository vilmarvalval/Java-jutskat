//Task 2: Generate number sequence and store it to a CSV file for spreadsheet application
//Generate a Fibonacci sequence of 60 numbers and write them to a CSV file.
//Then read the content of the file with a spreadsheet application.
//Note that the Fibonacci number of 60 is 1548008755920
// that is too large to be stored in a 32-bit integer.
// Therefore, you need to use long data type instead of int.
//Please note also that the sequence starts with 0 and 1 and depending on your algorithm,
// it may take time to calculate the sequence.
import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Task2 {
    public static void main(String[] args){
        // create FileOutputStream object
        String name="testi1.csv";
        createFile(name);
        long lt =0;
        long ct =1;
        long m;
        String strFilePath = "C:\\Users\\valta\\IdeaProjects\\java_helloworld\\module 3.4\\src\\"+name;
        try {
            FileOutputStream fos = new FileOutputStream(strFilePath);
            //*To create DataOutputStream object from FileOutputStream use,
            //*DataOutputStream(OutputStream os) constructor.
            DataOutputStream dos = new DataOutputStream(fos);
            String newLine = System.lineSeparator();
            String string = ""+ lt;
            dos.write(string.getBytes());
            for(int i=1;i<=60;i++){
                m = ct;
                ct += lt;
                lt = m;
                dos.write(newLine.getBytes());
                string = ""+ lt;
                dos.write(string.getBytes());
            }

            //*To write an int value to a file, use
            //* void writeInt(int i) method of Java DataOutputStream class.
            //*This method writes specified int to output stream as 4 bytes value.
            //*To close DataOutputStream use,void close() method.

            dos.close();
        } catch (Throwable e){
            System.err.println("Cannot open file: " + e.getMessage());
        }
    }
    public static void createFile(String name) {
        try {
            File myObj = new File(name); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
    }
}

// *Source - https://stackoverflow.com/a/32650294
// Posted by Vignesh Shiv
// Retrieved 2026-05-26, License - CC BY-SA 3.0