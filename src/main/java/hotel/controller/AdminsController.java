package hotel.controller;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;
import hotel.service.impl.AdminsServerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admins")
public class AdminsController {
    private final AdminsServerImpl adminsServer;

    public AdminsController(AdminsServerImpl adminsServer) {
        this.adminsServer = adminsServer;
    }

    @PostMapping
    @ResponseBody
    public ResponseDto addUser(AdminsDto adminsDto){
        return adminsServer.addNewAdmin(adminsDto);
    }

    @PutMapping
    @ResponseBody
    public ResponseDto updateUser(@RequestBody AdminsDto adminsDto){
        return adminsServer.updateAdminInfo(adminsDto);
    }

    @GetMapping("/excel")
    public void downloadExcelFile(Model model){
        model.addAttribute("title", "ExcelFile");
    }

}
