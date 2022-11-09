package net.vieracode.football.entity;

import lombok.*;
import net.vieracode.football.common.PositionEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private Integer number;
    private String name;
    private String lastName;
    private PositionEnum position;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
}
