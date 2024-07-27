package assign725;

/**
 * 성인 Bar에서는 나이 검증이 필요 없다고 가정한다.
 * 따라서 구매하려는 것이 주류인지, 미성년자인지 판단하는 로직은 제거.
 */
public class AdultBar extends AbstractBar {

    public AdultBar(Beverage[] beverages) {
        super(beverages);
    }

    @Override
    public boolean canSell(Beverage beverage, Customer customer) {
        return true;
    }
}
