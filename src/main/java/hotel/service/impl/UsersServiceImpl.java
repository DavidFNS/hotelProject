package hotel.service.impl;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.entity.Users;
import hotel.mapper.UsersMap;
import hotel.repository.UsersRepository;
import hotel.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public ResponseDto addUser(UsersDto usersDto) {
        Users user = UsersMap.parseToEntity(usersDto);
        usersRepository.save(user);
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
    public ResponseDto updateUser(UsersDto usersDto) {
        Users users = UsersMap.parseToEntity(usersDto);
        Optional<Users> optional = usersRepository.findById(users.getId());
        if (optional.isPresent()) {
            usersRepository.save(optional.get());
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
    public ResponseDto deleteUser(Integer id) {

        return null;
    }

    @Override
    public ResponseDto<List<UsersDto>> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(u -> UsersDto.builder()
                        .id(u.getId())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName())
                        .birthDate(u.getBirthDate())
                        .phoneNumber(u.getPhoneNumber())
                        .email(u.getEmail())
                        .gender(u.getGender())
                        .username(u.getUsername())
                        .password(u.getPassword())
                        .build())
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public ResponseDto<UsersDto> findById(Integer id) {
        return null;
    }
}
