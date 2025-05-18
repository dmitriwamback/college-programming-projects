import java.util.List;

public interface FileServiceI {

    // methods to override
    List<Student> readStudents(String filename);
    List<CourseScore> readScores(String filename);
    void writeToFile(String filename, List<Student> students);
}
