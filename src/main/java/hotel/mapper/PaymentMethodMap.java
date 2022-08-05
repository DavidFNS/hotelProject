package hotel.mapper;

import hotel.dto.PaymentMethodDto;
import hotel.entity.PaymentMethod;

public class PaymentMethodMap {

    public static PaymentMethodDto parseToDto(PaymentMethod paymentMethod){

        return PaymentMethodDto.builder()
                .id(paymentMethod.getId())
                .name_method(paymentMethod.getName_method())
                .build();
    }

    public static PaymentMethodDto parseToEntity(PaymentMethodDto paymentMethodDto){

        return PaymentMethodDto.builder()
                .id(paymentMethodDto.getId())
                .name_method(paymentMethodDto.getName_method())
                .build();
    }
}
