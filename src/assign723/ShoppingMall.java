package assign723;
/**
 * <Pre>
 *  ===========   문제 분석   ============
 * Q. 주문한 상품이 보유 상품 목록(productName)에 있는가?
 *     1. Yes → 주문량이 보유량(stock)보다 적거나 같으면? → 판매 → 해당 제품[i]의 보유량(stock)에서 주문량 차감  → 판매 메세지 + 남은 재고 출력
 *            → 주문량보다 보유량(stock)이 적을 경우 → "재고가 부족하므로 판매할 수 없습니다." + 남은 재고 출력
*             → 판매 후 보유량(stock)이 0이 될 경우 -> "재고가 0이므로 판매할 수 없습니다." 출력
 *
 *         no → "재고가 부족하므로 판매할 수 없습니다" 출력
 *
 * Q. 주문한 상품이 보유 상품 목록에 없는 경우?
 *    → "상품을 찾을 수 없습니다." 출력
 * </Pre>
 */
public class ShoppingMall {

    public static void main(String[] args) {
        // 상품 객체와 배열 생성
        Product[] products = {
            new Product("Macbook Pro 15'", 4_000_000, 5),
            new Product("Apple Watch mini", 550_000, 20),
            new Product("Ipad air", 1_200_000, 15)
        };

        // 판매자 객체 생성
        Seller seller = new Seller(products);
        // 출력
        seller.sell("Macbook Pro 15'",5);
        seller.sell("Apple Watch mini",21);
        seller.sell("Samsumg GalaxyTab",10);
    }

//        Product product1 = new Product("Macbook Pro 15'", 4_000_000, 5);
//        Product product2 = new Product("Apple Watch mini", 550_000, 20);
//        Product product3 = new Product("Ipad air", 1_200_000, 15);

        // 상품 배열 생성 - 상품 담기
        // Product[] products = {product1, product2, product3};
}
