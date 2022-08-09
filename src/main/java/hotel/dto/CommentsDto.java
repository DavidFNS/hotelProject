package hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class CommentsDto {
    private Integer id;
    private Integer user_id;
    private String comment;
    private Integer status;
    private Integer id_comment_type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
