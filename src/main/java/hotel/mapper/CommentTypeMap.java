package hotel.mapper;

import hotel.dto.CommentTypeDto;
import hotel.entity.CommentType;

public class CommentTypeMap {
    public static CommentTypeDto parseToDto(CommentType commentType){
        return CommentTypeDto.builder()
                .id(commentType.getId())
                .type_comment(commentType.getType_comment())
                .build();
    }

    public static CommentType parseToEntity(CommentTypeDto commentTypeDto){
        return CommentType.builder()
                .id(commentTypeDto.getId())
                .type_comment(commentTypeDto.getType_comment())
                .build();
    }
}
