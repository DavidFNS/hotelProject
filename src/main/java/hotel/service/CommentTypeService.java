package hotel.service;

import hotel.dto.CommentTypeDto;
import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;

import java.util.List;

public interface CommentTypeService {
    ResponseDto<CommentTypeDto> addUser(CommentTypeDto commentTypeDto);

    ResponseDto updateUser(CommentTypeDto );

    ResponseDto deleteUser(Integer id);

    ResponseDto<List<UsersDto>> getUser();

    ResponseDto<UsersDto> findById(Integer id);

}
