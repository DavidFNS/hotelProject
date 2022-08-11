package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "type_rooms")
public class TypeRooms {

    @Id
    @GeneratedValue(generator = "type_rooms_seq")
    @SequenceGenerator(name = "type_rooms_seq", sequenceName = "type_rooms_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_name")
    private String name;
}
