package assign719;

public class ClassMethod1 {
   public static boolean isValidAge(int age, int min, int max) {
       if (min < age && age < max) {
           return true;
       } else {
           return false;
       }
   }

    public static void main(String[] args) {
        ClassMethod1 cm1 = new ClassMethod1();
        System.out.println(isValidAge(20,18,30));
    }
}

