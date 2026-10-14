public class Student {
    private String studentID;
    private String name;

    // Constructor
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    // Getter metotları
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    // Öğrenci bilgilerini ekrana yazdıran metot
    public void printStudentInfo() {
        System.out.println("  ID: " + studentID + " | Ad: " + name);
    }
}