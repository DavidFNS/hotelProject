package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
@Builder
public class Servicee {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_service")
    private String name;

    @Column(name = "price")
    private Double price;
}
