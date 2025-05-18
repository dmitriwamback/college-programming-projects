import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileServiceI {

    @Override
    public List<Student> readStudents(String filename) {
        
        // open a file and check if it exists
        File file = openFile(filename);
        if (file == null) return null;

        // grab the contents of the file and each line
        String content = readFile(file);
        if (content == null) {
            System.out.println("File content is null");
            return null;
        }
        String[] lines = content.split("\n");

        // create a students list
        List<Student> students = new ArrayList<Student>();

        // go through each line of the file
        for (String line : lines) {
            try {
                // grab the elements separated by a comma
                String[] lineElements = line.split(",");

                // grab the id, studentName, discipline, yearOfStudy, and gender and parse it to its appropriate data type
                int id              = Integer.parseInt(lineElements[0]);
                String studentName  = lineElements[1];
                String discipline   = lineElements[2];
                int yearOfStudy     = Integer.parseInt(lineElements[3]);
                char gender         = lineElements[4].charAt(0);
                
                // create a new Student and append it to the list
                students.add(new Student(id, studentName, gender, discipline, yearOfStudy));
            }
            catch (Exception e) {
                System.out.println("Invalid file format: " + e); // exception if the file format is wrong (i.e. wrong parsing)
                return null;
            }
        }

        return students;
    }

    @Override
    public List<CourseScore> readScores(String filename) {
        
        // open a file and check if it exists
        File file = openFile(filename);
        if (file == null) return null;

        // grab the contents of the file and each line
        String content = readFile(file);
        if (content == null) {
            System.out.println("File content is null");
            return null;
        }
        String[] lines = content.split("\n");

        // create a course score list
        List<CourseScore> courseScores = new ArrayList<CourseScore>();

        // go through each line of the file
        for (String line : lines) {
            try {
                // grab the elements separated by a comma
                String[] lineElements = line.split(",");

                // grab the id, courseName, studentId, score, and teacherId and parse it to its appropriate data type
                String id           = lineElements[0];
                String courseName   = lineElements[1];
                int studentId       = Integer.parseInt(lineElements[2]);
                double score        = Double.parseDouble(lineElements[3]);
                String teacherId    = lineElements[4];
                
                // create a new CourseScore and append it to the list
                courseScores.add(new CourseScore(id, courseName, studentId, score, teacherId));
            }
            catch (Exception e) {
                System.out.println("Invalid file format: " + e);  // exception if the file format is wrong (i.e. wrong parsing)
                return null;
            }
        }

        return courseScores;
    }

    @Override
    public void writeToFile(String filename, List<Student> students) {
        
        // create a new file
        File file = new File(filename);
        PrintWriter printWriter = null; // create a printWriter
        try {
            // assign the printWriter to the file
            printWriter = new PrintWriter(file);

            // print the student information (using the student's toString method)
            for (Student student : students) {
                printWriter.println(student);
            }

            // close the printWriter
            printWriter.close();
        }
        catch(IOException e) {
            // warn the user that the program couldn't write to their desired file
            System.out.println("Couldn't write to file");
        }
    }
    
    /**
     * function that opens a file and checks if it exists or not
     * @param filename
     * @return
     */
    private File openFile(String filename) {
        
        // open a file
        File file = new File(filename);

        // if it doesn't exist then return null
        if (!file.exists()) return null;

        // otherwise return the file
        return file;
    }

    /**
     * function that reads the contents of a file
     * @param file
     * @return
     */
    private String readFile(File file) {

        // create a new stringbuilder
        StringBuilder stringBuilder = new StringBuilder();
        
        // fault-safety
        try {
            // read the file using a Scanner
            Scanner scanner = new Scanner(file);

            // read each line of the file and add a new line character '\n' to the end of the line
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()+'\n');
            }
        }
        catch(IOException exception) {
            // warning
            System.out.println("The file you're trying to read is invalid");
            return null; 
        }

        // return the stringbuilder as a string
        return stringBuilder.toString();
    }
}
