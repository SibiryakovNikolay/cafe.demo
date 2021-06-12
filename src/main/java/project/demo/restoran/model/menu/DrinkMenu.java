package project.demo.restoran.model.menu;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drinks")
public class DrinkMenu implements Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "поле не должно быть пустым")
    @Size(min = 2, max = 20, message = "название должно содержать от 2х до 20 символов")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "значение не может быть меньше 1")
    @Column(name = "bottle_volume")
    private double bottleVolume;

    @Min(value = 1, message = "значение не может быть меньше 1")
    @Column(name = "cost")
    private double cost;

    public DrinkMenu(String name, double bottleVolume, double cost) {
        this.name = name;
        this.bottleVolume = bottleVolume;
        this.cost = cost;
    }

    public DrinkMenu() {
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

    public double getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(double bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", bottleVolume=" + bottleVolume +
                ", cost=" + cost +
                '}';
    }
}
