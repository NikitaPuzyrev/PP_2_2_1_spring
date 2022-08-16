package hiber.model;

import javax.persistence.*;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private double series;
    @OneToOne(mappedBy = "usCar", cascade = CascadeType.ALL)
    private User carUser;

    public User getCarUser() {
        return carUser;
    }

    public void setCarUser(User carUser) {
        this.carUser = carUser;
    }

    public Car() {
    }

    public Car(String model, double series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
