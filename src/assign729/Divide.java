package assign729;

/**
 * 수학에서 어떤 수를 0으로 나누는 것은 성립되지 않는다. (대표적인 부정형)
 *  - 나누어지는 수(x)에 나누는 수(y)를 몇 번(q) 뺄 수 있는지 계산
 *  - 나눈 결과(q)를 나누는 수(y)와 곱하고 나머지(r)을 더하면 나누어지는 수(x)가 되어야 함.
 *  - 그런데 0으로 곱하면 무조건 결과는 0이되고 나머지는 없음. 성립하지 않는다.
 * 그러나 0을 나누는 것은 성립된다. 0/a = 0
 *
 * 따라서 0으로 나누는 경우의 예외처리를 해야함
 */
public class Divide implements Arithmatic {

    @Override
    public double calc(double x, double y) {

        if (y == 0 ) { // (x == 0 && y == 0) 이건 언제나 false
            throw new ArithmeticException("0으로 나누는 것은 허용되지 않습니다.");
        }
        return x / y;
    }

}
