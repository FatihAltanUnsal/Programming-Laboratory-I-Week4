import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Öğrencinin bu derse daha önce kayıt olup olmadığını kontrol eder
    public boolean isStudentEnrolled(String studentID) {
        for (Student s : enrolledStudents) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                return true;
            }
        }
        return false;
    }

    // Öğrenci kayıt işlemi ve kural kontrolleri
    public boolean registerStudent(Student student) {
        // Kapasite kontrolü
        if (enrolledStudents.size() >= capacity) {
            System.out.println("This course is full. Registration failed.");
            return false;
        }

        // Mükerrer ID kontrolü
        if (isStudentEnrolled(student.getStudentID())) {
            System.out.println("This student is already registered for this course.");
            return false;
        }

        enrolledStudents.add(student);
        System.out.println("Registration successful.");
        return true;
    }

    // Ders bilgilerini ve kayıtlı öğrencileri gösteren metot
    public void displayCourseInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Ders Adı       : " + courseName);
        System.out.println("Kapasite       : " + capacity);
        System.out.println("Kayıtlı Sayısı : " + enrolledStudents.size());
        System.out.println("Kayıtlı Öğrenciler:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("  (Kayıtlı öğrenci bulunmamaktadır)");
        } else {
            for (Student s : enrolledStudents) {
                s.printStudentInfo();
            }
        }
    }
}