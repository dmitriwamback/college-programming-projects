public class Person {
    private int id;
    private String name;
    private char gender;
    
    /**
     * Default constructor
     * @param id
     * @param name
     * @param gender
     */
    public Person(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    // ---------------------------------------------------------------------- //
    // Getters
    // ---------------------------------------------------------------------- //
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }

    // ---------------------------------------------------------------------- //
    // Setters
    // ---------------------------------------------------------------------- //
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
}
