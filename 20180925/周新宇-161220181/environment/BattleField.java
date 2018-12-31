package environment;

import info.Constants;
import lives.Creature;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<Land<Creature>> lands = new ArrayList<Land<Creature>>(Constants.battleFieldCapacity);

    public BattleField()
    {
        for(int i = 0;i < Constants.battleFieldRow;i++)
            for(int j = 0;j < Constants.battleFieldColumn;j++)
                lands.add(new Land<Creature>(i,j));
    }
    public void ShowBattleField()
    {
        for(int i = 0;i < Constants.battleFieldCapacity;i++)
        {
            if(lands.get(i).IsLandUsed())
                lands.get(i).ShowUserName();
            else
                System.out.print(" ");
            if((i + 1) % Constants.battleFieldColumn == 0)
                System.out.println();
        }
    }
    public List<Land<Creature>> GetLand()
    {
        return this.lands;
    }
}
