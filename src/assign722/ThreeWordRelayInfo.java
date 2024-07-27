package assign722;

public class ThreeWordRelayInfo {
    // 무작정 초기화 하는 것이 아니라 차근차근 만들어 나가는 것.
    // 일단 처음 필요한게 firstWord임.
    // 길이 = 관리는 하지만 굳이 가져올 필요는 없다.

    public final int WORD_LENGTH = 3;

    /**
     * 현재 제시 단어
     */
    private String firstWord; // 1. 첫번째 단어의 마지막 글자를 구한다.

    /**
     * 다음 단어
     */
    private String nextWord; // 2. 첫번째 단어 마지막을 자르면 다음 단어를 파라미터에 입력하고, 그 단어의 길이를 구한다.
    // 3. 2가 끝나면 길이가 3이상인지 체크. 3은 상수. 선언.
    /**
     * 마지막 글자
     */
    private String lastLetter;

    /**
     * 게임이 이어나간 횟수
     */
    private int gameCount;

    /**
     * 다음 단어의 길이
     */
    private int nextWordLength;


    public ThreeWordRelayInfo(String firstWord) {
        this.firstWord = firstWord;
        this.lastLetter = this.firstWord.substring(this.firstWord.length() -1); // 마지막 글자가 무엇인지 알 수 있다.
    }

    public void inputNextWord(String nextWord) {
        this.nextWord = nextWord;					  // 단어를 줄테니
        this.nextWordLength = this.nextWord.length(); // 길이까지 구해서 넣어라.
    }

    public boolean isEnoughLength() { // 4. 길이가 충분한지 체크. 여기까지 했으면 nextWord가 LastLetter로 시작하는지 체크
        return this.nextWordLength >= this.WORD_LENGTH;
    }

    public boolean isStartLetter() {
        return this.nextWord.startsWith(this.lastLetter); // 5. 현재 단어가 전 단어의 끝단어로 시작하는가. -> 6. 카운트 증가.
    }

    public void addCount() { //6. 카운트 증가.
        this.gameCount++;
    }

    public void changeCurrentWord() {
        this.firstWord = this.nextWord; // 7. 마지막 단어를 첫 단어로 바꿈. 1바퀴 돈 것.
        this.lastLetter = this.firstWord.substring(this.firstWord.length() -1); // 8. 새로 들어온 마지막 단어 체크
    }

    public void gameOver() { // 10. 종료 & 횟수 반환
        System.out.println("게임이 종료되었습니다.");
        System.out.println("이어나간 끝말잇기 횟수는 " + this.gameCount + "번 입니다.");
    }
}
