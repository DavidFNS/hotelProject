package hotel.service.mapper;

import hotel.dto.UsersDto;
import hotel.entity.Users;

public class UsersMapper {
    public static Users toEntity(UsersDto usersDto){
        if (usersDto == null){
            return null;
        }

        return Users.builder()
                .id(usersDto.getId())
                .age(usersDto.getAge())
                .firstname(usersDto.getFirstName())
                .lastname(usersDto.getLastName())
                .email(usersDto.getEmail())
                .password(usersDto.getPassword())
                .account(usersDto.getAccount())
                .phoneNumber(usersDto.getPhoneNumber())
                .created_at(usersDto.getCreated_at())
                .build();
    }

    public static UsersDto toDto(Users users){
        if (users == null){
            return null;
        }

        return UsersDto.builder()
                .id(users.getId())
                .age(users.getAge())
                .firstName(users.getFirstname())
                .lastName(users.getLastname())
                .email(users.getEmail())
                .password(users.getPassword())
                .account(users.getAccount())
                .phoneNumber(users.getPhoneNumber())
                .created_at(users.getCreated_at())
                .build();
    }
}
