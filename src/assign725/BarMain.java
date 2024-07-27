package assign725;

public class BarMain {

    public static void main(String[] args) {

//        AbstractBar ab = new AbstractBar(Beverage[] beverage){
//            @Override
//            public boolean canSell(Beverage beverage, Customer customer) {
//                return false;
//            }
//        };

        Beverage[] beverages = {
            new Liquor("소주", 9000),
            new Liquor("맥주", 13000),
            new Liquor("양주", 25000),
            new Soda("콜라", 2000),
            new Soda("사이다", 1500),
            new Soda("웰치스", 2500)
        };

        Bar bar = new Bar(beverages);

        Customer customer1 = new Customer("김지훈", 36);
        Customer customer2 = new Customer("신민규", 18);

        // 음료 판매
        bar.sellBeverage(beverages[3], customer1);
        bar.sellBeverage(beverages[5], customer1);

        // 주류 판매
        bar.sellBeverage(beverages[0], customer1);
        bar.sellBeverage(beverages[1], customer2);
        bar.sellBeverage(beverages[2], customer1);
        bar.sellBeverage(beverages[2], customer1);
        bar.sellBeverage(beverages[2], customer1);
        bar.sellBeverage(beverages[2], customer1);

        System.out.println("총 판매액은 " + bar.getTotalSalesAmount() + "원 입니다.");
    }
}