package project.restoran2.demo.restoran.model.menu;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "food")
public class FoodMenu implements Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "поле не должно быть пустым")
    @Size(min = 2, max = 20, message = "название должно содержать от 2х до 20 символов")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "значение не может быть меньше 1")
    @Column(name = "weight")
    private double weight;

    @Min(value = 1, message = "значение не может быть меньше 1")
    @Column(name = "cost")
    private double cost;

    public FoodMenu(String name, double weight, double cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public FoodMenu() {
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


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
