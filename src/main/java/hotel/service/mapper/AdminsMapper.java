package hotel.service.mapper;

import hotel.dto.AdminsDto;
import hotel.entity.Admins;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminsMapper {
    Admins toEntity(AdminsDto adminsDto);
    AdminsDto toDto(Admins admins);
}
