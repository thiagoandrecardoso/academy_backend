package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(name = "number_lesson_completed")
    private int numberLessonCompleted;

    @Column(name = "paid_lesson]")
    private double paidLesson;

    @ManyToOne
    private Lesson lesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberLessonCompleted() {
        return numberLessonCompleted;
    }

    public void setNumberLessonCompleted(int numberLessonCompleted) {
        this.numberLessonCompleted = numberLessonCompleted;
    }

    public double getPaidLesson() {
        return paidLesson;
    }

    public void setPaidLesson(double paidLesson) {
        this.paidLesson = paidLesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
