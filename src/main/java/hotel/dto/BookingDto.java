package hotel.dto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
@Builder
public class BookingDto {
    private Integer id;
    @NotNull
    private PaymentMethodDto paymentMethod;
    @NotNull
    private UsersDto user;
    @NotNull
    private RoomsDto room;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @FutureOrPresent
    private Date in_date;
    @Future
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date out_date;
    @NotNull

    private Integer count_senior;
    @NotNull
    private Integer count_junior;
    @NotNull
    private double total_price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
}
