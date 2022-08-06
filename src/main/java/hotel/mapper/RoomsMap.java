package hotel.mapper;

import hotel.dto.RoomsDto;
import hotel.entity.Rooms;

public class RoomsMap {

    public static RoomsDto parseToDto(Rooms rooms){

        if (rooms == null) return  null;
        return RoomsDto.builder()
                .id(rooms.getId())
                .service(rooms.getService())
                .typeRoomId(rooms.getTypeRoomId())
                .capacity(rooms.getCapacity())
                .price(rooms.getPrice())
                .createdAt(rooms.getCreatedAt())
                .build();

    }


    public static Rooms parseToEntity(RoomsDto roomsDto){

        if (roomsDto == null) return  null;
        return Rooms.builder()
                .id(roomsDto.getId())
                .service(roomsDto.getService())
                .typeRoomId(roomsDto.getTypeRoomId())
                .capacity(roomsDto.getCapacity())
                .price(roomsDto.getPrice())
                .createdAt(roomsDto.getCreatedAt())
                .build();
    }

}
