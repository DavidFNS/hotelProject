package hotel.service.impl;

import hotel.dto.CommentsDto;
import hotel.dto.ResponseDto;
import hotel.entity.Comments;
import hotel.repository.CommentsRepository;
import hotel.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository){
        this.commentsRepository = commentsRepository;
    }

    @Override
    public ResponseDto addComment(CommentsDto commentsDto) {
        Comments comments = Comments.builder()
                .id(commentsDto.getId())
                .id_comment_type(commentsDto.getId_comment_type())
                .comment(commentsDto.getComment())
                .user_id(commentsDto.getUser_id())
                .status(commentsDto.getStatus())
                .created_at(commentsDto.getCreated_at())
                .build();
        commentsRepository.save(comments);
        try {
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            return ResponseDto.builder()
                    .code(404)
                    .success(true)
                    .message("Not working")
                    .build();
        }
    }

    @Override
    public ResponseDto deleteComment(Integer id) {
        Optional<Comments> comments = commentsRepository.findById(id);
        if(comments.isPresent()){
            commentsRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();

        }
        return ResponseDto.builder()
                .code(404)
                .success(false)
                .message("Not working")
                .build();
    }

    @Override
    public ResponseDto<List<CommentsDto>> getComment() {
        List<Comments> comments = commentsRepository.findAll();
        List<CommentsDto> commentsDtos = comments.stream()
                .map(i -> CommentsDto.builder()
                        .id(i.getId())
                        .id_comment_type(i.getId_comment_type())
                        .user_id(i.getUser_id())
                        .comment(i.getComment())
                        .status(i.getStatus())
                        .created_at(i.getCreated_at())
                        .build())
                .toList();
        ResponseDto<List<CommentsDto>> responseDto = new ResponseDto<>(200, true, "OK", commentsDtos);
        return responseDto;
    }

    @Override
    public ResponseDto<CommentsDto> findById(Integer id) {
        if (commentsRepository.existsById(id)) {

            Comments comments = (commentsRepository.findById(id)).get();


        }
        return null;
    }
}
