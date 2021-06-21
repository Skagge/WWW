package pl.skagge.dealership.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offices")
@Getter
@Setter
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String owner;
    @JsonManagedReference
    @OneToMany(mappedBy = "office")
    private List<Car> cars;
}
