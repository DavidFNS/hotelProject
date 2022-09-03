package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ValidatorDto {
    private String fields;
    private String message;
}
