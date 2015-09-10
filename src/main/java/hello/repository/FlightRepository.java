package hello.repository;

import hello.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByFrom(String from);
    Flight findFirstByFromAndToAllIgnoreCase(String from, String to);

}


