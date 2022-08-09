package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    @Id
    private Integer id;
    private Integer user_id;
    private String card_sender;
    private String card_receiver;
    private String name_sender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
