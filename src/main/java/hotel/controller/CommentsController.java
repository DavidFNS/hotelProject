package hotel.controller;

import hotel.dto.CommentsDto;
import hotel.dto.ResponseDto;
import hotel.entity.Comments;
import hotel.service.impl.CommentsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/comments")

public class CommentsController {
    private final CommentsServiceImpl commentsService;

    public CommentsController(CommentsServiceImpl commentsService){
        this.commentsService = commentsService;
    }

    @GetMapping
    public ResponseDto<List<CommentsDto>> getComment(){
        return commentsService.getComment();
    }

    @GetMapping("/{id}")
    public ResponseDto<CommentsDto> findById(@PathVariable Integer id){
        return commentsService.findById(id);
    }

    @PostMapping
    public ResponseDto addComment(CommentsDto commentsDto){
        return commentsService.addComment(commentsDto);
    }

    @DeleteMapping
    public ResponseDto deleteComment(@RequestParam Integer id){
        return commentsService.deleteComment(id);
    }
}
