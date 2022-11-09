package net.vieracode.football.component;

import net.vieracode.football.dto.ClubRequestDto;
import net.vieracode.football.entity.Club;

import java.util.List;

public interface ClubComponent {
    public List<Club> getAll();
    public Club findByID(Long id);
    public Club save(ClubRequestDto dto);
    public Club update(Club club);
    public void delete(Long id);
}
