package World;

import java.util.List;

public abstract class Scheduler<T> {
    abstract List<T> getList();
    abstract void shuffle();
    abstract void init_Soldiers();
    abstract void setFormation(String name);
}
