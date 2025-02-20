public class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int registeredStudents;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.registeredStudents = 0;
        this.schedule = schedule;
    }

    // Getters and setters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getCapacity() { return capacity; }
    public int getRegisteredStudents() { return registeredStudents; }
    public String getSchedule() { return schedule; }

    public void registerStudent() {
        if (registeredStudents < capacity) {
            registeredStudents++;
        }
    }

    public void dropStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }
}


