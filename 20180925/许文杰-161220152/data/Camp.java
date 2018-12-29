package data;

import java.util.ArrayList;

public class Camp<T extends Unit> {
    private ArrayList<Unit>soldiers;
    private T leader;
    public Camp(T leader)
    {
        this.leader = leader;
        soldiers = new ArrayList<>();
    }
    public Camp(T leader, Unit[] unit,int num)
    {
        this.leader = leader;
        soldiers = new ArrayList<>();
        for(int i = 0;i<num;i++)
            soldiers.add(unit[i]);
    }
    public void add_unit(Unit unit)
    {
        soldiers.add(unit);
    }
    public ArrayList<Unit> getList()
    {
        return soldiers;
    }
    public T getLeader()
    {
        return leader;
    }
    
}
