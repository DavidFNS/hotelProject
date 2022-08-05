package hotel.mapper;

import hotel.dto.PaymentInfoDto;
import hotel.entity.PaymentInfo;

public class PaymentInfoMap {
    
    public static PaymentInfoDto parsToDto(PaymentInfo paymentInfo){
        return PaymentInfoDto.builder()
                .id(paymentInfo.getId())
                .user_id(paymentInfo.getUser_id())
                .card_sender(paymentInfo.getCard_sender())
                .card_receiver(paymentInfo.getCard_receiver())
                .name_sender(paymentInfo.getName_sender())
                .created_at(paymentInfo.getCreated_at())
                .build();
    }

    public static PaymentInfo parsToEntity(PaymentInfoDto paymentInfoDto){
        return PaymentInfo.builder()
                .id(paymentInfoDto.getId())
                .user_id(paymentInfoDto.getUser_id())
                .card_sender(paymentInfoDto.getCard_sender())
                .card_receiver(paymentInfoDto.getCard_receiver())
                .name_sender(paymentInfoDto.getName_sender())
                .created_at(paymentInfoDto.getCreated_at())
                .build();
    }
}
