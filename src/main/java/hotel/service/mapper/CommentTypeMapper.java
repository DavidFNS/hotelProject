package hotel.service.mapper;

import hotel.dto.CommentTypeDto;
import hotel.entity.CommentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentTypeMapper {
    CommentTypeDto toDto(CommentType commentType);
    CommentType toEntity(CommentTypeDto commentTypeDto);
}
