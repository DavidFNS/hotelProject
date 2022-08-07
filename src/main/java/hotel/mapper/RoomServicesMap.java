package hotel.mapper;

import hotel.dto.RoomServicesDto;
import hotel.dto.RoomsDto;
import hotel.entity.RoomServices;
import hotel.service.RoomsService;

public class RoomServicesMap {

    public static RoomServicesDto parseToDto(RoomServices roomServices){

        if (roomServices == null) return null;
        return RoomServicesDto.builder()
                .id(roomServices.getId())
                .serviceId(roomServices.getServiceId())
                .roomId(roomServices.getRoomId())
                .build();
    }


    public static RoomServices parseToEntity(RoomServicesDto roomServicesDto){

        if (roomServicesDto == null) return null;
        return RoomServices.builder()
                .id(roomServicesDto.getId())
                .serviceId(roomServicesDto.getServiceId())
                .roomId(roomServicesDto.getRoomId())
                .build();
    }
}
