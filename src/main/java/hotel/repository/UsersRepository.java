package hotel.repository;

import hotel.dto.UsersDto;
import hotel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select * from Users", nativeQuery = true)
    List<Users> query_q();
}
