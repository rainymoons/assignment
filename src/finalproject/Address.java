package finalproject;

class Address {
    private String siGunGu;
    private String eupMyeonDong;
    private String gil;
    private String addressNum;
    private String dongHoNum;
    private String zipCode;

    public Address(String siGunGu, String eupMyeonDong, String gil, String addressNum, String dongHoNum, String zipCode) {
        this.siGunGu = siGunGu;
        this.eupMyeonDong = eupMyeonDong;
        this.gil = gil;
        this.addressNum = addressNum;
        this.dongHoNum = dongHoNum;
        this.zipCode = zipCode;
    }

    public String getTotalAddress() {
        return siGunGu + " " + eupMyeonDong + " " + gil + " " + addressNum + " " + dongHoNum + " " + zipCode;
    }

    @Override
    public String toString() {
        return "주소 " +
            "[ 시/군/구: " + siGunGu +
            ", 읍/면/동: " + eupMyeonDong +
            ", 길: " + gil +
            ", 번지: " + addressNum +
            ", 동 호수: " + dongHoNum +
            ", 우편번호: " + zipCode;
    }
}