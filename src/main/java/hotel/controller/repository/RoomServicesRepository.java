package hotel.controller.repository;

import hotel.entity.RoomServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomServicesRepository extends JpaRepository<RoomServices, Integer> {

}
