package hotel.repository;

import hotel.entity.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentTypeRepository extends JpaRepository<CommentType, Integer> {
}
