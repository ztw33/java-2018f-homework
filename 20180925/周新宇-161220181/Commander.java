import environment.BattleField;
import info.Camp;
import info.Constants;
import info.Formation;
import info.PositionInfo;
import lives.CalabashBrothers.*;
import lives.Creature;
import lives.Monsters.Footman;
import lives.Monsters.Scorpion;
import lives.Monsters.Snake;

import java.util.ArrayList;
import java.util.List;

public class Commander {
    private BattleField battleField = new BattleField();
    private Creature[] creatures = new Creature[Constants.livesNum];

    public Commander()
    {
        //init calabash brothers
        creatures[0] = new GrandPa(battleField.GetLand().get(0));
        creatures[1] = new RedBoy(battleField.GetLand().get(Constants.battleFieldColumn));
        creatures[2] = new OrangeBoy(battleField.GetLand().get(2*Constants.battleFieldColumn));
        creatures[3] = new YellowBoy(battleField.GetLand().get(3*Constants.battleFieldColumn));
        creatures[4] = new GreenBoy(battleField.GetLand().get(4*Constants.battleFieldColumn));
        creatures[5] = new CyanBoy(battleField.GetLand().get(5*Constants.battleFieldColumn));
        creatures[6] = new BlueBoy(battleField.GetLand().get(6*Constants.battleFieldColumn));
        creatures[7] = new PurpleBoy(battleField.GetLand().get(7*Constants.battleFieldColumn));

        //init monsters
        creatures[8] = new Snake(battleField.GetLand().get(Constants.battleFieldColumn-1));
        creatures[9] = new Scorpion(battleField.GetLand().get(2*Constants.battleFieldColumn-1));
        for(int i = 10;i < Constants.livesNum;i++)
            creatures[i] = new Footman(i-8,battleField.GetLand().get((i-7)*Constants.battleFieldColumn-1));

        //init their position
        for(int i = 0;i < Constants.livesNum;i++) {
            int newIndex = creatures[i].GetMyWaitingAreaInfo().GetRowPosition()*Constants.battleFieldColumn + creatures[i].GetMyWaitingAreaInfo().GetColumnPosition();
            int oldIndex = creatures[i].GetMyRowPosition()*Constants.battleFieldColumn + creatures[i].GetMyColumnPosition();
            creatures[i].MoveToWaitingArea(battleField.GetLand().get(oldIndex),battleField.GetLand().get(newIndex));
        }
    }
    public void Formate()
    {
        List<PositionInfo> positionInfoList = new ArrayList<PositionInfo>(Constants.livesNum / 2);
        for(int i = 0;i < Constants.livesNum/2;i++)
            positionInfoList.add(new PositionInfo(-1,-1));
        Formation.GetSnakeFormation(Camp.CB,positionInfoList);
        //CB formation
        for(int i = 0;i < positionInfoList.size();i++)
        {
            int row = positionInfoList.get(i).GetRowPosition();
            int column = positionInfoList.get(i).GetColumnPosition();
            int newIndex = row * Constants.battleFieldColumn + column;
            int oldIndex = creatures[i].GetMyRowPosition()*Constants.battleFieldColumn + creatures[i].GetMyColumnPosition();
            creatures[i].MoveTo(row,column,battleField.GetLand().get(oldIndex),battleField.GetLand().get(newIndex));
        }
        //MO formation
        Formation.GetRandomFormation(Camp.MO,positionInfoList);
        for(int i = 0;i < positionInfoList.size();i++)
        {
            int row = positionInfoList.get(i).GetRowPosition();
            int column = positionInfoList.get(i).GetColumnPosition();
            int newIndex = row * Constants.battleFieldColumn + column;
            int oldIndex = creatures[i+8].GetMyRowPosition()*Constants.battleFieldColumn + creatures[i+8].GetMyColumnPosition();
            creatures[i+8].MoveTo(row,column,battleField.GetLand().get(oldIndex),battleField.GetLand().get(newIndex));
        }
        //first show
        battleField.ShowBattleField();

        //for(int i = 0;i < Constants.livesNum;i++)
        //    creatures[i].PrintMyPositionInfo();

        //separate
        System.out.println();
        //MO new formation
        for(int i = positionInfoList.size();i < Constants.livesNum;i++)
        {
            int newIndex = creatures[i].GetMyWaitingAreaInfo().GetRowPosition() * Constants.battleFieldColumn + creatures[i].GetMyWaitingAreaInfo().GetColumnPosition();
            int oldIndex = creatures[i].GetMyRowPosition()*Constants.battleFieldColumn + creatures[i].GetMyColumnPosition();
            creatures[i].MoveToWaitingArea(battleField.GetLand().get(oldIndex),battleField.GetLand().get(newIndex));
        }
        Formation.GetRandomFormation(Camp.MO,positionInfoList);
        for(int i = 0;i < positionInfoList.size();i++)
        {
            int row = positionInfoList.get(i).GetRowPosition();
            int column = positionInfoList.get(i).GetColumnPosition();
            int newIndex = row * Constants.battleFieldColumn + column;
            int oldIndex = creatures[i+8].GetMyRowPosition()*Constants.battleFieldColumn + creatures[i+8].GetMyColumnPosition();
            creatures[i+8].MoveTo(row,column,battleField.GetLand().get(oldIndex),battleField.GetLand().get(newIndex));
        }
        //second show
        battleField.ShowBattleField();
    }
    public static void main(String[] avgs)
    {
        Commander commander = new Commander();
        commander.Formate();
    }
}
