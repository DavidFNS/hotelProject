package hotel.controller;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;
import hotel.service.impl.AdminsServerImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    private final AdminsServerImpl adminsServer;

    public AdminsController(AdminsServerImpl adminsServer) {
        this.adminsServer = adminsServer;
    }

    @PostMapping
    public ResponseDto addUser(AdminsDto adminsDto){
        return adminsServer.addNewAdmin(adminsDto);
    }

    @PatchMapping
    public ResponseDto updateUser(@RequestBody AdminsDto adminsDto){ return adminsServer.updateAdminInfo(adminsDto);}
}
