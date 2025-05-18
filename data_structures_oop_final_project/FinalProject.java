import java.util.Comparator;
import java.util.List;

public class FinalProject {
    
    public static void finalProjectMain() {

        // create the FileServiceImpl class 
        FileServiceImpl implementation = new FileServiceImpl();

        // read student and course information
        List<Student> students = implementation.readStudents("student.txt");
        List<CourseScore> courseScores = implementation.readScores("courseScore.txt");

        // assign each student their corresponding courses
        for (Student student : students) {
            for (CourseScore course : courseScores) {
                if (course.getStudentId() == student.getId()) student.addCourse(course);
            }
            // calculate the GPA once all the courses are added
            student.calculateGPA();
        }

        // sort by studentID
        students.sort(Comparator.comparingInt(s -> s.getId()));

        // sort by GPA
        students.sort((student1, student2) -> Double.compare(student2.getGPA(), student1.getGPA()));

        // write data to 'result.txt'
        implementation.writeToFile("result.txt", students);
    }
}
