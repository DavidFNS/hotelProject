package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Rooms {

    @Id
    @GeneratedValue(generator = "rooms_seq")
    @SequenceGenerator(name = "rooms_seq", sequenceName = "rooms_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_room_id")
    private Integer typeRoomId;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "service")
    private Boolean service;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_at")
    private Date createdAt;

}
