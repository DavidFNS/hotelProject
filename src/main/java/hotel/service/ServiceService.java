package hotel.service;

import hotel.dto.ResponseDto;
import hotel.dto.ServiceDto;

import java.util.List;

public interface ServiceService {

    ResponseDto<List<ServiceDto>> getAllService();
    ResponseDto<ServiceDto> getServiceById(Integer id);
    ResponseDto addService(ServiceDto serviceDto);
    ResponseDto updateService(ServiceDto serviceDto);
    ResponseDto deleteService(Integer id);

}
