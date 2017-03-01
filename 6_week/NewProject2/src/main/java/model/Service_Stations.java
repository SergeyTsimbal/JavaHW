package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service_stations")
public class Service_Stations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_stations_id")
    private Long id;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "service_stations", fetch = FetchType.EAGER)
    private Set<Mechanic> mechanic = new HashSet<Mechanic>();
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="service")
    private Set<Car> car = new HashSet<Car>();


    public Service_Stations() {
    }

    public Set<Car> getCar() {
        return car;
    }

    public void setCar(Set<Car> car) {
        this.car = car;
    }

    public Set<Mechanic> getMechanic() {
        return mechanic;
    }

    public void setMechanic(Set<Mechanic> mechanic) {
        this.mechanic = mechanic;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Service_Stations{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
