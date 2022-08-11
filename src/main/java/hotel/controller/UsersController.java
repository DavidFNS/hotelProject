package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.UsersDto;
import hotel.service.impl.UsersServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    private final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService){
        this.usersService = usersService;
    }

    @GetMapping("/orderedUsers")
    public ResponseDto<List<UsersDto>> getUsersWhoOrderedRoom(){
        return usersService.getUsersWhoOrderedBook();
    }


    @GetMapping
    public ResponseDto<List<UsersDto>> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseDto<UsersDto> findById(@PathVariable Integer id) {
        return usersService.findById(id);
    }

    @PostMapping
    public ResponseDto addUser(UsersDto usersDto){
        return usersService.addUser(usersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteUser(@PathVariable Integer id){
        return usersService.deleteUser(id);
    }

    @PatchMapping
    public ResponseDto updateUser(@RequestBody UsersDto usersDto){ return usersService.updateUser(usersDto);}
}
