package assign719;

public class Student {

    int java;
    int python;
    int cpp;
    int csharp;

    public int getSumAllScores() {
        return java + python + cpp + csharp;
    }

    public double getAverage() {
        int average = (int) (getSumAllScores() / 4.0 * 100);
        return average / 100.0;
    }

//    public static double getCourseCredit(Student student) {
//        int courseCredit = (int) ((student.getAverage() - 55) / 10.0 * 100);
//        return courseCredit / 100.0;
//    }
    public static double getCourseCredit(Student student) {
        return ((student.getAverage() - 55) / 10.0 * 100.0) / 100;
    }

// 두 메서드 모두 Student 인스턴스를 참조해서 Student 인스턴스의 값을 사용하고 저장한다.

//  public String getABCDE() {
//      double courseCredit = getCourseCredit();
    public static String getABCDE(Student student) {
        double courseCredit = getCourseCredit(student);

        if (courseCredit >= 4.1) {
        return "A+";
        } else if (courseCredit >= 3.6) {
            return "A";
        } else if (courseCredit >= 3.1) {
            return "B+";
        } else if (courseCredit >= 2.6) {
            return "B";
        } else if (courseCredit >= 1.6) {
            return "C";
        } else if (courseCredit >= 0.6) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.java = 100;
        student.python = 97;
        student.cpp = 81;
        student.csharp = 99;

        int sum = student.getSumAllScores();
        double average = student.getAverage();
        double courseCredit = student.getCourseCredit(student);
        String abcde = student.getABCDE(student);

        System.out.println("합계: " + sum); //377
        System.out.println("평균: " + average); // 95.25
        System.out.println("학점: " + courseCredit); // 3.92
        System.out.println("등급: " + abcde); // A
    }
}

