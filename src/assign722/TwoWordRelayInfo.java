package assign722;

public class TwoWordRelayInfo {
    public final int WORD_LENGTH = 2;

    /**
     * 현재 제시 단어
     */
    private String firstWord;

    /**
     * 다음 단어
     */
    private String nextWord;

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

    /**
     * 사용된 단어 목록 (문자열로 관리)
     */
    private String usedWords;

    public TwoWordRelayInfo(String firstWord) {
        this.firstWord = firstWord;
        this.lastLetter = this.firstWord.substring(this.firstWord.length() - 1);
        this.usedWords = " " + firstWord + " "; // 단어 구분을 위해 공백 추가
    }

    public void inputNextWord(String nextWord) {
        this.nextWord = nextWord.trim();
        this.nextWordLength = this.nextWord.length();
    }

    public boolean isEnoughLength() {
        return this.nextWordLength >= this.WORD_LENGTH;
    }

    public boolean isEndLetter() {
        return this.nextWord.startsWith(this.lastLetter);
    }

    public void addCount() {
        this.gameCount++;
        this.usedWords += this.nextWord + " "; // 사용된 단어 추가
    }

    public void changeCurrentWord() {
        this.firstWord = this.nextWord;
        this.lastLetter = this.firstWord.substring(this.firstWord.length() - 1);
    }

    public boolean isWordUsed(String word) {
        return this.usedWords.contains(" " + word + " ");
    }

    public void gameOver() {
        System.out.println("게임이 종료되었습니다.");
        System.out.println("이어나간 끝말잇기 횟수는 " + this.gameCount + "번 입니다.");
    }
}
