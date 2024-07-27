package assign717;

public class ContactApp {
    String phoneNumber;
    String email;
    String memo;

    public void updatePhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    public void callNumber() {
        System.out.println("입력된 전화번호인 " + phoneNumber + "에 전화 거는 메서드");
    }

    public void sendEmail() {
        System.out.println("입력된 이메일인 " + email + "로 이메일 발송하는 메서드");
    }

    public void updateEmail(String newEmail) {
        email = newEmail;
    }

    public void showMemo() {
        System.out.println("메모한것 -> " + memo +  " 보여주는 메서드");
    }

    public void updateMemo(String newMemo) {
        memo = newMemo;
    }

    public void sendMessage() {
        System.out.println("입력된 전화번호인 " + phoneNumber + " 로 메세지 전송하는 메서드");
    }

    public void addFavorite() {
        System.out.println("즐겨찾기에 추가하는 메서드");
    }

    public void edit(String newPhoneNumber, String newEmail, String newMemo) {
        phoneNumber = newPhoneNumber;
        email = newEmail;
        memo = newMemo;
        System.out.println("전화번호, 이메일, 메모 수정하는 메서드");
    }

    public static void main(String[] args) {
        ContactApp app = new ContactApp();


        app.callNumber();
        app.showMemo();
        app.addFavorite();
        app.sendEmail();
        app.edit("010-9090-9090", "hihihi@gmail.com", "이것도 과제. 즐겁다..");
        app.updateEmail("rainymoon31@gmail.com");
        app.updatePhoneNumber("010-9036-9025");
        app.updateMemo("이것은 과제. 즐겁다.");
    }
}
