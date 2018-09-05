package problem1;

/**
 * Created by Chris Burgess on 10/25/2017.
 */
public interface Course {

    enum Courses {COMP101, COMP110, COMP410, COMP411, COMP426}

    String getCourseName();

    int getCourseNumber();

    String getProfessorName();

    boolean addStudent(Student student);

    boolean dropStudent(Student student);

    public String getRoster();
}
