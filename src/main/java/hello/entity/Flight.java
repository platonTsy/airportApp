package hello.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "flight", schema = "public")
public class Flight {

    @Id
    @GeneratedValue(generator = "flight_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator( name = "flight_id_seq", sequenceName = "flight_id_seq", allocationSize = 1, schema = "public")
    @Column(name = "\"id\"")
    private long id;

    @Column(name = "\"from\"")
    private String from;

    @Column(name = "\"to\"")
    private String to;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "flight")
    private Set<Shedule> shedules;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "flight")
//    private Ticket ticket;

    public Flight() {
    }

    public Flight(String from, String to, Airplane airplane) {
        this.from = from;
        this.to = to;
        this.airplane = airplane;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Set<Shedule> getShedules() {
        return shedules;
    }

    public void setShedules(Set<Shedule> shedules) {
        this.shedules = shedules;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
