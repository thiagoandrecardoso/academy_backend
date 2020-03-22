package main.java.main;

import main.java.dao.LessonDao;
import main.java.dao.StudentDao;
import main.java.entity.Lesson;
import main.java.entity.Student;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Thiago");
        student.setNumberLessonCompleted(1);
        student.setPaidLesson(3.0f);

        Student student1 = new Student();
        student1.setName("Edson");
        student1.setNumberLessonCompleted(10);
        student1.setPaidLesson(4.0f);

        List<Student> students = Arrays.asList(student, student1);

        Lesson lesson = new Lesson();
        lesson.setStudents(students);
        lesson.setDateLesson(new Date());
        lesson.setMoneyCollected(20.0f);
        lesson.setStartTime(new Date());

        Calendar calendar = Calendar.getInstance();
        Date dataAux = new Date();
        calendar.setTime(dataAux);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        dataAux = calendar.getTime();
        lesson.setEndTime(dataAux);
        lesson.setNumberOfStudents(students.size());

        student.setLesson(lesson);
        student1.setLesson(lesson);

        LessonDao lessonDao = new LessonDao();
        lessonDao.save(lesson);

        System.out.println("Aula " +  lesson.getId());

    }
}
