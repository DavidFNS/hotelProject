package hotel.service.impl;

import hotel.dto.PaymentInfoDto;
import hotel.dto.ResponseDto;
import hotel.repository.PaymentInfoRepository;
import hotel.service.PaymentInfoService;

import java.util.List;

public class PaymentInfoServiceImpl implements PaymentInfoService {

    private PaymentInfoRepository paymentInfoRepository;

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
