package board;

public class Post {

    /**
     * 게시글 제목의 최대 길이
     */
    private static final int MAX_POST_TITLE_LENGTH;
    static{
        MAX_POST_TITLE_LENGTH = 30;
    }
    /**
     * 게시물 번호
     */
    private int postNum;
    /**
     * 게시글 제목
     */
    private String postTitle;
    /**
     * 게시글 작성자
     */
    private String postAuthor;
    /**
     * 게시물 생성일
     */
    private String postCreatedAt;
    /**
     * 게시글 조회수
     */
    private int postViews;
    /**
     * 게시글 내용
     */
    private String postContent;

    /**
     * Post 클래스가 Comment 객체 배열을 포함하므로 `has-a` 관계가 된다.
     * Post 클래스 안에서 Comment 객체 배열인 Comment comments[]를 정의하기 때문에 Post에서 댓글 관리가 가능해진다.
     */
    private Comment[] comments;
    /**
     * 게시글의 댓글의 수
     */
    private int commentCount;
    private boolean isDelete;
    /**
     * 게시물의 모든 정보를 저장
     */
    private String postDetails;

    public Post(String postTitle, String postAuthor, String postCreatedAt, String postContent) {
        this.postTitle = postTitle;
        this.postAuthor = postAuthor;
        this.postCreatedAt = postCreatedAt;
        this.postViews = 0;
        this.postContent = postContent;
        this.comments = new Comment[10];
        this.commentCount = 0;
        this.isDelete = false;
        this.postDetails = "";
    }

    public void newPostNum(int postNum) {
        this.postNum = postNum;
    }

    // 게시글 수정 - 게시글 수정은 게시글 작성과 마찬가지로 검증조건을 모두 통과해야 한다.
    public void edit(String postTitle, String postContent) {
        if (postTitle != null && !postTitle.trim().isEmpty() && postTitle.length() <= MAX_POST_TITLE_LENGTH
            && postAuthor != null) { // 위 조건을 모두 만족하면
            this.postTitle = postTitle;
        }
        this.postContent = postContent;
    }

    public void postComment(Comment comment) {
        comments[commentCount] = comment;
        commentCount++;
    }

    @Override // 왜 오버라이딩 하는지에 대한 설명은 comment에 있다.
    public String toString() { // posts 배열에 있는 Post 객체를 문자열로 표현하는 메서드.
        StringBuilder postDetails = new StringBuilder(); // 문자 가져다 붙이기 = StringBuilder. 가변 문자열 버퍼를 이용해 합친다. append를 이용해서.
        postDetails.append("게시물 번호: ").append(postNum)
            .append("\n게시글 제목: ").append(postTitle).append(" | 댓글 수: ").append(commentCount)
            .append("\n게시글 작성자: ").append(postAuthor)
            .append("\n게시물 작성일: ").append(postCreatedAt)
            .append("\n게시물 조회수: ").append(postViews)
            .append("\n게시물 내용: ").append(postContent)
            .append("\n\n댓글 목록\n");
        for (int i = 0; i < commentCount; i++) { // 댓글 내용을 가져온다.
            postDetails.append(comments[i]).append("\n"); // 댓글의 수(commentCount)만큼 돌면서 댓글 내용을 문자열 버퍼에 저장.
        } // 게시글의 모든 정보를 저장하면
        this.postDetails = postDetails.toString();// 가변 문자열 버퍼에 저장된 모든 내용을 하나의 문자열로 만들어서 저장한다.
        return this.postDetails;
    }
    /* toString 메서드는 하나의 변수에 StringBuilder를 통해 만든 문자열을 저장하는게 아니다.
    가변 문자열 버퍼를 이용해 문자열을 더한 후 출력하고 없어진다.
    따라서 main메서드에서 출력하고 싶으면 Post 클래스의 멤버변수를 만들고 거기에 합산이 완료된 문자열 버퍼를 저장해두면 된다.
     */

    public int getPostNum() {
        return postNum;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void printIncreaseViews() { // printByIndex -> 정보 출력시 조회수 1 증가를 위해 생성
        postViews++;
    }

    public void delete() { // 게시글 삭제시 삭제 여부를 true로 변경하기 위해 생성
        isDelete = true;
    }
}
