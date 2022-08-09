package hotel.service.mapper;

import hotel.dto.PaymentMethodDto;
import hotel.entity.PaymentMethod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto toDto(PaymentMethod paymentMethod);
}
