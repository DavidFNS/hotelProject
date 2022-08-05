package hotel.repository;

import hotel.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository <PaymentInfo, Integer> {
}
