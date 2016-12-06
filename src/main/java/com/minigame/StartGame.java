package com.minigame;

import java.math.BigDecimal;

public class StartGame {
    public static void main(String[] args) {
        int counterGameRun = 1000000;
        BigDecimal generalMoneyWin = BigDecimal.valueOf(0);

        Simulation simulation = new Simulation();
        for (int i = 0; i<counterGameRun; i++) {
            generalMoneyWin = generalMoneyWin.add(BigDecimal.valueOf(simulation.startGame(0)));
        }
        System.out.println("Everage Money Win: " + generalMoneyWin.
                divide(BigDecimal.valueOf(counterGameRun),2,BigDecimal.ROUND_HALF_UP));
   }
}