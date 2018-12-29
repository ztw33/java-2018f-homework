package renyi;

import java.util.ArrayList;
import java.util.List;

public class Battle_Array {
    public int[][] position=new int[20][20];
    private int[] brothersx={4,4,4,4,4,4,4};
    private int[] brothersy={7,8,9,10,11,12,13};
    Battle_Array(String name,int ifhelp)
    {
        init_position(ifhelp);
        init_position_brothers();
        switch (name)
        {
            case "鹤翼":battle1();break;
            case "雁行":battle2();break;
            case "衝軛":battle3();break;
            case "长蛇":battle4();break;
            case "鱼鳞":battle5();break;
            case "方円":battle6();break;
            case "偃月":battle7();break;
            case "锋矢":battle8();break;
            default:break;
        }
    }
    void init_position(int ifhelp)
    {
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++)
                this.position[i][j]=0;
        if(ifhelp==1)
        {
            this.position[0][10]=2;
            this.position[19][10]=-3;
        }
    }
    void init_position_brothers()
    {
        for(int i=0;i<brothersx.length;i++)
            this.position[brothersx[i]][brothersy[i]]=1;
    }
    void init_position_orchin(int []x,int[] y)
    {
        for(int i=1;i<x.length;i++)
            this.position[x[i]][y[i]]=-1;
    }
    void init_position_scotpion(int x,int y)
    {
        this.position[x][y]=-2;
    }
    private void battle1()
    {
        int[] orchinx={15,16,17,18,16,17,18};
        int[] orchiny={10,9,8,7,11,12,13};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle2()
    {
        int[] orchinx={15,16,17,18,14,13,12};
        int[] orchiny={10,9,8,7,11,12,13};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle3()
    {
        int[] orchinx={15,16,15,16,16,15,16};
        int[] orchiny={10,11,12,13,9,8,7};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle4()
    {
        int[] orchinx={15,15,15,15,15,15,15};
        int[] orchiny={10,9,8,7,11,12,13};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle5()
    {
        int[] orchinx={15,13,14,14,15,15,16,16,16,16,17};
        int[] orchiny={10,10,11,9,8,12,7,9,11,13,10};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle6()
    {
        int[] orchinx={15,15,15,14,14,13,16,16,17};
        int[] orchiny={10,12,8,9,11,10,9,11,10};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle7()
    {
        int[] orchinx={15,11,11,11,13,13,13,15,15,14,14,15,15,16,16,17,17,18,18};
        int[] orchiny={10,9,10,11,9,10,11,9,11,8,12,13,7,8,12,13,7,14,6};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
    private void battle8()
    {
        int[] orchinx={15,16,17,18,14,13,14,14,15,15,16,16};
        int[] orchiny={10,10,10,10,10,10,11,9,12,8,13,7};
        init_position_scotpion(orchinx[0],orchiny[0]);
        init_position_orchin(orchinx,orchiny);
    }
}
