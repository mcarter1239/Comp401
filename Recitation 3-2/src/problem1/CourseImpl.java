package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chris Burgess on 10/25/2017.
 */
public class CourseImpl implements Course {
    private List<Student> studentList = new ArrayList<>();
    private String courseName;
    private int courseNumber;
    private String professorName;
    private Courses preReqs[];


    public CourseImpl(String courseName, int courseNumber, String professorName, Courses[] preReqs) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.professorName = professorName;
        this.preReqs = preReqs;
    }

    public CourseImpl(String courseName, int courseNumber, String professorName) {
        this(courseName, courseNumber, professorName, new Courses[0]);
    }

    public CourseImpl(String courseName, int courseNumber) {
        this(courseName, courseNumber, "UNKNOWN");
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getRoster() {
        String s = "";
        for (Student student : studentList) {
            s += student.getLastName() + ", " + student.getFirstName() + "\n";
        }
        return s;
    }

    @Override
    public boolean addStudent(Student student) {
        if (validateStudent(student)) {
            studentList.add(student);
            Collections.sort(studentList);
            return true;
        }
        return false;
    }

    @Override
    public boolean dropStudent(Student student) {
        if (studentList.contains(student)){
            studentList.remove(student);
            return true;
        }
        return false;
    }

    private boolean validateStudent(Student student) {
        return notInClass(student) && hasPreRequisites(student);
    }

    private boolean notInClass(Student student) {
        return !studentList.contains(student);
    }

    private boolean hasPreRequisites(Student student) {
        return Arrays.asList(student.getCompletedCourses()).containsAll(Arrays.asList(preReqs));
    }
}


