package hotel.service;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomsDto;

import java.util.List;

public interface RoomsService {

    ResponseDto<RoomsDto> addRoom(RoomsDto roomsDto);

    ResponseDto updateRoom(RoomsDto roomsDto);

    ResponseDto deleteRoom(Integer id);

    ResponseDto<RoomsDto> getRoomById(Integer id);

    ResponseDto<List<RoomsDto>> getAllRooms();

}
