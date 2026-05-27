//Task 3: Serialization of Course Enrollment
//Create a Java program that demonstrates the serialization
// and deserialization of a course enrollment system.
//You will create classes for students, courses, and enrollments,
//and then serialize and deserialize instances of these classes.

//Implement constructors, getters, and setters for all classes.
//Create a Main class with the  method to demonstrate serialization
// and deserialization.
//In the  method:
// -Create instances of Student, Course, and Enrollment.
// -Serialize and save the instances to a file named "enrollments.ser".
// -Deserialize the instances from the "enrollments.ser" file and print their information.

package course_enrollment_program;
import java.io.*;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        String name ="enrollments.ser";
        String[] check = System.getProperty("user.dir").split("\\\\");
        String strFilePath = "";
        if(check[check.length-1].equals("module 3.4")){
            strFilePath = System.getProperty("user.dir") + "\\src\\course_enrollment_program\\" + name;
        }else{
            strFilePath = System.getProperty("user.dir") + "\\module 3.4\\src\\course_enrollment_program\\" + name;
        }
        Student testS1 = new Student("Test student 1", 1, 20);
        Student testS2 = new Student("Test student 2", 2, 20);
        Course testC1 = new Course("test course1", "1234", "instructor 1");
        Course testC2 = new Course("test course2", "1234", "instructor 2");
        Enrollment e1 = new Enrollment(testS2, testC1, "01.01.1970");
        Enrollment e2 = new Enrollment(testS1, testC2, "01.01.1970");
        enrollments.add(e1);
        enrollments.add(e2);

        writeEnrollments(strFilePath, enrollments, name);
        readEnrollments(strFilePath);
    }

    private static void writeEnrollments(String path, ArrayList<Enrollment> enr, String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //System.out.println(enr);
            oos.writeObject(enr);
            oos.flush();
            oos.close();
            System.out.println("Enrollments written successfully");

        } catch (Throwable e){
            System.err.println("Cannot write file "+fileName+": " + e.getMessage());
        }
    }

    private static void readEnrollments(String path){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            ArrayList<Enrollment> enr = (ArrayList<Enrollment>) ois.readObject();

            System.out.println("Enrollment read successfully");
            System.out.println("-------------------------------------");
            for (Enrollment e: enr) {
                System.out.printf("| %-15s : %-15s |\n","Enrollment date",e.getDate());
                System.out.printf("| %-15s | %-15s |\n",e.getStudent().getName(),e.getCourse().getName());
                System.out.printf("|  ID: %-10s | ID: %-11s |\n",e.getStudent().getID(), e.getCourse().getCode());
                System.out.printf("| Age: %-10s | %-15s |\n",e.getStudent().getAge(), e.getCourse().getInst());
                System.out.println("-------------------------------------");
            }
        } catch (Throwable e){
            System.err.println("Cannot open file "+path+": "+e.getMessage());
        }
    }
}