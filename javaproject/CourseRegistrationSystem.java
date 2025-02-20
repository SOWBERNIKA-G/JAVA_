import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;
    private Scanner scanner;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add course");
            System.out.println("2. Add student");
            System.out.println("3. Register student for course");
            System.out.println("4. Drop student from course");
            System.out.println("5. Display courses");
            System.out.println("6. Display students");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    registerStudentForCourse();
                    break;
                case 4:
                    dropStudentFromCourse();
                    break;
                case 5:
                    displayCourses();
                    break;
                    case 6:
                    displayStudents();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void addCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter course description: ");
        String description = scanner.nextLine();
        System.out.print("Enter course capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter course schedule: ");
        String schedule = scanner.nextLine();

        Course course = new Course(code, title, description, capacity, schedule);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    private void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private void registerStudentForCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Student student = getStudentById(studentId);
        Course course = getCourseByCode(courseCode);
        if (student != null && course != null) {
            student.registerCourse(course);
            System.out.println("Student registered for course successfully!");
        } else {
            System.out.println("Student or course not found!");
        }; // Add semicolon here
    }
private void dropStudentFromCourse() {
    System.out.print("Enter student ID: ");
    String studentId = scanner.nextLine();
    System.out.print("Enter course code: ");
    String courseCode = scanner.nextLine();

    Student student = getStudentById(studentId);
    Course course = getCourseByCode(courseCode);

    if (student != null && course != null) {
        student.dropCourse(course);
        System.out.println("Student dropped from course successfully!");
    } else {
        System.out.println("Student or course not found!");
    }
}

private void displayCourses() {
    System.out.println("Available Courses:");
    for (Course course : courses) {
        System.out.println("Code: " + course.getCode());
        System.out.println("Title: " + course.getTitle());
        System.out.println("Description: " + course.getDescription());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Registered Students: " + course.getRegisteredStudents());
        System.out.println("Schedule: " + course.getSchedule());
        System.out.println();
    }
}

private void displayStudents() {
    System.out.println("Registered Students:");
    for (Student student : students) {
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Registered Courses:");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println();
    }
}

private Student getStudentById(String id) {
    for (Student student : students) {
        if (student.getId().equals(id)) {
            return student;
        }
    }
    return null;
}
private Course getCourseByCode(String code) {
    for (Course course : courses) {
        if (course.getCode().equals(code)) {
            return course;
        }
    }
    return null;
}

public static void main(String[] args) {
    CourseRegistrationSystem system = new CourseRegistrationSystem();
    system.run();
}

}

