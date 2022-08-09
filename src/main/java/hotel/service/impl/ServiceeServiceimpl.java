package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.ServiceDto;
import hotel.entity.Service;
import hotel.mapper.ServiceMap;
import hotel.repository.ServiceRepository;
import hotel.service.ServiceeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceeServiceimpl implements ServiceeService {

    private final ServiceRepository serviceRepository;

    @Override
    public ResponseDto<List<ServiceDto>> getAllService() {
        List<Service> serviceeList = serviceRepository.findAll();

        List<ServiceDto> serviceDtoList = serviceeList.stream()
                .map(b -> {
                    return ServiceDto.builder()
                            .id(b.getId())
                            .name(b.getName())
                            .price(b.getPrice())
                            .build();
                    }
                ).toList();

        ResponseDto<List<ServiceDto>> responseDto = new ResponseDto<>(200,
                true,
                "OK",
                serviceDtoList);

        return responseDto;
    }

    @Override
    public ResponseDto<ServiceDto> getServiceById(Integer id) {
        ResponseDto<ServiceDto> responseDto;
        if (serviceRepository.existsById(id)){
            Service servicee = (serviceRepository.findById(id)).get();
            ServiceDto serviceDto = ServiceMap.parseToDto(servicee);

            responseDto = new ResponseDto<>(200,true,"OK",serviceDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);

        return responseDto;

    }

    @Override
    public ResponseDto addService(ServiceDto serviceDto) {
        Service servicee = ServiceMap.parseToEntity(serviceDto);
        serviceRepository.save(servicee);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",serviceDto);
        return responseDto;

    }

    @Override
    public ResponseDto updateService(ServiceDto serviceDto) {
        if(serviceRepository.existsById(serviceDto.getId())){
            Service servicee = ServiceMap.parseToEntity(serviceDto);
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
