package zhenfa;

import creature.Creature;
import space.BatterGround;

public interface ZhenFa {
    void apply(BatterGround ground, Creature[] creatures);
    void clear(BatterGround ground, Creature[] creatures);
}
