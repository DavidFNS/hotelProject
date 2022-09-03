package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;
import hotel.service.impl.ServiceRoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomservice")
@RequiredArgsConstructor
public class RoomServicesController {

    private final ServiceRoomServiceImpl roomServiceService;

    @PostMapping
    public ResponseDto<RoomServices> addRoomService(@RequestBody RoomServicesDto roomServicesDto){
        return roomServiceService.addRoomService(roomServicesDto);
    }

    @PutMapping
    public ResponseDto updateRoomService(@RequestBody RoomServicesDto roomServicesDto){
        return roomServiceService.updateRoomService(roomServicesDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteRoomService(@PathVariable Integer id){
        return roomServiceService.deleteRoomService(id);
    }

    @GetMapping("/{id}")
    public ResponseDto<RoomServicesDto> getRoomServiceById(@PathVariable Integer id){
        return roomServiceService.getRoomServiceById(id);
    }

    @GetMapping
    public ResponseDto<List<RoomServicesDto>> getAllRoomService(){
        return roomServiceService.getAllRoomService();
    }


}
