package hotel.service.mapper;

import hotel.dto.PaymentMethodDto;
import hotel.entity.PaymentMethod;

public class PaymentMethodMapper {

    public static PaymentMethod toEntity(PaymentMethodDto paymentMethodDto){
        if (paymentMethodDto == null){
            return null;
        }

        return PaymentMethod.builder()
                .id(paymentMethodDto.getId())
                .name_method(paymentMethodDto.getName_method())
                .build();
    }
    public static PaymentMethodDto toDto(PaymentMethod paymentMethod){
        if (paymentMethod == null){
            return null;
        }
        return PaymentMethodDto.builder()
                .id(paymentMethod.getId())
                .name_method(paymentMethod.getName_method())
                .build();
    }
}
