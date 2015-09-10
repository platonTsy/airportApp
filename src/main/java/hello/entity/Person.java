package hello.entity;


import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name="person", schema = "public")
public class Person {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "\"person_id_seq\""
    )
    @SequenceGenerator(
            name = "\"person_id_seq\"",
            sequenceName = "\"person_id_seq\"",
            allocationSize = 1,
            schema = "public"
    )
    @Column(name="\"id\"")
    private long id;

    @Column(name="\"name\"")
    private String name;

    @Column(name="\"surname\"")
    private String surname;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
//    Set<Ticket> tickets;


    public Person() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public Set<Ticket> getTickets() {
//        return tickets;
//    }
//
//    public void setTickets(Set<Ticket> tickets) {
//        this.tickets = tickets;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
