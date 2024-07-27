package assign719;

public class ClassMethod3 {
    public static String getCourseCredit(double average) {
        if (average == 4.5) {
            return "GOD";
        } else if (4.0 <= average && average < 4.5 ) {
            return "A+";
        } else if (3.5 <= average && average < 4.0 ) {
            return "A";
        } else if (3.0 <= average && average < 3.5 ) {
            return "B+";
        } else if (2.5 <= average && average < 3.0 ) {
            return "B";
        } else if (1.5 <= average && average < 2.5 ) {
            return "C+";
        } else if (1.0 <= average && average < 1.5 ) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        System.out.println(getCourseCredit(4.5));
        System.out.println(getCourseCredit(3.2));
        System.out.println(getCourseCredit(0.1));
    }
}
