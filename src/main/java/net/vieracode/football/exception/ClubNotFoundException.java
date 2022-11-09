package net.vieracode.football.exception;

public class ClubNotFoundException extends RuntimeException {

    public ClubNotFoundException() {
    }

    public ClubNotFoundException(String message) {
        super(message);
    }
}
