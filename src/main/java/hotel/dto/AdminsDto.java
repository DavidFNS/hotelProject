package hotel.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class AdminsDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String card_number;
    private String valid_date;
    private Double balance;
    private Date created_at;
}
