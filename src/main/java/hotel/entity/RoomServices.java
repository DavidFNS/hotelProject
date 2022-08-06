package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "room_services")
public class RoomServices {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "room_id")
    private Integer roomId;
}
