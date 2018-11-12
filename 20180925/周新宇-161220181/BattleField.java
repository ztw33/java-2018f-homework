import java.util.Random;

enum FormationType {Snake, Wing, Goose, Zig, Fish, Square, Moon, Arrow}

public class BattleField {
    Living[] lives;
    Land[][] land;
    BattleField()
    {
        lives = new Living[20];
        land = new Land[20][20];
        for(int i = 0;i < 20;i++)
            for(int j = 0;j < 20;j++)
                land[i][j] = new Land();

        //CB
        lives[0] = new Grandpa();
        lives[0].SitInBattleField(land);
        lives[1] = new RedBoy();
        lives[1].SitInBattleField(land);
        lives[2] = new OrangeBoy();
        lives[2].SitInBattleField(land);
        lives[3] = new YellowBoy();
        lives[3].SitInBattleField(land);
        lives[4] = new GreenBoy();
        lives[4].SitInBattleField(land);
        lives[5] = new CyanBoy();
        lives[5].SitInBattleField(land);
        lives[6] = new BlueBoy();
        lives[6].SitInBattleField(land);
        lives[7] = new PurpleBoy();
        lives[7].SitInBattleField(land);

        //MO
        lives[8] = new Snake();
        lives[8].SitInBattleField(land);
        lives[9] = new Scorpion();
        lives[9].SitInBattleField(land);
        for(int i = 10;i <= 15;i++)
        {
            lives[i] = new Minions();
            lives[i].SitInBattleField(land);
        }
    }

    //General Formation
    void ZigFormation(int[][] positionMap, CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][3] = 1;
            positionMap[3][2] = 2;
            positionMap[5][2] = 3;
            positionMap[2][3] = 4;
            positionMap[6][3] = 5;
            positionMap[1][2] = 6;
            positionMap[7][2] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][8] = 1;
            positionMap[3][7] = 2;
            positionMap[5][7] = 2;
            positionMap[2][8] = 2;
            positionMap[6][8] = 2;
            positionMap[1][7] = 2;
            positionMap[7][7] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void WingFormation(int[][]positionMap,CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][3] = 1;
            positionMap[3][2] = 2;
            positionMap[5][2] = 3;
            positionMap[2][1] = 4;
            positionMap[6][1] = 5;
            positionMap[1][0] = 6;
            positionMap[7][0] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][6] = 1;
            positionMap[3][7] = 2;
            positionMap[5][7] = 2;
            positionMap[2][8] = 2;
            positionMap[6][8] = 2;
            positionMap[1][9] = 2;
            positionMap[7][9] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void GooseFormation(int [][]positionMap, CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][2] = 1;
            positionMap[3][3] = 2;
            positionMap[5][1] = 3;
            positionMap[2][3] = 4;
            positionMap[6][1] = 5;
            positionMap[1][4] = 6;
            positionMap[7][0] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][7] = 1;
            positionMap[3][6] = 2;
            positionMap[5][8] = 2;
            positionMap[2][6] = 2;
            positionMap[6][8] = 2;
            positionMap[1][5] = 2;
            positionMap[7][9] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void FishFormation(int[][] positionMap,CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][3] = 1;
            positionMap[4][2] = 2;
            positionMap[3][2] = 3;
            positionMap[5][2] = 4;
            positionMap[4][1] = 5;
            positionMap[2][1] = 6;
            positionMap[6][1] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][6] = 1;
            positionMap[4][7] = 2;
            positionMap[3][7] = 2;
            positionMap[5][7] = 2;
            positionMap[4][8] = 2;
            positionMap[2][8] = 2;
            positionMap[6][8] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void SquareFormation(int[][] positionMap, CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[3][3] = 1;
            positionMap[5][3] = 2;
            positionMap[2][2] = 3;
            positionMap[6][2] = 4;
            positionMap[3][1] = 5;
            positionMap[5][1] = 6;
            positionMap[4][0] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[3][6] = 2;
            positionMap[5][6] = 2;
            positionMap[2][7] = 2;
            positionMap[6][7] = 2;
            positionMap[3][8] = 2;
            positionMap[5][8] = 2;
            positionMap[4][9] = 1;
        }
        else
            System.out.println("Error CAMP!");
    }
    void MoonFormation(int[][] positionMap, CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][2] = 1;
            positionMap[3][2] = 2;
            positionMap[5][2] = 3;
            positionMap[2][3] = 4;
            positionMap[6][3] = 5;
            positionMap[1][4] = 6;
            positionMap[7][4] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][7] = 1;
            positionMap[3][7] = 2;
            positionMap[5][7] = 2;
            positionMap[2][6] = 2;
            positionMap[6][6] = 2;
            positionMap[1][5] = 2;
            positionMap[7][5] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void ArrowFormation(int[][] positionMap, CAMP camp)
    {
        //Formation
        if(camp == CAMP.CB)
        {
            positionMap[4][4] = 1;
            positionMap[4][3] = 2;
            positionMap[3][3] = 3;
            positionMap[5][3] = 4;
            positionMap[4][2] = 5;
            positionMap[4][1] = 6;
            positionMap[4][0] = 7;
        }
        else if(camp == CAMP.MO)
        {
            positionMap[4][5] = 1;
            positionMap[4][6] = 2;
            positionMap[3][6] = 2;
            positionMap[5][6] = 2;
            positionMap[4][7] = 2;
            positionMap[4][8] = 2;
            positionMap[4][9] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }
    void SnakeFormation(int[][] positionMap, CAMP camp)
    {
        //Get random queue
        int queueLength = 7;
        int []queue = new int[queueLength];
        for(int j = 0;j < queueLength;j++)
            queue[j] = -1;
        int ran = 0;
        int count = 0;
        boolean flag = false;
        while(count < queueLength)
        {
            Random RandomNumber = new Random();
            ran = Math.abs(RandomNumber.nextInt()) % queueLength + 1;
            for(int i = 0;i < count;i++) {
                if (ran == queue[i]) {
                    flag = true;
                    break;
                } else
                    flag = false;
            }
            if(!flag)
            {
                queue[count] = ran;
                count++;
            }
        }
        //Formation
        if(camp == CAMP.CB)
        {
            for(int i = 0;i < 7;i++)
                positionMap[1+i][2] = queue[i];
        }
        else if(camp == CAMP.MO)
        {
            //for(int i = 0;i < 7;i++)
            //    positionMap[1+i][7] = queue[i];
            positionMap[1][7] = 2;
            positionMap[2][7] = 2;
            positionMap[3][7] = 2;
            positionMap[4][7] = 1;
            positionMap[5][7] = 2;
            positionMap[6][7] = 2;
            positionMap[7][7] = 2;
        }
        else
            System.out.println("Error CAMP!");
    }


    //Formation
    public void PutLeaders(FormationType ft,CAMP camp)
    {
        if(camp == CAMP.CB)
        {
            switch (ft)
            {
                case Snake:lives[0].GoTo(4,3,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][3]);break;
                case Wing:lives[0].GoTo(4,4,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][4]);break;
                case Goose:lives[0].GoTo(4,4,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][4]);break;
                case Zig:lives[0].GoTo(4,4,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][4]);break;
                case Fish:lives[0].GoTo(4,4,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][4]);break;
                case Square:lives[0].GoTo(4,4,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][4]);break;
                case Moon:lives[0].GoTo(4,3,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[4][3]);break;
                case Arrow:lives[0].GoTo(0,0,land[lives[0].TellMyRowPosition()][lives[0].TellMyColumnPosition()],land[0][0]);break;
                default:System.out.println("Error with leaders");break;
            }
        }
        else if(camp == CAMP.MO)
        {
            switch(ft)
            {
                case Snake:lives[8].GoTo(4,6,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][6]);break;
                case Wing:lives[8].GoTo(4,5,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][5]);break;
                case Goose:lives[8].GoTo(4,5,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][5]);break;
                case Zig:lives[8].GoTo(4,5,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][5]);break;
                case Fish:lives[8].GoTo(4,5,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][5]);break;
                case Square:lives[8].GoTo(4,5,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][5]);break;
                case Moon:lives[8].GoTo(4,6,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[4][6]);break;
                case Arrow:lives[8].GoTo(9,9,land[lives[8].TellMyRowPosition()][lives[8].TellMyColumnPosition()],land[9][9]);break;
                default:System.out.println("Error with leaders");break;
            }
        }
    }
    public void Formation(FormationType ft,CAMP camp)
    {
        int[][] positionMap = new int[10][10];
        for(int i = 0;i < 10;i++)
            for(int j = 0;j < 10;j++)
                positionMap[i][j] = -1;
        switch(ft)
        {
            case Snake: SnakeFormation(positionMap,camp);break;
            case Zig: ZigFormation(positionMap,camp);break;
            case Fish: FishFormation(positionMap,camp);break;
            case Moon: MoonFormation(positionMap,camp);break;
            case Wing: WingFormation(positionMap,camp);break;
            case Arrow: ArrowFormation(positionMap,camp);break;
            case Goose: GooseFormation(positionMap,camp);break;
            case Square: SquareFormation(positionMap,camp);break;
            default: System.out.println("No Such Formation!");break;
        }
        if(camp == CAMP.CB)
        {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (positionMap[i][j] != -1) {
                        switch (positionMap[i][j]) {
                            case 1:lives[1].GoTo(i,j,land[lives[1].TellMyRowPosition()][lives[1].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 2:lives[2].GoTo(i,j,land[lives[2].TellMyRowPosition()][lives[2].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 3:lives[3].GoTo(i,j,land[lives[3].TellMyRowPosition()][lives[3].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 4:lives[4].GoTo(i,j,land[lives[4].TellMyRowPosition()][lives[4].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 5:lives[5].GoTo(i,j,land[lives[5].TellMyRowPosition()][lives[5].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 6:lives[6].GoTo(i,j,land[lives[6].TellMyRowPosition()][lives[6].TellMyColumnPosition()],land[i][j]);
                                break;
                            case 7:lives[7].GoTo(i,j,land[lives[7].TellMyRowPosition()][lives[7].TellMyColumnPosition()],land[i][j]);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        else if(camp == CAMP.MO)
        {
            int countMinions = 0;
            for(int i = 0;i < 10;i++)
            {
                for(int j = 0;j < 10;j++)
                {
                    if(positionMap[i][j] != -1)
                    {
                        switch (positionMap[i][j])
                        {
                            case 1:lives[9].GoTo(i,j,land[lives[9].TellMyRowPosition()][lives[9].TellMyColumnPosition()],land[i][j]);break;
                            case 2:lives[10+countMinions].GoTo(i,j,land[lives[10+countMinions].TellMyRowPosition()][lives[10+countMinions].TellMyColumnPosition()],land[i][j]); countMinions++;break;
                        }
                    }
                }
            }
        }
    }
    static FormationType GetRondomFormation()
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
    Land GetFreeLandOutside()
    {
        for(int i = 10;i < 20;i++)
            for(int j = 10;j < 20;j++)
                if(!land[i][j].isUsedUp())
                    return land[i][j];
        System.out.println("Error get free land");
        return land[0][0];
    }
    public void MoveOutside(CAMP camp)
    {
        if(camp == CAMP.CB)
        {
            for(int count = 0;count < 7;count++)
            {
                boolean flag = false;
                for(int i = 10;i < 20;i++)
                {
                    for (int j = 10; j < 20; j++)
                    {
                        if (!land[i][j].isUsedUp())
                        {
                            lives[count].GoTo(i, j, land[lives[count].TellMyRowPosition()][lives[count].TellMyColumnPosition()], land[i][j]);
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                }
            }
        }
        else if(camp == CAMP.MO)
        {
            for(int count = 8;count < 16;count++)
            {
                boolean flag = false;
                for(int i = 10;i < 20;i++)
                {
                    for (int j = 10; j < 20; j++)
                    {
                        if (!land[i][j].isUsedUp())
                        {
                            lives[count].GoTo(i, j, land[lives[count].TellMyRowPosition()][lives[count].TellMyColumnPosition()], land[i][j]);
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                }
            }
        }
        else
            System.out.println("Error move outside");
    }
    public void ShowBattleField()
    {
        for(int i = 0;i < 10;i++)
        {
            for(int j = 0;j < 10;j++)
            {
                if(land[i][j].isUsedUp())
                    land[i][j].GetSimpleName();
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String []args)
    {
        //init BattleFiled
        BattleField bf = new BattleField();

        //CalabashBrothers formation
        bf.Formation(FormationType.Snake,CAMP.CB);
        bf.PutLeaders(FormationType.Snake,CAMP.CB);

        //Monsters Formation
        FormationType ft = GetRondomFormation();
        bf.Formation(ft,CAMP.MO);
        bf.PutLeaders(ft,CAMP.MO);

        //Show BattleField
        bf.ShowBattleField();

        //Get new Monsters Formation
        FormationType newFT = ft;
        while(newFT == ft)
            newFT = GetRondomFormation();
        bf.MoveOutside(CAMP.MO);
        bf.Formation(newFT,CAMP.MO);
        bf.PutLeaders(newFT,CAMP.MO);

        //Show BattleField
        System.out.println("");
        bf.ShowBattleField();
    }
}
