package problem1;

import java.util.Arrays;

/**
 * Created by Chris Burgess on 10/25/2017.
 */

public class Main {
    public static void main(String[] args) {
        Course.Courses[] requirements_401 = new Course.Courses[]{Course.Courses.COMP101, Course.Courses.COMP110};
        Course comp401 = new CourseImpl("Foundations of Programming", 401, "kmp", requirements_401);

        Course.Courses[] insufficient_requirements = new Course.Courses[]{Course.Courses.COMP101};
        Course.Courses[] sufficient_requirements = new Course.Courses[]{Course.Courses.COMP101, Course.Courses.COMP110};
        Course.Courses[] no_requirements = new Course.Courses[]{};

        comp401.addStudent(new Student(6548, "Michael", "Scott", insufficient_requirements));
        comp401.addStudent(new Student(1236, "Kevin", "Malone", insufficient_requirements));

        comp401.addStudent(new Student(6489, "Jim", "Halpert", sufficient_requirements));
        comp401.addStudent(new Student(6942, "Andy", "Bernard", sufficient_requirements));
        comp401.addStudent(new Student(8434, "Oscar", "Martinez", sufficient_requirements));
        comp401.addStudent(new Student(3237, "Pam", "Beasley", sufficient_requirements));

        comp401.addStudent(new Student(7845, "Toby", "Flenderson", no_requirements));

        //students who do not meet all requirements will not be accepted to the course
        System.out.println(comp401.getRoster());

    }
}
