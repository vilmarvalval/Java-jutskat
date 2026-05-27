//Create a Student class with the following attributes:
//-id (int)
//-name (String)
//-age (int)

package course_enrollment_program;
import java.io.Serial;
import java.io.Serializable;
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    public Student(String name, int id, int age){
        this.name= name;
        this.id  = id;
        this.age = age;
    }
    protected int getID(){
        return this.id;
    }
    protected void setID(int newID){
        this.id = newID;
    }

    protected int getAge(){
        return this.age;
    }
    protected void setAge(int newAge){
        this.age = newAge;
    }

    protected String getName(){
        return this.name;
    }
    protected void setName(String newName){
        this.name = newName;
    }
}