package com.javamasterclass;

public class Main {

    public static void main(String[] args) {

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + highScore);

        highScore = calculateScore(true, 10_000, 8, 200);
        System.out.println("Your final score was " + highScore);

        //
        // Create a method called displayHighScorePosition
        // it should a players name as a parameter, and a 2nd parameter as a position in the high score table
        // You should display the players name along with a message like "managed to get into position" and the
        // position they got and a further message "on the high score table".
        //
        // Create a 2nd method called calculateHighScorePosition
        // it should be sent one argument only, the player score
        // it should return an int
        // the return data should be
        // 1 if the score is > 1_000
        // 2 if the score is > 500 and < 1_000
        // 3 if the score is > 100 and < 500
        // 4 in all other cases
        // call both methods and display the results of the following
        // a score of 1_500, 900, 400 and 50.
        //

        int highScorePosition = calculateHighScorePosition(1_500);
        displayHighScorePosition("Roger", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Loren", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Becky", highScorePosition);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2_000;
            return finalScore;
        }

        return -1;
    }

    public static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position " +
                highScorePosition + " on the high score table.");
    }

    public static int calculateHighScorePosition(int playerScore) {
//
//        if (playerScore >= 1_000) {
//            return 1;
//        } else if (playerScore >= 500) {
//            return 2;
//        } else if (playerScore >= 100) {
//            return 3;
//        }
//        return 4;
//
        int position = 4; // assuming position 4 will be returned

        if (playerScore >= 1_000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }
        return position;
    }
}
