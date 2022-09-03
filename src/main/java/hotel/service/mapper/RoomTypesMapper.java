package hotel.service.mapper;

import hotel.dto.RoomsDto;
import hotel.dto.TypeRoomsDto;
import hotel.entity.Rooms;
import hotel.entity.TypeRooms;

import java.util.List;

public class RoomTypesMapper {
    public static TypeRooms toEntity(TypeRoomsDto typeRoomsDto){
        if (typeRoomsDto == null){
            return null;
        }

        List<Rooms> roomsList = typeRoomsDto.getRoomsList().stream()
                .map(RoomsMapper::toEntityWithoutRoomType)
                .toList();
        return TypeRooms.builder()
                .id(typeRoomsDto.getId())
                .name(typeRoomsDto.getName())
                .roomsList(roomsList)
                .build();
    }

    public static TypeRoomsDto toDto(TypeRooms typeRooms){
        if (typeRooms == null){
            return null;
        }
        List<RoomsDto> roomsList = typeRooms.getRoomsList().stream()
                .map(RoomsMapper::toDtoWithoutRoomType)
                .toList();
        return TypeRoomsDto.builder()
                .id(typeRooms.getId())
                .name(typeRooms.getName())
                .roomsList(roomsList)
                .build();
    }

    public static TypeRooms toEntityWithoutRoomList(TypeRoomsDto typeRoomsDto){
        if (typeRoomsDto == null){
            return null;
        }

        return TypeRooms.builder()
                .id(typeRoomsDto.getId())
                .name(typeRoomsDto.getName())
                .build();
    }

    public static TypeRoomsDto toDtoWithoutRoomList(TypeRooms typeRooms){
        if (typeRooms == null){
            return null;
        }

        return TypeRoomsDto.builder()
                .id(typeRooms.getId())
                .name(typeRooms.getName())
                .build();
    }
}
