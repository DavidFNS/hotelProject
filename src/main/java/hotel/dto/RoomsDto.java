package hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomsDto {
    private Integer id;
    private Integer typeRoomId;
    private Integer capacity;
    private Boolean service;
    private Double price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
}
