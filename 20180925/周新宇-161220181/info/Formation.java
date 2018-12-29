package info;

import java.util.List;
import java.util.Random;

enum FormationType {Snake, Wing, Goose, Zig, Fish, Square, Moon, Arrow}

public class Formation {

    public Formation() {}
    static private FormationType GetRandomFormationType()
    {
        Random RandomNumber = new Random();
        int ran = Math.abs(RandomNumber.nextInt()) % 7 + 1;
        switch (ran)
        {
            case 1:return FormationType.Fish;
            case 2:return FormationType.Zig;
            case 3:return FormationType.Arrow;
            case 4:return FormationType.Goose;
            case 5:return FormationType.Moon;
            case 6:return FormationType.Square;
            case 7:return FormationType.Wing;
            default:System.out.println("Error with random formation");return FormationType.Snake;
        }
    }
    static public void GetSnakeFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(9,5);
            positionInfoList.get(3).SetPosition(11,5);
            positionInfoList.get(4).SetPosition(8,5);
            positionInfoList.get(5).SetPosition(12,5);
            positionInfoList.get(6).SetPosition(7,5);
            positionInfoList.get(7).SetPosition(13,5);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(9,14);
            positionInfoList.get(3).SetPosition(11,14);
            positionInfoList.get(4).SetPosition(8,14);
            positionInfoList.get(5).SetPosition(12,14);
            positionInfoList.get(6).SetPosition(7,14);
            positionInfoList.get(7).SetPosition(13,14);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetWingFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(9,4);
            positionInfoList.get(3).SetPosition(11,4);
            positionInfoList.get(4).SetPosition(8,3);
            positionInfoList.get(5).SetPosition(12,3);
            positionInfoList.get(6).SetPosition(7,2);
            positionInfoList.get(7).SetPosition(13,2);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(9,15);
            positionInfoList.get(3).SetPosition(11,15);
            positionInfoList.get(4).SetPosition(8,16);
            positionInfoList.get(5).SetPosition(12,16);
            positionInfoList.get(6).SetPosition(7,17);
            positionInfoList.get(7).SetPosition(13,17);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetGooseFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(9,6);
            positionInfoList.get(3).SetPosition(11,4);
            positionInfoList.get(4).SetPosition(8,7);
            positionInfoList.get(5).SetPosition(12,3);
            positionInfoList.get(6).SetPosition(7,8);
            positionInfoList.get(7).SetPosition(13,2);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(9,13);
            positionInfoList.get(3).SetPosition(11,15);
            positionInfoList.get(4).SetPosition(8,12);
            positionInfoList.get(5).SetPosition(12,16);
            positionInfoList.get(6).SetPosition(7,11);
            positionInfoList.get(7).SetPosition(13,17);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetZigFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(9,4);
            positionInfoList.get(3).SetPosition(11,4);
            positionInfoList.get(4).SetPosition(8,5);
            positionInfoList.get(5).SetPosition(12,5);
            positionInfoList.get(6).SetPosition(7,4);
            positionInfoList.get(7).SetPosition(13,4);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(9,15);
            positionInfoList.get(3).SetPosition(11,15);
            positionInfoList.get(4).SetPosition(8,14);
            positionInfoList.get(5).SetPosition(12,14);
            positionInfoList.get(6).SetPosition(7,15);
            positionInfoList.get(7).SetPosition(13,15);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetFishFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(10,4);
            positionInfoList.get(3).SetPosition(9,4);
            positionInfoList.get(4).SetPosition(11,4);
            positionInfoList.get(5).SetPosition(8,3);
            positionInfoList.get(6).SetPosition(10,3);
            positionInfoList.get(7).SetPosition(12,3);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(10,15);
            positionInfoList.get(3).SetPosition(9,15);
            positionInfoList.get(4).SetPosition(11,15);
            positionInfoList.get(5).SetPosition(8,16);
            positionInfoList.get(6).SetPosition(10,16);
            positionInfoList.get(7).SetPosition(12,16);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetSquareFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(9,5);
            positionInfoList.get(2).SetPosition(11,5);
            positionInfoList.get(3).SetPosition(8,4);
            positionInfoList.get(4).SetPosition(12,4);
            positionInfoList.get(5).SetPosition(9,3);
            positionInfoList.get(6).SetPosition(11,3);
            positionInfoList.get(7).SetPosition(10,2);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(9,14);
            positionInfoList.get(2).SetPosition(11,14);
            positionInfoList.get(3).SetPosition(8,15);
            positionInfoList.get(4).SetPosition(12,15);
            positionInfoList.get(5).SetPosition(9,16);
            positionInfoList.get(6).SetPosition(11,16);
            positionInfoList.get(7).SetPosition(10,17);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetMoonFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(8,6);
            positionInfoList.get(2).SetPosition(12,6);
            positionInfoList.get(3).SetPosition(9,5);
            positionInfoList.get(4).SetPosition(11,5);
            positionInfoList.get(5).SetPosition(9,4);
            positionInfoList.get(6).SetPosition(10,4);
            positionInfoList.get(7).SetPosition(11,4);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(9,13);
            positionInfoList.get(2).SetPosition(11,13);
            positionInfoList.get(3).SetPosition(8,14);
            positionInfoList.get(4).SetPosition(12,14);
            positionInfoList.get(5).SetPosition(9,15);
            positionInfoList.get(6).SetPosition(11,15);
            positionInfoList.get(7).SetPosition(10,15);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetArrowFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        if(camp == Camp.CB)
        {
            positionInfoList.get(0).SetPosition(10,6);
            positionInfoList.get(1).SetPosition(10,5);
            positionInfoList.get(2).SetPosition(10,4);
            positionInfoList.get(3).SetPosition(9,4);
            positionInfoList.get(4).SetPosition(11,4);
            positionInfoList.get(5).SetPosition(10,3);
            positionInfoList.get(6).SetPosition(10,2);
            positionInfoList.get(7).SetPosition(10,1);
        }
        else if(camp == Camp.MO)
        {
            positionInfoList.get(0).SetPosition(10,13);
            positionInfoList.get(1).SetPosition(10,14);
            positionInfoList.get(2).SetPosition(10,15);
            positionInfoList.get(3).SetPosition(9,15);
            positionInfoList.get(4).SetPosition(11,15);
            positionInfoList.get(5).SetPosition(10,16);
            positionInfoList.get(6).SetPosition(10,17);
            positionInfoList.get(7).SetPosition(10,18);
        }
        else
            System.out.println("Error camp");
    }
    static public void GetRandomFormation(Camp camp,List<PositionInfo> positionInfoList)
    {
        FormationType ft = GetRandomFormationType();
        switch (ft)
        {
            case Zig:GetZigFormation(camp,positionInfoList);break;
            case Fish:GetFishFormation(camp,positionInfoList);break;
            case Moon:GetMoonFormation(camp,positionInfoList);break;
            case Wing:GetWingFormation(camp,positionInfoList);break;
            case Arrow:GetArrowFormation(camp,positionInfoList);break;
            case Goose:GetGooseFormation(camp,positionInfoList);break;
            case Snake:GetSnakeFormation(camp,positionInfoList);break;
            case Square:GetSquareFormation(camp,positionInfoList);break;
            default:GetSnakeFormation(camp,positionInfoList);break;
        }
    }
}
