package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "room_services")
public class RoomServices {

    @Id
    @GeneratedValue(generator = "room_services_seq")
    @SequenceGenerator(name = "room_services_seq", sequenceName = "room_services_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "room_id")
    private Integer roomId;
}
