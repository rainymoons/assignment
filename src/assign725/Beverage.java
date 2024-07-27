package assign725;
/**
 * 추상클래스
 */
public abstract class  Beverage {

    private String name;
    private int price;
    private boolean isLiquor;

    public Beverage(String name, int price, boolean isLiquor) {
        this.name = name;
        this.price = price;
        this.isLiquor = isLiquor;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isLiquor() {
        return isLiquor;
    }

}
