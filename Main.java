import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        // 3. Course Setup: En az 3 ders oluşturma
        int numCourses = 0;
        while (numCourses < 3) {
            System.out.print("Kaç ders oluşturmak istiyorsunuz? (En az 3 olmalıdır): ");
            if (scanner.hasNextInt()) {
                numCourses = scanner.nextInt();
                scanner.nextLine(); // Satır sonu karakterini temizle
                if (numCourses < 3) {
                    System.out.println("Hata: En az 3 ders girmelisiniz!");
                }
            } else {
                System.out.println("Geçersiz giriş! Lütfen bir sayı girin.");
                scanner.nextLine();
            }
        }

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\n--- " + i + ". Ders Bilgileri ---");
            System.out.print("Ders Adı: ");
            String courseName = scanner.nextLine().trim();

            int capacity = 0;
            while (capacity <= 0) {
                System.out.print("Sınıf Kapasitesi: ");
                if (scanner.hasNextInt()) {
                    capacity = scanner.nextInt();
                    scanner.nextLine();
                    if (capacity <= 0) {
                        System.out.println("Kapasite pozitif bir sayı olmalıdır.");
                    }
                } else {
                    System.out.println("Geçersiz giriş! Sayı giriniz.");
                    scanner.nextLine();
                }
            }

            courses.add(new Course(courseName, capacity));
        }

        // Açılan derslerin listesi
        System.out.println("\n=== Kayıt İçin Mevcut Dersler ===");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " (Kapasite: " + c.getCapacity() + ")");
        }

        // 4. Register Students: Öğrenci kayıt döngüsü
        System.out.println("\n=== Öğrenci Kayıt İşlemleri ===");
        while (true) {
            System.out.print("\nYeni bir öğrenci kaydetmek istiyor musunuz? (e/h): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("h")) {
                break;
            } else if (!answer.equals("e")) {
                System.out.println("Lütfen 'e' (evet) veya 'h' (hayır) giriniz.");
                continue;
            }

            System.out.print("Öğrenci ID: ");
            String studentID = scanner.nextLine().trim();

            System.out.print("Öğrenci Adı: ");
            String studentName = scanner.nextLine().trim();

            System.out.print("Kayıt olunmak istenen dersin tam adı: ");
            String targetCourseName = scanner.nextLine().trim();

            // Dersi listede arama
            Course selectedCourse = null;
            for (Course c : courses) {
                if (c.getCourseName().equalsIgnoreCase(targetCourseName)) {
                    selectedCourse = c;
                    break;
                }
            }

            if (selectedCourse == null) {
                System.out.println("No course found with that name.");
            } else {
                Student newStudent = new Student(studentID, studentName);
                selectedCourse.registerStudent(newStudent);
            }
        }

        // 5. View All Courses: Tüm dersleri ve kayıtlı öğrencileri listeleme
        System.out.println("\n\n========================================");
        System.out.println("        TÜM DERSLER VE KAYITLAR        ");
        System.out.println("========================================");
        for (Course c : courses) {
            c.displayCourseInfo();
        }

        scanner.close();
    }
}
