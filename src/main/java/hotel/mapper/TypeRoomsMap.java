package hotel.mapper;

import hotel.dto.TypeRoomsDto;
import hotel.entity.TypeRooms;

public class TypeRoomsMap {

    public static TypeRoomsDto parseToDto(TypeRooms typeRooms){

        if (typeRooms == null) return null;
        return TypeRoomsDto.builder()
                .id(typeRooms.getId())
                .name(typeRooms.getName())
                .build();
    }


    public static TypeRooms parseToEntity(TypeRoomsDto typeRoomsDto){

        if (typeRoomsDto == null) return null;
        return TypeRooms.builder()
                .id(typeRoomsDto.getId())
                .name(typeRoomsDto.getName())
                .build();
    }
}
