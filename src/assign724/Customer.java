package assign724;

public class Customer {

    public static final int UNDER_AGE = 19;
    public static final int MAX_BAC = 30;

    private String name;
    private int age;
    /**
     * blood alcohol content : 혈중 알콜 농도. 만취자 판단 기준
     */
    private int bac;

    // bac 입력 안하는 이유
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.bac = 0;
    }

    public String getName() {
        return name;
    }

    public int getBac() {
        return bac;
    }
    // 매개변수 Liquor liquor -> 무슨 음료 먹냐
    public void drink(Liquor liquor) {
        if(canDrinkLiquor()) { // canDrinkLiquor가 true를 반환하면 (성인인지, 만취자인지 판단)
            bac += liquor.getAlcoholContent(); // 주류의 알콜 농도만큼 bac 증가
        }
    }

    public boolean canDrinkLiquor() { // 주류 주문 가능 나이 판단
        return age >= UNDER_AGE && bac < MAX_BAC;
    }

    public boolean isUnderAge() {
        return age < UNDER_AGE;
    }

    public boolean isLiquor() { // 만취자 판단
        return bac >= MAX_BAC; // bac가 만취자 판단 기준인 30보다 높냐
    }
}
