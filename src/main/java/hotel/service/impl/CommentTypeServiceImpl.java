package hotel.service.impl;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;
import hotel.repository.CommentTypeRepository;
import hotel.service.CommentTypeService;

import java.util.List;

public class CommentTypeServiceImpl implements CommentTypeService {

    private CommentTypeRepository commentTypeRepository;

    public CommentTypeServiceImpl(CommentTypeRepository commentTypeRepository){
        this.commentTypeRepository = commentTypeRepository;
    }

    @Override
    public ResponseDto<CommentTypeDto> addCommentTypeDto(CommentTypeDto commentTypeDto) {
        return null;
    }

    @Override
    public ResponseDto updateCommentTypeDto(CommentTypeDto commentTypeDto) {
        return null;
    }

    @Override
    public ResponseDto deleteCommentTypeDto(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<CommentTypeDto>> getCommentTypeDto() {
        return null;
    }

    @Override
    public ResponseDto<CommentTypeDto> findById(Integer id) {
        return null;
    }
}
