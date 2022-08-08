package hotel.service.impl;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.entity.Users;
import hotel.mapper.UsersMap;
import hotel.repository.UsersRepository;
import hotel.service.UserService;
import hotel.service.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {

    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper){
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public ResponseDto addUser(UsersDto usersDto) {
        Users user = usersMapper.toEntity(usersDto);
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
                .map(u -> UsersDto.builder()
                        .id(u.getId())
                        .firstName(u.getFirstname())
                        .lastName(u.getLastname())
                        .age(u.getAge())
                        .phoneNumber(u.getPhoneNumber())
                        .email(u.getEmail())
                        .password(u.getPassword())
                        .account(u.getAccount())
                        .created_at(u.getCreated_at())
                        .build())
                .toList();
        try {
            return new ResponseDto<>(200, true, "OK", usersDto);
        } catch (Exception i){
            return new ResponseDto<>(404, false, "Not working", null);
        }
    }

    @Override
    public ResponseDto<UsersDto> findById(Integer id) {
        Optional<Users> optional = usersRepository.findById(id);
        return optional.map(users -> new ResponseDto<>(200, true, "OK", UsersMap.parseToDto(users))).orElseGet(() -> new ResponseDto<>(404, false, "Not working", null));
    }
}
