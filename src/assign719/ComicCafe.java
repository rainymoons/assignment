package assign719;

public class ComicCafe {
    private Comic comic1;
    private Comic comic2;

    private int balance;

    public ComicCafe(Comic comic1, Comic comic2) {
        this.comic1 = comic1;
        this.comic2 = comic2;
        this.balance = 0;
    }

    private void printComicsStatus(Comic comic) {
        System.out.println("만화책 이름 : " + comic.getTitle() + ", 대여 상태 구분 : "
            + (comic.isRented() ? "대여중" : "대여안함") + ", 대여료 : " + comic.getRentalFee());
    }
    // 많은 만화책을 관리하려면 배열이나 List 필요. 수동으로 추가해줘도 됨. comic1, 2, 3, 4, ...
    public void listAllComics() {
        printComicsStatus(comic1);
        printComicsStatus(comic2);
    }
    // 대여 상태 확인과 대여 행위 분리
    // 입력된 제목 확인하고 제목이 맞을 경우 doRent 호출
    public void rentComic(String title) {
        if(comic1.getTitle().equals(title)) {
            doRent(comic1);
        } else if(comic2.getTitle().equals(title)) {
            doRent(comic2);
        } else {
            System.out.println(title + "는 없는 만화책입니다.");
        }
    }
    // rentComic에서 넘어온 만화책에 대해 대여 진행
    // 대여 상태 확인 - 대여중이아니면 대여, 대여중이면 메세지, 잔고 계신
    private void doRent(Comic comic) {
        if(!comic.isRented()) {
            comic.rent();
            balance += comic.getRentalFee();
            System.out.println(comic.getTitle() + "를 대여했습니다. 현재 잔고는 " + balance + "입니다.");
        } else {
            System.out.println(comic.getTitle() + "은 이미 대여중입니다.");
        }
    }

    private void doReturn(Comic comic) {
        if (comic.isRented()) {
            comic.returnComic();
            System.out.println(comic.getTitle() + "를 반납했습니다.");
        } else {
            System.out.println(comic.getTitle() + "는 대여중이 아닙니다.");
        }
    }

    public void returnComic(String title) {
        if(comic1.getTitle().equals(title)) {
            doReturn(comic1);
        } else if(comic2.getTitle().equals(title)) {
            doReturn(comic2);
        } else {
            System.out.println(title + "는 없는 만화책입니다.");
        }
    }

    public int getBalance() {
        return balance;
    }

}

