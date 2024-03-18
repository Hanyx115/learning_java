public class professor extends person{
    public int numOfPublications;

    public professor(String name, String PhoneNum, int numOfPublications) {
        super(name, PhoneNum);
        this.numOfPublications = numOfPublications;

    }
    public void ShowAcademicPosition(){

    }

    public void setNumOfPublications(int numOfPublications) {
        if (numOfPublications<8){
            System.out.print("Assistant Prof");
        }
        if (numOfPublications<16 && numOfPublications>=8){
            System.out.print("Associate Prof");
        }
        if (numOfPublications>16){
            System.out.print("Full Prof");
        }

    }

    @Override
    public String getVacationdays() {
        return "three" ;
    }

}
