package assign716;

import java.util.Scanner;

public class primeNumberCounter2 {

    // 소수를 판별하는 메서드
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int primeRange(int range) {
        int count = 0;
        for (int i = 1; i <= range; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static int getInputRange() {
        Scanner input = new Scanner(System.in);
        int inputRange = 0;
        while (true) {
            System.out.print("2부터 N까지 몇 개의 소수가 있을까요? 범위를 입력해주세요! (2이상 입력) : ");
            inputRange = input.nextInt();
            if (inputRange > 1) { //입력한 범위가 
                break;
            } else {
                System.out.println(" 2 이상의 값을 입력해주세요!");
            }
            System.out.println("");
        }
        return inputRange;
    }

    public static void main(String[] args) {
        int inputRange = getInputRange();
        int primeCount = primeRange(inputRange);
        System.out.println("1부터 " + inputRange + " 사이의 소수 개수 : " + primeCount + "개");
    }
}
