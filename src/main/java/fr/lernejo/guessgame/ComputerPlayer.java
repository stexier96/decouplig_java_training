package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    private long borneMax = 100;
    private long borneMin = 0;
    Logger logger = LoggerFactory.getLogger("computer");
    @Override
    public long askNextGuess() {
        long guess = (borneMax + borneMin ) / 2;
        logger.log("guessing " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {
            this.borneMax = (this.borneMax + this.borneMin) / 2;
            logger.log("plus petit");
        }
        else {
            this.borneMin = (this.borneMax + this.borneMin) / 2;
            logger.log("plus grand");
        }
    }
}
