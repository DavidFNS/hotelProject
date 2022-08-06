package hotel.service;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;

public interface AdminsService {

    ResponseDto<AdminsDto> addNewAdmin(AdminsDto adminsDto);

    ResponseDto updateAdminInfo(AdminsDto adminsDto);
}
