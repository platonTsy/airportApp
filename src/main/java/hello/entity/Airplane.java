package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="airplane", schema = "public")
public class Airplane {

    @Id
    @SequenceGenerator(
            name = "airplane_id_seq",
            schema = "public",
            sequenceName = "airplane_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "airplane_id_seq"
    )
    @Column(name = "\"id\"")
    private long id;

    @Column(name = "\"name\"")
    private String name;

    @Column(name="\"place_count\"")
    private int placeCount;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "airplane"
    )
    Set<Flight> flights;

    public Airplane() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", placeCount=" + placeCount +
                '}';
    }
}
