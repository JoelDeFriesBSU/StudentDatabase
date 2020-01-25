package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testEnrollingCourses(){
        Course aCourse = new Course(234,2300,"CS200","A course about CS or something",3);
        Student aStudent = new Student(1,"Joel");
        aStudent.enrollCourse(aCourse);
        assertEquals(1, aStudent.getEnrolledCourses().size());
    }

    @Test
    void testGradeSettingWithCourseEnrolled(){
        Course aCourse = new Course(234,2300,"CS200","A course about CS or something",3);
        Student aStudent = new Student(1,"Joel");
        aStudent.enrollCourse(aCourse);
        assertEquals(true,aStudent.setGrade(aCourse,4.0));

    }

    @Test
    void testGradeSettingWithoutCourseEnrolled(){
        Course aCourse = new Course(234,2300,"CS200","A course about CS or something",3);
        Student aStudent = new Student(1,"Joel");
        assertEquals(false,aStudent.setGrade(aCourse,4.0));

    }

    @Test
    void testGPACalculatorForAccuracy(){
        Student myself = new Student(1,"Joel");
        Course course1 = new Course(100,30000,"CS222","funny programming",3);
        Course course2 = new Course(101,30002,"CS224","funny algorithms",3);
        myself.enrollCourse(course1);
        myself.enrollCourse(course2);

        myself.setGrade(course1,4.0);
        myself.setGrade(course2,4.0);
        assertEquals(4.0,myself.calculateGPA());

    }

}