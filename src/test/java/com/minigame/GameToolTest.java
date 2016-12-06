package com.minigame;

import com.minigame.utils.Constants;
import com.minigame.utils.GameTool;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GameToolTest {

    @Test
    public void testGameBoxesArrayCreator(){
        List<Box> gameBoxes = GameTool.createGameBoxesArray();
        assertTrue(gameBoxes.size() == 12);
    }

    @Test
    public void testAdditionRewardBoxesArrayCreator(){
        List<Box> extraAwardWithSecondChance = GameTool.createAddtionRewardBoxesArray(0);
        List<Box> extraAward = GameTool.createAddtionRewardBoxesArray(1);
        assertTrue(extraAwardWithSecondChance.size() == 4);
        assertTrue(extraAward.size() == 3);
    }

    @Test
    public void testCalculateStepWinnings(){
        Box boxCoin1 = new Box(10);
        Box boxCoin2 = new Box(50);
        Box boxCoin3 = new Box(100);
        Box boxLife4 = new Box(Constants.SpecialSign.EXTRA_LIFE);
        Box boxGameOver5 = new Box(Constants.SpecialSign.GAME_OVER);
        Box boxGameOver6 = new Box(Constants.SpecialSign.GAME_OVER);

        List<Box> boxList1 = Arrays.asList(boxCoin1,boxCoin2,boxLife4,boxCoin3,boxGameOver5,boxGameOver6);
        assertTrue(GameTool.calculateStepWinnings(boxList1)==160);

        List<Box> boxList2 = Arrays.asList(boxCoin1,boxCoin2,boxGameOver5,boxCoin3,boxLife4,boxGameOver6);
        assertTrue(GameTool.calculateStepWinnings(boxList2)==60);

        List<Box> boxList3 = Arrays.asList(boxCoin1,boxLife4,boxGameOver5,boxCoin2,boxGameOver6,boxCoin3);
        assertTrue(GameTool.calculateStepWinnings(boxList3)==60);

        List<Box> boxList4 = Arrays.asList(boxGameOver5,boxCoin1,boxLife4,boxCoin2,boxGameOver6,boxCoin3);
        assertTrue(GameTool.calculateStepWinnings(boxList4)==0);
    }
}

