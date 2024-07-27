package assign719;

/**
 * --check--
 * doRent, rentComic / doReturn, returnComic 분리 // 입력받을 객체 고민
 * isRented() -> rent()
 */
public class ComicCafeMain {

    public static void main(String[] args) {
        //Comic comic1 = new Comic("슬램덩크 1화", 1500);
        Comic comic1 = new Comic("슬램덩크 1화");
        //Comic comic2 = new Comic("슬램덩크 2화", 1500);
        Comic comic2 = new Comic("슬램덩크 2화");

        ComicCafe comicCafe = new ComicCafe(comic1, comic2);
        comicCafe.listAllComics();
        comicCafe.rentComic("슬램덩크 1화");
        comicCafe.rentComic("슬램덩크 1화");
        comicCafe.returnComic("슬램덩크 2화");
        comicCafe.rentComic("슬램덩크 2화");
        comicCafe.listAllComics();
    }
}
