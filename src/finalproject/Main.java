package finalproject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        String inputWord;

        while(true) {
            System.out.println("1. 주소록에 등록하기");
            System.out.println("2. 모든 주소록 항목 보기");
            System.out.println("3. 이름 또는 별명으로 사람 찾기");
            System.out.println("4. 연락처로 검색하기");
            System.out.println("5. 주소로 검색하기");
            System.out.println("6. index로 사람 전체 정보 출력");
            System.out.println("7. 15일 후 생일자 찾기");
            System.out.println("8. 15일 전 생일자 찾기");
            System.out.println("9. 주소록 수정");
            System.out.println("10. 주소록 삭제");
            System.out.println("0. 종료");
            System.out.print("0~10까지 항목 중 원하시는 항목을 입력하세요: ");
            inputWord = scanner.nextLine();

            int choice = Integer.parseInt(inputWord);

            if(choice == 0) {
                System.out.println("프로그램 종료");
                break;
            }
            if (choice == 1) {
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("나이: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("생일 (YYYY-MM-DD): ");
                LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                System.out.print("별명: ");
                String nickName = scanner.nextLine();
                System.out.print("연락처: ");
                String contactNum = scanner.nextLine();
                System.out.print("이메일: ");
                String email = scanner.nextLine();
                System.out.print("시/군/구: ");
                String siGunGu = scanner.nextLine();
                System.out.print("읍/면/동: ");
                String eupMyeonDong = scanner.nextLine();
                System.out.print("길: ");
                String gil = scanner.nextLine();
                System.out.print("번지: ");
                String addressNum = scanner.nextLine();
                System.out.print("동 호수: ");
                String dongHoNum = scanner.nextLine();
                System.out.print("우편번호: ");
                String zipCode = scanner.nextLine();

                Address address = new Address(siGunGu, eupMyeonDong, gil, addressNum, dongHoNum, zipCode);
                PersonInfo personInfo = new PersonInfo(name, age, birthDate, nickName, contactNum, email, null, null, address);
                contactBook.registerPersonInfo(personInfo);

            } else if (choice == 2) {
                contactBook.printAllPersonInfo();

            } else if (choice == 3) {
                System.out.print("이름 또는 별명 입력: ");
                inputWord = scanner.nextLine();
                List<PersonInfo> searchResult = contactBook.searchByNameAndNickName(inputWord);
                for (PersonInfo person : searchResult) {
                    System.out.println(person);
                }

            } else if (choice == 4) {
                System.out.print("연락처 입력: ");
                inputWord = scanner.nextLine();
                List<PersonInfo> searchByContactResult = contactBook.searchByContactNum(inputWord);
                for (PersonInfo person : searchByContactResult) {
                    System.out.println(person);
                }

            } else if (choice == 5) {
                System.out.print("주소 입력: ");
                inputWord = scanner.nextLine();
                List<PersonInfo> searchByAddressResult = contactBook.searchAddress(inputWord);
                for (PersonInfo person : searchByAddressResult) {
                    System.out.println(person);
                }

            } else if (choice == 6) {
                System.out.print("인덱스 입력: ");
                int index = Integer.parseInt(scanner.nextLine());
                List<PersonInfo> personByIndex = contactBook.getPersonByIndex(index);
                for (PersonInfo person : personByIndex) {
                    System.out.println(person);
                }

            } else if (choice == 7) {
                List<PersonInfo> afterBday = contactBook.searchAfterBday();
                for (PersonInfo person : afterBday) {
                    System.out.println(person);
                }

            } else if (choice == 8) {
                List<PersonInfo> beforeBday = contactBook.searchBeforeBday();
                for (PersonInfo person : beforeBday) {
                    System.out.println(person);
                }

            } else if (choice == 9) {
                System.out.print("수정할 사람의 인덱스 입력: ");
                int index = Integer.parseInt(scanner.nextLine());
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("나이: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("생일 (YYYY-MM-DD): ");
                LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                System.out.print("별명: ");
                String nickName = scanner.nextLine();
                System.out.print("연락처: ");
                String contactNum = scanner.nextLine();
                System.out.print("이메일: ");
                String email = scanner.nextLine();
                System.out.print("시/군/구: ");
                String siGunGu = scanner.nextLine();
                System.out.print("읍/면/동: ");
                String eupMyeonDong = scanner.nextLine();
                System.out.print("길: ");
                String gil = scanner.nextLine();
                System.out.print("번지: ");
                String addressNum = scanner.nextLine();
                System.out.print("동 호수: ");
                String dongHoNum = scanner.nextLine();
                System.out.print("우편번호: ");
                String zipCode = scanner.nextLine();

                Address address = new Address(siGunGu, eupMyeonDong, gil, addressNum, dongHoNum, zipCode);
                PersonInfo personInfo = new PersonInfo(name, age, birthDate, nickName, contactNum, email, null, null, address);
                System.out.print("정말로 수정하시겠습니까? (수정: 1, 취소: 2 입력): ");
                inputWord = scanner.nextLine();
                contactBook.updatePersonInfo(index, personInfo, inputWord);

            } else if (choice == 10) {
                System.out.print("삭제할 사람의 인덱스 입력: ");
                int index = Integer.parseInt(scanner.nextLine());
                System.out.print("정말로 삭제하시겠습니까? (삭제: 1, 취소: 2 입력): ");
                inputWord = scanner.nextLine();
                contactBook.deletePersonInfo(index, inputWord);

            } else {
                System.out.println("잘못 입력하였습니다.");
            }
        }
    }
}
