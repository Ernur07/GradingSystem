package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name="Student_Status")
public abstract class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String buId;
    private String email;
    private double totalGrade=0;
    private String letterScore="";
    boolean freezed=false;
    String comment = "";

    @ManyToOne(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    List<Grades> grades;


    public Student() {
    }
    public Student(String name, String surname, String buId, String email) {
        this.name = name;
        this.surname = surname;
        this.buId = buId;
        this.email = email;
    }
    public Student(String name, String surname, String buId, String email,Course course) {
        this.name = name;
        this.surname = surname;
        this.buId = buId;
        this.email = email;
        this.course=course;
        this.grades=new ArrayList<Grades>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    public boolean isFreezed() {
        return freezed;
    }

    public void setFreezed(boolean freezed) {
        this.freezed = freezed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getLetterScore() {
        return letterScore;
    }

    public void setLetterScore(String letterScore) {
        this.letterScore = letterScore;
    }

    @Override
    public String toString() {
        return this.getName()+" "+this.getSurname();
    }
}
