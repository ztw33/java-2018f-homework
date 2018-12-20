package Field;

import Being.Creature;

public class PlaceObjToField {
    public static <T extends Creature> void PutToField(T a) {
        int temp_x = a.getX();
        int temp_y = a.getY();
        BattleField.battlefield[temp_x][temp_y] = a.getSymbol();
    }
}
