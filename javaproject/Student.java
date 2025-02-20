import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.registerStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.dropStudent();
    }
}

