package hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class BookingDto {
    private Integer id;
    private Integer id_paym_method;
    private Integer user_id;
    private Integer room_id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date in_date;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date out_date;
    private Integer count_senior;
    private Integer count_junior;
    private double total_price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
}
