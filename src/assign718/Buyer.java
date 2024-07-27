package assign718;

/**
 * 구매자
 */
public class Buyer {

    int asset;
    int goods;

    /**
     *
     * @param asset 구매자의 자산
     * @param goods 구매자가 보유한 상품의 수량
     */
    Buyer(int asset, int goods) {
        this.asset = asset;
        this.goods = goods;
    }

    /**
     *
     * @param seller 판매자 지정. 이래야 seller클래스의 재고와 자산 수량에 접근 가능
     * @param price 상품 가격
     * @param quantity 거래가 이루어지는 수량
     */
    public void buy(Seller seller, int price, int quantity) {
        if (quantity > seller.goods) { // 구매자의 구매 수량 > 판매자 재고 수량인 경우
            quantity = seller.goods;
        }
        int cost = price * quantity;
        if (cost > this.asset) { // 구매자의 자산이 부족한 경우
            System.out.println("상품을 구매하기 위한 자산이 부족합니다..");
            return; // 리턴 타입이 void라 return이 불필요하지만, 자산이 부족해도 자산감소와 상품 보유 수량이 증가할 수 있음. 메서드 종료용.
        }
        this.asset -= cost; // 자산 감소
        seller.goods += quantity; // 보유 상품 수량 증가
        seller.sell(quantity, price); // 재고 감소, 자산 증가
    }
}
