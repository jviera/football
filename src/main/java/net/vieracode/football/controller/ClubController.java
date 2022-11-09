package net.vieracode.football.controller;

import net.vieracode.football.component.ClubComponent;
import net.vieracode.football.dto.ClubRequestDto;
import net.vieracode.football.entity.Club;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/clubs")
@AllArgsConstructor
@Slf4j
public class ClubController {
    private ClubComponent clubComponent;

    @GetMapping
    public ResponseEntity<List<Club>> getAll(){
        log.info("Get all Clubs!");
        return new ResponseEntity(clubComponent.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getById(@PathVariable Long id) {
        log.info("Get Club with ID: {}",id);
        return new ResponseEntity(clubComponent.findByID(id),HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Club> newClub(@RequestBody @Valid ClubRequestDto club) {
        log.info("Creating new club!");
        return new ResponseEntity(clubComponent.save(club), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@RequestBody Club clubUpdate, @PathVariable Long id) {
        clubUpdate.setId(id);
        return new ResponseEntity(clubComponent.update(clubUpdate), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClub(@PathVariable Long id) {
        clubComponent.delete(id);
        return new ResponseEntity("Club was deleted.", HttpStatus.OK);
    }
}