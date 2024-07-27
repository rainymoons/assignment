package assign722;

import java.util.Scanner;

public class ThreeWordRelay {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ThreeWordRelayInfo gameInfo = new ThreeWordRelayInfo("자전거");

        System.out.println("첫번째 끝말잇기 제시어는 \"자전거\" 입니다.");

        //반복 시작
        while(true) {
            System.out.print("단어를 입력하세요 : ");
            String nextWord = input.nextLine();
            gameInfo.inputNextWord(nextWord); // 다음 단어 입력하고 inputNextWord 호출

            // 맞으면 진행. 틀리면 break;
            boolean isEnoughLength = gameInfo.isEnoughLength(); // 길이 체크
            if(!isEnoughLength) {
                break;
            }

            //맞으면 -> "거"로 시작하냐? 틀리면 break;
            boolean isStartLetter = gameInfo.isStartLetter(); // 이것도 정답이면
            if(!isStartLetter) {
                break;
            }

            gameInfo.addCount();
            gameInfo.changeCurrentWord(); //여기까지 조건을 충족했다고 판단하고 진행하는 것.
        }
        gameInfo.gameOver();
    }
}
