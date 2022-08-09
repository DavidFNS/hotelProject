package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
}
