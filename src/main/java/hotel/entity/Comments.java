package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

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

    @ManyToOne
    private Users user;
    private String comment;
    private Integer status;
    @ManyToOne
    private CommentType commentType;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
}
