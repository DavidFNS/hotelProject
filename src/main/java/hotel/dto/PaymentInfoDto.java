package hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class PaymentInfoDto {
    private Integer id;
    private UsersDto users;
    private String card_sender;
    private String card_receiver;
    private String name_sender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
