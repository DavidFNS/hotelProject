package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    @Id
    @GeneratedValue(generator = "payment_info_seq")
    @SequenceGenerator(name = "payment_info_seq", sequenceName = "payment_info_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    private Users user;
    private String card_sender;

    private String card_receiver;
    private String name_sender;
    private Date created_at;
}
