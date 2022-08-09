package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    private Integer id;
    private Integer user_id;
    private String comment;
    private Integer status;
    private Integer id_comment_type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
