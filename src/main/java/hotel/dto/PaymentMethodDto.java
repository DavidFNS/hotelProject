package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentMethodDto {
    private Integer id;
    private String name_method;
}
