package board.interfaces;

import board.Post;

public interface BoardService {
    // 게시글 작성
    void post(Post post);
    // 수정
    void edit(int postNum, String postTitle, String postContent);
    // 게시글 삭제
    void delete(int postNum);
    // 모든 게시글 제목 출력
    void printAll();
    // 게시글 번호로 게시글 정보 출력
    void printByIndex(int postNum);
    // 게시글의 총 개수 출력
    void printPostNum();
    // 게시글에 댓글 작성하기
    void postComment(int postNum, String commentContent, String commentAuthor, String commentCreatedAt);
}
