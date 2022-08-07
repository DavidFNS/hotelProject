package hotel.repository;

import hotel.entity.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee, Integer> {

}
