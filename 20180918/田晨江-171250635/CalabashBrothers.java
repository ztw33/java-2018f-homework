import java.util.Random;

public class CalabashBrothers{

    private CalabashBrothersEnum[] cb = new CalabashBrothersEnum[7];

    public CalabashBrothers(){

        /**
         * 一个数组存放七个葫芦娃 order是它的内在属性
         */

        cb[0] = CalabashBrothersEnum.FIRST;
        cb[1] = CalabashBrothersEnum.SECOND;
        cb[2] = CalabashBrothersEnum.THIRD;
        cb[3] = CalabashBrothersEnum.FOURTH;
        cb[4] = CalabashBrothersEnum.FIFTH;
        cb[5] = CalabashBrothersEnum.SIXTH;
        cb[6] = CalabashBrothersEnum.SEVENTH;


    }
    public static void main(String[] args){

        CalabashBrothers queue = new CalabashBrothers();
        System.out.println("随意站队");
        queue.randomQueue();
        queue.numberOffByOrder();


        System.out.println("按序号排序:");
        queue.sortByPriority();
        queue.numberOffByPriority();


        System.out.println("随意站队");
        queue.randomQueue();
        queue.numberOffByOrder();
        System.out.println("按颜色排序:");
        queue.sortByColor();
        queue.numberOffByColor();

    }



    /**
     * 随机排队
     */
    public void randomQueue(){
        Random random = new Random();
        for (int i = 7; i >= 1; i--){
            int j = random.nextInt(i);
            CalabashBrothersEnum temp = cb[i-1];
            cb[i-1] = cb[j];
            cb[j] = temp;
        }

        /*
        Random random = new Random();
        for(int i=0; i<cb.length; i++){
            int p = random.nextInt(i+1);
            CalabashBrothersEnum temp = cb[i];
            cb[i] = cb[p];
            cb[p] = temp;
        }
        */
    }


    /**
     * 查看当前状态下的排队顺序
     */
    public void numberOffByOrder(){
        for(CalabashBrothersEnum cb : cb){
            System.out.print(cb.getOrder()+" ");
        }
        System.out.println();
    }



    /**
     * 排序的过程中进行报数
     */
    public static void NumberOff(CalabashBrothersEnum[] cb, int start, int end){
        System.out.println(cb[start].getName()+ ": " + (start+1) + "->"+ (end+1));
        System.out.println(cb[end].getName()+ ": " + (end+1) + "->"+ (start+1));
    }

    /**
     * 报出排行
     */

    public void numberOffByPriority(){
        for(CalabashBrothersEnum brother : cb){
            System.out.print(brother.getName()+ " ");
        }
        System.out.println();
    }

    /**
     * 报出颜色
     */

    public void numberOffByColor(){
        for(CalabashBrothersEnum brother : cb){
            System.out.print(brother.getColor()+ " ");
        }
        System.out.println();
    }

    /**
     *  按照序号进行排序
     */

    public void sortByPriority(){
        Sort sort = new Sort();
        sort.BubbleSort(cb);
    }

    /**
     * 按照颜色进行排序
     */

    public void sortByColor(){
        Sort sort = new Sort();
        sort.binaryInsertSort(cb);
    }

}
