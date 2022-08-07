package hotel.service;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.TypeRoomsDto;

import java.util.List;

public interface TypeRoomsService {
    ResponseDto<BookingDto> addTypeRoom(TypeRoomsDto typeRoomsDto);

    ResponseDto updateTypeRoom(TypeRoomsDto typeRoomsDto);

    ResponseDto deleteTypeRoom(Integer id);

    ResponseDto<TypeRoomsDto> getTypeRoomById(Integer id);

    ResponseDto<List<TypeRoomsDto>> getAllTypeRoom();

}
