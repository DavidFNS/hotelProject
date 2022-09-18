package hotel.repository;

import hotel.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select u from Users u where exists(select id from Booking b where b.user_id = u.id)", nativeQuery = true)
    List<Users> getUsersWhoOrderedRoom();

    @Query("select u from Users u where u.email = :email")
    List<Users> findByEmail(String email);
}
