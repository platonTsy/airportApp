package hello.repository;

import hello.entity.Shedule;
import org.springframework.data.repository.CrudRepository;

public interface SheduleRepository extends CrudRepository<Shedule, Long>{
}
