package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryPercent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double percent;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryPercent_id")
    private List<Assignment> assignments;

    @ManyToOne(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private Course course;

    public CategoryPercent() {
    }

    public CategoryPercent(double percent, Category category, Course course) {
        this.percent = percent;
        this.category = category;
        this.course = course;
        List<Assignment> assignments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return this.category.getName();
        }
        else
            return "";
    }
    @Override
    public boolean equals(Object obj) {
        CategoryPercent categoryName = (CategoryPercent) obj;
        return this.getCategory().getName()==categoryName.getCategory().getName();
    }

}
