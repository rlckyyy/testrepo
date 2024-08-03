package relucky.code.testapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import relucky.code.testapi.model.enums.Gender;

/**
 * @author yernuromirzak
 * 03.08.2024
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
