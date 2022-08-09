package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "booking_room")
public class Booking {
    @Id
    private Integer id;
    @Column(name = "id_payment_method")
    private Integer id_pay_method;
    private Integer room_id;
    private Date in_date;
    private Date out_date;
    private Integer count_senior;
    private Integer count_junior;
    private double total_price;
    private Date created_at;
}
