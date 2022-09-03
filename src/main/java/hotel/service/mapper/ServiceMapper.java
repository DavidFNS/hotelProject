package hotel.service.mapper;

import hotel.dto.RoomsDto;
import hotel.dto.ServiceDto;
import hotel.entity.Rooms;
import hotel.entity.Service;

import java.util.List;

public class ServiceMapper {
    public static Service toEntity(ServiceDto serviceDto){
        if (serviceDto == null){
            return null;
        }

        List<Rooms> roomsList = serviceDto.getRoomsList().stream()
                .map(RoomsMapper::toEntityWithoutService)
                .toList();

        return Service.builder()
                .id(serviceDto.getId())
                .name(serviceDto.getName())
                .price(serviceDto.getPrice())
                .roomsList(roomsList)
                .build();
    }

    public static ServiceDto toDto(Service service){
        if (service == null){
            return null;
        }
        List<RoomsDto> roomsDtoList = service.getRoomsList().stream()
                .map(RoomsMapper::toDtoWithoutService)
                .toList();

        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .price(service.getPrice())
                .roomsList(roomsDtoList)
                .build();
    }

    public static Service toEntityWithoutRoomList(ServiceDto serviceDto){
        if (serviceDto == null){
            return null;
        }

        return Service.builder()
                .id(serviceDto.getId())
                .name(serviceDto.getName())
                .price(serviceDto.getPrice())
                .build();
    }

    public static ServiceDto toDtoWithoutRoomList(Service service){
        if (service == null){
            return null;
        }

        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .price(service.getPrice())
                .build();
    }
}
