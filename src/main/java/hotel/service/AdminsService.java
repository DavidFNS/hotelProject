package hotel.service;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;

public interface AdminsService {

    ResponseDto<AdminsDto> AddNewAdmin(AdminsDto adminsDto);

    ResponseDto UpdateAdminInfo(AdminsDto adminsDto);
}
