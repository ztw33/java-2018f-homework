import java.util.*;

public class ChessBoard {
    private ChessBoardElement[][] chessBoardView = new ChessBoardElement[7][15];//棋盘暂定7*15格局，因为考虑到N*N不是很方便实际
    ChessBoard(){
        for(int i = 0; i < 7 ; i++){
            for(int j = 0; j < 15; j++){
                chessBoardView[i][j] = new ChessBoardElement();
                chessBoardView[i][j].changeTaken(false);
                chessBoardView[i][j].changeTakenByCalabash(false);
                chessBoardView[i][j].changeTakenByMonster(false);
                chessBoardView[i][j].changeTakenByGrandFa(false);
                chessBoardView[i][j].changeTakenByScorpion(false);
                chessBoardView[i][j].changeTakenBySnake(false);
            }
        }
    }

    public void cleanChessBoard(){
        for(int i = 0; i < 7 ; i++){
            for(int j = 0; j < 15; j++){
                chessBoardView[i][j].changeTaken(false);
                chessBoardView[i][j].changeTakenByCalabash(false);
                chessBoardView[i][j].changeTakenByMonster(false);
                chessBoardView[i][j].changeTakenByGrandFa(false);
                chessBoardView[i][j].changeTakenByScorpion(false);
                chessBoardView[i][j].changeTakenBySnake(false);
            }
        }
    }

    public void calabashChangeDeploy(int key, CalabashBro[] arr){
        switch(key){
            case 1: calabashLongSnakeDeploy(arr); break;
            default: System.out.println("阵法序列错啦！"); break;
        }
    }

    public void calabashLongSnakeDeploy(CalabashBro[] arr){
        for(int i = 0; i < 7; i++){
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTaken(false);
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTakenByCalabash(false);
            arr[i].changePosX(i);
            arr[i].changePosY(3);
            chessBoardView[i][3].changeTaken(true);
            chessBoardView[i][3].changeTakenByCalabash(true);
        }
    }

    public void monsterChangeDeploy(int key, Creature[] arr){
        switch(key){
            case 1: monsterLongSnakeDeploy(arr); break;
            case 2: monsterThwartwiseDeploy(arr); break;
            default: System.out.println("阵法序列错啦！"); break;
        }
    }

    public void monsterLongSnakeDeploy(Creature[] arr){
        for(int i = 0; i < 7; i++){
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTaken(false);
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTakenByMonster(false);
            if(chessBoardView[arr[i].getPosX()][arr[i].getPosY()].getTakenByScorpion())
                chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTakenByScorpion(false);
            arr[i].changePosX(i);
            arr[i].changePosY(12);
            chessBoardView[i][12].changeTaken(true);
            if(arr[i].name == "蝎子精")
                chessBoardView[i][12].changeTakenByScorpion(true);
            else chessBoardView[i][12].changeTakenByMonster(true);
        }
    }

    public void monsterThwartwiseDeploy(Creature[] arr){
        for(int i = 0; i < 7; i++){
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTaken(false);
            chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTakenByMonster(false);
            if(chessBoardView[arr[i].getPosX()][arr[i].getPosY()].getTakenByScorpion())
                chessBoardView[arr[i].getPosX()][arr[i].getPosY()].changeTakenByScorpion(false);
            arr[i].changePosX(i);
            arr[i].changePosY(12 - (i % 2));
            chessBoardView[i][12 - (i % 2)].changeTaken(true);
            if(arr[i].name == "蝎子精")
                chessBoardView[i][12 - (i % 2)].changeTakenByScorpion(true);
            else chessBoardView[i][12 - (i % 2)].changeTakenByMonster(true);

        }
    }

    public void setGrandFather(GrandFather grandFatherObject){
        Random ra = new Random();
        boolean findPosition = false;
        int PosX, PosY;
        while(!findPosition){
            PosX = ra.nextInt(7);
            PosY = ra.nextInt(6);
            if(!chessBoardView[PosX][PosY].getTakenValue()){
                chessBoardView[grandFatherObject.getPosX()][grandFatherObject.getPosY()].changeTaken(false);
                chessBoardView[grandFatherObject.getPosX()][grandFatherObject.getPosY()].changeTakenByGrandFa(false);
                chessBoardView[PosX][PosY].changeTaken(true);
                chessBoardView[PosX][PosY].changeTakenByGrandFa(true);
                findPosition = true;
                grandFatherObject.changePosX(PosX);
                grandFatherObject.changePosY(PosY);
            }
        }
    }

    public void setSnakeMonarchess(Snake snakeObject){
        Random ra = new Random();
        boolean findPosition = false;
        int PosX, PosY;
        while(!findPosition){
            PosX = ra.nextInt(7);
            PosY = ra.nextInt(6) + 9;
            if(!chessBoardView[PosX][PosY].getTakenValue()){
                chessBoardView[snakeObject.getPosX()][snakeObject.getPosY()].changeTaken(false);
                chessBoardView[snakeObject.getPosX()][snakeObject.getPosY()].changeTakenBySnake(false);
                chessBoardView[PosX][PosY].changeTaken(true);
                chessBoardView[PosX][PosY].changeTakenBySnake(true);
                findPosition = true;
                snakeObject.changePosX(PosX);
                snakeObject.changePosY(PosY);
            }
        }
    }

    public void printChessBoard(){
        System.out.println("当前对战情况如下(-为空地,B为葫芦娃,@为爷爷,M为喽啰,S为蝎子精,$为蛇精)：");
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 15; j++){
                ChessBoardElement boardNode = chessBoardView[i][j];
                if(!boardNode.getTakenValue()){
                    System.out.print("-");
                }else if(boardNode.getTakenByCalabash()){
                    System.out.print("B");
                }else if(boardNode.getTakenByGrandFa()){
                    System.out.print("@");
                }else if(boardNode.getTakenBySnake()){
                    System.out.print("$");
                }else if(boardNode.getTakenByScorpion()){
                    System.out.print("S");
                }else if(boardNode.getTakenByMonster()){
                    System.out.print("M");
                }
            }
            System.out.println();
        }
    }
}
