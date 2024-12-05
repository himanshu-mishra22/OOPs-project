//This class is responsible to keep the
//track of students  fees, name, id, grade
//fees paid


public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * Fees for every student = Rs 20,000 per year
     * Fees paid initially = 0
     * @param id
     * @param name
     * @param grade
     */
    public Student(int id, String name, int grade) {

        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 20000;
    }

    public int getGrade() {
        return grade;
    }

    /**
     *
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * Keep adding the fees paid to feesPaid field
     * @param fees
     */
    public void updateFeesPaid(int fees) {
        this.feesPaid += fees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public void payFees(int fees){
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    public int getRemainingFees(){
        return feesTotal -= feesPaid;
    }


}
