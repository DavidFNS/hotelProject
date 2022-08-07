package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomsDto;
import hotel.dto.ServiceeDto;
import hotel.entity.RoomServices;
import hotel.entity.Rooms;
import hotel.entity.Servicee;
import hotel.mapper.RoomServicesMap;
import hotel.mapper.RoomsMap;
import hotel.mapper.ServiceeMap;
import hotel.repository.RoomServicesRepository;
import hotel.repository.RoomsRepository;
import hotel.service.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService{

    private final RoomsRepository roomsRepository;

    @Override
    public ResponseDto addRoom(RoomsDto roomsDto) {
        Rooms roomServices = RoomsMap.parseToEntity(roomsDto);
        roomsRepository.save(roomServices);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",roomsDto);
        return responseDto;

    }

    @Override
    public ResponseDto updateRoom(RoomsDto roomsDto) {
        if(roomsRepository.existsById(roomsDto.getId())){
            Rooms rooms = RoomsMap.parseToEntity(roomsDto);
            roomsRepository.save(rooms);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();

    }

    @Override
    public ResponseDto deleteRoom(Integer id) {
        if (roomsRepository.existsById(id)){
            roomsRepository.deleteById(id);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        }
        return ResponseDto.builder()
                .code(404)
                .success(false)
                .message("Not found!")
                .build();

    }

    @Override
    public ResponseDto<RoomsDto> getRoomById(Integer id) {
        ResponseDto<RoomsDto> responseDto;
        if (roomsRepository.existsById(id)){
            Rooms rooms = (roomsRepository.findById(id)).get();
            RoomsDto roomsDto = RoomsMap.parseToDto(rooms);

            responseDto = new ResponseDto<>(200,true,"OK",roomsDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);

        return responseDto;

    }

    @Override
    public ResponseDto<List<RoomsDto>> getAllRooms() {
        List<Rooms> roomsList = roomsRepository.findAll();

        List<RoomsDto> roomsDtoList = roomsList.stream()
                .map(b -> {
                            return RoomsDto.builder()
                                    .id(b.getId())
                                    .typeRoomId(b.getTypeRoomId())
                                    .service(b.getService())
                                    .price(b.getPrice())
                                    .createdAt(b.getCreatedAt())
                                    .capacity(b.getCapacity())
                                    .build();
                        }
                ).toList();

        ResponseDto<List<RoomsDto>> responseDto = new ResponseDto<>(200,
                true,
                "OK",
                roomsDtoList);

        return responseDto;

    }
}
