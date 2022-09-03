package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.ServiceDto;
import hotel.service.impl.ServiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceServiceImpl serviceeServiceimpl;

    @GetMapping
    public ResponseDto<List<ServiceDto>> getAllService(){
        return serviceeServiceimpl.getAllService();
    }

    @GetMapping("/{id}")
    public ResponseDto<ServiceDto> getServiceById(@PathVariable Integer id){
        return serviceeServiceimpl.getServiceById(id);
    }

    @PostMapping
    public ResponseDto addService(@RequestBody ServiceDto serviceDto){
        return serviceeServiceimpl.addService(serviceDto);
    }

    @PutMapping
    public ResponseDto updateService(@RequestBody ServiceDto serviceDto){
        return serviceeServiceimpl.updateService(serviceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteService(@PathVariable Integer id){
        return serviceeServiceimpl.deleteService(id);
    }

}
