package hotel.service.impl;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.entity.Users;
import hotel.repository.UsersRepository;
import hotel.service.UserService;
import hotel.service.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UsersServiceImpl implements UserService {

    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper){
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public ResponseDto<List<UsersDto>> getUsersWhoOrderedBook() {
        List<Users> users = usersRepository.getUsersWhoOrderedRoom();
        List<UsersDto> usersDto = users.stream()
                .map(usersMapper::toDto)
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
            List<Users> users = usersRepository.findAll();
            for(int i=0; i<users.size(); i++){
                if(users.get(i).getEmail().equals(usersDto.getEmail())){
                    return ResponseDto.builder().code(200).success(false).message("Bunday email mavjud!").build();
                }
            }

            Users user = usersMapper.toEntity(usersDto);
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
        Optional<Users> optional = usersRepository.findById(usersDto.getId());
        if(optional.isPresent()){
            Users users = optional.get();
            users.setId(usersDto.getId() != null? usersDto.getId() : users.getId());
            users.setFirstname(usersDto.getFirstName() != null? usersDto.getFirstName(): users.getFirstname());
            users.setLastname(usersDto.getLastName() != null? usersDto.getLastName() : users.getLastname());
            users.setAge(usersDto.getAge() != null? usersDto.getAge(): users.getAge());
            users.setPhoneNumber(usersDto.getPhoneNumber() != null? usersDto.getPhoneNumber() : users.getPhoneNumber());
            users.setEmail(usersDto.getEmail() != null? usersDto.getEmail() : users.getEmail());
            users.setPassword(usersDto.getPassword() != null? usersDto.getPassword() : users.getPassword());
            users.setAccount(usersDto.getAccount() != null? usersDto.getAccount() : users.getAccount());
            users.setCreated_at(usersDto.getCreated_at() != null? usersDto.getCreated_at() : users.getCreated_at());
            usersRepository.save(users);

            return new ResponseDto(200, true, "OK", null);
        }

        return new ResponseDto(404, false, "Not working", null);
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
                .map(usersMapper::toDto)
                .toList();
        return new ResponseDto<>(200, true, "OK", usersDto);
    }

    @Override
    public ResponseDto<UsersDto> findById(Integer id) {
        Optional<Users> optional = usersRepository.findById(id);
        return optional.map(users -> new ResponseDto<>(200, true, "OK", usersMapper.toDto(users))).orElseGet(() -> new ResponseDto<>(404, false, "Not working", null));
    }
}
