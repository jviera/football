package net.vieracode.football.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shortName;
    private String completeName;
    /*
    @OneToMany(
            mappedBy = "club",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Player> players = new ArrayList<>();*/
}
