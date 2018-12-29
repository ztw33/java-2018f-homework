

public class War {
    BattleField warField;
    CalabashSide calabashSide;
    MonsterSide monsterSide;

    War(int n, int m) {
        warField = new BattleField(n);
        calabashSide = new CalabashSide();
        monsterSide = new MonsterSide(m);
    }

    public void showWar() {
        warField.showBattle();
    }

    public void ChangeCalabashArray() {
        calabashSide.snakeArray(warField);
        calabashSide.addLeader(warField);
        //warField.showBattle();
    }

    public void ChangeMonsterArray(String arrayName) {
        switch (arrayName) {
            case "Crane":
                monsterSide.craneArray(warField);
                break;
            case "Arrow":
                monsterSide.arrowArray(warField);
                break;
            default:
                break;
        }
        monsterSide.addLeader(warField);
        //warField.showBattle();
    }

    public static void main(String[] args) {
        War war = new War(15, 11);
        war.ChangeCalabashArray();
        war.ChangeMonsterArray("Crane");
        war.showWar();
        war.ChangeMonsterArray("Arrow");
        war.showWar();
    }
}
