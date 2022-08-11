package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomsDto;
import hotel.entity.Rooms;
import hotel.repository.RoomsRepository;
import hotel.service.RoomsService;
import hotel.service.mapper.RoomMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService{
    private final RoomMapper roomMapper;
    private final RoomsRepository roomsRepository;

    public RoomsServiceImpl(RoomMapper roomMapper, RoomsRepository roomsRepository) {
        this.roomMapper = roomMapper;
        this.roomsRepository = roomsRepository;
    }

    @Override
    public ResponseDto addRoom(RoomsDto roomsDto) {
        Rooms rooms = roomMapper.toEntity(roomsDto);
        roomsRepository.save(rooms);
        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",roomsDto);
        return responseDto;

    }

    @Override
    public ResponseDto updateRoom(RoomsDto roomsDto) {
        if(roomsRepository.existsById(roomsDto.getId())){
            Rooms rooms = roomMapper.toEntity(roomsDto);
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
            RoomsDto roomsDto = roomMapper.toDto(rooms);

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
