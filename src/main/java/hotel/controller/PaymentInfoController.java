package hotel.controller;

import hotel.dto.ResponseDto;
import hotel.dto.PaymentInfoDto;
import hotel.service.impl.PaymentInfoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-info")
public class PaymentInfoController {
    
    private final PaymentInfoServiceImpl paymentInfoService;

    public PaymentInfoController(PaymentInfoServiceImpl paymentInfoService) {
        this.paymentInfoService = paymentInfoService;
    }

    @PostMapping
    public ResponseDto addUser(PaymentInfoDto paymentInfoDto){
        return paymentInfoService.addPaymentInfo(paymentInfoDto);
    }

    @PatchMapping
    public ResponseDto updateUser(@RequestBody PaymentInfoDto paymentInfoDto){ return paymentInfoService.updatePaymentInfo(paymentInfoDto);}

    @DeleteMapping
    public ResponseDto deleteUser(@RequestParam Integer id){
        return paymentInfoService.deletePaymentInfo(id);
    }

    @GetMapping
    public ResponseDto<List<PaymentInfoDto>> getAllUsers(){
        return paymentInfoService.getPaymentInfo();
    }

    @GetMapping("/{id}")
    public ResponseDto<PaymentInfoDto> findById(@PathVariable Integer id){
        return paymentInfoService.findById(id);
    }
}
