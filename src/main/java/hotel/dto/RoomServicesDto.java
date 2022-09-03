package hotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomServicesDto {

    private Integer id;
    private Integer service_id;
    private Integer room_id;

}
