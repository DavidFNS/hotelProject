package hotel.service.impl;

import hotel.dto.BookingDto;
import hotel.dto.ResponseDto;
import hotel.dto.ServiceDto;
import hotel.entity.Service;
import hotel.repository.ServiceRepository;
import hotel.service.ServiceService;
import hotel.service.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    @Override
    public ResponseDto<List<ServiceDto>> getAllService() {
        List<Service> serviceList = serviceRepository.findAll();
        List<ServiceDto> serviceDtoList = serviceList.stream()
                .map(b -> {
                    return ServiceDto.builder()
                            .id(b.getId())
                            .name(b.getName())
                            .price(b.getPrice())
                            .build();
                    }
                ).toList();

        return new ResponseDto<>(200,
                true,
                "OK",
                serviceDtoList);
    }

    @Override
    public ResponseDto<ServiceDto> getServiceById(Integer id) {
        ResponseDto<ServiceDto> responseDto;
        if (serviceRepository.existsById(id)){
            Service service = (serviceRepository.findById(id)).get();
            ServiceDto serviceDto = ServiceMapper.toDto(service);

            responseDto = new ResponseDto<>(200,true,"OK",serviceDto);
            return responseDto;
        }
        responseDto = new ResponseDto<>(200,true,"OK", null);
        return responseDto;
    }

    @Override
    public ResponseDto addService(ServiceDto serviceDto) {
        Service service = ServiceMapper.toEntity(serviceDto);
        serviceRepository.save(service);

        ResponseDto<BookingDto> responseDto = new ResponseDto(200,true,"OK",serviceDto);
        return responseDto;
    }

    @Override
    public ResponseDto updateService(ServiceDto serviceDto) {
        if(serviceRepository.existsById(serviceDto.getId())){
            Service service = ServiceMapper.toEntity(serviceDto);
            serviceRepository.save(service);

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
