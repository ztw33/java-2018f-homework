package Creature;

import Creature.Creature;

public class Huluwa extends Creature {
    public int order;
    public Huluwa(int order){
        this.order=order;
    }//构造函数 设置葫芦娃的序号
   // @Override
  /*  public  int compare(Huluwa hulu){
        if(this.order>hulu.order){
            return 1;
        }
        return -1;
    }//自定义排序函数*/
}//葫芦娃的颜色此时不是很重要 排序的依据是其order
