package hotel.service;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;

import java.util.List;

public interface CommentTypeService {
    ResponseDto<CommentTypeDto> addCommentTypeDto(CommentTypeDto commentTypeDto);

    ResponseDto updateCommentTypeDto(CommentTypeDto commentTypeDto);

    ResponseDto deleteCommentTypeDto(Integer id);

    ResponseDto<List<CommentTypeDto>> getCommentTypeDto();

    ResponseDto<CommentTypeDto> findById(Integer id);

}
