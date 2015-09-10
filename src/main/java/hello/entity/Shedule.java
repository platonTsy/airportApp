package hello.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="shedule", schema = "public")
public class Shedule {

    @Id
    @SequenceGenerator(
            name = "shedule_id_seq",
            sequenceName = "shedule_id_seq",
            allocationSize = 1,
            schema = "public"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shedule_id_seq"
    )
    @Column(name = "\"id\"")
    private long id;

    @Column(name="\"since\"")
    private Timestamp since;

    @Column(name = "\"to\"")
    private Timestamp to;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"flight_id\"")
    private Flight flight;

    public Shedule() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getSince() {
        return since;
    }

    public void setSince(Timestamp since) {
        this.since = since;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Shedule{" +
                "to=" + to +
                ", since=" + since +
                ", id=" + id +
                '}';
    }
}
