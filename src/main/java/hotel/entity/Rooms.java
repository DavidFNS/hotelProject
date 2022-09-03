package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @ManyToOne
    private TypeRooms typeRooms;

    @ManyToMany
    @JoinTable(
            name = "room_services",
            joinColumns = @JoinColumn(name = "room_id"),
            foreignKey = @ForeignKey(name = "fk_room_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"),
            inverseForeignKey = @ForeignKey(name = "fk_service_id")
    )
    private List<Service> serviceList;

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
