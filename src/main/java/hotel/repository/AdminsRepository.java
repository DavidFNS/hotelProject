package hotel.repository;

import hotel.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository <Admins, Integer> {
}
