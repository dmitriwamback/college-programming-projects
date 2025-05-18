public class CourseScore {

    // properties
    private String courseId;
    private String courseName;
    private int studentId;
    private double score;
    private String teacherId;

    /**
     * Default constructor
     * @param courseId
     * @param courseName
     * @param studentId
     * @param score
     * @param teacherId
     */
    public CourseScore(String courseId, String courseName, int studentId, double score, String teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentId = studentId;
        this.score = score;
        this.teacherId = teacherId;
    }

    // ---------------------------------------------------------------------- //
    // Getters
    // ---------------------------------------------------------------------- //
    public String getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getStudentId() {
        return studentId;
    }
    public double getScore() {
        return score;
    }
    public String getTeacherId() {
        return teacherId;
    }

    // ---------------------------------------------------------------------- //
    // Setters
    // ---------------------------------------------------------------------- //
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
