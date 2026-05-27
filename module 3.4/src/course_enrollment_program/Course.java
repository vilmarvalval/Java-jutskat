//Create a Course class with the following attributes:
//-courseCode (String)
//-courseName (String)
//-instructor (String)

package course_enrollment_program;
import java.io.Serial;
import java.io.Serializable;
public class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String courseCode;
    private String courseName;
    private String instructor;
    public Course(String name, String code, String instructor){
        this.courseCode = code;
        this.courseName = name;
        this.instructor = instructor;
    }

    protected String getCode(){
        return this.courseCode;
    }
    protected void setCode(String newCode){
        this.courseCode = newCode;
    }

    protected String getName(){
        return this.courseName;
    }
    protected void setName(String newName){
        this.courseName = newName;
    }

    protected String getInst(){
        return this.instructor;
    }
    protected void setInst(String newInst){
        this.instructor = newInst;
    }
}