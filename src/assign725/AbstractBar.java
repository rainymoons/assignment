package assign725;

public abstract class AbstractBar {

    private Beverage[] beverages;
    protected int totalSalesAmount;

    public AbstractBar(Beverage[] beverages) {
        this.beverages = beverages;
    }

    public abstract boolean canSell(Beverage beverage, Customer customer);

    /**
     * Bar는 추상화가 이루어진 AdultBar의 SubClass. sellBeverage를 오버라이딩 한다.
     * AdultBar sellBeverage에서 정의한 음료 판매 기능은, subClass인 Bar의 sellBeverage에서 재 정의할 필요가 없다.
     * 따라서 super()를 통해 상속 받는다.
     *
     * super()를 통해 상속받는 기능 -> Beverage를 판매한다.
     * 정의해야 하는 기능
     *  -> 구매를 원하는 항목이 주류인지 음료인지 여부
     *  -> 주류를 구매하려고 한다면 미성년자인지 검증
     */
    public void sellBeverage(Beverage beverage, Customer customer) {
        if (canSell(beverage, customer)) {
            totalSalesAmount += beverage.getPrice();
            System.out.println(customer.getName() + "에게 " + beverage.getName() + "를 판매했습니다.");
        }
        else {
            System.out.println(" (Warning!!!)  " + customer.getName() + "은(는) 미성년자입니다.");
        }
    }

    public int getTotalSalesAmount() {
        return totalSalesAmount;
    }
}