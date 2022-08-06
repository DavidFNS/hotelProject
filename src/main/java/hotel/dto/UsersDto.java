package hotel.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class UsersDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer age;

    private String phoneNumber;

    private Double account;

    private Date created_at;

}