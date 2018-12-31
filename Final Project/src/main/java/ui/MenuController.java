package ui;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import myfile.MyJdom;
import Bullet.Bullet;
import Creature.Creature;
import Instructor.Instructor;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import Formation.Formation;
import MyMap.MyMap;
import MyMap.MyPosition;
import Instructor.Global;
import java.util.concurrent.*;
import Formation.FormationAdapter;

import javax.swing.*;

import static Creature.CalaBrosAdapter.CalaBros;
import static Creature.CommanderCalabro.Grandpa;
import static Creature.CommanderMonster.Serpent;
import static Creature.Monster.Scorpion;
import static Creature.MonsterAdapter.mices;
import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

import myfile.Act;
public class MenuController {
    @FXML
    Button start;
    @FXML
    Button end;
    @FXML
    ComboBox formaHulu;
    @FXML
    ComboBox formaMons;
    @FXML
    Button readfile;
    @FXML
    TextField speed;
    @FXML
    Button speedup;
    @FXML
    Button speeddown;
    @FXML
    Canvas canvas;
    @FXML
    Canvas canvasBattle;
    @FXML
    Canvas canvasBullet;

    private GraphicsContext gc;
    private GraphicsContext gcBattle;
    private GraphicsContext gcBullets;
    public static double myspeed = 4;
    private Formation HuluForm;
    private Formation MonsForm;
    public static final double imageSize = 25;
    private boolean battleState = false;//false-preparing true-running;
    private static ArrayList<Creature> creatures;
    private ExecutorService myexec = Executors.newCachedThreadPool();
    private ExecutorService myexec2 = Executors.newCachedThreadPool();
    private ExecutorService fileexec = Executors.newCachedThreadPool();
    public static ExecutorService bulletexec = Executors.newCachedThreadPool();
    public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private static String filePrefix ;
    private static String myfilename;
    public static ArrayList<Act> acts= new ArrayList<>();
    private static int creatureCount;
    public static boolean endGame = false;
    private static boolean restart = false;
    public static boolean playcontrol = false;
    public static int currentDiff = 1;
    private static int currentMusic = 1;
    private static boolean initmusic = true;
    private MediaPlayer mediaPlayer;
    public void initialize(){

        playMusic(0);
        String path = System.getProperty("user.dir");
        filePrefix = path+'/';
        speed.setText(String.valueOf(myspeed));
        Instructor.myinit();
        formaMons.setValue("Crane");
        formaHulu.setValue("Crane");
        HuluForm = FormationAdapter.getFormationId("Crane");
        MonsForm = FormationAdapter.getFormationId("Crane");
        gc = canvas.getGraphicsContext2D();
        gcBattle = canvasBattle.getGraphicsContext2D();
        gcBullets = canvasBullet.getGraphicsContext2D();
        gc.save();
        Image background = new Image("timg.jpg");
        gc.drawImage(background,0,0);
        myexec2.execute(new FormCheck());
        creatures = new ArrayList<Creature>();
        creatures.addAll(CalaBros);
        creatures.addAll(mices);
        creatures.add(Scorpion);
        creatures.add(Grandpa);
        creatures.add(Serpent);
        creatureCount = creatures.size();
        setImage();
    }
    private void playMusic(int i){
        if(currentMusic==i)
            return;
        if(!initmusic)
            mediaPlayer.stop();
        initmusic = false;
        String mediaurl = getClass().getResource("/0.mp3").toString();
        if(i==0)
            mediaurl = getClass().getResource("/0.mp3").toString();
        else if(i==1)
            mediaurl = getClass().getResource("/1.mp3").toString();
        else if(i==2)
            mediaurl = getClass().getResource("/2.mp3").toString();
        else if(i==3)
            mediaurl = getClass().getResource("/3.mp3").toString();
        Media media = new Media(mediaurl);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.05);
        currentMusic = i;
    }
    private void reset(){
        battleState = false;
        bullets.clear();
        MyMap.initMap();

        creatures = new ArrayList<Creature>();
        creatures.addAll(CalaBros);
        creatures.addAll(mices);
        creatures.add(Scorpion);
        creatures.add(Grandpa);
        creatures.add(Serpent);
        creatureCount = creatures.size();
    }


    public void getStart(){
        playMusic(currentDiff);
        /*TODO 开始函数的弹幕初始化有问题*/
        JOptionPane.showMessageDialog(null, "开始游戏", "难度"+currentDiff, JOptionPane.INFORMATION_MESSAGE);
        if(restart) {
            getEnd();
            try {
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Serpent.setFormationMonster(FormationAdapter.getFormationId(getHuluForm()),15,10);
            Grandpa.setFormationCalaBros(FormationAdapter.getFormationId(getMonsForm()),5,10);
            //myexec2.execute(new RefreshImage());
            setImage();
        }
        playcontrol = false;
        battleState = true;
        endGame = false;
        restart = true;
        myexec2.execute(new RefreshImage());
        myfilename = createNewArchive();

        for(Creature x : creatures) {
            Act ori = new Act(x.getName(), Global.ACT_STAND, x.ifAlive(),x.getSitex(),x.getSitey());
            MenuController.acts.add(ori);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(400/(long)myspeed);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        setImage();
        for(Creature x : creatures)
            myexec.execute(x);
    }

    public void getEnd(){
        battleState = false;
        endGame = true;
        //bullets.clear();
        bullets = new ArrayList<Bullet>();
        gcBullets.clearRect(0,0,740,560);
        gcBattle.clearRect(0,0,740,560);
        myexec2.execute(new FormCheck());
        myexec.shutdownNow();
        bulletexec.shutdownNow();
        fileexec.shutdownNow();
        reset();
        myexec = Executors.newCachedThreadPool();
        bulletexec = Executors.newCachedThreadPool();
        fileexec = Executors.newCachedThreadPool();
        initCreature();
        //setImage();
    }

    public void getStopGo(){
        System.out.println("stopgo");
    }

    public void getReadFile(){
        getEnd();
        battleState = true;
        endGame = false;
        Serpent.setFormationMonster(FormationAdapter.getFormationId(getHuluForm()),15,10);
        Grandpa.setFormationCalaBros(FormationAdapter.getFormationId(getMonsForm()),5,10);
        bulletexec = Executors.newCachedThreadPool();
        String path = System.getProperty("user.dir");
        setImage();

        System.out.println(path);
        JFileChooser jf = new JFileChooser(path);
        jf.showOpenDialog(null);
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File f=jf.getSelectedFile();

        if(jf.getSelectedFile()!=null) {
            String temp = f.getName();
            String filename = filePrefix + temp;
            showArchive(filename);
        }

        //System.out.println(filename);
    }

    private void showArchive(String filename){
        MyJdom myJdom = new MyJdom(filename);
        //myJdom.readXML(filename);
        fileexec.execute(myJdom);
        fileexec.execute(new RefreshArchive(myJdom));
    }

    public void getSpeedUp(){
        if(myspeed<8)
            myspeed++;
        speed.setText(String.valueOf(myspeed));
    }

    public void getSpeedDown(){
        if(myspeed>1)
            myspeed--;
        speed.setText(String.valueOf(myspeed));
    }

    private String getHuluForm(){
        Object value = formaHulu.getValue();
        return value.toString();
    }

    private String getMonsForm(){
        Object value = formaMons.getValue();
        return value.toString();
    }

    private MyPosition getPosition(int x,int y){
        int newx = x*(int)imageSize;
        int newy = y*(int)imageSize;
        MyPosition pos = new MyPosition(newx,newy);
        return pos;
    }

    class FormCheck implements Runnable{
        @Override
        public void run(){
            while(!battleState) {
                try {
                    sleep(1000);
                    String x,y,m,n;
                    x = HuluForm.getName();y = getHuluForm();
                    m = MonsForm.getName();n = getMonsForm();
                    System.out.println(x+" "+y+" "+m+" "+n);
                    if (HuluForm.getName().compareTo(getHuluForm())!=0|| MonsForm.getName().compareTo(getMonsForm())!=0) {
                        HuluForm = FormationAdapter.getFormationId(getHuluForm());
                        MonsForm = FormationAdapter.getFormationId(getMonsForm());
                        Serpent.setFormationMonster(FormationAdapter.getFormationId(getHuluForm()),15,10);
                        Grandpa.setFormationCalaBros(FormationAdapter.getFormationId(getMonsForm()),5,10);
                        MyMap.printMap();
                        setImage();
                    }
                    yield();
                }
                catch (InterruptedException e){
                    System.out.print("!!");
                }
            }
        }
    }

    class RefreshArchive implements Runnable{
        MyJdom myJdom;
        RefreshArchive(MyJdom myJdom){this.myJdom = myJdom;}
        @Override
        public void run(){
            try {
                bullets.clear();
                while (!myJdom.readover) {
                    if(!Thread.currentThread().isInterrupted()) {
                        sleep(400 / (long) myspeed);
                        if (myJdom.readready) {
                            synchronized (MyMap.LandCreature) {
                                //System.out.println("refresh");
                                setImage();
                            }
                        }
                        synchronized (bullets) {
                            setBullets();
                        }
                    }else return;
                }
            }catch (InterruptedException e){
                return;
            }
        }
    }

    class RefreshImage implements Runnable{
        @Override
        public void run(){
            try{
                while(!endGame){
                    sleep(40/(long)myspeed);
                    //System.out.println("refresh");
                    /*TODO???*/
                    if (battleState) {
                        sleep(360/(long)myspeed);
                        synchronized (creatures) {
                            endGame = checkWin();
                            if (endGame)
                                break;
                        }
                        synchronized (bullets) {
                            setBullets();
                        }
                        synchronized (MyMap.LandCreature) {
                            setImage();
                        }
                        synchronized (acts) {
                            checkSave();
                        }
                        yield();
                    }
                }
                battleState = false;
                //getEnd();
            }
            catch (InterruptedException e){
                System.out.println("!!");
            }
        }
    }

    private void checkSave(){
        creatureCount=0;
        for(Creature x:creatures) {
            if (x.ifAlive())
                creatureCount++;
        }
        /*TODO*/
        if(playcontrol&&creatureCount>0)
            creatureCount--;
        /*TODO*/
        if(acts.size()>=creatureCount) {
            synchronized (acts) {
                MyJdom.writeXML(myfilename, acts);
                acts.clear();
            }
        }
    }

    private boolean checkWin(){
        boolean cala = false;
        boolean mons = false;
        for(Creature x:creatures){
            if(x.getCamp()==Global.CALABROS&&x.ifAlive())
                cala = true;
            else if(x.getCamp()==Global.MONSTER&&x.ifAlive())
                mons = true;
        }
        if(cala&&!mons)
            calaWin();
        else if(mons&&!cala)
            monsWin();
        else if(!mons&&!cala)
            gameDraw();
        else return false;
        return true;
    }
    private void calaWin(){
        JOptionPane.showMessageDialog(null, "葫芦娃获胜", "通关难度"+currentDiff, JOptionPane.INFORMATION_MESSAGE);
        if(currentDiff<3)
            currentDiff++;
        else {
            currentDiff = 1;
            JOptionPane.showMessageDialog(null, "难度重置", "重新开始", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void monsWin(){
        JOptionPane.showMessageDialog(null, "妖精获胜", "战斗结束", JOptionPane.INFORMATION_MESSAGE);
        //currentDiff=1;
    }
    private void gameDraw(){
        JOptionPane.showMessageDialog(null, "平局", "战斗结束", JOptionPane.INFORMATION_MESSAGE);
    }
    private void setBullets(){
        gcBullets.clearRect(0,0,740,560);
        for(Bullet x:bullets){
            if(!x.getExist())
                ;//bullets.remove(x);
            else{
                drawBullet(x);
            }
        }
    }
    private void drawBullet(Bullet bullet){
        if(bullet.getCamp()==Global.CALABROS)
            gcBullets.setFill(Color.BLACK);
        else
            gcBullets.setFill(Color.RED);
        double angle = bullet.getAngle();
        /*
        gcBullets.save();
        gcBullets.translate(bullet.getSitex(),bullet.getSitey());
        gcBullets.rotate(-angle);
        gcBullets.fillOval(0,0,bullet.getLength(),bullet.getHeight());
        gcBullets.rotate(angle);
        gcBullets.restore();
        */
        gcBullets.save();
        gcBullets.translate(bullet.getSitex(),bullet.getSitey());
        gcBullets.rotate(-angle+90);
        gcBullets.drawImage(bullet.getImage(),0,0,bullet.getLength(),bullet.getLength());
        gcBullets.rotate(angle-90);
        gcBullets.restore();
    }

    private String createNewArchive(){
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy@MM@dd@HH@mm@ss");
            String today = dateFormat.format(date);
            String filename = filePrefix + today + ".xml";
            System.out.println(filename);
            File file = new File(filename);
            File fileParent = file.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            file.createNewFile();
            MyJdom.createRoot(filename);
            return filename;
        } catch (IOException e){
            e.printStackTrace();
        }
        return "resourse/Archive/1.xml";
    }

    private static void initCreature(){
        for (Creature x:creatures){
            x.setHp(100);
            x.setAlive(true);
            //x.shoothz = 2;
        }
    }

    public static Creature getCreature(String name){
        for (Creature y:creatures)
            if(y.getName().compareTo(name)==0)
                return y;
        System.out.println("have not found name");
        return creatures.get(0);
    }

    class RefreshBullets implements Runnable{
        @Override
        public void run(){
            try{
                while(true){
                    sleep(400/(long)myspeed);
                    //System.out.println("refreshbullet");
                    setBullets();
                    yield();
                }
            }
            catch (InterruptedException e){
                System.out.println("!!");
            }
        }
    }

    private void setImage() {
        gcBattle.setLineWidth(2);
        gcBattle.clearRect(0,0,740,560);
        //for(Creature[]x:MyMap.LandCreature)
          //  for(Creature y:x){
                for(Creature y:creatures)
                if(y.getCamp()!=Global.EMPTY) {
                    MyPosition pos = getPosition(y.getSitex(), y.getSitey());
                    int newx = pos.x;
                    int newy = pos.y;
                    if(y.ifAlive()) {
                        gcBattle.setStroke(Color.RED);
                        gcBattle.strokeLine(newx,newy-1,newx+imageSize*(y.getHp()/100),newy-1);
                        //gcBattle.setStroke(Color.BLACK);
                        //gcBattle.strokeLine(newx+imageSize*(y.getHp()/100),newy-1,newx+imageSize*(1-y.getHp()/100),newy-1);
                        gcBattle.drawImage(y.getImage(), newx, newy, imageSize, imageSize);
                    }
                    else
                        gcBattle.drawImage(y.getDie(),newx,newy,imageSize,imageSize);
                }
            }
   // }
   public void myKeyBoard(KeyEvent event){
       canvas.requestFocus();
       if (event.getCode() == KeyCode.ENTER)
           getStart();
       else if (event.getCode() == KeyCode.A)
           getSpeedUp();
       else if (event.getCode() == KeyCode.S)
           getSpeedDown();
       else if (event.getCode() == KeyCode.L)
           getReadFile();
       else if (event.getCode() == KeyCode.K)
           getStart();
       else if(event.getCode() == KeyCode.UP){
           canvas.requestFocus();
           if(Grandpa.ifAlive()) {
               playcontrol = true;
               int sitey = Grandpa.getSitey();
               int sitex = Grandpa.getSitex();
               if (sitey - 1 >= 0 && MyMap.LandCreature[sitey - 1][sitex].getName() == "none") {
                   MyMap.setSite(Grandpa, sitex, sitey - 1);
                   savePlayerControl(Grandpa,Global.ACT_STAND);
               }
           }
       }
       else if(event.getCode() == KeyCode.LEFT){
           if(Grandpa.ifAlive()) {
               playcontrol = true;
               int sitey = Grandpa.getSitey();
               int sitex = Grandpa.getSitex();
               if (sitex - 1 >= 0 && MyMap.LandCreature[sitey][sitex - 1].getName() == "none") {
                   MyMap.setSite(Grandpa, sitex - 1, sitey);
                   savePlayerControl(Grandpa,Global.ACT_STAND);
               }
           }
       }
       else if(event.getCode() == KeyCode.DOWN){
           canvas.requestFocus();
           if(Grandpa.ifAlive()) {
               playcontrol = true;
               int sitey = Grandpa.getSitey();
               int sitex = Grandpa.getSitex();
               if (sitey + 1 < 20 && MyMap.LandCreature[sitey + 1][sitex].getName() == "none") {
                   MyMap.setSite(Grandpa, sitex, sitey + 1);
                   savePlayerControl(Grandpa,Global.ACT_STAND);
               }
           }
       }
       else if(event.getCode() == KeyCode.RIGHT){
           canvas.requestFocus();
           if(Grandpa.ifAlive()) {
               playcontrol = true;
               int sitey = Grandpa.getSitey();
               int sitex = Grandpa.getSitex();
               if (sitex + 1 < 20 && MyMap.LandCreature[sitey][sitex + 1].getName() == "none") {
                   MyMap.setSite(Grandpa, sitex + 1, sitey);
                   savePlayerControl(Grandpa,Global.ACT_STAND);
               }
           }
       }
       else if(event.getCode() == KeyCode.Z){
           if(Grandpa.ifAlive()) {
               playcontrol = true;
               MyPosition pos = MyMap.getNearestEnemy(Grandpa, MyMap.LandCreature);
               Grandpa.shootBullet(pos);
               savePlayerControl(Grandpa,Global.ACT_SHOOT);
           }
       }
       else if(event.getCode() == KeyCode.X){
           if(Grandpa.ifAlive()) {
               playcontrol = true;
           }
       }
   }

   private void savePlayerControl(Creature x,int action){
        String tempName = x.getName();
        boolean tempAlive = x.ifAlive();
        int sitex = x.getSitex();
        int sitey = x.getSitey();
        Act act = new Act(tempName, action,tempAlive,sitex,sitey);
        acts.add(act);
   }
}
