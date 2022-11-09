package net.vieracode.football.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClubRequestDto {
    @NotBlank(message = "shortName shouldn't be NULL OR EMPTY")
    @Size(min = 5, max = 50, message = "shortName can't be less than 5 and more than 50")
    private String shortName;
    @NotBlank(message = "completeName shouldn't be NULL OR EMPTY")
    @Size(min = 10, max = 100, message = "completeName can't be less than 10 and more than 100")
    private String completeName;
}
