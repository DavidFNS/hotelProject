package hotel.mapper;

import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;

public class RoomServicesMap {

    public static RoomServicesDto parseToDto(RoomServices roomServices){

        if (roomServices == null) return null;
        return RoomServicesDto.builder()
                .id(roomServices.getId())
                .roomId(roomServices.getRoomId())
                .serviceId(roomServices.getServiceId())
                .build();
    }


    public static RoomServices parseToEntity(RoomServicesDto roomServicesDto){

        if (roomServicesDto == null) return null;
        return RoomServices.builder()
                .id(roomServicesDto.getId())
                .roomId(roomServicesDto.getRoomId())
                .serviceId(roomServicesDto.getServiceId())
                .build();
    }
}
