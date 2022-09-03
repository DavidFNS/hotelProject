package hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ServiceDto {

    private Integer id;
    private String name;
    private Double price;
    private List<RoomsDto> roomsList;
}
