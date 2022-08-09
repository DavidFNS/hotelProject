package hotel.service.mapper;

import hotel.dto.UsersDto;
import hotel.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toEntity(UsersDto usersDto);
    UsersDto toDto(Users users);
}
