package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "booking_room")
public class Booking {
    @Id
    @GeneratedValue(generator = "sp_booking_seq")
    @GenericGenerator(
            name = "sp_booking", strategy = "increment", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "booking_id_seq"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "3"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    private Integer id;
    @ManyToOne
    private PaymentMethod paymentMethod;

    @ManyToOne
    private Users user;
    @ManyToOne
    private Rooms room;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date in_date;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date out_date;
    private Integer count_senior;
    private Integer count_junior;
    private double total_price;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
}
