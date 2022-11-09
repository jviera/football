package net.vieracode.football.common.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.vieracode.football.dto.ClubRequestDto;
import net.vieracode.football.entity.Club;

public class ValueMapper {

    public static Club convertToEntity(ClubRequestDto dto) {
        Club club = new Club();
        club.setCompleteName(dto.getCompleteName());
        club.setShortName(dto.getShortName());
        return club;
    }

}