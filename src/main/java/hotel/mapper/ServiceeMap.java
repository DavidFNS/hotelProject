package hotel.mapper;

import hotel.dto.ServiceeDto;
import hotel.entity.Servicee;

public class ServiceeMap {

    public static ServiceeDto parseToDto(Servicee servicee){

        if (servicee == null) return null;
        return ServiceeDto.builder()
                .id(servicee.getId())
                .name(servicee.getName())
                .price(servicee.getPrice())
                .build();
    }


    public static Servicee parseToEntity(ServiceeDto serviceDto){

        if (serviceDto == null) return null;
        return Servicee.builder()
                .id(serviceDto.getId())
                .name(serviceDto.getName())
                .price(serviceDto.getPrice())
                .build();
    }
}
