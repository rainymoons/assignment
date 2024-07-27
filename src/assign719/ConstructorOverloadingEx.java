package assign719;

public class ConstructorOverloadingEx {
    //Book
    String title;
    String author;
    int page;

    ConstructorOverloadingEx() {
        this("", "", 0);
    }

    ConstructorOverloadingEx(String title, String author) {
        this(title, author, 0);
    }

    ConstructorOverloadingEx(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    void show() {
        System.out.println("제목:" + title + " 저자:" + author + " 페이지수: " + page);
    }
}
