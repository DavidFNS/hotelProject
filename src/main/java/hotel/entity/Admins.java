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
public class Admins {
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String card_number;
    private String valid_date;
    private Float balance;
    private Date created_at;
}
