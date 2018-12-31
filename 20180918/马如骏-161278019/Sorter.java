public class Sorter {
    public static void CBBubbleSort(CalabashBrothers calabashBrothers){
        System.out.println("葫芦兄弟冒泡排序开始：");
        System.out.print("初始位置：");
        for(int i = 0;i<calabashBrothers.CalabashBrotherList.length;i++){
            System.out.print(calabashBrothers.CalabashBrotherList[i].tellName()+',');
        }
        System.out.println();
        System.out.println("报告：");
        for(int i = calabashBrothers.CalabashBrotherList.length-1;i>0;i--){
            for(int j = 0; j<i;j++){
                if(calabashBrothers.CalabashBrotherList[j].index > calabashBrothers.CalabashBrotherList[j+1].index){
                    int temp = calabashBrothers.CalabashBrotherList[j].position;
                    calabashBrothers.CalabashBrotherList[j].move(calabashBrothers.CalabashBrotherList[j+1].position);
                    calabashBrothers.CalabashBrotherList[j+1].move(temp);
                    CalabashBrother temp1 = calabashBrothers.CalabashBrotherList[j];
                    CalabashBrother temp2 = calabashBrothers.CalabashBrotherList[j+1];
                    calabashBrothers.CalabashBrotherList[j] = temp2;
                    calabashBrothers.CalabashBrotherList[j+1] = temp1;
                }
            }
        }
        System.out.println("葫芦娃冒泡排序结束：");
        for(int i = 0;i<calabashBrothers.CalabashBrotherList.length;i++){
            System.out.print(calabashBrothers.CalabashBrotherList[i].tellName()+',');
        }
        System.out.println();
        System.out.println();
    }
    public static void CBBinSearch(CalabashBrothers calabashBrothers){
        System.out.println("葫芦兄弟二分排序开始：");
        System.out.print("初始位置：");
        for(int i = 0;i<calabashBrothers.CalabashBrotherList.length;i++){
            System.out.print(calabashBrothers.CalabashBrotherList[i].tellName()+',');
        }
        System.out.println();
        System.out.println("报告：");
        for(int i = 0;i<calabashBrothers.CalabashBrotherList.length;i++){
            CalabashBrother temp = calabashBrothers.CalabashBrotherList[i];
            int low = 0;
            int height = i-1;
            int mid;
            while(low<=height){
                mid = (height + low + 1) / 2;
                if(calabashBrothers.CalabashBrotherList[mid].index > temp.index){
                    height = mid -1;
                } else {
                    low = mid + 1;
                }
            }
            for(int j = i - 1;j >= low; j--){
                calabashBrothers.CalabashBrotherList[j+1] = calabashBrothers.CalabashBrotherList[j];
                calabashBrothers.CalabashBrotherList[j+1].move(j + 1);
            }
            if(low != i){
                calabashBrothers.CalabashBrotherList[low] = temp;
                temp.move(low);
            }
        }
        System.out.println("葫芦娃二分排序结束：");
        for(int i = 0;i<calabashBrothers.CalabashBrotherList.length;i++){
            System.out.print(calabashBrothers.CalabashBrotherList[i].tellColor()+',');
        }
    }
}
