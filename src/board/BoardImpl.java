package board;

import board.interfaces.BoardService;

public class BoardImpl implements BoardService {

    private static final int MAX_POSTS; // 최대 게시글 개수
    private static final String INVALID_TITLE_MESSAGE; // 제목 오류 알림q
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

    private Post[] posts; // 게시글을 담을 수 있는 배열 생성
    private int postCount; // 배열의 0번 부터 게시글이 저장된다.

    public BoardImpl() {
        posts = new Post[MAX_POSTS]; // 게시글을 저장할 수 있는 배열을 1000개로 생성
        postCount = 0; // 배열의 0번부터 게시글이 저장된다.
    }

    // 게시글 작성 - 유효성 검증을 통해 메서드 간소화
    @Override
    public void post(Post post) { // true값이 넘어올 경우 post하고 count++, 유효하지 않다면 return.
        if (!isValidPost(post)) { // isValidPost 메서드를 호출해서 post 객체의 유효성 검증이 실패하면(false가 넘어오면 조건식이 true가 되므로)
            return;               //  -> 조건을 통과하지 못한 것.
        } // 생성자를 호출해서 객체 생성.
        for (int i = 0; i < MAX_POSTS; i++) {
            if (posts[i] == null) { // 조건 검증 = 배열이 비어있어야 한다.
                post.newPostNum(i); // postNum 설정. 생성자 호출할때 postNum까지 호출하면 Main에서 데이터를 넣을떄 자꾸 배열의 번호까지 넣으라고 해서 밖으로 빼버렸다.
                posts[i] = post; // post의 참조값을 post배열의 i번째에 저장.
                postCount++; // 다음 반복시 배열의 다음번 자리(빈자리)에 저장될 수 있도록 설정하는 ++
                break;
            }
        }
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
            if(posts[i].isDelete()) { // 만약 i번 게시글이 삭제되었다면
                System.out.println(posts[i].getPostNum() + "번 게시글은 삭제된 게시글입니다. \n"); // 삭제되었다고 알림.
                continue; // 다음 순서로 넘어간다.
            }
            System.out.println(posts[i]);
        }
    }

    @Override
    public void printByIndex(int postNum) { //게시글 번호로 게시글 정보 출력
        if(isValidPostNum(postNum)) { // 검증하고 통과못하면 에러메세지 반환
            return;
        }
        if (isDeleted(postNum)) { // 해당 게시물이 삭제 되었다면 에러메세지 반환
            return;
        }
        posts[postNum].printIncreaseViews(); // 게시글 번호에 해당하는 게시물로 가서 조회수를 증가시킨다.
        System.out.println(posts[postNum]); // postNum에 해당하는 게시물 정보 출력
    }

    @Override
    public void edit(int postNum, String postTitle, String postContent) { // 게시글 수정
        if(isValidPostNum(postNum)) {
            return;
        }
        if (isDeleted(postNum)) {
            return;
        }
        posts[postNum].edit(postTitle, postContent); // 조건 검증이 끝나면 Post의 edit 메서드를 호출한다.
    }

    public boolean isDeleted(int postNum) {
        if (posts[postNum].isDelete()) { // 해당 게시물이 삭제 되었다면
            System.out.println(DELETED_POST_MESSAGE); // 삭제되었음을 알림
            return true; // 삭제되었으니 True
        }
        return false; // 게시글이 삭제되지 않았다. false
    }
    /*
    게시물 번호가 실제 배열의 크기와 0보다 큰지, 게시물 번호에 해당하는 인덱스에 게시물이 있는지 체크하는 로직
     */
    public boolean isValidPostNum(int postNum) {
        if(postNum > postCount || postNum < 0 || posts[postNum] == null) {
            System.out.println(postNum + "번 게시물은 존재하지 않습니다.");
            return true;
        }
        return false;
    }

    // 게시글 삭제
    @Override
    public void delete(int postNum) { // 게시글 삭제, 배열을 지워버리면 게시글에 해당하는 댓글이 보이지 않게 될 듯?
        if(isValidPostNum(postNum)) {
            return;
        }
        posts[postNum].delete();
    }

    @Override
    public void printPostNum() { // 게시글 개수 출력
        System.out.println("모든 게시물의 개수는 : " + postCount);
    }

    @Override
    public void postComment(int postNum, String commentContent, String commentAuthor, String commentCreatedAt) {
        if(isValidPostNum(postNum)) { // 검증
            return;
        }
        if (isDeleted(postNum)){ // 게시글 삭제 검증
            System.out.println(DELETED_POST_MESSAGE);
            return;
        }
        Post post = posts[postNum]; // posts배열에서 postNum 인덱스 안에 있는 Post 객체를 가져와서 post 변수에 저장.
        if (post.getCommentCount() >= MAX_COMMENTS) { // 댓글 수가 10개 이상이면
            System.out.println("더 이상 댓글을 등록할 수 없습니다."); // 출력
            return; // 아래 실행되지 않음.
        } // 새로운 comment 객체 생성. 현재 댓글 수에 + 1 해서 새 댓글 번호 설정. (앞의 ++) 밑에 내용을 comment 변수에 저장.
        Comment comment = new Comment(post.getCommentCount() + 1 , commentContent, commentAuthor, commentCreatedAt);
        post.postComment(comment); // postComment 메서드 호출해서 comment 를 게시글에 추가.
    }
}