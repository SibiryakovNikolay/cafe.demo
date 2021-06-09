package project.restoran2.demo.restoran.model;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "поле не должно быть пустым")
    @Size(min = 2, max = 20, message = "имя должно содержать от 2х до 20 символов")
    @Column(name = "name_guest")
    private String nameGuest;

    @Size(max = 1000, message = "не может содержать больше 1000 символов")
    @Column(name = "review")
    private String review;

    @Column(name="grade")
    private String grade;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
