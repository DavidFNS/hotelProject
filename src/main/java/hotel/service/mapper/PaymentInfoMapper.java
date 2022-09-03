package hotel.service.mapper;

import hotel.dto.PaymentInfoDto;
import hotel.entity.PaymentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentInfoMapper {
    PaymentInfo toEntity(PaymentInfoDto paymentInfoDto);
    PaymentInfoDto toDto(PaymentInfo paymentInfo);
}
