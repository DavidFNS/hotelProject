package hotel.service;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;

import java.util.List;

public interface RoomServicesService {

    ResponseDto<RoomServices> addRoomService(RoomServicesDto roomServicesDto);

    ResponseDto updateRoomService(RoomServicesDto roomServicesDto);

    ResponseDto deleteRoomService(Integer id);

    ResponseDto<RoomServicesDto> getRoomServiceById(Integer id);

    ResponseDto<List<RoomServicesDto>> getAllRoomService();

}
