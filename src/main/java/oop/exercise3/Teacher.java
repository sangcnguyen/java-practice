package oop.exercise3;

public class Teacher extends Person {
    // private instance variables
    private int numCourses;   // number of courses taught currently
    private String[] courses; // course codes
    private static final int MAX_COURSES = 5; // maximum courses

    // Constructor
    public Teacher(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
    }

    // Describe itself
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    // Return false if the course already existed
    public boolean addCourse(String course) {
        // Check if the course already in the course list
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) return false;
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    // Return false if the course cannot be found in the course list
    public boolean removeCourse(String course) {
        boolean found = false;
        // Look for the course index
        int courseIndex = -1;  // need to initialize
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            // Remove the course and re-arrange for courses array
            for (int i = courseIndex; i < numCourses - 1; i++) {
                courses[i] = courses[i + 1];
            }
            numCourses--;
            return true;
        } else {
            return false;
        }
    }
}