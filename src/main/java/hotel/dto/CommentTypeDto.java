package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CommentTypeDto {
    private Integer id;
    private String type_comment;
}
