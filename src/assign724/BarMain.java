package assign724;

public class BarMain {

    public static void main(String[] args) {

        /*
        Liquor 객체는 Beverage 클래스의 자식 클래스이므로, Liquor 객체를 Beverage 타입으로 참조할 수 있다(다형성)
         = 자식 클래스는 부모 클래스를 상속하므로 자식 클래스의 객체는 부모 클래스 타입으로 할당 될 수 있다.

        자식 클래스를 부모 클래스 타입으로 변환하는 과정 => 업캐스팅
        Liquor 객체를 Beverage 타입으로 자동으로 업캐스팅하여 배열에 저장 -> 형변환이 필요없는 조건

        형변환이 필요할 떄는 부모 클래스 타입의 변수를 자식 클래스 타입으로 변환하여 자식 클래스의 고유 기능에 접근할 때 사용.

        beverage 변수는 Beverage 타입으로 선언되어 있지만 실제로는 Liquor와 Soda객체를 참조하고 있다.
        그렇다고 다 접근 되는 것은 아니고, Beverage 클래스에서 정의된것만 접근 가능.....? 형변환 안했는데 왜 되는건지 모르겠다.
        형변환이 필요한 것 아닌가ㅏ?
         */
        Beverage[] beverages = {
            new Liquor("소주", 9000, 5),
            new Liquor("맥주", 13000, 3),
            new Liquor("양주", 25000, 8),
            new Soda("콜라", 2000),
            new Soda("사이다", 1500),
            new Soda("웰치스", 2500)
        };

        // bar 객체 생성시 음료 배열 참조변수 전달
        Bar bar = new Bar(beverages);

        Customer customer1 = new Customer("김지훈", 36);
        Customer customer2 = new Customer("신민규", 18);

        // 음료 판매
        bar.sellBeverage(beverages[3], customer1);
        bar.sellBeverage(beverages[5], customer1); // 웰치스 5개 구매 -> 재고 부족

        // 주류 판매
        bar.sellBeverage(beverages[0], customer1); // 소주 판매
        bar.sellBeverage(beverages[1], customer2); // 맥주 판매
        bar.sellBeverage(beverages[2], customer1); // 양주 판매
        bar.sellBeverage(beverages[2], customer1); // 양주 판매
        bar.sellBeverage(beverages[2], customer1); // 양주 판매
        bar.sellBeverage(beverages[2], customer1); // 양주 판매

        System.out.println(customer1.getName() + "의 bac는 " + customer1.getBac() + "입니다.");
        System.out.println(customer2.getName() + "의 bac는 " + customer2.getBac() + "입니다.");

        System.out.println("총 판매액은 " + bar.getTotalSalesAmount() + "원 입니다.");

    }
}
