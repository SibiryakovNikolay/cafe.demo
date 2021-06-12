package project.demo.restoran.model;


import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "table_reserved")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "поле не должно быть пустым")
    @Size(min = 2, max = 20, message = "имя должно содержать от 2х до 20 символов")
    @Column(name = "name_guest")
    private String name;

    @Column(name = "date_reserve")
    private String dateReserve;

    @Column(name = "time_reserve")
    private String timeReserve;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}-\\d{2}", message = "телефон должен быть типа: XXX-XXX-XX-XX")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "confirm")
    private String confirm;


    public Tables(String name, String dateReserve, String timeReserve, String phoneNumber, String confirm) {
        this.name = name;
        this.dateReserve = dateReserve;
        this.timeReserve = timeReserve;
        this.phoneNumber = phoneNumber;
        this.confirm = confirm;
    }

    public Tables() {
    }

    public String getTimeReserve() {
        return timeReserve;
    }

    public void setTimeReserve(String timeReserve) {
        this.timeReserve = timeReserve;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(String dateReserve) {
        this.dateReserve = dateReserve;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
