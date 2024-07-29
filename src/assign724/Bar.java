package assign724;

public class Bar {
    private Beverage[] beverages; // 배열 선언.

    private int totalSalesAmount;

    /*
    Beverage 객체들의 배열을 받아서 Bar 객체의 beverage 필드에 저장하고 totalSalesAmount 필드를 0으로 초기화
    즉 Bar 객체가 생성될때 초기화 하는 생성자. -> 생성자를 통해 Beverage 배열을 Bar 객체의 인스턴스 변수에 할당
    그니까 배열에다가 음료 담고, 총 판매액 0으로 초기화
     */
    public Bar(Beverage[] beverages) {
        this.beverages = beverages;
        this.totalSalesAmount = 0;
    }

    /**
     * Liquor liquor = (Liquor) beverage; ==> beverage instanceof Liquor
     * beverage 객체가 Beverage 클래스 타입으로 선언되었지만, 실제로는 Liquor의 인스턴스이다. ( = 실제 객체는 Liquor 타입)
     *
     * Liquor 클래스는 Beverage 클래스를 상속하므로, Beverage 타입의 변수로 Liquor 객체를 참조할 수 있다.
     * 하지만, Liquor 클래스의 메서드나 속성에 접근 하려면 다시 Liquor 타입으로 형변환 해야 한다.
     * 부모 클래스 타입으로 선언된 객체를 자식 클래스 타입으로 변환
     *
     * 만약 beverage가 Soda 객체를 참조하고 있다면, ClassCastException이 발생
     */
    public void sellBeverage(Beverage beverage, Customer customer) {
        if (beverage instanceof Liquor liquor) { // 구매하려는 beverage가 주류인지 확인.
            if (customer.isUnderAge()) { // 만약 구매자가 미성년자라면
                System.out.println(" (Warning!!!)  " + customer.getName() + "은(는) 미성년자입니다."); // 경고!
            }
            if(!customer.isUnderAge()) { // 미성년자가 아니면
                customer.drink(liquor); // drink 메서드를 호출해서 고객이 주류를 마신다
                if (customer.isLiquor()) {  // 만약 고객이 만취자라면
                    System.out.println(customer.getName() + "은(는) 만취자 입니다. 더 이상 주류를 판매할 수 없습니다.");
                } else { // 만취자가 아니면
                    totalSalesAmount += liquor.getPrice(); // 판매액 증가
                    System.out.println(customer.getName() + "에게 " + liquor.getName() + "를 판매했습니다.");
                }
            }
        } else { // 구매하려는것이 주류가 아니라 탄산음료이면
            totalSalesAmount += beverage.getPrice(); // 핀메엑 증가
            System.out.println(customer.getName() + "에게 " + beverage.getName() + "를 판매했습니다.");
        }
    }

    public int getTotalSalesAmount() {
        return totalSalesAmount;
    }
}
