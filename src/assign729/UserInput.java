package assign729;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    public Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public double receiveNumber(String receiveNum) { // UserInput이 넘어오는 부분, 정수가 넘어오지 않는다면? InputMismatchException
        while (true) {// 계산기가 계속 도니까 같이 반복
            try {
                System.out.println(receiveNum); // "
                return scanner.nextDouble();    //
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                scanner.next(); // 잘못된 입력을 버린다. /
            }
        }
    }

    public String getArithmatic() {
        System.out.println("연산을 수행할 연산 부호를 선택해 주세요.");
        System.out.println("( + ) , ( - ) , ( * ) , ( / ) : ");
        System.out.println("프로그램 종료를 원하실 경우 'exit'을 입력해주세요.");

        return scanner.next();
    }
}
