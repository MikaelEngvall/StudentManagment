package se.lexicon.model;

public class Student {
    private int id;
    private String name;
    private static int nextStudentID = 1; // Initialize the next available ID

    // Methods

    private int generateUniqueID() {
        int uniqueID = nextStudentID;
        nextStudentID++; // Increment for the next student
        return uniqueID;
    }

    // Constructors

    public Student(String name) {
        this.id = generateUniqueID(); // Assign the unique ID
        this.name = name;
    }
    public Student(int id, String name) {
        this.id = id; // Use the provided ID
        this.name = name;
        if (id >= nextStudentID) {
            nextStudentID = id + 1; // Update nextStudentID if necessary
        }
    }

// Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        if (id >= nextStudentID) {
            nextStudentID = id + 1; // Update nextStudentID if necessary
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
