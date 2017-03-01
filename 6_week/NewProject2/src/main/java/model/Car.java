package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "make")
    private String make;
    @Column(name = "price")
    private int price;
    @Column(name = "date")
    private Date date;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_sto", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "sto_id"))
    private Set<Service_Stations> service = new HashSet();

    public Car() {
    }

    public Set<Service_Stations> getService() {
        return service;
    }

    public void setService(Set<Service_Stations> service) {
        this.service = service;
    }

    public void add(Service_Stations ser) {
        service.add(ser);
    }

    public Long getId() {
        return id;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
