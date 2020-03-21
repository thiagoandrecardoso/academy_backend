package main.java.main;

import main.java.dao.LeasonDao;
import main.java.entity.Lesson;
import main.java.entity.Student;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Lesson lesson = new Lesson();

        Student student = new Student();
        student.setName("Jandir");
        student.setAttendance(4);
        student.setTotalAmountPaid(5.00);

        Student student1 = new Student();
        student1.setName("Jose");
        student1.setAttendance(21);
        student1.setTotalAmountPaid(500.00);

        lesson.setDateLesson(new Date());
        lesson.setNumberStudents(12);
        lesson.setRevenues(300.00);
        lesson.setStudents(Arrays.asList(student, student1));

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        lesson.setHour(hour + ":" + minute + ":" + seconds);

        student.setLesson(lesson);
        student1.setLesson(lesson);

        LeasonDao dao = new LeasonDao();
        dao.save(lesson);
    }
}
