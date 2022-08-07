package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.ServiceeDto;
import hotel.entity.Booking;
import hotel.entity.Servicee;
import hotel.mapper.BookingMap;
import hotel.mapper.ServiceeMap;
import hotel.repository.ServiceRepository;
import hotel.service.ServiceeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceeServiceimpl implements ServiceeService {

    private final ServiceRepository serviceRepository;

    @Override
    public ResponseDto<List<ServiceeDto>> getAllService() {
        List<Servicee> serviceeList = serviceRepository.findAll();

        List<ServiceeDto> serviceDtoList = serviceeList.stream()
                .map(b -> {
                    return ServiceeDto.builder()
                            .id(b.getId())
                            .name(b.getName())
                            .price(b.getPrice())
                            .build();
                    }
                ).toList();

        ResponseDto<List<ServiceeDto>> responseDto = new ResponseDto<>(200,
                true,
                "OK",
                serviceDtoList);

        return responseDto;
    }

    @Override
    public ResponseDto<ServiceeDto> getServiceById(Integer id) {
        ResponseDto<ServiceeDto> responseDto;
        if (serviceRepository.existsById(id)){
            Servicee servicee = (serviceRepository.findById(id)).get();
            ServiceeDto serviceDto = ServiceeMap.parseToDto(servicee);

            responseDto = new ResponseDto<>(200,true,"OK",serviceDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);

        return responseDto;

    }

    @Override
    public ResponseDto addService(ServiceeDto serviceDto) {
        Servicee servicee = ServiceeMap.parseToEntity(serviceDto);
        serviceRepository.save(servicee);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",serviceDto);
        return responseDto;

    }

    @Override
    public ResponseDto updateService(ServiceeDto serviceDto) {
        if(serviceRepository.existsById(serviceDto.getId())){
            Servicee servicee = ServiceeMap.parseToEntity(serviceDto);
            serviceRepository.save(servicee);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();

    }

    @Override
    public ResponseDto deleteService(Integer id) {
        if (serviceRepository.existsById(id)){
            serviceRepository.deleteById(id);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        }
        return ResponseDto.builder()
                .code(404)
                .success(false)
                .message("Not found!")
                .build();
    }
}
