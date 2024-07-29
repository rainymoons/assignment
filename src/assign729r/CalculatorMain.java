package assign729r;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        /**
         * 검증이 필요한 부분
         *   1. 연산자가 제대로 입력되었는가? -> InvalidOperatorException 사용자 정의 예외(RuntimeException 상속)
         *   2. 입력된 숫자가 정수인가? -> InputMismatchException
         *   3. 0으로 나누려고 시도하는가? -> ArithMaticException
         *  그래서 이 세 부분을 try로 감싸서 검증한다.
         */
        while (true) {
            try {
                System.out.println("연산자를 입력하세요 ( + ) , ( - ) , ( * ) , ( / ) : "
                    + "\n (프로그램 종료를 원하시면 'exit'을 입력하세요)");
                String operator = scanner.next();

                if (operator.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                System.out.print("첫 번째 숫자를 입력하세요: ");
                double x = receiveNumber(scanner);// scanner를 파라미터로 가지는 receiveNumber를 호출한다.

                System.out.print("두 번째 숫자를 입력하세요: ");
                double y = receiveNumber(scanner);

                double result = calculator.calculate(operator, x, y);
                System.out.println("연산 결과: " + result);

            } catch (InputMismatchException ime) { // 잘못된 입력값 검증
                System.out.println("잘못된 입력입니다. 정수를 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 버립니다. 잘못 입력한 숫자 먹음.

            } catch (InvalidOperatorException ioe) { // 잘못된 연산자가 입력되었을때 검증
                System.out.println(ioe.getMessage());

            } catch (ArithmeticException ae) { // 0으로 나누려고 할때 예외를 던짐
                System.out.println(ae.getMessage());
            }
        }
    }
    // 사용자가 입력한 값이 잘못된 값일 때 InputMismatchException이 발생한다. 예외를 잡아내고 사용자에게 던지고, 다시 입력을 요청 받는다.
    // 무슨 값을? -> 사용자가 입력한 값을 -> 왜? -> 정수가 아닌 숫자가 입력되고 계산되면, RuntimeException이 발생하니까. 사전 차단.
    public static double receiveNumber(Scanner scanner) { // 사용자 입력을 받기 위해 scanner 파라미터 사용.
        while (true) {
            try {
                return scanner.nextDouble(); // 여기서 부터 실행되는데 입력된 숫자에 문제가 없으면, double 타입의 정수로 반환한다. 여기서 예외 발생
            } catch (InputMismatchException ime) { // 근데 정수가 아니면
                System.out.println("잘못된 입력입니다. 숫자를 다시 입력해 주세요."); // 예외를 날리고
                scanner.next(); // 잘못입력된 숫자를 먹어버린다. (잘못된 입력값 소모)
            }
        }
        /**
         * 위 코드를 보면, receiveNumber(scanner)를 통해 receiveNumber메서드를 호출하고, scanner.nextDouble();로 읽은 사용자 값에 대해 검증한다.
         * 이것을 루프 내의 예외 처리라고 하는데, while에 의해 반복문이 실행되는 동안 try 조건을 만족하지 못하면 그 조건을 만족할 때까지 반복을 진행하는 것을 의미한다.
         * 이것을 언뜻 보면 함수 내부에서 함수가 자기 자신을 또다시 호출하는 재귀 호출로 생각할 수 있으나, 재귀호출은 함수 호출 스택을 사용하여 호출 상태를 유지하는 반면
         * 반복문은 특정 조건이 충족될떄까지 코드 블록을 반복하여 실행하는 것이다.
         * 즉 위 코드는 반복문과 예외 처리를 조합하여 유효한 입력을 받을 때까지 반복적으로 사용자 입력을 요청하는 구조이다.
         */
    }
}
