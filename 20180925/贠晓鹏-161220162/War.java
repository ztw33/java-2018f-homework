public class War {
    battlefield warField;
    brothers brother_war;
    monster moneter_war;

    War(int n, int m) {
        warField = new battlefield(n);
        brother_war = new brothers();
        moneter_war = new monster(m);
    }

    public void showWar() {
        warField.showBattle();
    }

    public void ChangeCalabashArray() {
        brother_war.snakeArray(warField);
        brother_war.addLeader(warField);
        //warField.showBattle();
    }

    public void ChangeMonsterArray(int n) {
        switch (n) {
            case 0:
                moneter_war.craneArray(warField);
                break;
            case 1:
                moneter_war.arrowArray(warField);
                break;
            case 2:
                moneter_war.birdArray(warField);
                break;
            default:
                break;
        }
        moneter_war.addLeader(warField);
        //warField.showBattle();
    }
    public static void main(String[] args) {
        War war = new War(19, 12);
        war.ChangeCalabashArray();
        for(int i=0;i<3;i++)
        {
           war.ChangeMonsterArray(i);
           war.showWar();
        }
    }
}
