package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    @Id
    @GeneratedValue(generator = "java_booking_seq")
    @SequenceGenerator(name = "java_booking_seq", sequenceName = "user_id_seq", allocationSize = 1)
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
