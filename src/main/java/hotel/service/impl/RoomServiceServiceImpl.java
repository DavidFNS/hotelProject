package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomServicesDto;
import hotel.dto.ServiceeDto;
import hotel.entity.RoomServices;
import hotel.entity.Rooms;
import hotel.entity.Servicee;
import hotel.mapper.RoomServicesMap;
import hotel.mapper.ServiceeMap;
import hotel.repository.RoomServicesRepository;
import hotel.service.RoomServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceServiceImpl implements RoomServicesService {

    private final RoomServicesRepository roomServicesRepository;

    @Override
    public ResponseDto addRoomService(RoomServicesDto roomServicesDto) {
        RoomServices roomServices = RoomServicesMap.parseToEntity(roomServicesDto);
        roomServicesRepository.save(roomServices);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",roomServices);
        return responseDto;

    }

    @Override
    public ResponseDto updateRoomService(RoomServicesDto roomServicesDto) {
        if(roomServicesRepository.existsById(roomServicesDto.getId())){
            RoomServices roomServices = RoomServicesMap.parseToEntity(roomServicesDto);
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
            RoomServicesDto roomServicesDto = RoomServicesMap.parseToDto(roomServices);

            responseDto = new ResponseDto<>(200,true,"OK",roomServicesDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);

        return responseDto;

    }

    @Override
    public ResponseDto<List<RoomServicesDto>> getAllRoomService() {
        List<RoomServices> roomServicesList = roomServicesRepository.findAll();

        List<RoomServicesDto> roomServicesDtos = roomServicesList.stream()
                .map(b -> {
                            return RoomServicesDto.builder()
                                    .id(b.getId())
                                    .roomId(b.getRoomId())
                                    .serviceId(b.getServiceId())
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
