package assign716;

/**
 * 소수 - 1과 자기 자신만을 약수로 가지는 수
 * 오직 자기 자신으로 나눠야 나머지가 0
 * 약수의 특징 -> N의 약수는 무조건 제곱근의 범위 내에 존재한다.
 * 소수인지 확인할 숫자 n의 제곱근을 기준으로 약수끼리의 곱은 대칭으로 이루어진다.
 * ex) N = 64 -> 제곱근은 1,2,4,8,16,32,64
 * 1-64, 2-32, 4-16, 8-8
 * 따라서, 제곱근과 같거나 작은 숫자로 나누어지면 그 이후는 대칭이므로 소수인지 아닌지 확인할 필요가 없다.
 * 제곱근을 표현하는 메서드 => Math.sqrt();
 * 연관 알고리즘 -> '에라토스테네스의 체'
 */
public class primeNumberCounter {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) { //1은 소수도 아니고 합성수도 아니다. 1보다 커야하는 것 주의 -> 2부터 시작
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 10000; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("1부터 10000까지 소수의 개수는 : " + count);
    }
}
