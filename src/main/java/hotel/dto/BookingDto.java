package hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookingDto {
    private Integer id;
    private Integer id_payment_method;
    private Integer room_id;
    private Date in_date;
    private Date out_date;
    private Integer count_senior;
    private Integer count_junior;
    private float total_price;
    private Date created_at;

}
