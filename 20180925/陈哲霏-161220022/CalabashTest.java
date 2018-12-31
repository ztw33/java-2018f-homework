public class CalabashTest {
    public static void main(String[] args){
        CalabashBro[] calabashArray = CalabashBro.values();
        GrandFather grandFatherObject = new GrandFather();
        Creature scorpionObject = new Scorpion();
        Snake snakeObject = new Snake();
  //      snakeObject.cheerMonsters();
        Creature[] monsterArray = new Creature[7];
        for(int i = 0; i < 6; i++) monsterArray[i] = new Pawn();
        monsterArray[6] = scorpionObject;
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.cleanChessBoard();
        chessBoard.calabashChangeDeploy(1, calabashArray);
        chessBoard.monsterChangeDeploy(1, monsterArray);
        chessBoard.setGrandFather(grandFatherObject);
        grandFatherObject.cheerCalabash();
        chessBoard.setSnakeMonarchess(snakeObject);
        snakeObject.cheerMonsters();
        chessBoard.printChessBoard();
        chessBoard.monsterChangeDeploy(2, monsterArray);
        chessBoard.setGrandFather(grandFatherObject);
        grandFatherObject.cheerCalabash();
        chessBoard.setSnakeMonarchess(snakeObject);
        snakeObject.cheerMonsters();
        chessBoard.printChessBoard();
    }
}
