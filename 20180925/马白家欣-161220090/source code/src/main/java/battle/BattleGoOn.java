package battle;

import formation.FormationType;

import java.util.List;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/2
 */
public interface BattleGoOn {
    List<BattleFieldLattice> oneRandomFormation();
    List<BattleFieldLattice> oneSpecifiedFormation(FormationType formationType);
    List<List<BattleFieldLattice>> groupRandomFormation();
}
