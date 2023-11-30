package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue
    private long car_id;
    private String model;
    private int series;

    @OneToOne(mappedBy = "car")
    private User owner;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public long getId() {
        return car_id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public User getOwner() {
        return owner;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
