package hotel.mapper;

import hotel.dto.AdminsDto;
import hotel.entity.Admins;

public class AdminMap {

    public static AdminsDto parsToDto(Admins admins){
        return AdminsDto.builder()
                .id(admins.getId())
                .firstname(admins.getFirstname())
                .lastname(admins.getLastname())
                .email(admins.getEmail())
                .password(admins.getPassword())
                .card_number(admins.getCard_number())
                .valid_date(admins.getValid_date())
                .balance(admins.getBalance())
                .created_at(admins.getCreated_at())
                .build();
    }

    public static Admins parsToEntity(AdminsDto adminsDto){
        return Admins.builder()
                .id(adminsDto.getId())
                .firstname(adminsDto.getFirstname())
                .lastname(adminsDto.getLastname())
                .email(adminsDto.getEmail())
                .password(adminsDto.getPassword())
                .card_number(adminsDto.getCard_number())
                .valid_date(adminsDto.getValid_date())
                .balance(adminsDto.getBalance())
                .created_at(adminsDto.getCreated_at())
                .build();
    }
}
