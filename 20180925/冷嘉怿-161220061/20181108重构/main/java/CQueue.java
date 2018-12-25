import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/*
* 管理一个队伍，并支持排序和随机排列
* */
public class CQueue {               //完成对队伍中人物的排序和打乱顺序
    private ArrayList<Charactor> charactors=new ArrayList<>();      //储存人物
    private List<Integer> innerposition=new ArrayList<Integer>();        //人物在队列内的位置
    private int len=0;                                               //队列长度
    Point startloc;                                                   //队首的位置

    public CQueue(int sx, int sy)
    {
        startloc=new Point(sx,sy);
    }
    public void addCharactor(Charactor c)                            //向队伍中加入新成员
    {
        charactors.add(c);
        innerposition.add(len);
        len+=1;
    }
    private boolean checkAvaliable()                                //判断是否队伍中的人当前都没有执行操作
    {
        for(int i=0;i<len;i++) {
            Charactor x = charactors.get(i);
            if(!x.avaliable.get())
                return false;
        }
        return true;
    }
    public void Sort()                                               //排序
    {
        if(!checkAvaliable())
            return;
        innerposition.sort(null);
        reSetPosition();
    }
    public void Randomize()                                          //打乱顺序
    {
        if(!checkAvaliable())
            return;
        Random rnd=new Random(2);
        Collections.shuffle(innerposition,rnd);
        reSetPosition();
    }
    private void reSetPosition()                                    //所有人物执行移动动画
    {
        for(int i=0;i<len;i++)
        {
            Charactor x=charactors.get(i);
            int innerpos=innerposition.get(i);
            x.moveto(virtualField.vpTorp(startloc.x, startloc.y+innerpos));
            x.cmd.set(1);
        }
    }
}
