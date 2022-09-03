package hotel.service.mapper;

import hotel.dto.CommentTypeDto;
import hotel.dto.CommentsDto;
import hotel.entity.CommentType;
import hotel.entity.Comments;

import java.util.List;

public class CommentTypeMapper {

    public static CommentTypeDto toDto(CommentType commentType){
        if (commentType == null){
            return null;
        }
        List<CommentsDto> commentsList = commentType.getCommentsList().stream()
                .map(CommentMapper::toDtoWithoutCommentType)
                .toList();

        return CommentTypeDto.builder()
                .id(commentType.getId())
                .type_comment(commentType.getName_type())
                .commentsList(commentsList)
                .build();
    }
    public static CommentType toEntity(CommentTypeDto commentType){
        if (commentType == null){
            return null;
        }
        List<Comments> commentsList = commentType.getCommentsList().stream()
                .map(CommentMapper::toEntityWithoutCommentType)
                .toList();

        return CommentType.builder()
                .id(commentType.getId())
                .name_type(commentType.getType_comment())
                .commentsList(commentsList)
                .build();
    }

    public static CommentType toEntityWithoutCommentList(CommentTypeDto commentType){
        if (commentType == null){
            return null;
        }

        return CommentType.builder()
                .id(commentType.getId())
                .name_type(commentType.getType_comment())
                .build();
    }
    public static CommentTypeDto toDtoWithoutCommentList(CommentType commentType){
        if (commentType == null){
            return null;
        }

        return CommentTypeDto.builder()
                .id(commentType.getId())
                .type_comment(commentType.getName_type())
                .build();
    }

}
