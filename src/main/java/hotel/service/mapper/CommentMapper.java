package hotel.service.mapper;

import hotel.dto.CommentsDto;
import hotel.entity.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comments toEntity(CommentsDto commentsDto);
    CommentsDto toDto(Comments c);
}
