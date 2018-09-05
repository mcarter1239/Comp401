package problem1;

/**
 * Created by Chris Burgess on 10/25/2017.
 */
public class Student implements Comparable<Student>{
    private int pid;
    private String firstName;
    private String lastName;
    private Course.Courses[] completedCourses;

    public Student(int pid, String firstName, String lastName, Course.Courses[] completedCourses) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.completedCourses = completedCourses;
    }

    public Student(int pid, String firstName, String lastName) {
        this(pid, firstName,lastName, new Course.Courses[0]);
    }

    public int getPid() {
        return pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Course.Courses[] getCompletedCourses() {
        return completedCourses;
    }

    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        if (!Student.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        Student student = (Student) object;
        return student.firstName.equals(firstName) && student.lastName.equals(lastName) && student.pid == pid;
    }

    @Override
    public int compareTo(Student o) {
        return lastName.compareTo(o.lastName);
    }
}
