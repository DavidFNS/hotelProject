package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(generator = "java_comments")
    @SequenceGenerator(name = "java_comments", sequenceName = "comments_id_seq", allocationSize = 1)
    private Integer id;
    private Integer user_id;
    private String comment;
    private Integer status;
    private Integer id_comment_type;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
}
