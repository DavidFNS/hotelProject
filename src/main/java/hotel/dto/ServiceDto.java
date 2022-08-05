package hotel.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
public class ServiceDto {

    private Integer id;
    private String name;
    private Double price;

}
