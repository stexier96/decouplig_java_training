package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

        HumanPlayer JeanMich = new HumanPlayer();
        Simulation simulation = new Simulation(JeanMich);
        simulation.initialize(randomNumber);

        simulation.loopUntilPlayerSucceed();
    }
}
