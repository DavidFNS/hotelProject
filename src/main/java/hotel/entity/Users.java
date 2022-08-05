package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Integer age;

    private String phoneNumber;
    private Double account;

    private Date created_at;
}
