public class BattleField {
    private char[][] battleField;
    //存在一个战场，用二维数组表示
    BattleField() {
        battleField = new char[15][15];
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                battleField[i][j] = ' ';
            }
        }
    }

    public char[][] getBattleField() {
        return battleField;
    }

    public void printTheBattle() {//显示当前战场情况,默认为空
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                System.out.print(battleField[i][j]);
            }
            System.out.println();
        }
    }

    public void cleanUpTheBattleFiled() {//清扫战场
        for (int i = 0; i < battleField.length; i++)
            for (int j = 0; j < battleField[i].length; j++) {
                battleField[i][j] = ' ';
            }
    }

}
