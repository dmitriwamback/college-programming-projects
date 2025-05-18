import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Comparable<Student> {


    private String discipline;
    private int yearOfStudy;
    private List<CourseScore> courses;

    private double gpa;

    /**
     * Default constructor
     * @param id
     * @param name
     * @param gender
     * @param discipline
     * @param yearOfStudy
     */
    public Student(int id, String name, char gender, String discipline, int yearOfStudy) {
        super(id, name, gender);
        this.discipline = discipline;
        this.yearOfStudy = yearOfStudy;
        this.courses = new ArrayList<CourseScore>();
        this.gpa = 0;
    }

    // ---------------------------------------------------------------------- //
    // Getters
    // ---------------------------------------------------------------------- //
    public String getDiscipline() {
        return discipline;
    }
    public int getYearOfStudy() {
        return yearOfStudy;
    }
    public List<CourseScore> getCourses() {
        return courses;
    }
    public double getGPA() {
        return gpa;
    }

    // ---------------------------------------------------------------------- //
    // Setters
    // ---------------------------------------------------------------------- //
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    public void addCourse(CourseScore course) {
        courses.add(course);
    }

    // ---------------------------------------------------------------------- //
    // Calculate GPA
    // ---------------------------------------------------------------------- //
    /**
     * function that calculates the GPA of a student based on their courses
     */
    public void calculateGPA() {

        // assign a total score
        double totalScore = 0;
        for (CourseScore course : courses) {
            // add each score to the total score and divide by 25
            // /25 => [0, 100] mapping into [0, 4]
            totalScore += course.getScore()/25.0;
        }
        // calculate total GPA (assume all courses have the same credits)
        double gpa = totalScore / courses.size();
        // map it to only 2 digits by casting to an int and dividing by 100
        double gpaTwoDecimalPlaces = (int)(gpa * 100)/100.0;
        this.gpa = gpaTwoDecimalPlaces; // setting
    }

    @Override
    public String toString() {
        // toString method for the student to write to the result file
        return "Student: " 
                + super.getName() + ", id: " 
                + super.getId() + ", gender: " 
                + super.getGender() + ", discipline: " 
                + discipline + ", years of study: " 
                + yearOfStudy + ", GPA: " + gpa;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
