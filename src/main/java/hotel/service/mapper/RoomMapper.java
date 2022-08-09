package hotel.service.mapper;

import hotel.controller.RoomsController;
import hotel.dto.BookingDto;
import hotel.dto.RoomsDto;
import hotel.entity.Rooms;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Rooms toEntity(RoomsDto roomsDto);
    RoomsDto toDto(Rooms xona);
}
