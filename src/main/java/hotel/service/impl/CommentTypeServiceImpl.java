package hotel.service.impl;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;
import hotel.repository.CommentTypeRepository;
import hotel.service.CommentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentTypeServiceImpl implements CommentTypeService {

    private final CommentTypeRepository commentTypeRepository;

    public CommentTypeServiceImpl(CommentTypeRepository commentTypeRepository){
        this.commentTypeRepository = commentTypeRepository;
    }

    @Override
    public ResponseDto addCommentType(CommentTypeDto commentTypeDto) {

        return null;
    }

    @Override
    public ResponseDto updateCommentType(CommentTypeDto commentTypeDto) {
        return null;
    }

    @Override
    public ResponseDto deleteCommentType(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<CommentTypeDto>> getCommentType() {
        return null;
    }

    @Override
    public ResponseDto<CommentTypeDto> findById(Integer id) {
        return null;
    }
}
