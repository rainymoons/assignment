package board;

public class BoardMain {

    public static void main(String[] args) {
        BoardImpl ktBoard = new BoardImpl();

        // 게시글 작성
        Post post1 = new Post("아아 게시판 테스트", "박기문", "2024-07-28, 20:45","게시판 작성 테스트 하는 중");
        Post post2 = new Post("모아나", "디즈니", "2024-06-24, 13:44","드웨인 존슨은 어디에나 있다.");
        Post post3 = new Post("데드풀과 울버린", "마블", "2024-07-22, 08:41","울버린이 살아났네?");
        Post post4 = new Post("한국 최고의 공포영화는", "이동진", "2024-07-28, 14:21","역시 기담입니다.");
        Post post5 = new Post("하울의", "지브리", "2024-07-21, 03:11","움직이는 성");
        Post post6 = new Post("최고의 전쟁미드는", "HBO", "2024-07-29, 12:34","HBO의 Band of Brothers");
        Post post7 = new Post("해리포터", "WARNER BROS", "2024-07-22, 11:26","에서 가장 슬픈 OST는 Dumbledore's Farewell이야..");

        ktBoard.post(post1);
        ktBoard.post(post2);
        ktBoard.post(post3);
        ktBoard.post(post4);
        ktBoard.post(post5);
        ktBoard.post(post6);
        ktBoard.post(post7);

        // 모든 게시글 출력
        ktBoard.printAll();

        // 게시글 번호로 게시글 정보 출력 count++
        ktBoard.printByIndex(5);

        // 게시글 수정
        ktBoard.edit(5,"지브리 애니메이션은", "아무래도 센과 치히로가");
        ktBoard.printByIndex(5);

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
