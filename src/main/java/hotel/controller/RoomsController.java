package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.RoomsDto;
import hotel.service.RoomsService;
import hotel.service.impl.RoomsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomsServiceImpl roomsService;

    @PostMapping
    public ResponseDto<RoomsDto> addRoom(@RequestBody RoomsDto roomsDto){
        return roomsService.addRoom(roomsDto);
    }

    @PutMapping
    public ResponseDto updateRoom(@RequestBody RoomsDto roomsDto){
        return roomsService.updateRoom(roomsDto);
    }

    @DeleteMapping
    public ResponseDto deleteRoom(@PathVariable Integer id){
        return roomsService.deleteRoom(id);
    }

    @GetMapping("/{id}")
    ResponseDto<RoomsDto> getRoomById(@PathVariable Integer id){
        return roomsService.getRoomById(id);
    }

    @GetMapping
    ResponseDto<List<RoomsDto>> getAllRooms(){
        return roomsService.getAllRooms();
    }

}
