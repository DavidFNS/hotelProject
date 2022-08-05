package hotel.mapper;

import hotel.dto.ServiceDto;
import hotel.entity.Service;

public class ServiceMap {

    public static ServiceDto parseToDto(Service service){

        if (service == null) return null;
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .price(service.getPrice())
                .build();
    }


    public static Service perseToEntity(ServiceDto serviceDto){

        if (serviceDto == null) return null;
        return Service.builder()
                .id(serviceDto.getId())
                .name(serviceDto.getName())
                .price(serviceDto.getPrice())
                .build();
    }
}
