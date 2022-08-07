package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.ServiceeDto;
import hotel.dto.TypeRoomsDto;
import hotel.entity.Servicee;
import hotel.entity.TypeRooms;
import hotel.mapper.ServiceeMap;
import hotel.mapper.TypeRoomsMap;
import hotel.repository.TypeRoomsRepository;
import hotel.service.TypeRoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeRoomsServiceImpl implements TypeRoomsService {

    private final TypeRoomsRepository typeRoomsRepository;

    @Override
    public ResponseDto addTypeRoom(TypeRoomsDto typeRoomsDto) {
        TypeRooms typeRooms = TypeRoomsMap.parseToEntity(typeRoomsDto);
        typeRoomsRepository.save(typeRooms);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",typeRooms);
        return responseDto;

    }

    @Override
    public ResponseDto updateTypeRoom(TypeRoomsDto typeRoomsDto) {
        if(typeRoomsRepository.existsById(typeRoomsDto.getId())){
            TypeRooms typeRooms = TypeRoomsMap.parseToEntity(typeRoomsDto);
            typeRoomsRepository.save(typeRooms);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();
    }

    @Override
    public ResponseDto deleteTypeRoom(Integer id) {
        if (typeRoomsRepository.existsById(id)){
            typeRoomsRepository.deleteById(id);

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
    public ResponseDto<TypeRoomsDto> getTypeRoomById(Integer id) {
        ResponseDto<TypeRoomsDto> responseDto;
        if (typeRoomsRepository.existsById(id)){
            TypeRooms typeRooms = (typeRoomsRepository.findById(id)).get();
            TypeRoomsDto typeRoomsDto = TypeRoomsMap.parseToDto(typeRooms);

            responseDto = new ResponseDto<>(200,true,"OK",typeRoomsDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);

        return responseDto;

    }

    @Override
    public ResponseDto<List<TypeRoomsDto>> getAllTypeRoom() {
        List<TypeRooms> typeRooms = typeRoomsRepository.findAll();

        List<TypeRoomsDto> typeRoomsDtoList = typeRooms.stream()
                .map(b -> {
                        return TypeRoomsDto.builder()
                                .id(b.getId())
                                .name(b.getName())
                                .build();
                    }
                ).toList();

        ResponseDto<List<TypeRoomsDto>> responseDto = new ResponseDto<>(200,
                true,
                "OK",
                typeRoomsDtoList);

        return responseDto;

    }
}
