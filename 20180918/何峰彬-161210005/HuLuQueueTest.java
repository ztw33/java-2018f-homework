package homework2;

public class HuLuQueueTest {
    static public void main(String[] args){
        HuLuQueue huLuQueue = new HuLuQueue();
        System.out.println("This is the order before sorting by name:");
        huLuQueue.reportName();
        huLuQueue.sortByName();
        System.out.println("And this is the order after sorting by name:");
        huLuQueue.reportName();

        System.out.println();
        huLuQueue.randomQueue();
        System.out.println("This is the order before sorting by color:");
        huLuQueue.reportColor();
        huLuQueue.sortByColor();
        System.out.println("And this is the order after sorting by color:");
        huLuQueue.reportColor();
    }
}
