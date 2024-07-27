package board;

public class Comment {

    /**
     * 댓글 번호
     */
    private int commentNum;
    /**
     * 댓글 내용
     */
    private String commentContent;
    /**
     * 댓글 작성자
     */
    private String commentAuthor;
    /**
     * 댓글 작성 일자
     */
    private String commentCreatedAt;

    public Comment(int commetNum, String commentContent, String commentAuthor, String commentCreatedAt) {
        this.commentNum = commetNum;
        this.commentContent = commentContent;
        this.commentAuthor = commentAuthor;
        this.commentCreatedAt = commentCreatedAt;
    }

    // 댓글 작성자의 정보를 보기 좋게 출력하고 싶다.
    @Override // 뭘 오버라이딩 하냐? -> Java.lang.Object 클래스. 어떻게? 모든 자바 클래스들은 암묵적으로 Object 클래스를 상속받으므로.
    public String toString() { // Object Class에서 정의된 toString 메서드를 오버라이딩 하는 것.
        return "댓글 번호: " + commentNum +
            "\n댓글 내용: " + commentContent +
            "\n댓글 작성자: " + commentAuthor +
            "\n댓글 작성일자: " + commentCreatedAt;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public String getCommentCreatedAt() {
        return commentCreatedAt;
    }
}
