package hotel.service.mapper;

import hotel.dto.ServiceDto;
import hotel.entity.Service;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ServiceMapper {
    Service toEntity(ServiceDto serviceDto);
    ServiceDto toDto(Service service);
}
