package assign729;

import java.util.Scanner;

public class ArithmaticMain {

    public static void main(String[] args) {
        UserInput userInput = new UserInput(new Scanner(System.in));
        Calculator calculator = new Calculator();

        while(true) {

            double x = userInput.receiveNumber("첫 번째 수를 입력하세요: ");
            double y = userInput.receiveNumber("두 번째 수를 입력하세요: ");

            String option = userInput.getArithmatic();

            if (option.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Arithmatic arithmatic = null;

            if (option.equals("+")) {
                arithmatic = new Add();
            } else if (option.equals("-")) {
                arithmatic = new Subtract();
            } else if (option.equals("*")) {
                arithmatic = new Multiple();
            } else if (option.equals("/")) {
                arithmatic = new Divide();
            } else {
                System.out.println("잘못 입력하셨습니다."); // +, -, /, * 가 아닐 경우 입력라인으로 돌아간다.
                continue;
            }

            try {
                double result = calculator.calculate(x, y, arithmatic);
                System.out.println("연산 결과는: " + result + "입니다.");
            } catch (ArithmeticException ae) { // public class ArithmeticException extends RuntimeException
                System.out.println(ae.getMessage());
            }
        }
    }
}
