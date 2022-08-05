package hotel.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class PaymentInfoDto {
    private Integer id;
    private Integer user_id;
    private String card_sender;
    private String card_receiver;
    private String name_sender;
    private Date created_at;
}
