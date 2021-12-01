package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    Logger logger = LoggerFactory.getLogger("player");
    Scanner sc = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Devine quel nombre");
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {
            logger.log("plus petit");
        }
        else {
            logger.log("plus grand");
        }
    }
}
