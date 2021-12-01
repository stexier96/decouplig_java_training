package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {
    private final Logger logger;
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
        this.logger = LoggerFactory.getLogger("simulation");
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /*
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long tmp = 0;
        tmp = player.askNextGuess();
        if (tmp == numberToGuess){
            logger.log("Bonne réponse");
            return true;
        }
        else {
            player.respond(tmp > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        while (!this.nextRound());
    }
}
