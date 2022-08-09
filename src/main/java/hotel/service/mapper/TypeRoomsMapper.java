package hotel.service.mapper;

import hotel.dto.TypeRoomsDto;
import hotel.entity.TypeRooms;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeRoomsMapper {

    TypeRooms toEntity(TypeRoomsDto typeRoomsDto);
    TypeRoomsDto toDto(TypeRooms typeRooms);
}
