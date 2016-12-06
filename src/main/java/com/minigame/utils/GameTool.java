package com.minigame.utils;

import com.minigame.Box;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameTool {

    public static List createGameBoxesArray (){
        Integer[] coins = {20, 20, 5, 5, 5, 5, 5, 100};
        Stream<Integer> stream = Arrays.stream(coins);

        List<Box> boxArray;
        boxArray = stream.map(x -> new Box(x)).collect(Collectors.toList());
        boxArray.add(new Box(Constants.SpecialSign.EXTRA_LIFE));

        boxArray.addAll(IntStream.range(1, 4)
                .mapToObj(i -> new Box(Constants.SpecialSign.GAME_OVER))
                .collect(Collectors.toList()));
        return boxArray;
    }

    public static List createAddtionRewardBoxesArray (int gameState){
        Integer[] coins = {20, 10, 5};
        Stream<Integer> stream = Arrays.stream(coins);

        List<Box> boxArray;
        boxArray = stream.map(x -> new Box(x)).collect(Collectors.toList());

        if(gameState==0) boxArray.add(new Box(Constants.SpecialSign.SECOND_CHANCE));
        return boxArray;
    }

    public static Integer calculateStepWinnings(List<Box> gameBoxes){
        boolean extraLife = false;
        Integer stepWinnings = 0;
        Iterator<Box> iterator = gameBoxes.iterator();
        while (iterator.hasNext()){
            Box currentBox = iterator.next();
            if(currentBox.getSpecial_sign() == Constants.SpecialSign.EXTRA_LIFE){
                extraLife = true;
            } else if ((currentBox.getSpecial_sign() == Constants.SpecialSign.GAME_OVER) && (extraLife == false)){
                break;
            } else if ((currentBox.getSpecial_sign() == Constants.SpecialSign.GAME_OVER) && (extraLife == true)){
                extraLife = false;
            } else {
                stepWinnings += currentBox.getAmount();
            }
        }
        return stepWinnings;
    }
}
