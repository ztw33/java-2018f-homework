public class BattleField {
    private int ScorpionAbscissa;
    private int ScorpionOrdinate;
    private int SnakeAbscissa;
    private int SnakeOrdinate;
    private int GrandpaAbscissa;
    private int GrandpaOrdinate;
    private int FormationNum;
    private int SpriteNum;
    private char Map[][];
    private BattleField(int num, CalabashBrothers Brothers, Snake SnakeKing, Scorpion ScorpionKing, Grandpa oldGrandpa, Underlings underlings) {
        Map = new char[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Map[i][j] = ' ';
            }
        }
        updateBattle(num, Brothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
    }
    public void clearBattle(Underlings underlings)
    {
        int SpriteAbscissa, SpriteOrdinate;
        Map[SnakeAbscissa][SnakeOrdinate] = ' ';
        Map[ScorpionAbscissa][ScorpionOrdinate] = ' ';
        Map[GrandpaAbscissa][GrandpaOrdinate] = ' ';
        SpriteNum = underlings.getSpriteNum();
        for(int i = 0; i < SpriteNum; i++)
        {
            SpriteAbscissa = underlings.getSpriteAbscissa(i);
            SpriteOrdinate = underlings.getSpriteOrdinate(i);
            Map[SpriteAbscissa][SpriteOrdinate] = ' ';
        }
        for(int i = 0; i < 7; i++)
        {
            Map[7 + i][5] = ' ';
        }
    }
    public void updateBattle(int num, CalabashBrothers Brothers, Snake SnakeKing, Scorpion ScorpionKing, Grandpa oldGrandpa, Underlings underlings)
    {
        int SpriteAbscissa, SpriteOrdinate;
        underlings.deploySpite(num);
        FormationNum = num;
        ScorpionAbscissa = ScorpionKing.getAbscissa();
        ScorpionOrdinate = ScorpionKing.getOrdinate();
        SnakeAbscissa = SnakeKing.getAbscissa();
        SnakeOrdinate = SnakeKing.getOrdinate();
        GrandpaAbscissa = oldGrandpa.getAbscissa();
        GrandpaOrdinate = oldGrandpa.getOrdinate();
        SpriteNum = underlings.getSpriteNum();
        for(int i = 0; i < SpriteNum; i++)
        {
            SpriteAbscissa = underlings.getSpriteAbscissa(i);
            SpriteOrdinate = underlings.getSpriteOrdinate(i);
            Map[SpriteAbscissa][SpriteOrdinate] = 'L';
        }
        Map[SnakeAbscissa][SnakeOrdinate] = 'S';
        Map[ScorpionAbscissa][ScorpionOrdinate] = 'X';
        Map[GrandpaAbscissa][GrandpaOrdinate] = 'G';
        displayCalabashBrothers(Brothers);
    }
    public void displayCalabashBrothers(CalabashBrothers Brothers)
    {
        for(int i = 0; i < 7; i++)
        {
            Map[7 + i][5] = Brothers.getCalabashBoySymbol(i);
        }
    }
    public void displayBattle()
    {
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                System.out.print(Map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String []args)
    {
        int []array = {7, 6, 5, 1, 2, 4, 3};
        int num = 1;
        Scorpion ScorpionKing = new Scorpion();
        Snake SnakeKing = new Snake();
        Underlings underlings = new Underlings(num);
        Grandpa oldGrandpa = new Grandpa();
        CalabashBrothers SevenBrothers = new CalabashBrothers(array);
        BattleField newBattle = new BattleField(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        SevenBrothers.BubbleSort();
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 2;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 3;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 4;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 5;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 6;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 7;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
        num = 8;
        underlings = new Underlings(num);
        newBattle.updateBattle(num, SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, underlings);
        newBattle.displayBattle();
        newBattle.clearBattle(underlings);
    }
}
