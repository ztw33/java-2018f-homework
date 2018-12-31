package backstage;

import backstage.creature.Audience.*;
import backstage.creature.Creature;
import backstage.creature.fighter.*;
import backstage.formation.*;
import javafx.geometry.Pos;

import java.util.Random;

public class Space {
    private static int maxRow = 30;    //最大行数
    private static int maxCow = 40;    //最大列数

    private static Position[][] position = new Position[maxRow][maxCow]; //position数组，用来放葫芦娃
    private static GourdBoy[] gourdBoys = new GourdBoy[7];    //7个葫芦兄弟
    private static GrandFather grandFather = new GrandFather(); //爷爷
    private static Snake snake = new Snake();                //蛇精


    public void initialize() {

        //初始化出一个position数组来存放各种生物
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCow; j++)
                position[i][j] = new Position();
        }
        System.out.println("战场初始化成功。");

        //把爷爷和蛇精放在空间的左下角和右下角
        position[maxRow - 1][0].setCreature(grandFather);
        position[maxRow - 1][maxCow - 1].setCreature(snake);
        grandFather.cheer();
        snake.cheer();

        //得到随机的葫芦娃
        for (int i = 0; i < 7; i++) {
            gourdBoys[i] = new GourdBoy(Attribute.values()[i]);
        }
        Random random = new Random();
        int maxRandomNumber = 7;
        int randomNumber = 0;
        for (int i = 0; i < 7; i++) {
            randomNumber = random.nextInt(maxRandomNumber);
            GourdBoy temp = gourdBoys[randomNumber];
            maxRandomNumber--;
            gourdBoys[randomNumber] = gourdBoys[maxRandomNumber];
            gourdBoys[maxRandomNumber] = temp;
        }
        setLongSnake(gourdBoys);
    }

    public Position[][] randomFormation(int selectIndex){
        Formation formation = Formation.values()[selectIndex];
        switch (formation) {
            case CRANEWING:
                System.out.println("现在变换为鹤翼阵法");
                setCraneWing();
                break;
            case WILDGOOSE:
                System.out.println("现在变换为雁行阵法");
                setWildGoose();
                break;
            case DOUBLEYOKE:
                System.out.println("现在变换为衡軛阵法");
                setDoubleYoke();
                break;
            case FISHSCALE:
                System.out.println("现在变换为鱼鳞阵法");
                setFishScale();
                break;
            case SQUAREDOOR:
                System.out.println("现在变换为方门阵法");
                setSquareDoor();
                break;
            case CRESCENTMOON:
                System.out.println("现在变换为偃月阵法");
                setCrescentMoon();
                break;
            case FENGSHI:
                System.out.println("现在变换为锋矢阵法");
                setFengShi();
                break;
        }


        return position;

    }

//    public static void main(String[] args){
//
//        //初始化出一个position数组来存放各种生物
//        for(int i = 0; i< maxRow; i++){
//            for(int j = 0; j< maxCow; j++)
//                position[i][j] = new Position();
//        }
//        System.out.println("战场初始化成功。");
//
//        //把爷爷和蛇精放在空间的左下角和右下角
//        position[maxRow -1][0].setCreature(grandFather);
//        position[maxRow -1][maxCow -1].setCreature(snake);
//        grandFather.cheer();
//        snake.cheer();
//
//        //得到随机的葫芦娃
//        for(int i=0;i<7;i++){ gourdBoys[i] = new GourdBoy(Attribute.values()[i]); }
//        Random random = new Random();
//        int maxRandomNumber = 7;
//        int randomNumber = 0;
//        for(int i=0;i<7;i++){
//            randomNumber = random.nextInt(maxRandomNumber);
//            GourdBoy temp = gourdBoys[randomNumber];
//            maxRandomNumber--;
//            gourdBoys[randomNumber] = gourdBoys[maxRandomNumber];
//            gourdBoys[maxRandomNumber] = temp;
//        }
//        setLongSnake(gourdBoys);
//
//        int num=0;
//        while (num++<7) {
//
//            maxRandomNumber = 7;
////            randomNumber = random.nextInt(maxRandomNumber) + 1;
//            randomNumber = 5;
//            Formation formation = Formation.values()[randomNumber];
//            switch (formation) {
//                case CRANEWING:
//                    System.out.println("现在变换为鹤翼阵法");
//                    setCraneWing();
//                    break;
//                case WILDGOOSE:
//                    System.out.println("现在变换为雁行阵法");
//                    setWildGoose();
//                    break;
//                case DOUBLEYOKE:
//                    System.out.println("现在变换为衡軛阵法");
//                    setDoubleYoke();
//                    break;
//                case FISHSCALE:
//                    System.out.println("现在变换为鱼鳞阵法");
//                    setFishScale();
//                    break;
//                case SQUAREDOOR:
//                    System.out.println("现在变换为方门阵法");
//                    setSquareDoor();
//                    break;
//                case CRESCENTMOON:
//                    System.out.println("现在变换为偃月阵法");
//                    setCrescentMoon();
//                    break;
//                case FENGSHI:
//                    System.out.println("现在变换为锋矢阵法");
//                    setFengShi();
//                    break;
//            }
//
//            print();
//        }
//
//
//    }

    private static void  setLongSnake(GourdBoy[] gourdBoys){
        for(int i=0; i<7; i++){
            for(int j=i+1; j<7; j++){
                if(gourdBoys[i].getRank() > gourdBoys[j].getRank()){
                    GourdBoy temp = gourdBoys[i];
                    gourdBoys[i] = gourdBoys[j];
                    gourdBoys[j] = temp;
                }
            }
        }

        int length = gourdBoys.length;
        int cow = maxCow /4;
        int row = maxRow /2 - length /2;

        int i=0;
        while (i < length){
            position[row++][cow].setCreature(gourdBoys[i]);
            i++;
        }



    }

    //鹤翼
    private static void setCraneWing(){
        cleanRightHalf();
        int row = 3*maxRow/5;
        int cow = 3*maxCow/4;
        int len = maxRow/4;
        int i=0;
        for(;i<len;i++){
            position[row-i][cow+i].setCreature(new Minions());
            position[row-i][cow-i].setCreature(new Minions());
        }
        position[row-i][cow-i].setCreature(new Scorpion());
        position[row-i][cow+i].setCreature(new Minions());
    }

    //雁行
    private static void setWildGoose(){
        cleanRightHalf();
        int row = 2*maxRow/5;
        int cow = 4*maxCow/5;
        int len = maxRow/3;
        int i=0;
        for(;i<len;i++){ position[row+i][cow-i].setCreature(new Minions()); }
        position[row+i][cow-i].setCreature(new Scorpion());
    }

    //衡軛
    private static void setDoubleYoke(){
        cleanRightHalf();
        int row = maxRow/6;
        int cow = 3*maxCow/4;
        int len = 2*maxRow/3;
        boolean flag= true;
        position[row++][cow-1].setCreature(new Scorpion());
        while (len>0){
            len--;
            if(flag){
                position[row++][cow].setCreature(new Minions());
            }else {
                position[row++][cow-1].setCreature(new Minions());
            }
            flag = !flag;
        }
    }

    //鱼鳞
    private static void setFishScale(){
        cleanRightHalf();
        int row = maxRow/3;
        int cow = 3*maxCow/4;
        int len = maxRow/3;
        position[row++][cow].setCreature(new Scorpion());
        for(int i=2;i<=len; i++){
            int index = 0;
            while (index<i){
                position[row][cow+index].setCreature(new Minions());
                position[row][cow-index].setCreature(new Minions());
                index++;
            }
            row++;
        }

        for(int i=0;i<maxRow/6;i++){
            position[row][cow-1].setCreature(new Minions());
            position[row][cow].setCreature(new Minions());
            position[row][cow+1].setCreature(new Minions());
            row++;
        }
    }

    //方门
    private static void setSquareDoor(){
        cleanRightHalf();
        int row = maxRow/6;
        int cow = 3*maxCow/4;
        int len = maxRow/4;
        position[row++][cow].setCreature(new Scorpion());
        int i=1;
        while (i<len){
            position[row][cow-i].setCreature(new Minions());
            position[row][cow+i].setCreature(new Minions());
            row++;i++;
        }
        while (i>=0){
            position[row][cow-i].setCreature(new Minions());
            position[row][cow+i].setCreature(new Minions());
            row++;i--;
        }
    }

    //偃月
    private static void setCrescentMoon(){
        cleanRightHalf();
        int row = maxRow/2;
        int cow = 3*maxCow/5;
        int len = maxRow/4;
        position[row][cow].setCreature(new Scorpion());
        int i=1;
        for(;i<len;i++){
            position[row-i][cow+i].setCreature(new Minions());
            position[row+i][cow+i].setCreature(new Minions());
        }
        position[row-i][cow+i].setCreature(new Minions());
        position[row+i][cow+i].setCreature(new Minions());
    }

    //锋矢
    private static void setFengShi(){
        cleanRightHalf();
        int row = maxRow/4;
        int cow = 3*maxCow/4;
        int len = 2*maxRow/3;
        position[--row][cow].setCreature(new Scorpion());
        int i=1;
        for(;i<len;i++){ position[row+i][cow].setCreature(new Minions()); }
        for(i=1;i<len/2;i++){
            position[row+i][cow-i].setCreature(new Minions());
            position[row+i][cow+i].setCreature(new Minions());
        }

    }

    private static void cleanRightHalf(){
        for(int i=0; i<maxRow; i++){
            for(int j=maxCow/2; j<maxCow; j++){
                position[i][j].clean();
            }
        }
        position[maxRow -1][maxCow -1].setCreature(snake);
    }

    private static void print(){
        for(int i = 0; i< maxRow; i++){
            for(int j = 0; j< maxCow; j++){
                position[i][j].print();
            }
            System.out.print('\n');
        }
    }




    public static int getMaxRow() {
        return maxRow;
    }

    public static int getMaxCow() {
        return maxCow;
    }
}
