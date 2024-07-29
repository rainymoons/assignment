package assign729r;

public class Calculator {

    public double calculate(String operator, double x, double y) throws InvalidOperatorException {

        if (operator.equals("+")) {
            return x + y;
        } else if (operator.equals("-")) {
            return x - y;
        } else if (operator.equals("*")) {
            return x * y;
        } else if (operator.equals("/")) {
            if (y == 0) { // (x == 0 && y == 0) 이건 언제나 false
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        } else {
            throw new InvalidOperatorException(operator + "는 올바르지 않은 연산자입니다. 다시 입력해주세요.");
        }
    }
}

