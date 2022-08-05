package hotel.repository;

import hotel.entity.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentTypeRepository extends JpaRepository<CommentType, Integer> {
}
