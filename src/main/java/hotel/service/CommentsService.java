package hotel.service;

import hotel.dto.CommentsDto;
import hotel.dto.ResponseDto;

import java.util.List;

public interface CommentsService {
    ResponseDto addComment(CommentsDto commentsDto);

    ResponseDto deleteComment(Integer id);

    ResponseDto<List<CommentsDto>> getComment();

    ResponseDto<CommentsDto> findById(Integer id);
}
