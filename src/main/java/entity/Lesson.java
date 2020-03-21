package main.java.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateLesson;
    private String startTime;
    private String endTime;
    private float moneyCollected;
    private int numberOfStudents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateLesson() {
        return dateLesson;
    }

    public void setDateLesson(Date dateLesson) {
        this.dateLesson = dateLesson;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getMoneyCollected() {
        return moneyCollected;
    }

    public void setMoneyCollected(float moneyCollected) {
        this.moneyCollected = moneyCollected;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
