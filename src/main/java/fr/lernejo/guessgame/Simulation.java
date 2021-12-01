package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        long guess = 0;
        guess = player.askNextGuess();
        if (guess == numberToGuess){
            logger.log("Yes it was indeed " + numberToGuess);
            return true;
        }
        else {
            player.respond(guess > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIter) {
        long timestart = System.currentTimeMillis();
        boolean bool = false;
        while (bool == false) {
            bool = this.nextRound();
            maxIter = maxIter -1;
            //logger.log(String.valueOf(maxIter));
            if (maxIter<=0){
                bool = true;
            }
        };
        long timer = System.currentTimeMillis() - timestart;
        String ms = String.format("%03d", timer%1000);
        String sec = String.format("%02d", timer/1000 %60);
        String min = String.format("%02d", timer/1000 /60);
        String logTimer = min + "." + sec + "." + ms;
        logger.log("Found in :" + logTimer);
    }
}
