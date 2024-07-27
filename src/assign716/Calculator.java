package assign716;

import java.util.Scanner;

public class Calculator {

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }

    // scanner 객체를 이용하여 문자열 입력을 읽어오는 메서드. 사용자가 입력한 연산자를 반환함. 이렇게 안하면 메서드마다 scanner 객체를 생성해야됨
    private static String getInputMessage(Scanner input) {
        System.out.println(" 계산하고 싶은 연산자를 선택하여 입력하세요!  ");
        System.out.println("('exit'를 입력하면 프로그램이 종료됩니다.)");
        System.out.print("    [ +  , - ,  *  ,  /  ]   :  ");
        return input.nextLine();
    }
    // 여기서는 숫자 메세지만 입력 받음. getInputMessage 메서드는 연산자 정보만 입력받음. 메서드의 단일 책임 원칙
    // 입력한 숫자와 순서를 같이 받음.
    private static int getNumber(Scanner input, String orderNum) {
        System.out.printf(" %s 숫자를 입력하세요! : ", orderNum); // 반복을 위해 printf - %s 사용. (ex : 첫번째, 두번쨰). print로는 죽어도 안됨
        int number = input.nextInt();
        input.nextLine(); // 개행문자(\n) 제거용. nextInt 입력할 때 생기는 엔터 때문.
        return number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            String inputMessage = getInputMessage(input);
            // 아래 if문에 exit 넣으면 동작하지 않고 숫자 입력만 뜬다. 위로 뽑아내니까 된다. 숫자가 먼저 입력되야 해서 그런가?
            if (inputMessage.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 사용자가 입력한 숫자와 그에 따른 순서를 저장하는 변수 ex) `첫 번쨰`숫자 & `두 번째`숫자를 ~~~. 별로 안중요하지만 그래도..
            int num1 = getNumber(input, "첫 번째");
            int num2 = getNumber(input, "두 번째");

            if (inputMessage.equals("+")) {
                System.out.println("결과: " + add(num1, num2));
            } else if (inputMessage.equals("-")) {
                System.out.println("결과: " + subtract(num1, num2));
            } else if (inputMessage.equals("*")) {
                System.out.println("결과: " + multiply(num1, num2));
            } else if (inputMessage.equals("/")) {
                if (num2 != 0) {
                    System.out.println("결과: " + divide(num1, num2));
                } else {
                    System.out.println("ERROR! 0으로 나눌 수 없습니다.");
                }
            } else {
                System.out.println("잘못된 연산자입니다. 다시 시도하세요!");
            }
            System.out.println("");
        }
    }

}
