package hotel.controller;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;
import hotel.service.impl.CommentTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment-type")
public class CommentTypeController {
    private final CommentTypeServiceImpl commentTypeService;

    public CommentTypeController(CommentTypeServiceImpl commentTypeService){
        this.commentTypeService = commentTypeService;
    }

    @GetMapping
    public ResponseDto<List<CommentTypeDto>> getAllUsers(){
        return commentTypeService.getCommentType();
    }

    @GetMapping("/{id}")
    public ResponseDto<CommentTypeDto> findById(@PathVariable Integer id){
        return commentTypeService.findById(id);
    }

    @PostMapping
    public ResponseDto addUser(CommentTypeDto commentTypeDto){
        return commentTypeService.addCommentType(commentTypeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteUser(@PathVariable Integer id){
        return commentTypeService.deleteCommentType(id);
    }

    @PatchMapping
    public ResponseDto updateUser(@RequestBody CommentTypeDto commentTypeDto){
        return commentTypeService.updateCommentType(commentTypeDto);
    }
}
