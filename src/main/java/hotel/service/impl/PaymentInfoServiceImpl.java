package hotel.service.impl;

import hotel.dto.PaymentInfoDto;
import hotel.dto.ResponseDto;
import hotel.entity.PaymentInfo;
import hotel.repository.PaymentInfoRepository;
import hotel.service.PaymentInfoService;
import hotel.service.mapper.PaymentInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private final PaymentInfoRepository paymentInfoRepository;
    private final PaymentInfoMapper paymentInfoMapper;


    @Override
    public ResponseDto addPaymentInfo(PaymentInfoDto paymentInfoDto) {
        paymentInfoRepository.save(paymentInfoMapper.toEntity(paymentInfoDto));
        try {
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            return ResponseDto.builder()
                    .code(404)
                    .success(true)
                    .message("Not working")
                    .build();
        }
    }

    @Override
    public ResponseDto updatePaymentInfo(PaymentInfoDto paymentInfoDto){
        if(paymentInfoRepository.existsById(paymentInfoDto.getId())){
            PaymentInfo paymentInfo = paymentInfoMapper.toEntity(paymentInfoDto);
            paymentInfoRepository.save(paymentInfo);

            return ResponseDto.builder().code(200).success(true).message("OK").build();
        }
        return ResponseDto.builder().code(404).success(false).message("Not found").build();
    }

    @Override
    public ResponseDto deletePaymentInfo(Integer id) {
        Optional<PaymentInfo> paymentInfo = paymentInfoRepository.findById(id);
        if(paymentInfo.isPresent()){ 
            paymentInfoRepository.deleteById(id);
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .build();
        }
        return ResponseDto.builder()
                .code(404)
                .success(false)
                .message("Not working")
                .build();
    }

    @Override
    public ResponseDto<List<PaymentInfoDto>> getPaymentInfo() {
        List<PaymentInfo> paymentInfos = paymentInfoRepository.findAll();
        List<PaymentInfoDto> paymentInfoDtos = paymentInfos.stream()
                .map(paymentInfoMapper::toDto)
                .toList();
        return new ResponseDto<>(200, true, "OK", paymentInfoDtos);
    }

    @Override
    public ResponseDto<PaymentInfoDto> findById(Integer id) {
        if (paymentInfoRepository.existsById(id)) {
            PaymentInfo paymentInfo = (paymentInfoRepository.findById(id)).get();
            return new ResponseDto<>(200, true, "OK", paymentInfoMapper.toDto(paymentInfo));
        }
        return new ResponseDto<>(404, false, "Not working", null);
    }
}
