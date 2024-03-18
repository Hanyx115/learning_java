public class student extends person {
    public Double GPA;

    public student(String name, String PhoneNum, Double GPA) {
        super(name, PhoneNum);
        this.GPA = GPA;
    }
    public void showGeneralGrade(){
        if (GPA==4 && GPA>3.4){
            System.out.print("Excellent");
        }
        if (GPA<3.4 && GPA>2.8){
            System.out.print("Very Good");
        }
        if (GPA<2.8 && GPA>2.4){
            System.out.print("Good");
        }
        if (GPA<2.4 && GPA>2.0){
            System.out.print("pass");
        }
        if (GPA<2.0){
            System.out.print("Fail");
        }
    }

    public Double getGPA() {
        return GPA;
    }
}
