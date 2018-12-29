package hw2_sort;
import java.util.*;
import java.util.Random;
public class HuLuBrothers {
    private HuLuWa []bro;
    Random rand;
    private int []positionArry;
    public HuLuBrothers()
    {
        bro = new HuLuWa[7];
        positionArry = new int[7];
        rand =new Random();
        //每个位置已经确定好，进行初始化
        for(int i = 0; i < 7; i++)
        {
            bro[i] = new HuLuWa(i,i);
        }
    }
    public static void main(String[] args) {
        // write your code here
        HuLuBrothers father = new HuLuBrothers();
        father.random();
        father.showPosition();
        //进行按次序排序
        System.out.println("按次序进行排序");
        father.sortByorder();
        father.showPosition();
        System.out.println("重新打乱");
        father.random();
        //进行按颜色排序
        father.showPosition();
        System.out.println("按颜色进行排序");
        father.sortBycolor();
        father.showPosition();
    }
    public void random()
    {
        int i;
        for(int k = 0; k  < 7;k++) {
            i = rand.nextInt(7);
            HuLuWa temp = bro[k];
            bro[k] = bro[i];
            bro[i] = temp;
        }
    }
    public void showPosition()
    {
        for(int i = 0; i < 7;i++)
        {
            System.out.print("位置为:");
            System.out.println(i);
            bro[i].showTheName();
            bro[i].showTheColor();
            System.out.println();
        }
    }

    public void sortByorder()//进行排序
    {
        for(int i = 6;i >=0;i--)
        {
            for(int j = 0; j < i; j++)
            {
                int pro_1 = bro[j].getPriority();
                int pro_2 = bro[j+1].getPriority();
                if(pro_2 < pro_1)
                {
                    swapHuLuWa(j,j+1);
                }
            }
        }
    }
    public void sortBycolor()//进行排序
    {
        int begin = 0;
        int end = 6;
        int tempEnd = 0;
        while(tempEnd < end)
        {
            int insertHuluwa = tempEnd + 1;
            int insertPosition = -1;
            int findLeft =begin;
            int findRight = tempEnd;
            while(findLeft <= findRight)
            {
                insertPosition = (findLeft+findRight)/2;
                boolean T = bro[insertHuluwa].compareColor(bro[insertPosition]);
                if(T == true){
                    //在其后方
                    findLeft = insertPosition+1;
                }else{
                    //在其前方
                    findRight = insertPosition-1;
                }
            }
            for(int j =  insertHuluwa; j > findLeft; j--) {
                swapHuLuWa(j, j - 1);
            }
            tempEnd++;
        }
    }
    public void swapHuLuWa(int i,int j)
    {
        bro[i].shoutThechange(i,j);
        //bro[j].shoutThechange(j,i);
        HuLuWa temp = bro[i];
        bro[i] = bro[j];
        bro[j] = temp;
    }
}
