public class HuluwaSort {

    // 七个葫芦娃
    private Huluwa []brothers;

    // 构造函数(初始化)
    HuluwaSort() {
        brothers = new Huluwa[7];
        brothers[0] = new Huluwa(0, "老大", "赤");
        brothers[1] = new Huluwa(1, "老二", "橙");
        brothers[2] = new Huluwa(2, "老三", "黄");
        brothers[3] = new Huluwa(3, "老四", "绿");
        brothers[4] = new Huluwa(4, "老五", "青");
        brothers[5] = new Huluwa(5, "老六", "蓝");
        brothers[6] = new Huluwa(6, "老七", "紫");

    }



    // 打乱位置
    public void upset() {
        for (int i = 0; i < 7; i++) {
            int j = (int)(Math.random() * 7) ;
            Huluwa tmp = brothers[i];
            brothers[i] = brothers[j];
            brothers[j] = tmp;
        }
    }




    // 报告要交换位置的两只 并交换
    private void SwapAndReport(int i, int j) {
            System.out.println(brothers[i].getName() + ": " + i + "<->" + j);
            Huluwa tmp = brothers[i];
            brothers[i] = brothers[j];
            brothers[j] = tmp;
    }








    // 报告每只的名字
    public void reportName() {
        for (Huluwa tmp: brothers) {
            System.out.println(tmp.getName());
        }
    }

    // 报告每只的颜色
    public void reportColor() {
        for (Huluwa tmp: brothers) {
            System.out.println(tmp.getColor());
        }
    }



    // 冒泡排序
    public void bubbleSort() {
        int i, j, len = brothers.length;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (brothers[j].getNo() > brothers[j + 1].getNo()) {
                    SwapAndReport(j, j + 1);
                }
            }
        }
    }






    //快排

    public void quickSortHelp(){
        quickSort(0,brothers.length-1);
    }

    public void quickSort(int low,int high){
        if(low<high){
            int partition=partition(low,high);
            quickSort(low,partition-1);
            quickSort(partition+1,high);
        }
    }

    public int partition(int low,int high){
        while (low<high){
            while (brothers[high].getNo()>=brothers[low].getNo()&&low<high){
                high--;
            }
            SwapAndReport(high,low);
            while (brothers[low].getNo()<=brothers[high].getNo()&&low<high){
                low++;
            }
            SwapAndReport(high,low);
        }
        return low;
    }


}
