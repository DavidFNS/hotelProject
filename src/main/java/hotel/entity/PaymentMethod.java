package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(generator = "payment_method_seq")
    @SequenceGenerator(name = "payment_method_seq", sequenceName = "payment_method_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_method")
    private String name_method;

}
