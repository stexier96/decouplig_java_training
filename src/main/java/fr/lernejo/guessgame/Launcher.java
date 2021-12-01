package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

        if (args.length == 0){
            System.out.println("-interactive pour jouer");
            System.out.println("-auto x pour faire devinez le nombre x à l'ordi");
            System.exit(1);
        }
        if (args[0].compareTo("-interactive") == 0){
            HumanPlayer humanP = new HumanPlayer();
            Simulation simulation = new Simulation(humanP);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if (args[0].compareTo("-auto") == 0){
            ComputerPlayer computerP = new ComputerPlayer();
            Simulation simulation = new Simulation(computerP);
            simulation.initialize(Integer.valueOf(args[1]));
            simulation.loopUntilPlayerSucceed(10);
        }

        else{
            System.out.println(args[0] + " Utilisez -interactive pour jouer, ou -auto x pour faire devinez le nombre x à l'ordi");
        }
    }
}
