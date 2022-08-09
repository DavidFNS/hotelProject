package hotel.service.mapper;

import hotel.dto.RoomServicesDto;
import hotel.entity.RoomServices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomServiceServiceMapper {
    RoomServices toEntity(RoomServicesDto dto);
    RoomServicesDto toDto(RoomServices r);
}
