
public class TestExamples {
    public static void main(String[] args){
        HuluwaBrothers example1 = new HuluwaBrothers();

        example1.randomOrder();
        System.out.println("random line:");
        example1.reportName();

        System.out.println("\nbubble sort:");
        example1.bubbleSort();
        System.out.println("report name:");
        example1.reportName();

        System.out.println("\nrandom line:");
        example1.randomOrder();
        example1.reportName();

        System.out.println("\nbinary sort:");
        example1.binarySort();
        System.out.println("report color:");
        example1.reportColor();
        return;
    }
}
