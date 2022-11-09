package net.vieracode.football.component.impl;

import net.vieracode.football.common.util.ValueMapper;
import net.vieracode.football.component.ClubComponent;
import net.vieracode.football.dto.ClubRequestDto;
import net.vieracode.football.entity.Club;
import net.vieracode.football.exception.ClubNotFoundException;
import net.vieracode.football.repository.ClubRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClubComponentImpl implements ClubComponent {
    private final ClubRepository repository;

    public ClubComponentImpl(ClubRepository clubRepository) {
        this.repository = clubRepository;
    }

    @Override
    public List<Club> getAll() {
        return repository.findAll();
    }

    @Override
    public Club findByID(Long id) {
        Optional<Club> optionalClub = repository.findById(id);
        if (optionalClub.isPresent())
            return optionalClub.get();
        throw new ClubNotFoundException("There is not a Club with ID " + id);
    }

    @Override
    public Club save(ClubRequestDto dto) {
        return repository.save(ValueMapper.convertToEntity(dto));
    }

    @Override
    public Club update(Club clubFinder) {
        repository.findById(clubFinder.getId()).ifPresentOrElse(club -> {
            club.setShortName(clubFinder.getShortName());
            club.setCompleteName(clubFinder.getCompleteName());
            repository.save(club);
        }, () -> {
            throw new ClubNotFoundException("There is not a Club with ID " + clubFinder.getId());
        });
        return clubFinder;
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresentOrElse(club -> {
            repository.delete(club);
        }, () -> {
            throw new ClubNotFoundException("There is not a Club with ID " + id);
        });
    }
}