package assign719;

public class PracString {

    public static void main(String[] args) {
        String adress = "서울특별시 서초구 효령로 176";

        boolean isSeoul = adress.contains("서울");
        System.out.println(isSeoul);

        boolean isNum = adress.endsWith("176");
        System.out.println(isNum);

        String name = "ktdsuniversity";
        boolean isEqual = name.equals("ktdsuniversity");
        System.out.println(isEqual);

        String name1 = "ktdsuniversity";
        boolean isEqual1 = name1.equalsIgnoreCase("ktdsuniversity");
        System.out.println(isEqual1);

        String format = "%s에서 교육하는 %s과정";
        String str = String.format(format, "ktdsuniversity", "Java");
        System.out.println(str);

        String format1 = "%s에서 교육하는 %s과정";
        String str1 = format.formatted("ktdsuniversity", "Java");
        System.out.println(str1);
    }

}
