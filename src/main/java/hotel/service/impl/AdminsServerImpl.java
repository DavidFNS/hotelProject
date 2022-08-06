package hotel.service.impl;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;
import hotel.entity.Admins;
import hotel.mapper.AdminMap;
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
    public ResponseDto AddNewAdmin(AdminsDto adminsDto) {
        Admins admins = AdminMap.parsToEntity(adminsDto);
        adminsRepository.save(admins);

        return new ResponseDto<>(200, true, "Ok", adminsDto);
    }

    @Override
    public ResponseDto UpdateAdminInfo(AdminsDto adminsDto) {
        if(adminsRepository.existsById(adminsDto.getId())){
            Admins admins = AdminMap.parsToEntity(adminsDto);
            adminsRepository.save(admins);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();
    }
}
