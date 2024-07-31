package assign730;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 추가한 기능
 *  -
 */
public class Dictionary {

    public static void main(String[] args) {

        Map<String, String> dictionary = new HashMap<String, String>();

        System.out.println("======================================");
        System.out.println("               간편 단어장               ");
        System.out.println("======================================");

        Scanner console = new Scanner(System.in);
        int flag = 0;

        String english = "";
        String korean = "";

        while (true) {
            System.out.println("======== 메뉴를 선택하세요 =========");
            System.out.println("1. 단어 등록");
            System.out.println("2. 단어 조회");
            System.out.println("3. 단어 삭제");
            System.out.println("9. 종료");

            flag = console.nextInt();
            console.nextLine();

            if (flag == 1) {
                DicUtils.inputWord(dictionary, console);
            }
            else if (flag == 2) {
                DicUtils.findWord(dictionary, console);
            }
            else if (flag == 3) {
                DicUtils.deleteWord(dictionary, console);
            }
            else if (flag == 9) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            else {
                System.out.println("숫자 1, 2, 3, 9 중 하나를 입력하세요.");
            }
        }
    }
}
/*
    public static void inputWord(Map<String, String> dictionary, Scanner console) {
        System.out.println("사전에 등록하고 싶은 영어 단어를 입력하세요!");
        String english = console.nextLine().trim();
        if (!isValidEnglish(english)) {
            System.out.println("(Warning!!) '영어'로 된 단어를 입력하세요! (a~zA~Z)");
            return;
        }

        System.out.println("등록한 영어의 뜻을 '한국어'로 입력하세요!");
        String korean = console.nextLine().trim();
        if(!isValidKorean(korean)) {
            System.out.println("(Warning!!) '한국어'로 된 단어를 입력하세요~!");
            return;
        }

        dictionary.put(english, korean);
        System.out.println("단어를 등록하는데 성공했습니다!");
    }

    public static boolean isValidEnglish(String english) {
        return english.matches("[a-zA-Z]+");
    }

    public static boolean isValidKorean(String korean) {
        return korean.matches("[a-zA-Z]+");
    }
*/
