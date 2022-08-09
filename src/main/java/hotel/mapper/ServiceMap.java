package hotel.mapper;

import hotel.dto.ServiceDto;
import hotel.entity.Service;

public class ServiceMap {

    public static ServiceDto parseToDto(Service servicee){

        if (servicee == null) return null;
        return ServiceDto.builder()
                .id(servicee.getId())
                .name(servicee.getName())
                .price(servicee.getPrice())
                .build();
    }


    public static Service parseToEntity(ServiceDto serviceDto){

        if (serviceDto == null) return null;
        return Service.builder()
                .id(serviceDto.getId())
                .name(serviceDto.getName())
                .price(serviceDto.getPrice())
                .build();
    }
}
