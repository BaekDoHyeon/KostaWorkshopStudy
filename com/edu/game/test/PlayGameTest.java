package workshop.com.edu.game.test;

import workshop.com.edu.game.Game;

import java.util.Scanner;

public class PlayGameTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Game game = new Game();
        boolean gameFail = true;
        int gameType = 0;
        boolean gameLun = false;
        boolean gameStatus = false;

        //게임 설명 및 게임 타입 선택 V1
        game.gameInfo();
        do {
            gameType = in.nextInt();
            gameLun = game.gameTypeValidation(gameType);
        } while (!gameLun);

        //게임 실행
        do {
            game.runGameInput();
            int userPick = in.nextInt();
            gameStatus = game.runGameOutput(userPick);
        } while (gameStatus);

        //게임 결과 확인
        game.gameResult();

    }
}
