package workshop.com.edu.game;

public class Game {

    private int type; //사용 안하네요
    private int totalGameCnt;
    private int winCondition;
    private int currentGameCnt;
    private int currentWinCnt;
    private int currentLoseCnt;
    private int currentTieCnt;
    private int userPick; //사용 안하네요
    private int computerPick;
    private boolean gameStatus = false;

    //게임 안내 기능
    public void gameInfo() {
        System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");
        System.out.print("번호를 입력하세요 >> ");
    }

    //게임 타입 선택 검증
    public boolean gameTypeValidation(int value) {
        switch (value) {
            case 1:
                totalGameCnt = 5;
                winCondition = 3;
                type = value; //필요한가...?
                gameStatus = true;
                return gameStatus;
            case 2:
                totalGameCnt = 3;
                winCondition = 2;
                type = value;
                gameStatus = true;
                return gameStatus;
            case 3:
                totalGameCnt = 1;
                winCondition = 1;
                type = value;
                gameStatus = true;
                return gameStatus;

            default:
                System.out.print("[에러] 1~3의 사이값으로 다시 입력해 주세요 : ");
                gameStatus = false;
                return gameStatus;
        }
    }

    //게임 시작 기능
    public void runGameInput() {
        //게임 실행
        computerPick = (int) (Math.random() * 3) + 1;
        System.out.print("1.가위 2.바위 3.보 중 하나 입력: ");
    }

    public boolean runGameOutput(int userPick) {
        //컴퓨터 비교
        if (userPick + 1 == computerPick || userPick - 2 == computerPick) {
            //user 지는 거
            System.out.println("졌습니다 ㅠㅠ");
            currentGameCnt++;
            currentLoseCnt++;
        } else if (userPick == computerPick) {
            System.out.println("비겼습니다..");
            currentGameCnt++;
            currentTieCnt++;
        } else {
            // user 이기는 거
            System.out.println("이겼습니다!!");
            currentGameCnt++;
            currentWinCnt++;
        }

        //계속 실행 조건
        if (currentGameCnt < totalGameCnt && currentWinCnt < winCondition && currentLoseCnt < winCondition) return true;
        else return false;
    }

    //게임 결과
    public void gameResult() {
        System.out.println("================== 게임 종료 ==================");
        if (currentWinCnt == winCondition) System.out.printf("승리 하셨습니다!! [전적:%d판 %d승 %d무 %d패]\n", totalGameCnt, currentWinCnt, currentTieCnt, currentLoseCnt);
        else if (currentWinCnt < currentLoseCnt) System.out.printf("패배 하셨습니다 ㅠㅠ [전적:%d판 %d승 %d무 %d패]\n", totalGameCnt, currentWinCnt, currentTieCnt, currentLoseCnt);
        else System.out.printf("무승부입니다.. [전적:%d판 %d승 %d무 %d패]", totalGameCnt, currentWinCnt, currentTieCnt, currentLoseCnt);
    }
}
