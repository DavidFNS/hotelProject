package hotel.service.impl;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;
import hotel.entity.CommentType;
import hotel.mapper.CommentTypeMap;
import hotel.repository.CommentTypeRepository;
import hotel.service.CommentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentTypeServiceImpl implements CommentTypeService {

    private final CommentTypeRepository commentTypeRepository;

    public CommentTypeServiceImpl(CommentTypeRepository commentTypeRepository){
        this.commentTypeRepository = commentTypeRepository;
    }

    @Override
    public ResponseDto addCommentType(CommentTypeDto commentTypeDto) {
        CommentType commentType = CommentTypeMap.parseToEntity(commentTypeDto);
        commentTypeRepository.save(commentType);
        try {
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            return ResponseDto.builder()
                    .code(404)
                    .success(false)
                    .message("Not working")
                    .build();
        }
    }

    @Override
    public ResponseDto updateCommentType(CommentTypeDto commentTypeDto) {
        Optional<CommentType> optional = commentTypeRepository.findById(commentTypeDto.getId());
        if(optional.isPresent()){
            CommentType commentType = optional.get();
            commentType.setId(commentTypeDto.getId() != null? commentTypeDto.getId() : commentType.getId());
            commentType.setType_comment(commentType.getType_comment() != null? commentTypeDto.getType_comment() : commentType.getType_comment());
            commentTypeRepository.save(commentType);

            return new ResponseDto(200, true, "OK", null);
        }
        return new ResponseDto(404, false, "Not working", null);
    }

    @Override
    public ResponseDto deleteCommentType(Integer id) {
            Optional<CommentType> optional = commentTypeRepository.findById(id);
            if (optional.isPresent()){
                commentTypeRepository.delete(optional.get());
                return ResponseDto.builder()
                        .code(200)
                        .success(true)
                        .message("OK")
                        .build();
            }
            return ResponseDto.builder()
                    .code(404)
                    .success(false)
                    .message("Not working!")
                    .build();
    }

    @Override
    public ResponseDto<List<CommentTypeDto>> getCommentType() {
        List<CommentType> commentTypes = commentTypeRepository.findAll();

        List<CommentTypeDto> commentTypesDtos = commentTypes.stream()
                .map(b ->
                        CommentTypeDto.builder()
                                .id(b.getId())
                                .type_comment(b.getType_comment())
                                .build())
                .toList();
        try {
            return ResponseDto.<List<CommentTypeDto>>builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .data(commentTypesDtos)
                    .build();
        } catch (Exception i){
            return ResponseDto.<List<CommentTypeDto>>builder()
                    .code(404)
                    .success(false)
                    .message("Not working!")
                    .data(null)
                    .build();
        }
    }

    @Override
    public ResponseDto<CommentTypeDto> findById(Integer id) {
        Optional<CommentType> optional = commentTypeRepository.findById(id);
        if (optional.isPresent()){
            CommentTypeDto commentTypeDto = CommentTypeMap.parseToDto(optional.get());
            return new ResponseDto<>(200, true, "OK", commentTypeDto);

        }
        return new ResponseDto<>(404, false, "Not working!", null);
    }
}
