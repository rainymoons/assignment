package assign719;

public class ClassMethod2 {

    public static double getAverage(double java, double spring, double mysql, double docker) {
        return (java + spring + mysql + docker) / 4;
    }

    public static String getCourseCredit(double java, double spring, double mysql, double docker) {
        double average = getAverage(java, spring, mysql, docker);
        double result = (average - 55) / 10;
        return String.format("%.2f", result);
    }

    public static void main(String[] args) {
        double java = 100;
        double spring = 100;
        double mysql = 100;
        double docker = 100;

        String format = getCourseCredit(java, spring, mysql, docker);
        System.out.println("평점평균은 : " + format);
    }
}
