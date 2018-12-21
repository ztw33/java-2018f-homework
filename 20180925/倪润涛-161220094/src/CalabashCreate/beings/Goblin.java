package CalabashCreate.beings;

enum GoblinName{蝎子精,小喽啰}
public class Goblin extends Goat {
    public int rank;
    public GoblinName name;
    public Goblin(int rank)
    {
        this.rank = rank;
        this.name = GoblinName.values()[rank];
    }
}