package hotel.service;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;

import java.util.List;

public interface UserService {
    ResponseDto addUser(UsersDto usersDto);

    ResponseDto updateUser(UsersDto usersDto);

    ResponseDto deleteUser(Integer id);

    ResponseDto<List<UsersDto>> getAllUsers();

    ResponseDto<UsersDto> findById(Integer id);
}
