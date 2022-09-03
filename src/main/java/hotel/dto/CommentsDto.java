package hotel.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Builder
public class CommentsDto {
    private Integer id;
    private UsersDto users;
    private String comment;
    private Integer status;
    private CommentTypeDto commentType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
