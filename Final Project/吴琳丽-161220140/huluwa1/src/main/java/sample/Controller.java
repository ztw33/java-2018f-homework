package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.TimerTask;
import com.company.BattleField.BattleField;
import com.company.Creature.*;
import com.company.Formation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.sleep;

public class Controller {
    Scanner in=new Scanner(System.in);
    BattleField BF=new BattleField();//创建战场
    HuluBrothers HuluFamily = new HuluBrothers();//产生葫芦娃兄弟
    Monsters LouluoMonsters= new Monsters();//产生妖怪们
    Grandpa Yeye=new Grandpa();//产生爷爷
    SheJing she=new SheJing();//产生蛇精
    //创建线程
    Thread thread1 = new Thread(HuluFamily.getHulu()[0]);
    Thread thread2 = new Thread(HuluFamily.getHulu()[1]);
    Thread thread3 = new Thread(HuluFamily.getHulu()[2]);
    Thread thread4 = new Thread(HuluFamily.getHulu()[3]);
    Thread thread5 = new Thread(HuluFamily.getHulu()[4]);
    Thread thread6 = new Thread(HuluFamily.getHulu()[5]);
    Thread thread7 = new Thread(HuluFamily.getHulu()[6]);
    Thread thread8 = new Thread(Yeye);
    Thread thread9 = new Thread(LouluoMonsters.getmonsters()[0]);
    Thread thread10 = new Thread(LouluoMonsters.getmonsters()[1]);
    Thread thread11 = new Thread(LouluoMonsters.getmonsters()[2]);
    Thread thread12 = new Thread(LouluoMonsters.getmonsters()[3]);
    Thread thread13 = new Thread(LouluoMonsters.getmonsters()[4]);
    Thread thread14 = new Thread(LouluoMonsters.getmonsters()[5]);
    Thread thread15 = new Thread(LouluoMonsters.getmonsters()[6]);
    Thread thread16 = new Thread(she);

    ChangShe CreatureChangShe=new ChangShe();//产生长蛇队形
    HeYi CreatureHeYi = new HeYi();//产生鹤翼队形
    YanXing CreatureYanXing = new YanXing();//产生雁行队形
    HengE CreatureHengE = new HengE();//产生衡轭队形
    YuLin CreatureYuLin = new YuLin();//产生鱼鳞队形
    FangYuan CreatureFangYuan = new FangYuan();//产生方円队形
    YanYue CreatureYanYue = new YanYue();//产生偃月队形
    FengShi CreatureFengShi = new FengShi();//产生锋失队形

    int Hulux;
    int Huluy;
    int XieZix;
    int XieZiy;
    int hulunum=0;
    int yaojingnum=0;
    @FXML
    public ImageView hulu11;
    @FXML
    private Canvas hulucanvas;
    @FXML
    private GraphicsContext gc ;

    Image image1= new Image("image/1.jpg");
    Image image2= new Image("image/2.jpg");
    Image image3= new Image("image/3.jpg");
    Image image4= new Image("image/4.jpg");
    Image image5= new Image("image/5.jpg");
    Image image6= new Image("image/6.jpg");
    Image image7= new Image("image/7.jpg");
    Image imagelouluo= new Image("image/louluo.png");
    Image imagexiezijing= new Image("image/xiezijing.png");
    Image imageyeye= new Image("image/yeye.png");
    Image imageshejing= new Image("image/shejing.png");
    Image imagedead= new Image("image/dead.jpg");
    Image imagehuluwin= new Image("image/huluwin.jpg");
    Image imageyaoguaiwin= new Image("image/yaoguaiwin.jpg");

    ExecutorService fixedThreadPool;
    ArrayList<BattleField> bfs = new  ArrayList<BattleField>();
    boolean save=false;
    boolean back=false;
    boolean isplay=false;
    int count=0;
    final FileChooser fileChooser = new FileChooser();
    File fileopen = new File(("c:\\data/c.txt"));
    File filesave = new File(("c:\\data/c.txt"));

    @FXML protected void handleautoRunUpdateCombox() throws IOException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (!back) { //这不是回放
                            BF = Creature.getBattleFieldcreature();//改变战场的状态
                            if (!save) { //还没有保存
                                bfs.add(new BattleField(BF));//存入战场信息
                                scanbf();//刷新界面
                                if (BF.getgoodnum() == 0) {//如果好的全部死掉了
                                    gc.drawImage(imageyaoguaiwin, 100, 100, 500, 300);
                                    fixedThreadPool.shutdown();
                                    try {
                                        savefile( );//存入文件
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                else if (BF.getbadnum() == 0) {//如果坏的全部死掉了
                                    gc.drawImage(imagehuluwin, 100, 100, 500, 300);
                                    fixedThreadPool.shutdown();
                                    try {
                                        savefile();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }
                        }
                        else {//如果是回放
                            try {//控制速度
                                sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(count < bfs.size()) {
                                BF = bfs.get(count++);
                                BF.displayField();
                                scanbf();//显示战场

                            }
                            if (BF.getgoodnum() == 0) {
                                gc.drawImage(imageyaoguaiwin, 100, 100, 500, 300);
                                back=false;
                            } else if (BF.getbadnum() == 0) {
                                gc.drawImage(imagehuluwin, 100, 100, 500, 300);
                                back=false;
                            }
                        }
                    }
                });
            }
        }, 100, 100);
    }
    void savefile() throws IOException {
        FileOutputStream fileInputStream = new FileOutputStream(filesave);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        for(BattleField c:bfs)
            objectOutputStream.writeObject(c);
        System.out.println("bf对象序列化成功！");
        save = true;
        objectOutputStream.close();
    }

    @FXML
    void openfile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileopen);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        bfs.clear();
        while (fileInputStream.available() > 0) {
            BattleField a=(BattleField) objectInputStream.readObject();
            bfs.add(a);
        }
        BF = bfs.get(0);
        count=0;
        back=true;
    }

    public void startgame() throws IOException {
        bfs.clear();
        isplay=true;
        save=false;
        fixedThreadPool = Executors.newFixedThreadPool(16);
        fixedThreadPool.execute(thread1);
        fixedThreadPool.execute(thread2);
        fixedThreadPool.execute(thread3);
        fixedThreadPool.execute(thread4);
        fixedThreadPool.execute(thread5);
        fixedThreadPool.execute(thread6);
        fixedThreadPool.execute(thread7);
        fixedThreadPool.execute(thread8);
        fixedThreadPool.execute(thread9);
        fixedThreadPool.execute(thread10);
        fixedThreadPool.execute(thread11);
        fixedThreadPool.execute(thread12);
        fixedThreadPool.execute(thread13);
        fixedThreadPool.execute(thread14);
        fixedThreadPool.execute(thread15);
        fixedThreadPool.execute(thread16);
        System.out.println("开始");
        handleautoRunUpdateCombox();
    }
    public void runmain(ActionEvent actionEvent) throws IOException {
        startgame();
    }

    public void displaybf(){
        BF.clearField();
        switch (hulunum){
            case 1:CreatureChangShe.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 2:CreatureHeYi.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 3:CreatureYanXing.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 4:CreatureHengE.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 5:CreatureYuLin.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 6:CreatureFangYuan.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 7:CreatureYanYue.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
            case 8:CreatureFengShi.setCreatures(BF.getField(),Hulux,Huluy,HuluFamily.getHulu());BF.setgoodnum(8);break;
        }
        switch (yaojingnum){
            case 1:CreatureChangShe.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 2:CreatureHeYi.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 3:CreatureYanXing.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 4:CreatureHengE.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 5:CreatureYuLin.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 6:CreatureFangYuan.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 7:CreatureYanYue.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
            case 8:CreatureFengShi.setCreatures(BF.getField(),XieZix,XieZiy,LouluoMonsters.getmonsters());BF.setbadnum(8);break;
        }
        if(hulunum!=0)
            Yeye.creatureCheer(BF.getField(),4,0);
        if(yaojingnum!=0)
            she.creatureCheer(BF.getField(),3,13);
        Creature.setBattleFieldcreature (BF);
        scanbf();
    }

    public void scanbf(){
        gc=hulucanvas.getGraphicsContext2D();
        gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
        for(int i = 0;i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                if(BF.getField()[i][j].creature.getisalive())
                    drawcreature(BF.getField()[i][j].creature.getname(),j,i);
                else
                    gc.drawImage(imagedead,j*45,i*45,40,40);
            }
        }
    }

    public void drawcreature(String a,int x,int y){
        if(a.equals("NULL"))
            return;
        else if(a.equals("老大"))
            gc.drawImage(image1,x*45,y*45,40,40);
        else if(a.equals("老二"))
            gc.drawImage(image2,x*45,y*45,40,40);
        else if(a.equals("老三"))
            gc.drawImage(image3,x*45,y*45,40,40);
        else if(a.equals("老四"))
            gc.drawImage(image4,x*45,y*45,40,40);
        else if(a.equals("老五"))
            gc.drawImage(image5,x*45,y*45,40,40);
        else if(a.equals("老六"))
            gc.drawImage(image6,x*45,y*45,40,40);
        else if(a.equals("老七"))
            gc.drawImage(image7,x*45,y*45,40,40);
        else if(a.equals("小喽啰"))
            gc.drawImage(imagelouluo,x*45,y*45,40,40);
        else if(a.equals("蝎子精"))
            gc.drawImage(imagexiezijing,x*45,y*45,40,40);
        else if(a.equals("爷爷"))
            gc.drawImage(imageyeye,x*45,y*45,40,40);
        else if(a.equals("蛇精"))
            gc.drawImage(imageshejing,x*45,y*45,40,40);
    }
    public void huluchangshe(ActionEvent actionEvent) {
        hulunum=1;
        Hulux=1;
        Huluy=1;
        displaybf();
    }

    public void yaoguaichangshe(ActionEvent actionEvent) {
        yaojingnum=1;
        XieZix=1;
        XieZiy=9;
        displaybf();
    }

    public void huluheyan(ActionEvent actionEvent) {
        hulunum=2;
        Hulux=1;
        Huluy=1;
        displaybf();
    }

    public void yaoguaiheyan(ActionEvent actionEvent) {
        yaojingnum=2;
        XieZix=1;
        XieZiy=9;
        displaybf();
    }

    public void huluyanxing(ActionEvent actionEvent) {
        hulunum=3;
        Hulux=7;
        Huluy=0;
        displaybf();
    }

    public void yaoguaiyanxing(ActionEvent actionEvent) {
        yaojingnum=3;
        XieZix=6;
        XieZiy=9;
        displaybf();
    }

    public void huluhenge(ActionEvent actionEvent) {
        hulunum=4;
        Hulux=1;
        Huluy=1;
        displaybf();
    }

    public void yaoguaihenge(ActionEvent actionEvent) {
        yaojingnum=4;
        XieZix=1;
        XieZiy=9;
        displaybf();
    }

    public void huluyulin(ActionEvent actionEvent) {
        hulunum=5;
        Hulux=4;
        Huluy=1;
        displaybf();
    }

    public void yaoguaiyulin(ActionEvent actionEvent) {
        yaojingnum=5;
        XieZix=4;
        XieZiy=9;
        displaybf();
    }

    public void hulufangyuan(ActionEvent actionEvent) {
        hulunum=6;
        Hulux=4;
        Huluy=1;
        displaybf();
    }

    public void yaoguaifangyuan(ActionEvent actionEvent) {
        yaojingnum=6;
        XieZix=4;
        XieZiy=9;
        displaybf();
    }

    public void huluyanyue(ActionEvent actionEvent) {
        hulunum=7;
        Hulux=4;
        Huluy=1;
        displaybf();
    }

    public void yaoguaiyanyue(ActionEvent actionEvent) {
        yaojingnum=7;
        XieZix=4;
        XieZiy=9;
        displaybf();
    }

    public void hulufengshi(ActionEvent actionEvent) {
        hulunum=8;
        Hulux=5;
        Huluy=1;
        displaybf();
    }

    public void yaoguaifengshi(ActionEvent actionEvent) {
        yaojingnum=8;
        XieZix=5;
        XieZiy=9;
        displaybf();
    }

    public void closegame(ActionEvent actionEvent) {
        fixedThreadPool.shutdown();
        System.out.println("close------------");
    }

    public void replaygame(ActionEvent actionEvent) throws IOException {
        // fixedThreadPool.shutdown();
         gc=hulucanvas.getGraphicsContext2D();
         gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
         BF.clearField();
         BF.setgoodnum(1);
         BF.setbadnum(1);
         HuluFamily = new HuluBrothers();//产生葫芦娃兄弟
         LouluoMonsters= new Monsters();//产生妖怪们
         Yeye=new Grandpa();//产生爷爷
         she=new SheJing();//产生蛇精
         isplay = true;
         thread1 = new Thread(HuluFamily.getHulu()[0]);
         thread2 = new Thread(HuluFamily.getHulu()[1]);
         thread3 = new Thread(HuluFamily.getHulu()[2]);
         thread4 = new Thread(HuluFamily.getHulu()[3]);
         thread5 = new Thread(HuluFamily.getHulu()[4]);
         thread6 = new Thread(HuluFamily.getHulu()[5]);
         thread7 = new Thread(HuluFamily.getHulu()[6]);
         thread8 = new Thread(Yeye);
         thread9 = new Thread(LouluoMonsters.getmonsters()[0]);
         thread10 = new Thread(LouluoMonsters.getmonsters()[1]);
         thread11 = new Thread(LouluoMonsters.getmonsters()[2]);
         thread12 = new Thread(LouluoMonsters.getmonsters()[3]);
         thread13 = new Thread(LouluoMonsters.getmonsters()[4]);
         thread14 = new Thread(LouluoMonsters.getmonsters()[5]);
         thread15 = new Thread(LouluoMonsters.getmonsters()[6]);
         thread16 = new Thread(she);
         //startgame();
    }

    public void kongge(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.SPACE){
            startgame();
        }
        else if(keyEvent.getCode() == KeyCode.L&&isplay==false){
            choosefilefunc();
        }
    }
    public void choosefilefunc(){
        fileopen = fileChooser.showOpenDialog(null);
    }
    public void choosefile(ActionEvent actionEvent) {
        choosefilefunc();
    }
}
