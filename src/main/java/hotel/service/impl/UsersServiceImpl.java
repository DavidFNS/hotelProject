package hotel.service.impl;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.repository.UsersRepository;
import hotel.service.UserService;

import java.util.List;

public class UsersServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public ResponseDto<UsersDto> addUser(UsersDto usersDto) {

        return null;
    }

    @Override
    public ResponseDto updateUser(UsersDto usersDto) {
        return null;
    }

    @Override
    public ResponseDto deleteUser(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<UsersDto>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseDto<UsersDto> findById(Integer id) {
        return null;
    }
}
