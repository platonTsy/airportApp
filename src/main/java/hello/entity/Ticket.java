package hello.entity;

import javax.persistence.*;

@Entity
@Table(name="ticket", schema = "public")
public class Ticket {

    @Id
    @SequenceGenerator(
            name="\"ticket_id_seq\"",
            sequenceName = "\"ticket_id_seq\"",
            allocationSize = 1,
            schema = "public"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "\"ticket_id_seq\""
    )
    @Column(name="\"id\"")
    private long id;

    @Column(name="\"place\"")
    private int place;

    @Column(name = "reserved")
    private Boolean reserved;

    @Column(name="sold")
    private Boolean sold;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "person_id")
//    private Person person;

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sold=" + sold +
                ", reserved=" + reserved +
                ", place=" + place +
                ", id=" + id +
                '}';
    }

}
