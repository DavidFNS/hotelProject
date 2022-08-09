package hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class AdminsDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String card_number;
    private String valid_date;
    private Double balance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
