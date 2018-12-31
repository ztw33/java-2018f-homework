package Creature;

public class Enemy extends Creature {
    public Enemy(int n) {
        if (n == 0)
            this.name = "蝎子";
        else
            this.name = "喽啰";
    }
}

