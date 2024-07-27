package assign718;
/**
 * <pre>
 * =========== 문제 분석 ==============
 * ### 구매자 상품 1개 구매 ###
 * - 자산 1개 가격만큼 감소
 * - 보유 수량 1개 증가
 *
 * ### 구매자 상품 1개 판매 ###
 * - 판매자 상품 1개 감소
 * - 1개만큼의 자산증가
 *
 * ### 구매자 구매 원하는 수량 > 판매자 재고 수량
 * - 구매자
 *   - 판매자의 재고 수량 * 가격 만큼 자산 감소
 *   - 판매자의 재고 수량만큼 보유 수량 증가
 * - 판매자
 *   - 재고 수량 * 가격만큼 자산 증가
 *   - 판매자의 재고는 0이 됨
 *   - 판매자 판매 가능 수량 < 구매자 구매 의사 수량
 *      - 판매 가능 수량 = 현재 재고 수량 = 구매자 구매 가능 수량
 *
 * ### 구매자가 자신의 자산을 초과하여 상품을 구매하려 하는 경우 ###
 * - 거래가 성사되지 않음
 * =================================
 * </pre>
 */

public class BargainingMain {

    public static void main(String[] args) {
        int price = 500;
        Buyer buyer = new Buyer(8_000, 0);
        Seller seller = new Seller(50_000, 5);

        System.out.println("거래가 이루어지기 전 상태");
        System.out.println("구매자 자산 : " + buyer.asset + ", 구매자 보유 수량 : " + buyer.goods);
        System.out.println("판매자 자산 : " + seller.asset + ", 판매자 보유 수량 : " + seller.goods);

        buyer.buy(seller, price, 7);

        System.out.println();
        System.out.println("거래가 이루어진 후 상태");
        System.out.println("구매자 자산 : " + buyer.asset + ", 구매자 보유 수량 : " + buyer.goods);
        System.out.println("판매자 자산 : " + seller.asset + ", 판매자 보유 수량: " + seller.goods);
    }

}
