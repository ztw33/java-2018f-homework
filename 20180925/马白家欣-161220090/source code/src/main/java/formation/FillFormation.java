package formation;

import being.*;
import position.Position;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/11/18
 */
public class FillFormation {

    static void fillFormation(CartoonCharacter kind, Map<Position, CartoonCharacter> formationMap, List<Position> positionList) {
        if(kind instanceof Justice)
        {
            formationMap.put(positionList.get(0), new Grandfather());
            formationMap.put(positionList.get(1), new Green());
            formationMap.put(positionList.get(2), new Red());
            formationMap.put(positionList.get(3), new Orange());
            formationMap.put(positionList.get(4), new Yellow());
            formationMap.put(positionList.get(5), new Cyan());
            formationMap.put(positionList.get(6), new Blue());
            formationMap.put(positionList.get(7), new Purple());
        }
        else if(kind instanceof Evil)
        {
            formationMap.put(positionList.get(0), new Scorpion());
            formationMap.put(positionList.get(1), new Snake());
            for (int i = 2; i < positionList.size(); i++) {
                formationMap.put(positionList.get(i), new LowLevelDemon());
            }
        }
        else
        {
            assert false;
        }

    }
}
