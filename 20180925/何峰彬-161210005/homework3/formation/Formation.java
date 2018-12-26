package homework3.formation;
import homework3.BattleField;

public interface Formation<T>{
    void arrange(BattleField bf, T... objs);
}
