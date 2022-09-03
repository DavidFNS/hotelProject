package hotel.dto;

import hotel.entity.Comments;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class CommentTypeDto {
    private Integer id;
    private String type_comment;
    private List<CommentsDto> commentsList;
}
