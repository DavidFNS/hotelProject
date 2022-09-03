package hotel.dto;

import hotel.service.mapper.RoomsMapper;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TypeRoomsDto {

    private Integer id;
    private String name;
    private List<RoomsDto> roomsList;
}
