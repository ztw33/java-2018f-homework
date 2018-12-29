import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
    //成员变量
    public Pane pane;
    private Stage primaryStage;
    private Map map;
    private Formation formation;
    private ArrayList<Creature> goodGuysInFormation = new ArrayList<>();
    private ArrayList<Creature> badGuysInFormation = new ArrayList<>();

    //成员函数
    public Pane initialization(){
        //设置界面背景
        pane = new Pane();
        pane.setPrefSize(800, 800);
        this.setBackground();

        //初始化地图
        map = new Map(20);

        //初始化阵型类
        formation = new Formation(this);

        //初始化游戏人物 goodguys
        ArrayList<CalabashBros> calabashBros = new ArrayList<>();
        for(int i=0;i<7;i++)
            calabashBros.add(new CalabashBros(i));
        GrandFather grandFather = new GrandFather();
        for(CalabashBros c : calabashBros){
            goodGuysInFormation.add(c);
        }
        goodGuysInFormation.add(grandFather);
        //初始化游戏人物 badguys
        Snake snake = new Snake();
        Scorpion scorpion = new Scorpion();
        ArrayList<Underling> underlings = new ArrayList<>();
        for(int i=0;i<6;i++)
            underlings.add(new Underling(i));
        badGuysInFormation.add(scorpion);
        for(Underling u : underlings){
            badGuysInFormation.add(u);
        }
        badGuysInFormation.add(snake);

        return pane;
    }

    private void setBackground(){
        TextField textBox = new TextField();
        textBox.setOpacity(0);
        pane.getChildren().add(textBox);
        Image backGroundImage = new Image("file:///../src/pictures/background.png");
        ImageView backGroundImageView = new ImageView();
        backGroundImageView.setImage(backGroundImage);
        backGroundImageView.setFitWidth(800);
        backGroundImageView.setFitHeight(800);
        pane.getChildren().add(backGroundImageView);
    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        setInitialFormation();
        keyBoardListener();
    }

    private void setInitialFormation(){
        Random random = new Random();
        int formationNumber = random.nextInt(8);
        switch(formationNumber){
            case 0:formation.HeYi(goodGuysInFormation,8,10,"Left");break;
            case 1:formation.HengE(goodGuysInFormation,8,10,"Left");break;
            case 2:formation.YanXing(goodGuysInFormation,8,10,"Left");break;
            case 3:formation.ChangShe(goodGuysInFormation,8,10,"Left");break;
            case 4:formation.YuLin(goodGuysInFormation,8,10,"Left");break;
            case 5:formation.FangYuan(goodGuysInFormation,8,10,"Left");break;
            case 6:formation.YanYue(goodGuysInFormation,8,10,"Left");break;
            case 7:formation.FengShi(goodGuysInFormation,8,10,"Left");break;
        }
        formationNumber = random.nextInt(8);
        switch(formationNumber){
            case 0:formation.HeYi(badGuysInFormation,11,10,"Right");break;
            case 1:formation.HengE(badGuysInFormation,11,10,"Right");break;
            case 2:formation.YanXing(badGuysInFormation,11,10,"Right");break;
            case 3:formation.ChangShe(badGuysInFormation,11,10,"Right");break;
            case 4:formation.YuLin(badGuysInFormation,11,10,"Right");break;
            case 5:formation.FangYuan(badGuysInFormation,11,10,"Right");break;
            case 6:formation.YanYue(badGuysInFormation,11,10,"Right");break;
            case 7:formation.FengShi(badGuysInFormation,11,10,"Right");break;
        }
        //formation.LieDui(goodGuysInFormation,0,0,"Left");
        //formation.LieDui(badGuysInFormation, map.getSize()-1,0,"Right");
    }
    private void changeFormation(){
        formation.ChangShe(goodGuysInFormation,8,10,"Left");
        formation.YanYue(badGuysInFormation, 11,10,"Right");
    }

    public void playback(char[] charArray){
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='M'){
                i++;
                if(charArray[i]=='G'){
                    i++;
                    int order = Integer.parseInt(String.valueOf(charArray[i]));i++;
                    int x = Integer.parseInt(String.valueOf(charArray[i]))*10+Integer.parseInt(String.valueOf(charArray[i+1]));i+=2;
                    int y = Integer.parseInt(String.valueOf(charArray[i]))*10+Integer.parseInt(String.valueOf(charArray[i+1]));i++;
                    moveCreature(goodGuysInFormation.get(order),x,y);
                }
                else if(charArray[i]=='B'){
                    i++;
                    int order = Integer.parseInt(String.valueOf(charArray[i]));i++;
                    int x = Integer.parseInt(String.valueOf(charArray[i]))*10+Integer.parseInt(String.valueOf(charArray[i+1]));i+=2;
                    int y = Integer.parseInt(String.valueOf(charArray[i]))*10+Integer.parseInt(String.valueOf(charArray[i+1]));i++;
                    moveCreature(badGuysInFormation.get(order),x,y);
                }
            }
            else
                return;
        }
    }

    public void setCreature(Creature creature, int x, int y){ //x和y是地图坐标，不是像素坐标！
        ImageView creatureImageView = getImageView(creature);
        creatureImageView.setX(x*40);
        creatureImageView.setY(y*40);
        pane.getChildren().add(creatureImageView);
        map.setCreature(creature,x,y); //修改地图
    }
    public void moveCreature(Creature creature, int x, int y){
        if(x==creature.getX()&&y==creature.getY()) //位置其实没有变
            return;
        ImageView creatureImageView = getImageView(creature);
        Path path = new Path(new MoveTo(creature.getX()*40+20,creature.getY()*40+20), new LineTo (x*40+20,y*40+20));
        path.setStroke(Color.TRANSPARENT); //path.getStrokeDashArray().setAll(5d, 5d);
        pane.getChildren().add(path);
        PathTransition transition = new PathTransition(Duration.seconds(2), path, creatureImageView);
        transition.play();
        map.moveCreature(creature,x,y);
    }
    public void removeCreature(Creature creature){
        ImageView creatureImageView = getImageView(creature);
        pane.getChildren().remove(creatureImageView);
        map.removeCreature(creature.getX(),creature.getY());
    }

    private ImageView getImageView(Creature creature){
        ImageView creatureImageView = null;
        switch(creature.getName()){
            case Calabash1:     creatureImageView = CreaturePictures.Calabash1.imageView;break;
            case Calabash2:     creatureImageView = CreaturePictures.Calabash2.imageView;break;
            case Calabash3:     creatureImageView = CreaturePictures.Calabash3.imageView;break;
            case Calabash4:     creatureImageView = CreaturePictures.Calabash4.imageView;break;
            case Calabash5:     creatureImageView = CreaturePictures.Calabash5.imageView;break;
            case Calabash6:     creatureImageView = CreaturePictures.Calabash6.imageView;break;
            case Calabash7:     creatureImageView = CreaturePictures.Calabash7.imageView;break;
            case GrandFather:   creatureImageView = CreaturePictures.GrandFather.imageView;break;
            case Snake:          creatureImageView = CreaturePictures.Snake.imageView;break;
            case Scorpion:      creatureImageView = CreaturePictures.Scorpion.imageView;break;
            case Underling1:    creatureImageView = CreaturePictures.Underling1.imageView;break;
            case Underling2:     creatureImageView = CreaturePictures.Underling2.imageView;break;
            case Underling3:    creatureImageView = CreaturePictures.Underling3.imageView;break;
            case Underling4:     creatureImageView = CreaturePictures.Underling4.imageView;break;
            case Underling5:    creatureImageView = CreaturePictures.Underling5.imageView;break;
            case Underling6:     creatureImageView = CreaturePictures.Underling6.imageView;break;
            case Underling7:    creatureImageView = CreaturePictures.Underling7.imageView;break;
            case Underling8:     creatureImageView = CreaturePictures.Underling8.imageView;break;
            case Undefined:     creatureImageView = CreaturePictures.Undefined.imageView;break;
        }
        return creatureImageView;
    }

    public void keyBoardListener(){
        pane.setOnKeyReleased((KeyEvent ke) -> {
            //System.out.println(ke.getText());
            //dealWithKeyBoardInput(ke.getText());
            char c = ke.getText().charAt(0);
            switch(c){
                 //case ' ': setInitialFormation();break;
                 case 'l': showHistoryFileOpenDialog();break;
                 case 's': saveHistoryFile();break;
                 default: System.out.println(c);
            }
        });
    }

    private void showHistoryFileOpenDialog(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("打开历史游戏记录");
        File file = fileChooser.showOpenDialog(primaryStage);
        if(file!=null)
            openHistoryFile(file);
    }
    private void openHistoryFile(File file){
        FileReader freader = null;
        char[] charArray = new char[1024];
        try {
            freader = new FileReader(file);
            freader.read(charArray);
        }
        catch(Exception e){
            System.out.println("Error when reading history file!");
            showHistoryFileOpenDialog();
        }
        finally {
            try {
                freader.close();
            }
            catch(Exception e){
                throw new RuntimeException("关闭输入流失败");
            }
        }
        playback(charArray);
    }
    private void saveHistoryFile() {
        ArrayList<String> stringArray = map.getHistory();
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter("history.txt");
            for (String s : stringArray) {
                fwriter.write(s);
            }
            fwriter.flush();
        } catch (Exception e) {
            throw new RuntimeException("文件输出流失败！");
        } finally {
            try {
                fwriter.close();
            } catch (Exception e) {
                throw new RuntimeException("文件输出流失败！");
            }
        }
    }
}
