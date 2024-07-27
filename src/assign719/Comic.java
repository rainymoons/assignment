package assign719;

/**
 * 속성 : 만화책 이름, 대여 상태, 대여료
 * 기능 : 만화책 대여, 반납 기능
 */
public class Comic {
    /**
     *만화책 제목
     */
    private String title;
    /**
     * 대여 상태
     */
    private boolean isRented = false;
    /**
     * 대여료
     */
    private static final int RENTAL_FEE = 1500;
    //private int rentalFee;

    public Comic(String title) { //int rentalFee 제거
        this.title = title;
        this.isRented = false;
        //this.rentalFee = rentalFee; 클래스 상수로 변경. 생성자 오버로딩.
    }

    public String getTitle() {
        return title;
    }
    // rent와 return에 필요한 boolean값 반환
    public boolean isRented() {
        return isRented;
    }

    // 대여 - 대여중이면 true, 아니면 false
    public void rent() {
        if (!isRented) { // isRented가 false이면 대여 가능. true이면 대여 중인 것
            isRented = true; // isRentedrk false이므로 대여 하고 true(대여중)으로 바꿈
        } else {
            System.out.println(title + "는 대여중입니다.");
        }
    }
    // 빈닙
    public void returnComic() {
        if(!isRented) { // isRented가 true이면 대여중이므로 반납하고
            isRented = false; // 상태를 false(반납)로 바꿈
        } else {
            System.out.println(title + "는 대여중이 아닙니다.");
        }
    }

    public int getRentalFee() {
        //return rentalFee;
        return RENTAL_FEE;
    }
}
