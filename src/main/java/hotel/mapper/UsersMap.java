package hotel.mapper;

import hotel.dto.UsersDto;
import hotel.entity.Users;

public class UsersMap {
    public static UsersDto parseToDto(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .firstName(users.getFirstname())
                .lastName(users.getLastname())
                .email(users.getEmail())
                .age(users.getAge())
                .account(users.getAccount())
                .password(users.getPassword())
                .phoneNumber(users.getPhoneNumber())
                .created_at(users.getCreated_at())
                .build();
    }

    public static Users parseToEntity(UsersDto usersDto){
        return Users.builder()
                .id(usersDto.getId())
                .firstname(usersDto.getFirstName())
                .lastname(usersDto.getLastName())
                .email(usersDto.getEmail())
                .age(usersDto.getAge())
                .account(usersDto.getAccount())
                .password(usersDto.getPassword())
                .phoneNumber(usersDto.getPhoneNumber())
                .created_at(usersDto.getCreated_at())
                .build();
    }
}
