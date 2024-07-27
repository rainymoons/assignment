package assign723;

public class Seller {
    // 상품 배열
    Product[] products;

    /**
     * Seller 객체를 생성할 때 Product 배열을 인자로 받아 this.products 필드에 할당.
     *   ( = seller 클래스가 Product 배열을 매개변수로 받는 생성자를 정의하는 것)
     *   ( = Seller 객체를 생성할 떄 Product 객체들의 배열을 전달 받아 초기화 할 수 있게 해주는 것)
     * -> Seller 클래스와 products 배열이 동일한 인스턴스를 참조하게 된다.
     * -> Seller 객체 내부에서 this.products를 통해서 상품 배열을 조작할 수 있게 됨.
     * -> 배열 내부의 데이터가 변경되면 변경한 사항이 Seller 객체와 배열을 참조하는 다른 모든 객체에 반영된다.
     */
    public Seller(Product[] products) {
        this.products = products;
    }

    public void sell(String productName, int orderQuantity) {
        // for문으로 배열 순회
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equals(productName)) { // 주문한 상품이 보유 상품 목록에 있고
                if(orderQuantity <= products[i].getStock()) { // 주문량이 보유량보다 적거나 같으면
                    products[i].decreaseStock(orderQuantity); // 보유량에서 주문량을 차감한다.
                    System.out.println("주문한 상품 " + productName + "을 " + orderQuantity
                        + "개 만큼 판매했습니다. " + productName +"의 남은 재고는 " + products[i].getStock() +"개 입니다.");
                }
                // 그렇지 않으면 오류 메세지 출력 후 return
                System.out.println("(Warning!) " + productName + "의 재고가 부족합니다. 현재 재고는 "
                    + products[i].getStock() +"개 입니다.");
                return;
            }
        }
        System.out.println("주문하신 " + productName + " 는 없는 제품입니다."); // 주문한 상품이 보유 상품 목록에 없는 경우 오류 메세지 출력
    }
}

/*
 sell(String productName, int orderQuantity)가 public void decreaseStock(int quantity)로 매핑 될 수 있는 이유는
같은 데이터 타입이기 떄문이다. Int . 근데 이것 보다는 인자의 순서와 메서드 정의의 파라미터 순서가 일치하기 때문이다.
 */