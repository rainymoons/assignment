package board;

import board.interfaces.BoardService;

public class BoardImpl implements BoardService {

    private static final int MAX_POSTS; // 최대 게시글 개수
    private static final String INVALID_TITLE_MESSAGE; // 제목 오류 알림
    private static final String INVALID_AUTHOR_MESSAGE; // 작성자 오류 알림
    private static final String MAX_POSTS_MESSAGE; // 게시글 제한 오류 알림
    private static final String DELETED_POST_MESSAGE; // 게시글 삭제시 조회 및 수정 불가 알림.
    private static final int MAX_COMMENTS;
    static {
        MAX_POSTS = 1000;
        MAX_COMMENTS = 10;
        INVALID_TITLE_MESSAGE = "게시글 제목을 입력하지 않았거나, 공백만 입력되었거나, 30자 이상 입력되었습니다. 다시 작성해주세요. \\n"
            + " (게시글 제목은 30자 이하의 문자로 입력해야 합니다. 공백만 입력하는 것은 허용되지 않습니다.) ";
        INVALID_AUTHOR_MESSAGE = "작성자 이름은 필수 입력 항목입니다. 다시 작성해주세요.";
        MAX_POSTS_MESSAGE = "더 이상 게시글을 작성할 수 없습니다.";
        DELETED_POST_MESSAGE = "삭제된 게시물은 조회 및 수정이 불가합니다.";
    }

    private Post[] posts;
    private int postCount;

    public BoardImpl() {
        posts = new Post[MAX_POSTS]; // 게시글을 저장할 수 있는 배열을 1000개로 생성
        postCount = 0; // 배열의 0번부터 게시글이 저장된다.
    }

    // 게시글 작성 - 유효성 검증을 통해 메서드 간소화
    @Override
    public void post(Post post) { // true값이 넘어올 경우 post하고 count++, 유효하지 않다면 return.
        if (!isValidPost(post)) { // isValidPost 메서드를 호출해서 post 객체의 유효성 검증이 실패하면(false가 넘어오면 조건식이 true가 되므로)
            return;               //  -> 조건을 통과하지 못한 것.
        }
        posts[postCount] = post; // postCount의 현재 값을 사용해서 posts 배열의 postCount인덱스에 post 객체를 할당
        postCount++; // post[i]가 0이라면 count를 ++해서 post[1]에 다음 게시글이 저장될 수 있도록 카운트 증가
    }

    // 유효성 검증 -> 메인 기능인 post 메서드의 검증 조건 5개 통과하는지 판단 -> 다 통과하면 true 반환
    private boolean isValidPost(Post post) {
        if (post.getPostTitle() == null || post.getPostTitle().trim().isEmpty() || post.getPostTitle().length() > MAX_POSTS) {
            System.out.println(INVALID_TITLE_MESSAGE);
            return false;
        }
        if (post.getPostAuthor() == null) {
            System.out.println(INVALID_AUTHOR_MESSAGE);
            return false;
        }
        if (postCount >= MAX_POSTS) {
            System.out.println(MAX_POSTS_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < postCount; i++) { // 배열의 0번째 게시글부터 끝 게시물까지 가면서
            if(!posts[i].isDelete()) { // 만약 i번 게시글이 삭제되었다면
                System.out.println(posts[i].getPostNum() + "번 게시글은 삭제된 게시글입니다."); // 삭제되었다고 알림.
            }
        }
    }

    @Override
    public void printByIndex(int postNum) { // 게시글 번호로 게시글 정보 출력
        if (posts[postNum].isDelete()) { // 해당 게시글이 삭제 되었다면 (isDelete 기본값은 false)
            System.out.println(DELETED_POST_MESSAGE);
            return;
        }
        posts[postNum].printIncreaseViews(); // 게시글 번호에 해당하는 게시물로 가서 조회수를 증가시킨다.
        System.out.println(posts[postNum]); // postNum번째 게시물 정보 출력
    }

    @Override
    public void edit(int postNum, Post post) { // 게시글 수정
        if (!posts[postNum].isDelete()) {
            System.out.println(DELETED_POST_MESSAGE);
            return;
        }
        posts[postNum].edit(post.getPostTitle(), post.getPostContent()); // 수정할것은 제목과 내용만. 작성자는 당연히 수정하면 안된다.
    }

    @Override
    public void delete(int postNum) { // 게시글 삭제
        posts[postNum].delete();
    }

    @Override
    public void printPostNum() { // 게시글 개수 출력
        System.out.println("모든 게시물의 개수는 : " + postCount);
    }

    @Override
    public void postComment(Post post, Comment comment) { // commentCount를 post에서 정의하여 파라미터를 Post에서 가져와야했다.
        if (post.getCommentCount() >= MAX_COMMENTS) {
            System.out.println("더 이상 댓글을 등록할 수 없습니다.");
            return;
        }
        posts[post.getPostNum()].postComment(comment);
    }
}