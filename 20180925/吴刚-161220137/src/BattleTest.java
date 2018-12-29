import logic.battleInformation.*;

public class BattleTest {
    public static void main(String argv[]){
        /* n * n 棋盘 */
        Board board = new Board();
        Sides.formation = new Formation(board);

        JustSide justSide = new JustSide();
        EvilSide evilSide = new EvilSide(9);

        /*葫芦娃摆出蛇阵*/
        justSide.changeFormation("snake");

        /*妖精摆出大雁阵*/
        evilSide.changeFormation("goose");
        board.printBoard();
        System.out.println();

        /*妖精摆出鹤翼阵*/
        evilSide.changeFormation("flank");
        board.printBoard();

    }
}
