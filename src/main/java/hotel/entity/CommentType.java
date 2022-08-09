package hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentType {
    @Id
    @GeneratedValue(generator = "java_commentType_seq")
    @SequenceGenerator(name = "java_commentType_seq", sequenceName = "commentType_id_seq", allocationSize = 1)
    private Integer id;
    private String type_comment;
}
