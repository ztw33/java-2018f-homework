package hw3.space;
import hw3.creature.Creature;

public class Block {
    private Creature creature;
    Block() {
        creature = null;
    }

    void putCreature(Creature creature) {
        this.creature = creature;
    }

    void eraseCreature() {
        this.creature = null;
    }

    Creature showCreature() {
        return creature;
    }
}
