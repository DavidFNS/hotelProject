package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
@Builder
public class Service {

    @Id
    @GeneratedValue(generator = "service_seq")
    @SequenceGenerator(name = "service_seq", sequenceName = "service_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_service")
    private String name;

    @Column(name = "price")
    private Double price;
}
