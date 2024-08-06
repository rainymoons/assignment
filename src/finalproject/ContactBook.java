package finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    private List<PersonInfo> contacts;

    // contacts 객체 생성
    public ContactBook() {
        this.contacts = new ArrayList<PersonInfo>();
    }

    // 주소록에 PersonInfo 추가
    public void addPersonInfo(PersonInfo personInfo) {
        contacts.add(personInfo);
    }

    // 모든 PersonInfo를 출력
    public void printAllPersonInfo() {
        for (PersonInfo personInfo : contacts) {
            System.out.println(personInfo);
        }
    }
    // 1. 리스트를 돌아서 검색 결과를 저장한다. -> 저장할 객체 필요.
    // 2. null 체크, empty체크 한다. + equal일 경우
    // 3. 아니면 담는다. equal일 경우
    // 4. 담은 결과 반환한다. -> 어디로
    // 5. 리스트 하나 새로 만들어야된다. 돌면서 담을거.
    // 6. 검색해서 나온거 문자열 객체에 저장해서 넘겨야된다.
    public List<PersonInfo> searchByNameAndNickName(String inputWord) {
        List<PersonInfo> result = new ArrayList<>(); // 검색 결과를 저장할 List 생성

        for (PersonInfo personInfo : contacts) { // contacts 리스트의 PersonInfo 객체를 전부 돌면서 name과 nickName이 InputWord와 일치하는지 체크
            String name = personInfo.getName(); // contacts 리스트 돌면서 나온 postInfo 객체의 이름을 저장
            String nickName = personInfo.getNickName();
            // name이 null이 아니고, name이 비어있지 않은 상태에서 -> name이 inputWord와 같으면
            if (name != null && !name.isEmpty() && name.equals(inputWord)) {
                result.add(personInfo); // result 리스트 만들어둔것에 저장.
            } else if (nickName != null && !nickName.isEmpty() && nickName.equals(inputWord)){
                result.add(personInfo); // 동일
            }
        }
        if(result.isEmpty()) { // 다 돌았는데 리스트에 아무것도 없으면
            System.out.println("검색 조건에 부합하는 결과가 없습니다."); // 이거 else로 넣으면 순회할때마다 출력됨. 어차피 resuLt는 외부에 있음.
        }
        return result;
    }

    // 연락처로 검색하는 메서드
    public List<PersonInfo> searchByContactNum(String inputWord) {
        List<PersonInfo> result = new ArrayList<>();

        for (PersonInfo personInfo : contacts) {
            String contactNum = personInfo.getContactNum();
            if (contactNum != null && !contactNum.isEmpty() && contactNum.equals(inputWord)) {
                result.add(personInfo);
            }
        }
        if (result.isEmpty()) {
            System.out.println("검색 조건에 부합하는 결과가 없습니다.");
        }
        return result;
    }

    /*
    personInfo.getAddress().getTotalAddress(); 하는 이유
     - PersonInfo는 사람의 정보. Address는 주소 정보. 그런데 PersonInfo가 Address 객체를 필드에 가지고 있음.
     - 이게 바로 Has a 관계.
     - 따라서 PersonInfo 객체는 Address 객체를 포함하고 있으므로, getAddress() 메서드를 통해 Address 객체를 가져와야함.

     - contacts 리스트의 각 PersonInfo 객체를 순회하면서 getAddress() 메서드를 호출하여 Address 객체를 가져온다.
     - Address 객체의 getTotalAddress() 메서드를 호출하여 전체 주소 문자열을 가져온다.
     - 전체 주소 문자열이 inputWord를 포함하는지 확인하고, 만약 있으면 결과에 추가한다.
     */
    // 주소 정보(입력한 값)로 주소 전체 정보 검색
    public List<PersonInfo> searchAddress(String inputWord) {
        List<PersonInfo> result = new ArrayList<>();// 결과담을 객체 생성
        for (PersonInfo personInfo : contacts) { // 돈다.
            String totalAddress = personInfo.getAddress().getTotalAddress(); // 전체 주소 가져와서 담는다.
            if (totalAddress != null && !totalAddress.isEmpty() && totalAddress.equals(inputWord)) {
                result.add(personInfo); // 검증통과하면 result에 담는다.
            }
        }
        if (result.isEmpty()) { // 만약 결과가 아무것도 안나오면 = 없으면
            System.out.println("검색 조건에 부합하는 결과가 없습니다."); // 없다고 출력
        }
        return result;
    }
    // 인덱스로 한명의 전체 정보 출력
    public List<PersonInfo> getPersonByIndex(int index) {
        List<PersonInfo> result = new ArrayList<>();

        if (index < 0 || index >= contacts.size()) { // 인덱스가 0보다 작고 리스트의 사이즈보다 크면
            System.out.println("해당하는 번호는 빈 주소록입니다."); // 출력
            return  result;
        }

        PersonInfo person = contacts.get(index);
        result.add(person); //
        System.out.println(person);
        System.out.println("주소록에 현재 총 " + contacts.size() + "명이 있습니다.");
        return result;
    }
    /*
    1. 오늘 날짜 생성
    2. 15일 후 날짜 생성
    3. 리스트에 담을려면 새 리스트 생성
    4. 생일 리스트 가져와서 담음 - i값 필요함 포이치 못쓸듯
    5. 비교
     - 대소비교는 안됌
     - 검색
     - isBefore, isAfter -> boolean 타입이네 -> if에서 비교 가능
     - 생일도 올해날짜로 바꿔야된단다 비교할라면 wtihYear 2024 하드코딩. 오늘날짜에서 올해년도 가져옴
     - 오늘 8월 1일 -> 15일 까지면
     - 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 15개. 그럼 8월 15일 근데 plusday15하면 16나옴. -1
     -
     */
    // 15일 후 까지의 생일자 찾기
    public List<PersonInfo> searchAfterBday() {
        LocalDate nowDay = LocalDate.now(); // 오늘 날짜
        LocalDate targetDay = nowDay.plusDays(15); // 15일 후 날짜
        List<PersonInfo> result = new ArrayList<>(); // 결과 담을 객체 생성

        for (int i = 0; i < contacts.size(); i++) {
            PersonInfo personInfo = contacts.get(i); // 리스트에서 i 번째 postInfo 정봅를 가져옴.
            LocalDate birthDay = personInfo.getBirthDate(); // 생일 가져와서 birthDay에 저장. 비겨해야지
            // 생일자 체크
            if (birthDay != null) {
                LocalDate bDay = birthDay.withYear(nowDay.getYear()); // ㅅ생일을 올해년도로 변경

                if (bDay.isAfter(nowDay.minusDays(1)) && bDay.isBefore(targetDay)) {
                    result.add(personInfo);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("보름 내에 생일인 사람을 찾을 수 없습니다.");
        }
        return result;
    }

    public List<PersonInfo> searchBeforeBday() {
        LocalDate nowDay = LocalDate.now(); // 오늘 날짜
        LocalDate targetDay = nowDay.minusDays(15); // 15일 전 날짜
        List<PersonInfo> result = new ArrayList<>(); // 결과 담을 객체 생성
        // 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        for (int i = 0; i < contacts.size(); i++) {
            PersonInfo personInfo = contacts.get(i); // 리스트에서 i 번째 postInfo 정봅를 가져옴.
            LocalDate birthDay = personInfo.getBirthDate(); // 생일 가져와서 birthDay에 저장. 비겨해야지
            // 생일자 체크
            if (birthDay != null) {
                LocalDate bDay = birthDay.withYear(nowDay.getYear()); // ㅅ생일을 올해년도로 변경

                if (bDay.isAfter(nowDay.plusDays(1)) && bDay.isBefore(targetDay)) {
                    result.add(personInfo);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("보름 전에 생일인 사람을 찾을 수 없습니다.");
        }
        return result;
    }

    // 주소록에 등록
    public List<PersonInfo> registerPersonInfo(PersonInfo personInfo) {
        List<PersonInfo> result = new ArrayList<>();
        // postInfo 객체가 있기는 한지 || 객체는 있는디 이름은 초기화는 되었는 지 || 다 있는데 이름은 입력을 했는지
        if (personInfo == null || personInfo.getName() == null || personInfo.getName().isEmpty()) {
            System.out.println("등록이 불가능합니다.");
            return result; // 메서드 종료
        }

        personInfo.setModificationDate(LocalDate.now()); // 오늘 날짜로 등록날짜 변경(변수 영어 잘못씀) register로 해야되는데
        contacts.add(personInfo); // 리스트에 추가
        result.add(personInfo); // 결과 담음
        System.out.println("주소록에 총 " + contacts.size() + "명의 사람이 있습니다.");
        return result;
    }

    public List<PersonInfo> deletePersonInfo(int index, String inputWord) {
        List<PersonInfo> result = new ArrayList<>();
        if (index < 0 || index >= contacts.size()) { // 인덱스가 유효한지 확인하고
            System.out.println("존재하지 않는 사람입니다.");
            return result;
        }

        PersonInfo personInfo = contacts.get(index); // 인덱스의 사람 정보를 가져오고
        System.out.println(personInfo.getName() +"("+personInfo.getAge()+")"+ "을(를) 정말로 삭제하시겠습니까? (삭제: 1, 취소: 2 입력)" );

        if (inputWord.equals("1")) { // 1이면 삭제 2이면 취소
            contacts.remove(index);
            result.add(personInfo);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제가 취소되었습니다.");
        }
        return result;
    }
/*
사람정보들에서 인덱스 범위에서 벗어난 인덱스라면 존재하지 않는 사람입니다. 를 출력

새로운 사람정보가 null이거나 이름이 비어있다면 "등록할 수 없습니다."라고 예외 출력

사람정보들에서 인덱스로 해당 사람을 찾아

새로운_사람정보에 기존의 추가날짜를 할당하고 수정날짜를 오늘로 할당한다.

수정하기전 이름(나이)를 정말로 수정하겠습니까? 라고 물어보고 수정한다고 할 때만 수정해야 하며 수정이 오나료되었습니다. 를 출력한다.
새로운_사람정보로 변경한다.
수정하지 않는다고 할때는 수정이 취소되었습니다. 를 출력한다.

 */
    // 사람 정보 수정
    public List<PersonInfo> updatePersonInfo(int index, PersonInfo personInfo, String inputWord) {
        List<PersonInfo> result = new ArrayList<>();
        // 인덱스 검증
        if (index < 0 || index >= contacts.size()) {
            System.out.println("존재하지 않는 사람입니다.");
            return result;
        }
        // 객체, 이름, 빈공간 검증
        if (personInfo == null || personInfo.getName() == null || personInfo.getName().isEmpty()) {
            System.out.println("등록이 불가능합니다.");
            return result;
        }
        // 사람 정보 가져오기
        PersonInfo getPersonInfo = contacts.get(index);
        // 물어보기
        System.out.println(getPersonInfo.getName() + " ( " + getPersonInfo.getAge() + " ) "
            + "을(를) 정말로 수정하시겠습니까? (수정: 1, 취소: 2 입력)");

        if (inputWord.equals("1")) {
            // 새로운_사람정보에 기존의 추가날짜를 할당하고 수정날짜를 오늘로 할당
            personInfo.setModificationDate(getPersonInfo.getModificationDate()); // 기존날짜
            personInfo.setLastModificationDate(LocalDate.now()); // 오늘 날짜
            contacts.set(index, personInfo); // 교체 = set 인덱스 찾아서 personInfo 변한걸로 바꿔라
            result.add(personInfo);
            System.out.println("수정이 완료되었습니다.");
        } else {
            System.out.println("수정이 취소되었습니다.");
        }
        return result;
    }
}
