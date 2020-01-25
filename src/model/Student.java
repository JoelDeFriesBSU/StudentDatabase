package model;

import java.util.*;

public class Student {

    private int id;
    private String name;
    private HashMap<Integer,Double> grades;
    ArrayList<Course> enrolledCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void displayCourses(){
        System.out.println("Courses enrolled for " + name + ":");
        for(Course e : enrolledCourses){
            System.out.println(e);
        }
    }

    public double calculateGPA(){
        double gradeSum = 0;
        Set<Map.Entry<Integer,Double>> gradeSet = grades.entrySet();

        for (Map.Entry<Integer,Double> mapEntry : gradeSet){ // Obtaining sum of grades
            for (Course course : enrolledCourses) {
                if (course.getId() == mapEntry.getKey()) {
                    for (int i = 0 ; i<course.getCredit() ; i++) {
                        gradeSum += mapEntry.getValue();
                    }
                }
            }
        }

        int totalCredits = 0;
        for (Course course : enrolledCourses){
            totalCredits += course.getCredit();
        }

        return (gradeSum / gradeSet.size()) / (totalCredits / gradeSet.size());
    }

    public void enrollCourse(Course course){
        enrolledCourses.add(course);
    }

    public boolean setGrade(Course course, double grade){
        if(enrolledCourses.contains(course)){
            grades.put(course.getId(),grade);
            return true;
        }else{
            return false;
        }
    }

    public List<Course> getEnrolledCourses(){
        return enrolledCourses;
    }


    public static void main(String[] args) {
        Student myself = new Student(1,"Joel");
        Course course1 = new Course(100,30000,"CS222","funny programming",3);
        Course course2 = new Course(101,30002,"CS224","funny algorithms",3);
        Course course3 = new Course(103,30004,"CS224","funny algorithms",3);
        myself.enrollCourse(course1);
        myself.enrollCourse(course2);
        myself.enrollCourse(course3);
        myself.displayCourses();
    }
}
