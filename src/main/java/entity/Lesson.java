package main.java.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_lesson")
    private Date dateLesson;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")
    private Date endTime;

    private float moneyCollected;
    private int numberOfStudents;

    // FetchType.EAGER para poder retornar toda a lista
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "lesson")
    private List<Student> students;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
