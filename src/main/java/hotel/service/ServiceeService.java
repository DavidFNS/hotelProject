package hotel.service;

import hotel.dto.ResponseDto;
import hotel.dto.ServiceeDto;

import java.util.List;

public interface ServiceeService {

    ResponseDto<List<ServiceeDto>> getAllService();
    ResponseDto<ServiceeDto> getServiceById(Integer id);
    ResponseDto addService(ServiceeDto serviceDto);
    ResponseDto updateService(ServiceeDto serviceDto);
    ResponseDto deleteService(Integer id);

}
