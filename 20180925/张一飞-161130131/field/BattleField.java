package field;

import creature.Creature;

public class BattleField {

    private int N;

    private Creature[][] creatures;

    public BattleField() {
        N = 20;
        creatures = new Creature[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                creatures[i][j] = null;
            }
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    private boolean isPositionEmpty(int x, int y) {
        return creatures[x][y] == null;
    }

    public void printBattleFieldStatues() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPositionEmpty(i, j))
                    System.out.print("- ");
                else
                    System.out.print(creatures[i][j].getSymbolForCrea() + " ");
                //System.out.println();
            }
            System.out.println();
        }
    }

    private void moveCreatureOut(Creature creature) {
        if (creature != null) {
            creatures[creature.getCoorX()][creature.getCoorY()] = null;
            creature.moveToGoal(-1, -1);
        }
    }

    //留作以后扩展用。谁打死了谁就出去。
    public void moveSpecialCreatureOut(Creature creature) {
        moveCreatureOut(creature);
    }

    private void setCreatureToPositon(Creature creature, int inputX, int inputY) {
        if (isPositionEmpty(inputX, inputY)) {
            creatures[inputX][inputY] = creature;
            creature.moveToGoal(inputX, inputY);
        } else {
            System.out.println("thispersion Have a PeoPLE");
        }
    }

    public void getMessageFromControl(Control control) {
        creatures = control.getCreatures();
    }
}