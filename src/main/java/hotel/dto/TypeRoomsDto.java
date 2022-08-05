package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeRoomsDto {

    private Integer id;
    private String name;
}
