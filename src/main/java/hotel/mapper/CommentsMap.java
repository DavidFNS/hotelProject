package hotel.mapper;

import hotel.dto.CommentsDto;
import hotel.entity.Comments;

public class CommentsMap {
    public static Comments parseToEntity(CommentsDto commentsDto){
        return Comments.builder()
                .id(commentsDto.getId())
                .id_comment_type(commentsDto.getId_comment_type())
                .comment(commentsDto.getComment())
                .user_id(commentsDto.getUser_id())
                .status(commentsDto.getStatus())
                .created_at(commentsDto.getCreated_at())
                .build();
    }
    public static CommentsDto parseToDto(Comments comments){
        return CommentsDto.builder()
                .id(comments.getId())
                .id_comment_type(comments.getId_comment_type())
                .user_id(comments.getUser_id())
                .comment(comments.getComment())
                .status(comments.getStatus())
                .created_at(comments.getCreated_at())
                .build();
    }
}
