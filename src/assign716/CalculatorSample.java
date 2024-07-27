package assign716;

import java.util.Scanner;

public class CalculatorSample {

    public static void main(String[] args) {

        int a = 2;
        int b = 1;
        String str = "";

        Scanner input = new Scanner(System.in);

        while(true) {

            System.out.println("=== 다음의 연산자 중 하나를 선택해 입력하세요! === ");
            System.out.print("  === (  +  ,  -  ,  *  ,  /  ) === : ");
            String inputMsg = input.nextLine();

            if (inputMsg.equals("exit") ) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }

            System.out.print("=== 숫자를 입력하세요! === : ");
            int inputNum1 = input.nextInt();

            System.out.print("=== 숫자를 입력하세요! === : ");
            int inputNum2 = input.nextInt();
            input.nextLine();

            int resultPlus = inputNum1 + inputNum2;
            int resultSub = inputNum1 - inputNum2;
            int resultMul = inputNum1 * inputNum2;

            if (inputMsg.equals("+")) {
                System.out.println("결과: " + resultPlus);
            } else if (inputMsg.equals("-")) {
                System.out.println("결과: " + resultSub);
            } else if (inputMsg.equals("*")) {
                System.out.println("결과: " + resultMul);
            } else if (inputMsg.equals("/")) {
                if (inputNum2 != 0) {
                    int resultDiv = inputNum1 / inputNum2;
                    System.out.println("결과: " + resultDiv);
                } else {
                    System.out.println("오류: 0으로 나눌 수 없습니다.");
                }
            } else {
                System.out.println("잘못된 연산자입니다. 다시 시도하세요.");
            }
        }
    input.close();
    }
}