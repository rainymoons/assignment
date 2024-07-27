package assign717;

import java.util.Random;

public class CraneGameMachine {

    boolean isInsertCoin;

    int dolls;

    public void sucess() {
        System.out.println("Congratulations!");
    }

    public void fail() {
        System.out.println("You Died..");
    }



    public void insertCoin() {
        // 인형이 남아있을 경우에만 코인 넣기
        if (dolls > 0) {
            isInsertCoin = true;
            System.out.println("코인을 넣었습니다! 결과는?");
        } else {
            isInsertCoin = false;
            System.out.println("인형이 없습니다.");
        }
    }

    public int doGame() {
        if (isInsertCoin) {
            Random number = new Random();
            int result = number.nextInt(2);
            dolls -= result;
            isInsertCoin = false; // 게임이 끝나면 코인 상태 초기화. 안해주면 원코인으로 실패해도 계속 게임을 한다.
            if (result == 1) {
                sucess();
            } else {
                fail();
            }
            return result;
        }
        System.out.println("코인을 넣어주세요.");
        return 0; // 코인이 넣어지지 않으면 0 -> 뽑기 실패
    }




    public static void main(String[] args) {
        CraneGameMachine craneGameMachine = new CraneGameMachine();
        craneGameMachine.isInsertCoin = false;
        craneGameMachine.dolls = 5;

        craneGameMachine.insertCoin();
        int result = craneGameMachine.doGame();

        System.out.println(result + "개 뽑으셨네요!");
        System.out.println("남은 인형 개수는 " + craneGameMachine.dolls + "개 입니다.");
        System.out.println("isInsertCoin = " + craneGameMachine.isInsertCoin);
    }
}
