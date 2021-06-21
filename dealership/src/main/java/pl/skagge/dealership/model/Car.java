package pl.skagge.dealership.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String vin;
    private String color;
    private int power;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}
