package hotel.service.impl;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;
import hotel.repository.AdminsRepository;
import hotel.service.AdminsService;
import org.springframework.stereotype.Service;

@Service
public class AdminsServerImpl implements AdminsService {

    private final AdminsRepository adminsRepository;

    public AdminsServerImpl(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    @Override
    public ResponseDto<AdminsDto> AddNewAdmin(AdminsDto adminsDto) { return null; }

    @Override
    public ResponseDto UpdateAdminInfo(AdminsDto adminsDto) { return null; }
}
