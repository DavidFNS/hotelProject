package hotel.service;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;

import java.util.List;

public interface CommentTypeService {
    ResponseDto addCommentType(CommentTypeDto commentTypeDto);

    ResponseDto updateCommentType(CommentTypeDto commentTypeDto);

    ResponseDto deleteCommentType(Integer id);

    ResponseDto<List<CommentTypeDto>> getCommentType();

    ResponseDto<CommentTypeDto> findById(Integer id);

}
