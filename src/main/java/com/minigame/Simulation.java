package com.minigame;

import com.minigame.utils.Constants;
import com.minigame.utils.GameTool;

import java.util.*;

public class Simulation {
    private int totalWinnings = 0;

    public Integer startGame (int gameState){
        if(gameState==0)
            this.totalWinnings = 0;
        this.totalWinnings += calculateWinnings(GameTool.createGameBoxesArray());
        addAdditionReward(GameTool.createAddtionRewardBoxesArray(gameState));
        return totalWinnings;
    }

    private Integer calculateWinnings(List<Box> gameBoxes){
        Collections.shuffle(gameBoxes);
        return GameTool.calculateStepWinnings(gameBoxes);
    }

    private void addAdditionReward(List<Box> addtionRewardBoxes){
        Collections.shuffle(addtionRewardBoxes);
        Box selectedBox = addtionRewardBoxes.get(0);
        if (selectedBox.getSpecial_sign() == Constants.SpecialSign.SECOND_CHANCE){
            startGame(1);
        }
        else
            this.totalWinnings += selectedBox.getAmount();
    }
}
