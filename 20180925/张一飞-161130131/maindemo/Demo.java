package maindemo;

//import


import field.BattleField;
import field.Control;
import creature.*;
import creature.devil.Mobs;
import creature.devil.Scorpion;
import creature.devil.Snake;
import creature.justice.Calabashs;
import creature.justice.Grandfather;

public class Demo {
    public static void main(String[] args) {
        Creature[] calas = {new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs()};
        Creature snake = new Snake();
        Creature grandfather = new Grandfather();
        Creature[] devils = {new Scorpion(), new Mobs(), new Mobs(), new Mobs(), new Mobs(), new Mobs(), new Mobs()};
        BattleField battleField = new BattleField();
        Control control = new Control();

        for (int i = 0; i < 7; i++) {
            control.setQuene(i, calas, devils);
            control.setImportantCrea(grandfather, snake);
            battleField.getMessageFromControl(control);
            battleField.printBattleFieldStatues();
            control.clearBattleField();
            battleField.getMessageFromControl(control);
            // battleField.printBattleFieldStatues();
        }
    }
}