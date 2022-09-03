package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;
import hotel.repository.RoomServicesRepository;
import hotel.service.RoomServicesService;
import hotel.service.mapper.RoomServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceRoomServiceImpl implements RoomServicesService {
    private final RoomServiceMapper mapper;
    private final RoomServicesRepository roomServicesRepository;

    public ServiceRoomServiceImpl(RoomServiceMapper mapper, RoomServicesRepository roomServicesRepository) {
        this.mapper = mapper;
        this.roomServicesRepository = roomServicesRepository;
    }

    @Override
    public ResponseDto addRoomService(RoomServicesDto roomServicesDto) {
        RoomServices roomServices = mapper.toEntity(roomServicesDto);
        roomServicesRepository.save(roomServices);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",roomServices);
        return responseDto;

    }

    @Override
    public ResponseDto updateRoomService(RoomServicesDto roomServicesDto) {
        if(roomServicesRepository.existsById(roomServicesDto.getId())){
            RoomServices roomServices = mapper.toEntity(roomServicesDto);
            roomServicesRepository.save(roomServices);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();

    }

    @Override
    public ResponseDto deleteRoomService(Integer id) {
        if (roomServicesRepository.existsById(id)){
            roomServicesRepository.deleteById(id);

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
    public ResponseDto<RoomServicesDto> getRoomServiceById(Integer id) {
        ResponseDto<RoomServicesDto> responseDto;
        if (roomServicesRepository.existsById(id)){
            RoomServices roomServices = (roomServicesRepository.findById(id)).get();
            RoomServicesDto roomServicesDto = mapper.toDto(roomServices);

            responseDto = new ResponseDto<>(200,true,"OK",roomServicesDto);
            return responseDto;
        }
        return new ResponseDto<>(404,false,"Not found", null);

    }

    @Override
    public ResponseDto<List<RoomServicesDto>> getAllRoomService() {
        List<RoomServices> roomServicesList = roomServicesRepository.findAll();

        List<RoomServicesDto> roomServicesDtos = roomServicesList.stream()
                .map(b -> {
                            return RoomServicesDto.builder()
                                    .id(b.getId())
                                    .room_id(b.getRoom_id())
                                    .service_id(b.getService_id())
                                    .build();
                        }
                ).toList();

        ResponseDto<List<RoomServicesDto>> responseDto = new ResponseDto<>(200,
                true,
                "OK",
                roomServicesDtos);

        return responseDto;

    }
}
