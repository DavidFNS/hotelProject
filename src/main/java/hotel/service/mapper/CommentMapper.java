package hotel.service.mapper;

import hotel.dto.CommentsDto;
import hotel.entity.Comments;

public class CommentMapper {
    public static Comments toEntity(CommentsDto comments){
        if (comments == null){
            return null;
        }

        return Comments.builder()
                .id(comments.getId())
                .comment(comments.getComment())
                .user(UsersMapper.toEntity(comments.getUsers()))
                .commentType(CommentTypeMapper.toEntityWithoutCommentList(comments.getCommentType()))
                .status(comments.getStatus())
                .created_at(comments.getCreated_at())
                .build();
    }

    public static Comments toEntityWithoutCommentType(CommentsDto comments){
        if (comments == null){
            return null;
        }

        return Comments.builder()
                .id(comments.getId())
                .comment(comments.getComment())
                .user(UsersMapper.toEntity(comments.getUsers()))
                .status(comments.getStatus())
                .created_at(comments.getCreated_at())
                .build();
    }

    public static CommentsDto toDto(Comments comments){
        if (comments == null){
            return null;
        }

        return CommentsDto.builder()
                .id(comments.getId())
                .comment(comments.getComment())
                .users(UsersMapper.toDto(comments.getUser()))
                .commentType(CommentTypeMapper.toDtoWithoutCommentList(comments.getCommentType()))
                .status(comments.getStatus())
                .created_at(comments.getCreated_at())
                .build();
    }

    public static CommentsDto toDtoWithoutCommentType(Comments comments){
        if (comments == null){
            return null;
        }

        return CommentsDto.builder()
                .id(comments.getId())
                .comment(comments.getComment())
                .users(UsersMapper.toDto(comments.getUser()))
                .status(comments.getStatus())
                .created_at(comments.getCreated_at())
                .build();
    }
}
