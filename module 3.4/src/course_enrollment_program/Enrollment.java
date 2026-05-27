//Create an Enrollment class that represents the enrollment of a student in a course.
//It should have attributes:
//-student (Student)
//-course (Course)
//-enrollmentDate (String)

package course_enrollment_program;

import java.io.Serial;
import java.io.Serializable;
public class Enrollment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Student student;
    private Course course;
    private String enrollmentDate;
    public Enrollment(Student student, Course course, String date){
        this.student = student;
        this.course  = course;
        this.enrollmentDate = date;
    }

    protected Student getStudent(){
        return student;
    }
    protected void setStudent(Student student){
        this.student = student;
    }

    protected Course getCourse(){
        return course;
    }
    protected void setCourse(Course course){
        this.course = course;
    }

    protected String getDate(){
        return enrollmentDate;
    }
    protected void setEnrollmentDate(String date){
        this.enrollmentDate = date;
    }
}