package hotel.service.mapper;

import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomServiceMapper {
    RoomServices toEntity(RoomServicesDto roomServicesDto);
    RoomServicesDto toDto(RoomServices roomServices);
}
