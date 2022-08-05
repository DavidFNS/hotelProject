package hotel.service;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    ResponseDto<UsersDto> addUser(UsersDto usersDto);

    ResponseDto updateUser(UsersDto usersDto);

    ResponseDto deleteUser(Integer id);

    ResponseDto<List<UsersDto>> getUser();

    ResponseDto<UsersDto> findById(Integer id);





}
