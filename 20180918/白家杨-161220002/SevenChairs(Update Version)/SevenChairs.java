package bjy.SevenChairs;

import java.util.Random;
public class SevenChairs {
    private boolean[] chairs=new boolean[7];
    private Brother []hero=new Brother[7];
    public void ArrangeChairs(){
        System.out.println("开始随机排序");
        for(int i=0;i<7;i++)
            chairs[i]=true;
        //随机安排座位
        for(int i=0;i<7;i++)
        {
            Random rand = new Random();
            int index = rand.nextInt(7);
            while(chairs[index] == false)
                index = rand.nextInt(7);
            chairs[index] = false;
            hero[i] = new Brother(index);
        }
        for(int i = 0; i < 7; i++){
            hero[i].Display();
        }
    }
    public void ShowState(){
        for(int i = 0; i < 7; i++){
            hero[i].Display();
        }
    }
    //展示辈分
    public void ShowAge(){
        for(int i = 0; i < 7; i++){
            hero[i].DisplayAge();
        }
    }
    //展示颜色
    public void ShowColor(){
        for(int i = 0; i < 7; i++){
            hero[i].DisplayColor();
        }
    }
    public static void main(String[] args){
        SevenChairs seat = new SevenChairs();
        seat.ArrangeChairs();
        seat.Bubble();
        //seat.hero[0].ChangePlace(8);
        seat.ShowAge();
        seat.ArrangeChairs();
        seat.SepSort();
        seat.ShowColor();
    }

    private void ArrangeColor() {
        ;
    }
    private void Exchange(int i, int j){
        hero[i].DeclareExchange(i,j);
        hero[j].DeclareExchange(j,i);
        Brother tmp = hero[i];
        hero[i] = hero[j];
        hero[j] = tmp;
    }
    public void Bubble() {
        for(int i = 0; i < 7; i++){
            for(int j = 1; j < 7-i; j++){
                if(this.hero[j].compare_brother(this.hero[j-1]))
                    Exchange(j, j - 1);
            }
        }
    }
    public void SepSort(){
        //对于第i个元素来排序
        for(int i = 1; i < 7; i++){
            int begin=0;
            int end = i - 1;
            while(begin<=end){
                int mid = (begin + end)/ 2;
                if(hero[i].compare_brother(hero[mid])){
                    begin = mid + 1;
                }
                else
                    end = mid - 1;
            }
            //移动来排序前i个位置
            for(int j = i; j > begin; j--)
                if(hero[j].compare_brother(hero[j-1]))
                    Exchange(j,j-1);
        }
    }
}
