package model;

import javax.persistence.*;

@Entity
@Table(name = "mechanic")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_stations_id", nullable = false)
    private Service_Stations service_stations;


    public Service_Stations getService_stations() {
        return service_stations;
    }

    public void setService_stations(Service_Stations service_stations) {
        this.service_stations = service_stations;
    }

    public Mechanic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Mechanic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", service_stations=" + service_stations +
                '}';
    }


}
