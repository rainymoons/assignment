package finalproject;

import java.time.LocalDate;

class PersonInfo {

    private String name;
    private int age;
    private LocalDate birthDate;
    private String nickName;
    private String contactNum;
    private String email;
    private LocalDate modificationDate;
    private LocalDate lastModificationDate;
    private Address address;

    public PersonInfo(String name, int age, LocalDate birthDate, String nickName, String contactNum, String email,
        LocalDate modificationDate, LocalDate lastModificationDate, Address address) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.nickName = nickName;
        this.contactNum = contactNum;
        this.email = email;
        this.modificationDate = modificationDate;
        this.lastModificationDate = lastModificationDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNickName() {
        return nickName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setLastModificationDate(LocalDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("======================================");
        sb.append("이름: ").append(name).append("\n");
        sb.append("나이: ").append(age).append("\n");
        sb.append("생일: ").append(birthDate).append("\n");
        sb.append("별명: ").append(nickName).append("\n");
        sb.append("전화번호: ").append(contactNum).append("\n");
        sb.append("email: ").append(email).append("\n");
        sb.append("수정일자: ").append(modificationDate).append("\n");
        sb.append("마지막 수정 일자: ").append(lastModificationDate).append("\n");
        System.out.println("=======================================");
        sb.append(address);

        return sb.toString();
    }
}