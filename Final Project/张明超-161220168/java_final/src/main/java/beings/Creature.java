package beings;

public class Creature extends Being {
    Creature(){
        name = "      ";
    }
    protected Boolean IsDead = false;
    public Boolean getIsDead(){
        return IsDead;
    }
}
