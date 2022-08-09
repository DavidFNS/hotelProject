package hotel.repository;

import hotel.dto.UsersDto;
import hotel.entity.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentTypeRepository extends JpaRepository<CommentType, Integer> {

    @Query("select '*' from Users")
    UsersDto query_q(UsersDto usersDto);
}
