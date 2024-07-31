package assign730;

import java.util.Map;
import java.util.Scanner;

public class DicUtils {
    public static void inputWord(Map<String, String> dictionary, Scanner console) {

        System.out.println("사전에 등록하고 싶은 영어 단어를 입력하세요!");
        String english = console.nextLine().trim(); // 스페이스바를 입력할 수 있으니 그것을 제거
        if (!isValidEnglish(english)) { // 영어가 아니면?
            System.out.println("(Warning!!) '영어'로 된 단어를 입력하세요! (a~zA~Z)"); // 영어를 입력해주세요
            return; // 처음으로
        }

        System.out.println("등록한 영어의 뜻을 '한국어'로 입력하세요!");
        String korean = console.nextLine().trim(); // 단어의 공백 제거
        if(!isValidKorean(korean)) { // 한국어가 아니면?
            System.out.println("(Warning!!) '한국어'로 된 단어를 입력하세요~!"); // 한국어로 입력해주세요.
            return;
        }

        dictionary.put(english, korean); // 모든 문제해결의 시작 -> englsih : key, korean : value.
        System.out.println("단어를 등록하는데 성공했습니다!");
    }
    // 영어로만 이루어져 있는지 검증
    public static boolean isValidEnglish(String english) {
        return english.matches("[a-zA-Z]+");
    }
    // 한국어로만 이루어져있는지 검증
    public static boolean isValidKorean(String korean) {
        return korean.matches("[가-힣]+");
    }

    // 단어 찾을때 검증하는 메서드.
    public static void findWord(Map<String, String> dictionary, Scanner console) {
        System.out.println("찾고 싶은 영어 단어를 입력하세요!");
        String english = console.nextLine().trim();

        if (!isValidEnglish(english)) {
            System.out.println("(Warning!!) '영어'로 된 단어를 입력하세요! (a~zA~Z)");
            return;
        }
        // 여기까지 inputWord 메서드 복사. 왜? 반복되니까. -> 이것도 따로 빼서 유효성 검증 메서드 만들어야 될듯.

        /*
         * if (사전에 저장된 영단어와 입력한 영단어를 대소문자 구분하지 말고 비교해서 만약 그 값이 같다면 (true)) {
         *     출력하고 싶다.
         *  -> 이걸 하려면? 지금까지는 Hash와 관련된건 put 하나만 썼는데 찾아보니 이거 key keySet에 대해 알아야 한다.
         *  (정리) https://www.notion.so/HashMap-8184630adde44cb1a22af4468c203a25?pvs=4
         */

        // 사용자가 검색하기 위해 입력한 영어단어 vs 이 단어를 대소문자를 무시하고 동일한 키가 dictionary에 있는지 검증
        // dictionary라는 해시맵에서 english에 키에 해당하는 값을 찾는다. 찾으면 korean에 저장된다. (나중에 키값으로 영어단어를 찾아오기 위한 것)
        String korean = dictionary.get(english);
        boolean found = false; // 이걸 안해주면 반복문 내에서 계속 찾는 단어는 존재하지 않는다고 뜬다.
        // 입력된 english변수에 저장된 단어와 대소문자를 무시하고 동일한 키가 dictionary에 있는지 확인한다. 같다면 0을 반환한다.
        for (String key : dictionary.keySet()) {
            if (key.compareToIgnoreCase(english) == 0) { //
                // 동일한 키가 존재한다면 korean 변수에 해당 키의 값을 할당한다.
                korean = dictionary.get(key);
                found = true; // 동일한 키를 찾았으면 true값으로 변경
                break; // 동일한 키를 찾았으므로 반복을 종료
//            } else {
//                System.out.println("찾으시는 단어는 사전에 존재하지 않습니다.");
//            }
            }
        }
        if (!found) {
            System.out.println("찾으시는 단어는 사전에 존재하지 않습니다.");
        }

        if (korean == null || korean.isEmpty()) { // english에 대응하는 키가 존재하지 않으면 null -> 예외처리
            System.out.println("해당 단어는 존재하지 않습니다.");
        } else {
            System.out.println(english + "의 뜻은 " + korean + "입니다.");
        }
    }

    // 얘도 위에꺼 반대로 하면 개선 가능
    public static void deleteWord(Map<String, String> dictionary, Scanner console) {
        System.out.println("삭제하고 싶은 영어 단어를 입력하세요");
        String english = console.nextLine().trim();
        String korean = dictionary.get(english);

        if( korean == null) {
            System.out.println("해당 단어는 존재하지 않습니다.");
        } else {
            dictionary.remove(english);
            System.out.println(english + "을(를) 삭제했습니다.");
        }
    }
}