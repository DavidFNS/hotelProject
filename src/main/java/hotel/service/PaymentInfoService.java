package hotel.service;

import hotel.dto.PaymentInfoDto;
import hotel.dto.ResponseDto;

import java.util.List;

public interface PaymentInfoService {

    ResponseDto<PaymentInfoDto> addPaymentInfo(PaymentInfoDto paymentInfoDto);

    ResponseDto updatePaymentInfo(PaymentInfoDto paymentInfoDto);

    ResponseDto deletePaymentInfo(Integer id);

    ResponseDto<List<PaymentInfoDto>> getPaymentInfo();

    ResponseDto<PaymentInfoDto> findById(Integer id);
}
