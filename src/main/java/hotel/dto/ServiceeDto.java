package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceeDto {

    private Integer id;
    private String name;
    private Double price;

}
