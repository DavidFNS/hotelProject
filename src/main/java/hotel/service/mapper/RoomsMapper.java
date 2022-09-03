package hotel.service.mapper;

import hotel.dto.RoomsDto;
import hotel.dto.ServiceDto;
import hotel.entity.Rooms;
import hotel.entity.Service;

import java.util.List;

public class RoomsMapper {
    public static Rooms toEntity(RoomsDto roomsDto){
        if (roomsDto == null){
            return null;
        }

        return Rooms.builder()
                .id(roomsDto.getId())
                .capacity(roomsDto.getCapacity())
                .typeRooms(RoomTypesMapper.toEntityWithoutRoomList(roomsDto.getTypeRooms()))
                .service(roomsDto.getService())
                .price(roomsDto.getPrice())
                .createdAt(roomsDto.getCreatedAt())
                .build();
    }

    public static RoomsDto toDto(Rooms rooms){
        if (rooms == null){
            return null;
        }

        List<ServiceDto> serviceList = rooms.getServiceList().stream()
                .map(ServiceMapper::toDtoWithoutRoomList)
                .toList();
        return RoomsDto.builder()
                .id(rooms.getId())
                .capacity(rooms.getCapacity())
                .typeRooms(RoomTypesMapper.toDtoWithoutRoomList(rooms.getTypeRooms()))
                .serviceList(serviceList)
                .service(rooms.getService())
                .price(rooms.getPrice())
                .createdAt(rooms.getCreatedAt())
                .build();
    }

    public static Rooms toEntityWithoutService(RoomsDto roomsDto){
        if (roomsDto == null){
            return null;
        }

        return Rooms.builder()
                .id(roomsDto.getId())
                .typeRooms(RoomTypesMapper.toEntityWithoutRoomList(roomsDto.getTypeRooms()))
                .capacity(roomsDto.getCapacity())
                .price(roomsDto.getPrice())
                .createdAt(roomsDto.getCreatedAt())
                .service(roomsDto.getService())
                .build();
    }

    public static RoomsDto toDtoWithoutService(Rooms rooms){
        if (rooms == null){
            return null;
        }

        return RoomsDto.builder()
                .id(rooms.getId())
                .typeRooms(RoomTypesMapper.toDtoWithoutRoomList(rooms.getTypeRooms()))
                .capacity(rooms.getCapacity())
                .price(rooms.getPrice())
                .createdAt(rooms.getCreatedAt())
                .service(rooms.getService())
                .build();
    }

    public static Rooms toEntityWithoutRoomType(RoomsDto roomsDto){
        if (roomsDto == null){
            return null;
        }

        List<Service> serviceList = roomsDto.getServiceList().stream()
                .map(ServiceMapper::toEntityWithoutRoomList)
                .toList();
        return Rooms.builder()
                .id(roomsDto.getId())
                .serviceList(serviceList)
                .capacity(roomsDto.getCapacity())
                .price(roomsDto.getPrice())
                .createdAt(roomsDto.getCreatedAt())
                .service(roomsDto.getService())
                .build();
    }

    public static RoomsDto toDtoWithoutRoomType(Rooms rooms){
        if (rooms == null){
            return null;
        }

        List<ServiceDto> serviceList = rooms.getServiceList().stream()
                .map(ServiceMapper::toDtoWithoutRoomList)
                .toList();
        return RoomsDto.builder()
                .id(rooms.getId())
                .serviceList(serviceList)
                .capacity(rooms.getCapacity())
                .price(rooms.getPrice())
                .createdAt(rooms.getCreatedAt())
                .service(rooms.getService())
                .build();
    }

}
