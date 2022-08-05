package hotel.service.impl;

import hotel.dto.CommentsDto;
import hotel.dto.ResponseDto;
import hotel.repository.CommentsRepository;
import hotel.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
    }


    @Override
    public ResponseDto<CommentsDto> addComment(CommentsDto commentsDto) {
        return null;
    }

    @Override
    public ResponseDto updateComment(CommentsDto commentsDto) {
        return null;
    }

    @Override
    public ResponseDto deleteComment(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<CommentsDto>> getComment() {
        return null;
    }

    @Override
    public ResponseDto<CommentsDto> findById(Integer id) {
        return null;
    }
}
