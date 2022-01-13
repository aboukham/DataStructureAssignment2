package lab3.Question3;

public class Marketing {
    private String  employeeName;
    private String  productName;
    private double  salesAmount;

    public Marketing(String employeeName, String productName, double mount){
        this.employeeName = employeeName;
        this.productName = productName;
        this.salesAmount = mount;
    }

    public double getSalesAmount(){
        return salesAmount;
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "employeeName='" + employeeName + '\'' +
                ", productName='" + productName + '\'' +
                ", salesMount=" + salesAmount +
                '}';
    }
}
