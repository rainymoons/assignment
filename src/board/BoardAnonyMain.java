package board;

import board.interfaces.BoardService;

public class BoardAnonyMain {

    public static void main(String[] args) {
        BoardService ktBoard = new BoardService() { // 익명 클래스를 이용하여 BoardService 인터페이스를 구현하고 구현체를 ktBoard 변수에 할당
                                                    // 인터페이스의 모든 메서드를 구현해야 한다.
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

            /**
             * 익명 클래스 정의와 동시에 인스턴스 생성 ======
             */
            private Post[] posts;
            private int postCount;
            // 초기화 블록
            {
                posts = new Post[MAX_POSTS];
                postCount = 0;
            }
//            public BoardImpl() { // 인터페이스에서 생성자를 가질 수 없다. -> 따라서 직접 초기화 한다.
//                posts = new Post[MAX_POSTS]; //
//                postCount = 0; //
//            }

            /**
             * 이곳부터 인터페이스의 모든 메서드를 구현한다.
             */
            @Override
            public void post(Post post) {
                if (!isValidPost(post)) {
                    return;
                }
                for (int i = 0; i < MAX_POSTS; i++) {
                    post.newPostNum(i);
                    if (posts[i] == null) {
                        posts[i] = post;
                        postCount++;
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
            public void delete(int postNum) { // 게시글 삭제
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
        };

        /*
        익명클래스가 BoardService 인터페이스를 구현하므로, BoardImpl 클래스의 인스턴스를 명시적으로 생성할 필요가 없다.
        익명 클래스 내부에서 모든 메서드를 구현하고 있기 떄문에, BoardImpl 클래스 인스턴스를 새로 만들지 않아도 인터페이스 기능을 사용할 수 있다.
         */
        //BoardImpl ktBoard = new BoardImpl(); //

        Post apost1 = new Post("a아아 게시판 테스트", "a박기문", "a2024-07-28, 20:45","a게시판 작성 테스트 하는 중");
        Post apost2 = new Post("a모아나", "a디즈니", "a2024-06-24, 13:44","a드웨인 존슨은 어디에나 있다.");
        Post apost3 = new Post("a데드풀과 울버린", "a마블", "a2024-07-22, 08:41","a울버린이 살아났네?");
        Post apost4 = new Post("a한국 최고의 공포영화는", "a이동진", "a2024-07-28, 14:21","a역시 기담입니다.");
        Post apost5 = new Post("a하울의", "a지브리", "a2024-07-21, 03:11","a움직이는 성");
        Post apost6 = new Post("a최고의 전쟁미드는", "aHBO", "a2024-07-29, 12:34","aHBO의 Band of Brothers");
        Post apost7 = new Post("a해리포터", "aWARNER BROS", "a2024-07-22, 11:26","a에서 가장 슬픈 OST는 Dumbledore's Farewell이야..");

        ktBoard.post(apost1);
        ktBoard.post(apost2);
        ktBoard.post(apost3);
        ktBoard.post(apost4);
        ktBoard.post(apost5);
        ktBoard.post(apost6);
        ktBoard.post(apost7);

        // 모든 게시글 출력
        ktBoard.printAll();

        // 게시글 번호로 게시글 정보 출력 count++
        ktBoard.printByIndex(5);

        // 게시글 수정
        ktBoard.edit(4,"지브리 애니메이션은", "아무래도 센과 치히로가");
        ktBoard.printByIndex(4);

        // 게시글 삭제
        ktBoard.delete(5);
        ktBoard.printByIndex(5);

        // 게시글의 개수 출력
        ktBoard.printPostNum();

        // 게시글에 댓글 작성
        ktBoard.postComment(4, "진짜 재밌나요?", "익명의 망곰이", "2024-06-24");
        ktBoard.postComment(4, "별론데요 ㅡㅡ", "화가난 망곰이", "2024-07-26");
        ktBoard.printByIndex(4);
    }
}
