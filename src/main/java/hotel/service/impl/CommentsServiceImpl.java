package hotel.service.impl;

import hotel.dto.CommentsDto;
import hotel.dto.ResponseDto;
import hotel.entity.Comments;
import hotel.repository.CommentsRepository;
import hotel.service.CommentsService;
import hotel.service.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;
    private final CommentsMapper commentsMapper;

    public CommentsServiceImpl(CommentsRepository commentsRepository, CommentsMapper commentsMapper){
        this.commentsRepository = commentsRepository;
        this.commentsMapper = commentsMapper;
    }

    @Override
    public ResponseDto addComment(CommentsDto commentsDto) {
        commentsRepository.save(commentsMapper.toEntity(commentsDto));
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
                .map(commentsMapper::toDto)
                .toList();
        return new ResponseDto<>(200, true, "OK", commentsDtos);
    }

    @Override
    public ResponseDto<CommentsDto> findById(Integer id) {
        if (commentsRepository.existsById(id)) {
            Comments comments = (commentsRepository.findById(id)).get();
            return new ResponseDto<>(200, true, "OK", commentsMapper.toDto(comments));
        }
        return new ResponseDto<>(404, false, "Not working", null);
    }
}
