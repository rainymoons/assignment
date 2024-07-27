package assign724;

/**
 * Beverage 클래스 상속
 */
public class Liquor extends Beverage{

    /**
     * 알콜 농도
     */
    private int alcoholContent;
    /*
    isLiquor 값을 입력해야 하는 이유
    Liquor 클래스는 Beverage 클래스를 상속하고, 모든 Liquor 객체는 주류이기 때문에 isLiquor 값을 ture로 설정해야됨.
    부모한테 isLiquor값이 있으니 상속하면 버릴 수가 없는 것. -> Soda 클래스도 마찬가지. Soda는 주류가 아니니까 false.
     */
    public Liquor(String name, int price, int alcoholContent) {
        super(name, price, true);
        this.alcoholContent = alcoholContent;
    }

    public int getAlcoholContent() {
        return alcoholContent;
    }
}
