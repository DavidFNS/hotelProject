package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date created_at;
}
