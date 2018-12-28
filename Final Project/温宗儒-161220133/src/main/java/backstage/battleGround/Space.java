package backstage.battleGround;

import annotation.AuthorAnno;
import backstage.creature.Audience.*;
import backstage.creature.battle.*;
import backstage.creature.fighter.gourdboys.*;
import backstage.creature.fighter.minions.Bat;
import backstage.creature.fighter.minions.Centipede;
import backstage.creature.fighter.minions.Toad;
import controller.GourdboysController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@AuthorAnno(time = "2018.12.20",version = "2.0")
public class Space{
    private static Space instance;
    private static Pane creaturePane;
    private static Text text;
    private static String battleString;
    private static final int MAX_ROW = 30;
    private static final int MAX_COW = 40;
    private static Position position[][];  //position数组，用来放葫芦娃
    private static FirstChild firstChild;
    private static GourdBoys gourdBoys;
    private static Minions minions;
    private static Scorpion scorpion;   //蝎子
    private static GrandFather grandFather; //爷爷
    private static Snake snake;
    private static boolean soloEnd = false;  //判断单挑是否结束
    private static boolean warEnd = false;   //战争是否结束
    private static ImageView endImageView;


    public static Space getInstance(){
        if(instance == null){
            synchronized (FifthChild.class) {
                if(instance == null) {
                    instance = new Space();
                }
            }
        }
        return instance;
    }

    private Space(){
        position = new Position[MAX_ROW][MAX_COW];
        firstChild = new FirstChild();
        gourdBoys = new GourdBoys();
        scorpion = new Scorpion();
        grandFather = GrandFather.getInstance(); //爷爷
        snake = Snake.getInstance();                //蛇精
        battleString = "";
    }

    public static void victory() {
        if(minions.getBat().getNumber()<=0 && minions.getCentipede().getNumber()<=0 && minions.getToad().getNumber()<=0){
            endImageView.setImage(new Image("/common/images/victory.jpg"));
            addText("妖精被消灭了，葫芦娃取得胜利！");
        }else{
            addText("战争结束，葫芦娃惨败。");
        }
        endImageView.setVisible(true);

    }


    public void initialize(GameType gameType) {
        if(gameType == GameType.CREATE) {
            createFile();
        }
        positionInit();   //初始化二维战场
        audienceInit();   //爷爷和蛇精就位
        gourdBoysInit();  //葫芦娃就位
        monsterInit(GourdboysController.getBatNumber(),GourdboysController.getCentipedeNumber(),GourdboysController.getToadNumber());    //怪物就位
        gameStart();

    }
    //游戏回放数据
    private void createFile(){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String name = df.format(new Date());
            File file = new File(name + ".gameLog");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            int[] selectedGourdBoys = GourdboysController.getSelectedGourdboys();
            int[] numbers = new int[6];
            for (int number : selectedGourdBoys) {
                numbers[number - 2] = 1;
            }
            StringBuilder firstLine = new StringBuilder();
            for (int number : numbers) {
                firstLine.append(Integer.toString(number)).append(',');
            }
            firstLine.deleteCharAt(firstLine.length()-1);
            out.write(firstLine.toString() + '\n');

            String secondLine = Integer.toString(GourdboysController.getBatNumber())+','+Integer.toString(GourdboysController.getCentipedeNumber())+','+Integer.toString(GourdboysController.getToadNumber())+'\n';
            out.write(secondLine);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //游戏开始
    private void gameStart() {
        endImageView = new ImageView(new Image("/common/images/defeat.jpg"));
        endImageView.setFitWidth(480);
        endImageView.setFitHeight(360);
        endImageView.setLayoutY(210);
        endImageView.setLayoutX(300);
        endImageView.setVisible(false);
        creaturePane.getChildren().add(endImageView);
        //设置三种怪物
        System.out.println("战斗开始");
        System.out.printf("葫芦娃阵营： %s, %s, %s\n" , gourdBoys.getTop().getName(),gourdBoys.getMid().getName(),gourdBoys.getBottom().getName());
        System.out.printf("怪物阵营: %s:%d个, %s:%d个, %s:%d个\n", minions.getBat().getName(),minions.getBat().getNumber(),minions.getCentipede().getName(),minions.getCentipede().getNumber(),minions.getToad().getName(),minions.getToad().getNumber());
        firstChild.start();
        scorpion.start();
        minions.start();
        gourdBoys.start();

    }

    //怪物初始化
    private void monsterInit(int batNumber, int centipedeNumber, int toadNumber) {
        minions = new Minions(batNumber,centipedeNumber,toadNumber);
        position[15][20].setCreature(scorpion,15,20);
        creaturePane.getChildren().addAll(scorpion.getImageView(),scorpion.getRed(),scorpion.getGreen());
        Bat bat = minions.getBat();
        position[8][32].setCreature(bat,8,32);
        Centipede centipede = minions.getCentipede();
        position[15][32].setCreature(centipede,15,32);
        Toad toad = minions.getToad();
        position[22][32].setCreature(toad,22,32);
        creaturePane.getChildren().addAll(bat.getImageView(),bat.getRed(),bat.getGreen(),centipede.getImageView(),centipede.getRed(),centipede.getGreen(),toad.getImageView(),toad.getRed(),toad.getGreen());

    }
    //观众初始化
    private void audienceInit() {
        position[MAX_ROW - 1][0].setCreature(grandFather, MAX_ROW -1,0);
        position[MAX_ROW - 1][MAX_COW - 1].setCreature(snake, MAX_ROW -1, MAX_COW -1);
        grandFather.cheer();
        snake.cheer();
        creaturePane.getChildren().addAll(grandFather.getImageView(),snake.getImageView());
    }
    //战场初始化
    private void positionInit() {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COW; j++)
                position[i][j] = new Position();
        }
        System.out.println("战场初始化成功。");
    }
    //葫芦娃初始化
    private void gourdBoysInit() {
        position[15][19].setCreature(firstChild,15,19);
        creaturePane.getChildren().addAll(firstChild.getImageView(),firstChild.getRed(),firstChild.getGreen());
        for(int i=0; i<3; i++){
            int selectedGourdboys[] = GourdboysController.getSelectedGourdboys();
            GourdBoy gourdBoy = null;
            if(selectedGourdboys[i] <= 7) {
                switch (selectedGourdboys[i]){
                    case 2 : gourdBoy = SecondChild.getInstance(i+1);break;
                    case 3 : gourdBoy = ThirdChild.getInstance(i+1);break;
                    case 4 : gourdBoy = FourthChild.getInstance(i+1);break;
                    case 5 : gourdBoy = FifthChild.getInstance(i+1);break;
                    case 6 : gourdBoy = SixthChild.getInstance(i+1);break;
                    case 7 : gourdBoy = SeventhChild.getInstance(i+1);break;
                }
                if(i==0){gourdBoys.setTop(gourdBoy);}
                else if(i ==1){gourdBoys.setMid(gourdBoy);}
                else {gourdBoys.setBottom(gourdBoy);}
                int locationx = 8 + i*7;
                position[locationx][7].setCreature(gourdBoy, locationx, 7);
                creaturePane.getChildren().addAll(gourdBoy.getImageView(),gourdBoy.getRed(),gourdBoy.getGreen());
            }
        }
    }
    //战局文字添加
    public static void addText(String string){
        battleString += string;
        if(text != null){
            text.setText(battleString);
        }
    }



    public static Scorpion getScorpion() { return scorpion; }
    public static FirstChild getFirstChild(){ return firstChild; }
    public static boolean isSoloEnd() { return soloEnd; }
    public static void setSoloEnd(boolean soloEnd) { Space.soloEnd = soloEnd; }
    public static Position[][] getPosition() { return position; }
    public static GourdBoys getGourdBoys() { return gourdBoys; }
    public static Minions getMinions() { return minions; }
    public static void setText(Text text) { Space.text = text; }

    public static boolean isWarEnd() { return warEnd; }
    public static void setWarEnd(boolean warEnd) { Space.warEnd = warEnd; }
    public static void setCreaturePane(Pane creaturePane) { Space.creaturePane = creaturePane; }



}
