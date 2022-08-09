package hotel.controller;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.TypeRoomsDto;
import hotel.service.impl.TypeRoomsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typerooms")
@RequiredArgsConstructor
public class TypeRoomsController {

    private final TypeRoomsServiceImpl typeRoomsService;

    @PostMapping
    public ResponseDto<BookingDto> addTypeRoom(@RequestBody TypeRoomsDto typeRoomsDto){
        return typeRoomsService.addTypeRoom(typeRoomsDto);
    }

    @PutMapping
    public ResponseDto updateTypeRoom(@RequestBody TypeRoomsDto typeRoomsDto){
        return typeRoomsService.updateTypeRoom(typeRoomsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteTypeRoom(@PathVariable Integer id){
        return typeRoomsService.deleteTypeRoom(id);
    }

    @GetMapping("/id")
    public ResponseDto<TypeRoomsDto> getTypeRoomById(@PathVariable Integer id){
        return typeRoomsService.getTypeRoomById(id);
    }

    @GetMapping
    ResponseDto<List<TypeRoomsDto>> getAllTypeRoom(){
        return typeRoomsService.getAllTypeRoom();
    }

}
