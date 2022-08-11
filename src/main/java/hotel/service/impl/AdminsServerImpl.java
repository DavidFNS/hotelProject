package hotel.service.impl;

import hotel.dto.AdminsDto;
import hotel.dto.ResponseDto;
import hotel.entity.Admins;
import hotel.repository.AdminsRepository;
import hotel.service.AdminsService;
import hotel.service.mapper.AdminsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminsServerImpl implements AdminsService {

    private final AdminsRepository adminsRepository;
    private final AdminsMapper adminsMapper;


    @Override
    public ResponseDto addNewAdmin(AdminsDto adminsDto) {
        Admins admins = adminsMapper.toEntity(adminsDto);
        adminsRepository.save(admins);

        return new ResponseDto<>(200, true, "Ok", adminsDto);
    }

    @Override
    public ResponseDto updateAdminInfo(AdminsDto adminsDto) {
        if(adminsRepository.existsById(adminsDto.getId())){
            Admins admins = adminsMapper.toEntity(adminsDto);
            adminsRepository.save(admins);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();
    }
}
