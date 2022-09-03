package hotel.service.impl;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.entity.Comments;
import hotel.entity.Users;
import hotel.repository.UsersRepository;
import hotel.service.UserService;
import hotel.service.mapper.CommentMapper;
import hotel.service.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public ResponseDto<List<UsersDto>> getUsersWhoOrderedBook() {
        List<Users> users = usersRepository.getUsersWhoOrderedRoom();
        List<UsersDto> usersDto = users.stream()
                .map(UsersMapper::toDto)
                .toList();
        if (usersDto.isEmpty()){
            return ResponseDto.<List<UsersDto>>builder()
                    .code(404).success(false).message("NOT FOUND!!!!!!!!!!!!!!").data(null).build();
        }

        return ResponseDto.<List<UsersDto>>builder()
                .code(200).success(true).message("OK").data(usersDto).build();
    }

    @Override
    public ResponseDto addUser(UsersDto usersDto) {
        try {

            if(usersRepository.findByEmail(usersDto.getEmail()).size() != 0){
                return ResponseDto.builder().code(200).success(false).message("Bunday email mavjud!").build();
            }

            Users user = UsersMapper.toEntity(usersDto);
            usersRepository.save(user);
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
        if(usersRepository.existsById(usersDto.getId())){
            Users user = usersRepository.findById(usersDto.getId()).get();
            usersRepository.save(user);

            return new ResponseDto(200, true, "OK", null);
        }

        return new ResponseDto(404, false, "Not found!", null);
    }

    @Override
    public ResponseDto deleteUser(Integer id) {
        Optional<Users> optional = usersRepository.findById(id);
        if (optional.isPresent()){
            usersRepository.delete(optional.get());
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
    public ResponseDto<List<UsersDto>> getAllUsers() {
        List<Users> users = usersRepository.findAll();

        List<UsersDto> usersDto = users.stream()
                .map(UsersMapper::toDto)
                .toList();
        return new ResponseDto<>(200, true, "OK", usersDto);
    }

    @Override
    public ResponseDto<UsersDto> findById(Integer id) {

        if (usersRepository.existsById(id)) {
            Users user = usersRepository.findById(id).get();
            return new ResponseDto<>(200, true, "OK", UsersMapper.toDto(user));
        }
        return new ResponseDto<>(404, false, "Not found!", null);
    }
}
