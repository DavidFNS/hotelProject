package hotel.service.impl;

import hotel.dto.PaymentInfoDto;
import hotel.dto.ResponseDto;
import hotel.repository.PaymentInfoRepository;
import hotel.service.PaymentInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private final PaymentInfoRepository paymentInfoRepository;

    public PaymentInfoServiceImpl(PaymentInfoRepository paymentInfoRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Override
    public ResponseDto<PaymentInfoDto> addPaymentInfo(PaymentInfoDto paymentInfoDto) {
        return null;
    }

    @Override
    public ResponseDto updatePaymentInfo(PaymentInfoDto paymentInfoDto) {
        return null;
    }

    @Override
    public ResponseDto deletePaymentInfo(Integer id) {
        return null;
    }

    @Override
    public ResponseDto<List<PaymentInfoDto>> getPaymentInfo() {
        return null;
    }

    @Override
    public ResponseDto<PaymentInfoDto> findById(Integer id) {
        return null;
    }
}
