enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}
class  BrotherAct {
    private int num;
    Brother[] brother;
    BrotherAct(int brother_num){
        num=brother_num;
        String[] name={"老大","老二","老三","老四","老五","老六","老七"};//初始化对象
        brother=new Brother[brother_num];
        for(int i=0;i<brother_num;i++){
            switch(i){
                case 0:brother[i]=new Brother(i,name[i],Color.RED);break;
                case 1:brother[i]=new Brother(i,name[i],Color.ORANGE);break;
                case 2:brother[i]=new Brother(i,name[i],Color.YELLOW);break;
                case 3:brother[i]=new Brother(i,name[i],Color.GREEN);break;
                case 4:brother[i]=new Brother(i,name[i],Color.CYAN);break;
                case 5:brother[i]=new Brother(i,name[i],Color.BLUE);break;
                case 6:brother[i]=new Brother(i,name[i],Color.PURPLE);break;
                default:
                    break;
            }
        }
    }
    public void report_allname(){
        for(int i=0;i<num;i++){
            brother[i].report_name();
        }
    }
    public void report_allcolor(){
        for(int i=0;i<num;i++){
            brother[i].report_color();
        }
    }
    public void get_pos(int[] a){//获得初始位置
        for(int i=0;i<7;i++){
            brother[i].position=a[i];
        }
    }
    public void change_pos(){//改变排序位置，即初始化位置
        for(int i=0;i<num;i++){
            if(brother[i].position!=(i+1)){
                Brother temp=brother[brother[i].position-1];
                brother[brother[i].position-1]=brother[i];
                brother[i]=temp;
                i=0;
            }
        }
    }
    public void move_pos(int i,int j){//排序算法移动位置
        brother[i].move(i,j);
        brother[j] = brother[i];
    }
    public void exchange_pos(int i,int j){//排序算法交换位置
        brother[i].move(i,j);
        brother[j].move(j,i);
        Brother temp=brother[i];
        brother[i]=brother[j];
        brother[j]=temp;
    }
}
public class Brother{
    private String name;//葫芦娃名字
    private Color color;//葫芦娃颜色
    int position;//葫芦娃当前位置
    int number;//葫芦娃应当的排序

    Brother(int get_number,String get_name,Color get_color){
        number=get_number;
        name=get_name;
        color=get_color;
    }
    public void report_name(){//打印名字
        System.out.println(name);
    }
    public void report_color(){//打印颜色
        System.out.println(color);
    }
    public void move(int i,int j){//打印移动信息
        position=j;
        System.out.println(name+": "+i+"->"+j);
    }
}
class test {
    static int brother_num=7;
    public static void BubbleSort(Brother[] brother,BrotherAct act){//冒泡
        for(int i=0;i<brother_num-1;i++){
            for(int j=0;j<brother_num-1-i;j++){
                if(brother[j].number>brother[j+1].number){
                    act.exchange_pos(j,j+1);
                }
            }
        }
    }

    public static void BinarySort(Brother[] brother,BrotherAct act) {//二分
        for (int i = 0; i < brother_num; i++) {
            Brother pivot = brother[i];
            int left = 0, middle = 0;
            int right = i - 1;
            while (left <= right) {
                middle = (left + right) / 2;
                if (pivot.number < brother[middle].number) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                act.move_pos(j,j+1);
            }
            if (left != i) {
                pivot.move(i,left);
                brother[left] = pivot;
            }
        }
    }
    public static void main(String[] args){
        BrotherAct act=new BrotherAct(brother_num);
        int[] get_pos1={2,1,5,4,7,3,6};//初始排序，大娃第二个，二娃第一个，以此类推
        int[] get_pos2={4,7,2,3,1,6,5};
        act.get_pos(get_pos1);
        act.change_pos();
        System.out.println("冒泡排序：");
        BubbleSort(act.brother,act);
        act.report_allname();
        act.get_pos(get_pos2);
        act.change_pos();
        System.out.println("二分排序：");
        BinarySort(act.brother,act);
        act.report_allcolor();
    }
}