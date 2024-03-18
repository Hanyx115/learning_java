public abstract class person {
   public String name;
    private String vacationdays;
    public String PhoneNum;

    public person() {
    }

    public String getVacationdays() {
        return null;
    }

    public person(String name,String PhoneNum) {
        this.name = name;
        this.PhoneNum=PhoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

}
