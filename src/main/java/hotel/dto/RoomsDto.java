package hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RoomsDto {

    private Integer id;
    private Integer typeRoomId;
    private Integer capacity;
    private Boolean service;
    private Double price;
    private Date createdAt;

}
