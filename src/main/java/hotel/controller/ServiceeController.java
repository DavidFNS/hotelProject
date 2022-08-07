package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.ServiceeDto;
import hotel.service.impl.ServiceeServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceeController {

    private final ServiceeServiceimpl serviceeServiceimpl;

    @GetMapping
    public ResponseDto<List<ServiceeDto>> getAllService(){
        return serviceeServiceimpl.getAllService();
    }

    @GetMapping("/{id}")
    public ResponseDto<ServiceeDto> getServiceById(@PathVariable Integer id){
        return serviceeServiceimpl.getServiceById(id);
    }

    @PostMapping
    public ResponseDto addService(@RequestBody ServiceeDto serviceDto){
        return serviceeServiceimpl.addService(serviceDto);
    }

    @PutMapping
    public ResponseDto updateService(@RequestBody ServiceeDto serviceDto){
        return serviceeServiceimpl.updateService(serviceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteService(@PathVariable Integer id){
        return serviceeServiceimpl.deleteService(id);
    }

}
