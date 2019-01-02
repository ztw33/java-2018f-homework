package hw2_sort;

import hw2_sort.Color_ENUM;

public class HuLuWa
{
    String name;
    Color_ENUM ownColor;
    int priority;
    HuLuWa(int i,int positionRndom)
    {
        switch (i) {
            case 0: {
                name = "老大";
                ownColor = Color_ENUM.Red;
                priority = 0;
                break;
            }
            case 1: {
                name = "老二";
                ownColor = Color_ENUM.Orange;
                priority = 1;
                break;
            }
            case 2: {
                name = "老三";
                ownColor = Color_ENUM.Yellow;
                priority = 2;
                break;
            }
            case 3: {
                name = "老四";
                ownColor = Color_ENUM.Green;
                priority = 3;
                break;
            }
            case 4: {
                name = "老五";
                ownColor = Color_ENUM.Cyan;
                priority = 4;
                break;
            }
            case 5: {
                name = "老六";
                ownColor = Color_ENUM.Blue;
                priority = 5;
                break;
            }
            case 6: {
                name = "老七";
                ownColor = Color_ENUM.Purple;
                priority = 6;
                break;
            }
            default:
            {
                System.out.println("输入有误");
                return;
            }
        }
    }
    public void showTheName()
    {
        System.out.print(name);
    }
    public int getPriority() {
        return priority;
    }
    public boolean compareColor(HuLuWa compareTarget){
        int colorOne = ownColor.ordinal();
        int colorTwo = compareTarget.ownColor.ordinal();
        //System.out.print(colorOne);
        //System.out.print(colorTwo);
        if(colorOne < colorTwo)
        {
            return false;
        }
        else return true;
    }
    public void showTheColor() {
        System.out.print("颜色为：");
        System.out.print(ownColor);
    }
    public void shoutThechange(int i,int j)
    {
        System.out.println(name+"："+i+"->"+j);
    }
}