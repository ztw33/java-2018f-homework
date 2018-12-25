public class Main {
        public static void main(String []args) {
        HuluwaSort huluwaSort = new HuluwaSort();

        System.out.println("******冒泡******");
        huluwaSort.upset();
        huluwaSort.bubbleSort();
        System.out.println("******结束******\n");
        System.out.println("******排序后名字******");
        huluwaSort.reportName();


        System.out.println("\n******快排******");
        huluwaSort.upset();
        huluwaSort.quickSortHelp();
        System.out.println("******结束******\n");
        System.out.println("******排序后颜色******");
        huluwaSort.reportColor();

    }

}
