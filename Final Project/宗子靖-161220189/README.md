# Final Project

----------
## 运行结果演示
![chain](https://github.com/JimZong/java-2018f-homework/blob/master/Final%20Project/%E5%AE%97%E5%AD%90%E9%9D%96-161220189/pic/battle.gif "Battle")
---
## 程序代码及设计思路
### 构建基本框架
- ##### 下载maven并创建maven项目
- ##### 在pom.xml中添加junit的支持
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>FinalProject</groupId>
    <artifactId>CalabashBros</artifactId>
    <version>2.0</version>

    <properties>    <!-- 添加该项使maven支持lamda表达式 -->
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
</project>
```
- ##### 在src/main/resource中添加项目所需图片

![chain](https://github.com/JimZong/java-2018f-homework/blob/master/Final%20Project/%E5%AE%97%E5%AD%90%E9%9D%96-161220189/pic/resources.PNG "resources")

- ##### 在src/main/resource中添加创建窗口的资源文件game.fxml，用SceneBuilder进行管理

![chain](https://github.com/JimZong/java-2018f-homework/blob/master/Final%20Project/%E5%AE%97%E5%AD%90%E9%9D%96-161220189/pic/SceneBuilder.PNG "SceneBuilder")

``` xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.control.*?>

<AnchorPane fx:id="anchorPane" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="693.0" prefWidth="815.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1" fx:controller="Controller">
    <children>
        <ImageView fitHeight="663.0" fitWidth="1134.0" layoutY="30.0" pickOnBounds="true" preserveRatio="true">
            <image>
                <Image url="@background.png" />
            </image>
        </ImageView>
        <MenuBar layoutY="-1.0" prefHeight="32.0" prefWidth="816.0" />
    </children>
</AnchorPane>
```
- ##### 在src/main/java中添加Controller实现对窗口中控件的控制
```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public AnchorPane anchorPane;

    public void initialize(URL location, ResourceBundle resources){
    }
}
```

------

### 面向对象逐步设计程序
- ##### 游戏需要一个坐标系，每个个体有自己的坐标，实现Position表示坐标
```java
public class Position{//代表位置的对象
    private int x;//横坐标
    private int y;//纵坐标
    Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    Position(Position pos){
        setPos(pos);
    }
    public void setPos(Position pos){
        x=pos.x;
        y=pos.y;
    }
    public void changePos(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public void addX(int a){
        x+=a;
    }
    public void addY(int b){
        y+=b;
    }
    public final Position addPosWithChange(Position pos){//改变本位置，返回本位置
        x+=pos.x;
        y+=pos.y;
        return this;
    }
    public Position addPosWithoutChange(Position pos){//返回一个新的改变后的位置，本位置不改变
        Position res=new Position(x,y);
        return res.addPosWithChange(pos);
    }
    public boolean overZeroPoint(){//判断位置是否在第一象限
        if(x>0&&y>0)
            return true;
        else
            return false;
    }
    public static boolean oneStepClose(Position aPos,Position bPos){//判断两个位置之间距离是否为1
        if(Math.abs(aPos.getX()-bPos.getX())==1&&aPos.getY()-bPos.getY()==0)
            return true;
        if(Math.abs(aPos.getY()-bPos.getY())==1&&aPos.getX()-bPos.getX()==0)
            return true;
        return false;
    }
    public static int distance(Position aPos,Position bPos){//计算两点距离(间接距离)
        return Math.abs(aPos.getX()-bPos.getX())+Math.abs(aPos.getY()-bPos.getY());
    }
}
```
- ##### 游戏中有两边的阵形，使用enum设计阵形
- ##### 每个个体都是一个生物，而游戏中分两派，实现Being，GoodBeing和EvilBeing类
> 个体拥有自己的名字、所在的位置、存活信息、力量（在两个生物互相攻击时产生效果），代表该生物的图片
> GoodBeing和EvilBeing继承自Being
```java
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Being {//生物
    protected Position pos;
    protected String name;
    protected boolean alive;
    protected int strength;
    public String viewURL;
    public ImageView view;
    public Being(){
        name="noname";
        pos=new Position(0,0);
        alive=true;
        view=null;
    }
    public Being(String name){
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        view=null;
        strength=0;
    }
    public Being(String name, int str){
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        view=null;
        strength=str;
    }
    public Being(String name,String imageURL,int str){
        viewURL=imageURL;
        this.name=name;
        pos=new Position(0,0);
        alive=true;
        //System.out.println("initialize "+name+" url: "+imageURL);
        Image image=new Image(imageURL);
        view = new ImageView();
        view.setImage(image);
        view.setPreserveRatio(true);
        view.setFitWidth(40);
        strength=str;
    }
    public final String getName() {
        return name;
    }
    public final Position getPos(){
        return pos;
    }
    public void changePos(int x, int y){
        pos.changePos(x,y);
    }
    public void changePos(Position pos){
        this.pos.changePos(pos.getX(),pos.getY());
    }
    public boolean isAlive(){
        return alive;
    }
    public void kill(){
        alive=false;
    }
    public void revive(){
        alive=true;
    }
}
class GoodBeing extends Being{
    GoodBeing(){
        name="noname";
        pos=new Position(0,0);
    }
    GoodBeing(String name){
        super(name);
    }
    GoodBeing(String name,int str){
        super(name,str);
    }
    GoodBeing(String name, String imageURL,int str){
        super(name,imageURL,str);
    }
}
class EvilBeing extends Being{
    EvilBeing(){
        name="noname";
        pos=new Position(0,0);
    }
    EvilBeing(String name,int str){
        super(name,str);
    }
    EvilBeing(String name, String imageURL,int str){
        super(name,imageURL,str);
    }
}
```
- ##### 每个葫芦娃都是一个GoodBeing，一个CalabashKid代表一个葫芦娃
```java
class CalabashKid extends GoodBeing{//需要使用extends，放弃enum使用class，在calabashbros中定义七个葫芦娃
    private String color;
    private int sortWeight;//每个葫芦娃排行地位，即排序的权重
    CalabashKid(String name, String color, int sortWeight, String imageURL,int str){
        super(name,imageURL,str);
        this.color=color;
        pos=new Position(0,0);
        this.sortWeight=sortWeight;
    }
    CalabashKid(String name, String color, int sortWeight){
        super(name);
        this.color=color;
        pos=new Position(0,0);
        this.sortWeight=sortWeight;
    }
}
```
- ##### 构建七个葫芦娃的总体CalabashBros，能对其中的每个葫芦娃进行排序
```java
class CalabashBros implements SortingMethods{           //七个葫芦娃的集合，提供这个集体的方法，如排序的方法
    private CalabashKid [] calabashBros;
    private Formation formation;
    private int broNum;//葫芦娃数量
    CalabashBros(String folderURL){                     //初始化葫芦娃
        broNum=7;
        formation=Formation.LONGSNAKE;                  //葫芦娃默认为长蛇阵
        calabashBros=new CalabashKid[]{new CalabashKid("大娃","红色",1,folderURL+"大娃.png",90),
                new CalabashKid("二娃","橙色",2,folderURL+"二娃.png",80),
                new CalabashKid("三娃","黄色",3,folderURL+"三娃.png",80),
                new CalabashKid("四娃","绿色",4,folderURL+"四娃.png",80),
                new CalabashKid("五娃","青色",5,folderURL+"五娃.png",80),
                new CalabashKid("六娃","蓝色",6,folderURL+"六娃.png",80),
                new CalabashKid("七娃","紫色",7,folderURL+"七娃.png",80)};
        reArrange(false);
    }
    CalabashBros(){//初始化葫芦娃
        broNum=7;
        formation=Formation.LONGSNAKE;
        calabashBros=new CalabashKid[]{new CalabashKid("大娃","红色",1),
                new CalabashKid("二娃","橙色",2),
                new CalabashKid("三娃","黄色",3),
                new CalabashKid("四娃","绿色",4),
                new CalabashKid("五娃","青色",5),
                new CalabashKid("六娃","蓝色",6),
                new CalabashKid("七娃","紫色",7)};
        reArrange(false);
    }
    void reArrange(boolean printMessage){               //随机排列七个葫芦娃
        Random rand=new Random();
        for(int i=0;i<100;i++){
            int a=rand.nextInt(7),b=rand.nextInt(7);
            change(a,b,printMessage);
        }
        if(printMessage)
            System.out.println("rearrange complete");
    }
    public void bubbleSort(boolean printMessage){       //冒泡排序
        if(printMessage==true)
            System.out.println("Bubble Sorting:");
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++) {
                if(calabashBros[j].getSortWeight()>calabashBros[j+1].getSortWeight()){
                    change(j,j+1,printMessage);
                }
            }
        }
        if(printMessage) {
            System.out.println("Bubble Sort Complete!");
            printName();
        }
    }
    private void change(int i, int j, boolean printMesssage){   //交换葫芦娃位置
        if(printMesssage)
            System.out.println(calabashBros[i].getName()+" at pos "+i+" <-> "+calabashBros[j].getName()+" at pos "+j);
        CalabashKid tempKid=calabashBros[i];
        calabashBros[i]=calabashBros[j];
        calabashBros[j]=tempKid;
    }                                                   
}
```
- ##### 构建一个“棋盘”Board，以二维数组保存场上生物，用ArrayList保存所有生物，提供生物移动，攻击等方法，并能保存文件和读取文件进行重放。
```java
class Board{//棋盘的对象
    private int maxRow;
    private int maxColumn;
    private Being[][] beings;
    public AnchorPane pane;
    private ArrayList<Being> list;
    private int picWidth;
    private int picHeight;
    private PrintWriter pw;
    SequentialTransition st;
    Board(int row,int column,AnchorPane pane){
        st=new SequentialTransition();
        maxRow=row;
        maxColumn=column;
        beings=new Being[maxRow][maxColumn];
        picWidth=46;
        picHeight=53;
        this.pane=pane;
        list =new ArrayList<Being>();
    }
    public void loadFile(File file)throws Exception{                //读取文件记录
        try {
            if(list!=null&&!list.isEmpty()){                        //删除窗口上的所有生物
                for(Being being:list)
                    pane.getChildren().remove(being.view);
            }
            st=new SequentialTransition();                          //创建序列动画
            FileReader fr = new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String str;
            str=br.readLine();
            if(!str.equalsIgnoreCase("board")) {                    //读取棋盘
                //System.out.println(str+" "+str.length());
                throw new Exception();
            }
            str=br.readLine();
            list=new ArrayList<Being>();
            int i=0;
            while(!str.equalsIgnoreCase("board end")) {
                if(str==null)
                    throw new Exception();
                String strs[]=str.split(" ");
                if(strs.length!=maxColumn)
                    throw new Exception();
                for(int j=0;j<maxColumn;j++){
                    if(!strs[j].equalsIgnoreCase("*")){             //文件中位置上无生物用"*"表示，
                        //System.out.println(strs[j]);              //有生物用该生物的图片路径表示
                        Being being=new Being("new",strs[j],0);     
                        list.add(being);
                        being.changePos(j,i);
                        setCordinate(being.view,j,i);               
                        pane.getChildren().add(being.view);
                    }
                }
                i++;
                str=br.readLine();
            }
            for(Being being: list){
                Position pos=being.getPos();
                //System.out.println("being at "+pos.getX()+","+pos.getY());
            }
            str=br.readLine();
            while(str!=null){                                       //读取文件中的每一步操作
                String strs[]=str.split(" ");
                if(strs.length==3){                                 //表示一个生物被杀
                    //System.out.println(str);
                    if(!strs[2].equalsIgnoreCase("killed"))
                        throw new Exception();
                    int x=Integer.parseInt(strs[0]);
                    int y=Integer.parseInt(strs[1]);
                    for(Being being: list){
                        Position pos=being.getPos();
                        if(pos.getX()==x&&pos.getY()==y&&being.alive){
                            //System.out.println(x+","+y+" killed "+being.view);
                            being.kill();
                            deleteBeingView(being.view);
                            break;
                        }
                    }
                }
                else if(strs.length==5){                            //表示一个生物移动到另一位置
                    //System.out.println(str);
                    if(!strs[2].equalsIgnoreCase("to"))
                        throw new Exception();
                    int x1=Integer.parseInt(strs[0]);
                    int y1=Integer.parseInt(strs[1]);
                    int x2=Integer.parseInt(strs[3]);
                    int y2=Integer.parseInt(strs[4]);
                    for(Being being: list){
                        Position pos=being.getPos();
                        if(pos.getX()==x1&&pos.getY()==y1&&being.alive){
                            moveCordinate(being,x2,y2);
                            being.changePos(x2,y2);
                            break;
                        }
                    }
                }
                else
                    throw new Exception();
                str=br.readLine();
            }
        }
        catch(Exception e){
            System.out.println("load file failed");
            e.printStackTrace();
        }
    }
    public void printFile(PrintWriter pw){                          //将棋盘的信息保存到文件中
        this.pw=pw;
        pw.println("board");
        for(int i=0;i<maxRow;i++){
            for(int j=0;j<maxColumn;j++){
                if(beings[i][j]!=null)
                    pw.print(beings[i][j].viewURL+" ");
                else
                    pw.print("*"+ " ");
            }
            pw.print('\n');
        }
        pw.println("board end");
    }
    public void stop(){                                             //停止播放动画
        if(st!=null&&st.getStatus()== Animation.Status.RUNNING)
            st.stop();
    }
    public void spacePressed(){                                     //处理按下空格的事件
        //System.out.println("board.space");
        if(st.getStatus()== Animation.Status.RUNNING)
            st.pause();
        else if(st.getStatus()== Animation.Status.PAUSED||st.getStatus()==Animation.Status.STOPPED)
            st.play();
    }
    public void play(){                                             //开始播放动画
        st.play();
    }
    private void setCordinate(ImageView view, int x, int y){        //将ImageView添加到窗口上
        //System.out.println("set cordinate"+view);
        view.setX(x*picWidth);
        view.setY(y*picHeight+50);
    }
    private void moveCordinate(Being being, int x, int y){          //向动画集添加一个ImageView移动的动画
        TranslateTransition ttx=new TranslateTransition(Duration.millis(300),being.view);
        Position pos=being.getPos();
        //System.out.println(pos.getX()+","+pos.getY()+" to "+x+","+y);
        ttx.setByX(picWidth*(x-pos.getX()));
        ttx.setByY(picHeight*(y-pos.getY()));
        st.getChildren().add(ttx);
    }
    public void addBeing (int x, int y, Being being)throws Exception{   //向棋盘上添加生物
        if(x>=maxColumn||y>=maxRow||y<0||x<0)
            throw new Exception("position out of bound");
        if(beings[y][x]!=null)
            throw new Exception("position taken");
        beings[y][x]=being;
        being.changePos(x,y);
        list.add(being);
        pane.getChildren().add(being.view);
        setCordinate(being.view,x,y);
    }
    public Being deleteBeing(Position pos){                     //删除棋盘上处于位置pos的生物，在生物被杀死时调用
        Being being=beings[pos.getY()][pos.getX()];
        beings[pos.getY()][pos.getX()]=null;
        if(being!=null) {
            deleteBeingView(being.view);
            //pane.getChildren().remove(being.view);
        }
        return being;
    }
    public Being deleteBeing(int x, int y){
        Being being=beings[y][x];
        beings[y][x]=null;
        if(being!=null) {
            deleteBeingView(being.view);
            //pane.getChildren().remove(being.view);
        }
        return being;
    }
    private void deleteBeingView(ImageView view){                   //向动画集添加一个ImageView消失的动画
        FadeTransition ft=new FadeTransition(Duration.millis(300),view);
        ft.setFromValue(1);
        ft.setToValue(0);
        st.getChildren().add(ft);
    }
    public void changePos(Being being,Position pos)throws Exception{    //改变一个生物的位置
        if(being==null)
            throw new Exception("null being, cant change pos");
        if(pos.getX()>=maxColumn||pos.getY()>=maxRow||pos.getY()<0||pos.getX()<0)
            throw new Exception("position out of bound");
        if(beings[pos.getY()][pos.getX()]!=null)
            throw new Exception("position already taken");
        //System.out.println(being.getName()+" change pos "+being.getPos().getX()+", "+being.getPos().getY()+
        //" to "+pos.getX()+", "+pos.getY());
        pw.println(being.getPos().getX()+" "+being.getPos().getY()+" to "+pos.getX()+" "+pos.getY());
        beings[being.getPos().getY()][being.getPos().getX()]=null;
        beings[pos.getY()][pos.getX()]=being;
        moveCordinate(being,pos.getX(),pos.getY());
        being.changePos(pos);
    }
    public void fightAndChangePos(Being being,Being enemy)throws Exception{     //让生物being和他的敌人enemy
        if(being==null||enemy==null)                                            //战斗，通过being和enemy的力量强度比例
            throw new Exception("null being, cant change pos");                 //设计一边活下来的几率
        Position pos=enemy.getPos();                                    
        if(pos.getX()>=maxColumn||pos.getY()>=maxRow||pos.getY()<0||pos.getX()<0)
            throw new Exception("position out of bound");

        Random rand=new Random();
        Position oPos=being.getPos();
        double r=rand.nextDouble();
        double prob=(double)being.strength/((double)enemy.strength+(double)being.strength);
        System.out.println(being.getName()+" fight "+enemy.getName()+" chance is "+prob+" result is "+r);
        if(prob>r){                                         //being获胜，则杀死enemy并将being移动到enemy的位置
            System.out.println(being.getName()+" wins");
            enemy.kill();
            pw.println(pos.getX()+" "+pos.getY()+" killed");
            deleteBeing(pos);
            pw.println(oPos.getX()+" "+oPos.getY()+" to "+pos.getX()+" "+pos.getY());
            moveCordinate(being,pos.getX(),pos.getY());
            beings[pos.getY()][pos.getX()]=being;
            beings[oPos.getY()][oPos.getX()]=null;
            being.changePos(pos);
        }
        else{                                               //enemy获胜，则杀死being
            System.out.println(enemy.getName()+" wins");
            pw.println(oPos.getX()+" "+oPos.getY()+" killed");
            deleteBeing(oPos);
            being.kill();
        }
    }
}
```
- ##### 实现战场BattleField操纵board
>对双方生物进行初始化，为怪物选择一个随机阵形
>每当一个生物行动，创建一个线程为其使用
>提供开始战斗的方法，当场上双方都有生物存在时一直保持场上的生物行动
>包括生物的行动逻辑
```java
public class BattleField {//战场，保存了每一个单位和棋盘信息
    public enum Status{
        UNSTARTED,UNPROCESSING,PROCESSING,ENDED,REPLAYING
    }
    public Status status;                               //保存目前运行状态，未开始，未处理，处理中，战斗结束，重放中
    private int maxRow;
    private int maxColumn;
    private CalabashBros calabashBros;
    private GoodBeing grandpa;
    private EvilBeing snakeQueen;
    private EvilBeing[] mobs;
    private Formation mobsFormation;
    private Board board;
    private FileWriter fw;
    private PrintWriter pw;
    BattleField(int maxRow, int maxColumn, boolean debug, AnchorPane pane){
        String url="savings/";
        status=Status.UNSTARTED;
        this.maxColumn=maxColumn;
        this.maxRow=maxRow;
        board=new Board(maxRow,maxColumn,pane);
        calabashBros=new CalabashBros("");
        grandpa=new GoodBeing("爷爷","爷爷.png",50);
        snakeQueen=new EvilBeing("蛇精","蛇精.png",90);
        try {
            int i = 1;
            String saveURL = url + i + ".save";
            File file = new File(saveURL);
            while (file.exists()) {
                i++;
                saveURL = url + i + ".save";
                file = new File(saveURL);
            }
            file.createNewFile();
            fw=new FileWriter(file);
            pw=new PrintWriter(fw);
        }
        catch (Exception e){
            System.out.println("creating file error");
            e.printStackTrace();
        }
        randomRearrange(debug);
    }
    public void lPressed(Window stage){                     //按下l跳出文件记录选择
        if(status==Status.UNPROCESSING&&status==Status.PROCESSING)
            return;
        board.stop();
        FileChooser fileChooser=new FileChooser();
        fileChooser.setInitialDirectory(new File("savings"));
        fileChooser.setTitle("Open File");
        File file=fileChooser.showOpenDialog(stage);
        if(file!=null&&file.exists()) {
            try {
                status=Status.REPLAYING;
                board.loadFile(file);
            }
            catch(Exception e){
                System.out.println("load file failed");
                e.printStackTrace();
            }
        }
    }
    public void spacePressed(){                                 //按下空格根据当前状态判断开始战斗还是开始重放
        System.out.println("status="+status.toString());
        if(status==Status.UNSTARTED){
            status=Status.UNPROCESSING;
            startBattle();
        }
        else if(status==Status.UNPROCESSING||status==Status.REPLAYING||status==Status.ENDED){
            board.spacePressed();
        }
    }
    public void randomRearrange(boolean debug){                 //随机选择一个阵形并在场上随机放置
        calabashRearrange(debug);
        mobsRearrange(debug);
        printBattleField();
        board.printFile(pw);
    }
    private void calabashRearrange(boolean debug){              //在战场左半边随机选择位置并放置葫芦娃
        for(int i=0;i<calabashBros.getBroNum();i++){
            board.deleteBeing(calabashBros.getCalabashKid(i).getPos());
        }
        board.deleteBeing(grandpa.getPos());
        int mid=maxColumn/2;
        Random rand=new Random();
        if(calabashBros.getFormation().getMaxRow()>maxRow||calabashBros.getFormation().getMaxColumn()>maxColumn/2){
            System.out.println("BattleField too small, cannot initialize");
            return;
        }
        Position calabashStart=new Position(rand.nextInt(mid+1-calabashBros.getFormation().getMaxColumn()),
                rand.nextInt(maxRow+1-calabashBros.getFormation().getMaxRow()));
        if(debug)
            System.out.println("CalabashBros start pos: "+calabashStart.getX()+", "+calabashStart.getY());
        calabashBros.bubbleSort(false);
        try {
            for (int i = 0; i < calabashBros.getBroNum(); i++) {
                Position pos = calabashBros.getFormation().getPosition(i).addPosWithoutChange(calabashStart);
                board.addBeing(pos.getX(), pos.getY(), calabashBros.getCalabashKid(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        grandpaRearrange();
    }
    private void grandpaRearrange(){                        //在左边半场没有葫芦娃的地方放置爷爷
        Random rand=new Random();
        int mid=maxColumn/2;
        int x=rand.nextInt(mid);
        int y=rand.nextInt(maxRow);
        while(board.getBeing(x,y)!=null){
            x=rand.nextInt(mid);
            y=rand.nextInt(maxRow);
        }
        try {
            board.addBeing(x, y, grandpa);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void mobsRearrange(boolean debug){                   //在右边半场随机选择阵形放置怪物
        int midColumn=maxColumn/2;
        Random rand=new Random();
        int mobForNum=rand.nextInt(Formation.values().length);
        Formation formation=Formation.values()[mobForNum];
        while(formation.getMaxRow()>maxRow||formation.getMaxColumn()>maxColumn/2){
            mobForNum=rand.nextInt(Formation.values().length);
            formation=Formation.values()[mobForNum];
        }
        if(debug)
            System.out.println("mobs' formation number: "+mobForNum);
        changeMobFormation(formation);
        queenRearrange();
    }
    private void queenRearrange(){                          //在右半场无怪物的地方放置蛇精
        Random rand=new Random();
        int mid=maxColumn/2;
        int x=rand.nextInt(maxColumn-mid-1)+mid;
        int y=rand.nextInt(maxRow);
        while(board.getBeing(x,y)!=null){
            x=rand.nextInt(maxColumn-mid-1)+mid;
            y=rand.nextInt(maxRow);
        }
        try {
            board.addBeing(x, y, snakeQueen);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public synchronized void printBattleField(){            //输出战场信息（调试时使用）
        System.out.println("battle field:");
        for(int i=0;i<maxRow;i++){
            for(int j=0;j<maxColumn;j++){
                Being a=board.getBeing(j,i);
                if(a==null) {
                    System.out.print("O\t\t");
                }
                else{
                    System.out.print(a.getName());
                    if(a.getName().length()<=2)
                        System.out.print("\t\t");
                    else
                        System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
    }
    public void changeMobFormation(Formation formation){        //改变怪物的阵形
        mobsFormation=formation;
        int midColumn=maxColumn/2;
        if(mobs!=null){
            for(int i=0;i<mobs.length;i++){
                board.deleteBeing(mobs[i].getPos().getX(),mobs[i].getPos().getY());
            }
            board.deleteBeing(snakeQueen.getPos().getX(),snakeQueen.getPos().getY());
        }
        Random rand=new Random();
        int mobNum=mobsFormation.getUnitNum();
        mobs=new EvilBeing[mobsFormation.getUnitNum()];
        for(int i=0;i<mobNum;i++){                  //随机放置蝎子精或小喽啰
            if(rand.nextInt(2)==0)
                mobs[i]=new EvilBeing("蝎子精","蝎子精.png",70);
            else
                mobs[i]=new EvilBeing("小喽啰","小喽啰.png",60);
        }
        Position mobStart=new Position(rand.nextInt(maxColumn-midColumn+1-mobsFormation.getMaxColumn())+midColumn,
                rand.nextInt(maxRow+1-mobsFormation.getMaxRow()));
        try {
            for (int i = 0; i < mobNum; i++) {
                Position pos = mobsFormation.getPosition(i).addPosWithoutChange(mobStart);
                board.addBeing(pos.getX(), pos.getY(), mobs[i]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void startBattle(){                      //开始战斗
        printBattleField();
        while(true){
            if(!evilBeingAlive()) {
                System.out.println("good beats evil");
                try{
                    fw.close();
                }
                catch(Exception e){
                    System.out.println("fail to close file");
                    e.printStackTrace();
                }
                board.play();
                status=Status.ENDED;
                return;
            }
            else if(!goodBeingAlive()){
                System.out.println("evil beats good");
                try{
                    fw.close();
                }
                catch(Exception e){
                    System.out.println("fail to close file");
                    e.printStackTrace();
                }
                board.play();
                status=Status.ENDED;
                return;
            }
            try {
                nextStep();
                status=Status.UNPROCESSING;
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    private void nextStep()throws Exception {                   //让每个活着的生物寻找目标并向目标前进
        if (status == Status.PROCESSING)
            throw new Exception("processsing false");
        status = Status.PROCESSING;
        for (int i = 0; i < calabashBros.getBroNum(); i++) {
            CalabashKid kid = calabashBros.getCalabashKid(i);
            new Thread(()-> {
                synchronized (this) {
                    if (kid.isAlive()) {
                        EvilBeing enemy = getNextAliveEvil(kid);
                        if (enemy == null)
                            return;
                        try {
                            moveForward(kid, enemy);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        new Thread(()-> {
            synchronized (this) {
                if (grandpa.isAlive()) {
                    EvilBeing enemy = getNextAliveEvil(grandpa);
                    if (enemy == null)
                        return;
                    try {
                        moveForward(grandpa, enemy);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        for (int i = 0; i < mobsFormation.getUnitNum(); i++) {
            EvilBeing mob = mobs[i];
            new Thread(()-> {
                synchronized (this) {
                    if (mob.isAlive()) {
                        GoodBeing enemy = getNextAliveGood(mob);
                        if (enemy == null)
                            return;
                        try {
                            moveForward(mob, enemy);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        new Thread(()-> {
            synchronized (this) {
                if (snakeQueen.isAlive()) {
                    GoodBeing enemy = getNextAliveGood(snakeQueen);
                    if (enemy == null)
                        return;
                    try {
                        moveForward(snakeQueen, enemy);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try{
            Thread.sleep(50);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        printBattleField();
    }
    private boolean goodBeingAlive(){                       //判断是否有活着的好人
        if(grandpa.isAlive())
            return true;
        for(int i=0;i<calabashBros.getBroNum();i++) {
            if (calabashBros.getCalabashKid(i).isAlive())
                return true;
        }
        return false;
    }
    private boolean evilBeingAlive(){                       //判断是否有活着的坏人
        if(snakeQueen.isAlive())
            return true;
        for(int i=0;i<mobsFormation.getUnitNum();i++) {
            if (mobs[i].isAlive())
                return true;
        }
        return false;
    }
    private EvilBeing getNextAliveEvil(GoodBeing goodBeing) {   //将每个活着的坏人加入ArrayList，
        ArrayList<EvilBeing> list = new ArrayList<EvilBeing>(); //选择离goodBeing最近的一个作为目标
        for (int i = 0; i < mobsFormation.getUnitNum(); i++) {
            if (mobs[i].isAlive())
                list.add(mobs[i]);
        }
        if(snakeQueen.isAlive())
            list.add(snakeQueen);
        if(list.isEmpty())
            return null;
        EvilBeing evilBeing=list.get(0);
        for(int i=1;i<list.size();i++){
            EvilBeing tempBeing=list.get(i);
            if(Position.distance(goodBeing.getPos(),evilBeing.getPos())>Position.distance(goodBeing.getPos(),tempBeing.getPos()))
                evilBeing=tempBeing;
        }
        //System.out.println(goodBeing.getName()+"'s target is "+evilBeing.getName());
        return evilBeing;
    }
    private GoodBeing getNextAliveGood(EvilBeing evilBeing) {       //将每个活着的好人加入ArrayList，    
        ArrayList<GoodBeing> list = new ArrayList<GoodBeing>();     //选择离evilBeing最近的一个作为目标
        for (int i = 0; i < calabashBros.getBroNum(); i++) {
            if (calabashBros.getCalabashKid(i).isAlive())
                list.add(calabashBros.getCalabashKid(i));
        }
        if(grandpa.isAlive())
            list.add(grandpa);
        if(list.isEmpty())
            return null;
        GoodBeing goodBeing=list.get(0);
        for(int i=1;i<list.size();i++){
            GoodBeing tempBeing=list.get(i);
            if(Position.distance(evilBeing.getPos(),goodBeing.getPos())>Position.distance(evilBeing.getPos(),tempBeing.getPos()))
                goodBeing=tempBeing;
        }
        //System.out.println(evilBeing.getName()+"'s target is "+goodBeing.getName());
        return goodBeing;
    }
    private void moveForward(Being a,Being b)throws Exception{      //a朝b前进的行为逻辑
        Position aPos=a.getPos();
        Position bPos=b.getPos();
        if(Position.oneStepClose(aPos,bPos)){
            board.fightAndChangePos(a,b);
            return;
        }
        int xDis=aPos.getX()-bPos.getX();
        int yDis=aPos.getY()-bPos.getY();
        boolean xFlag=xDis>0;
        boolean yFlag=yDis>0;
        if(xDis==0){
            Position pos=new Position(aPos.getX(),yFlag?aPos.getY()-1:aPos.getY()+1);
            Being being=board.getBeing(pos);
            if(being==null){
                board.changePos(a,pos);
            }
            return;
        }
        if(yDis==0){
            Position pos=new Position(xFlag?aPos.getX()-1:aPos.getX()+1,aPos.getY());
            Being being=board.getBeing(pos);
            if(being==null){
                board.changePos(a,pos);
            }
            return;
        }
        Position nextPos1=new Position(xFlag?aPos.getX()-1:aPos.getX()+1,aPos.getY());
        Position nextPos2=new Position(aPos.getX(),yFlag?aPos.getY()-1:aPos.getY()+1);
        Being being1=board.getBeing(nextPos1);
        Being being2=board.getBeing(nextPos2);
        if(being1!=null&&being2!=null)
            return;
        if(being1!=null)
            board.changePos(a,nextPos2);
        else if(being2!=null)
            board.changePos(a,nextPos1);
        else if(Math.abs(xDis)<Math.abs(yDis))
            board.changePos(a,nextPos2);
        else if(Math.abs(xDis)>Math.abs(yDis))
            board.changePos(a,nextPos1);
        else {
            Random rand = new Random();
            if (rand.nextInt(2) == 1)
                board.changePos(a, nextPos2);
            else
                board.changePos(a, nextPos1);
        }
    }
}
```
- ##### 在Main中对程序窗口进行初始化，添加对按键的判断以调用BattleField的方法。
```java
public class Main extends Application {

    private BattleField battleField;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        try {
            URL location = getClass().getResource("game.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = fxmlLoader.load();

            primaryStage.setTitle("葫芦娃大战妖精");
            controller = fxmlLoader.getController();
            Scene scene = new Scene(root, 804, 681);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            primaryStage.show();

            battleField = new BattleField(12, 18, false, controller.anchorPane);

            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("space pressed");
                    battleField.spacePressed();
                }
                if (event.getCode() == KeyCode.L) {
                    System.out.println("l pressed");
                    battleField.lPressed(primaryStage);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
```

- ##### 为一些算法创建测试，新建TestUnit
![chain](https://github.com/JimZong/java-2018f-homework/blob/master/Final%20Project/%E5%AE%97%E5%AD%90%E9%9D%96-161220189/pic/TestUnit.PNG "TestUnit")
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUnit {
    @Test
    public void testChangePos()throws Exception{
        Being being=new Being("a",0);
        being.changePos(10,20);
        assertEquals(10,being.getPos().getX());
        assertEquals(20,being.getPos().getY());
    }
    @Test
    public void testBubbleSort()throws Exception{
        CalabashBros bros=new CalabashBros();
        bros.reArrange(false);
        bros.bubbleSort(false);
        assertTrue(bros.getCalabashKid(0).getName().equalsIgnoreCase("大娃"));
        assertTrue(bros.getCalabashKid(1).getName().equalsIgnoreCase("二娃"));
        assertTrue(bros.getCalabashKid(2).getName().equalsIgnoreCase("三娃"));
        assertTrue(bros.getCalabashKid(3).getName().equalsIgnoreCase("四娃"));
        assertTrue(bros.getCalabashKid(4).getName().equalsIgnoreCase("五娃"));
        assertTrue(bros.getCalabashKid(5).getName().equalsIgnoreCase("六娃"));
        assertTrue(bros.getCalabashKid(6).getName().equalsIgnoreCase("七娃"));
    }
    @Test
    public void testAddPosWithChange()throws Exception{
        Position pos=new Position(10,20);
        Position npos=new Position(20,30);
        Position nnpos=pos.addPosWithChange(npos);
        assertEquals(30,pos.getX());
        assertEquals(50,pos.getY());
        assertEquals(30,nnpos.getX());
        assertEquals(50,nnpos.getY());
    }
    @Test
    public void testAddPosWithoutChange()throws Exception{
        Position pos=new Position(10,20);
        Position npos=new Position(20,30);
        Position nnpos=pos.addPosWithoutChange(npos);
        assertEquals(10,pos.getX());
        assertEquals(20,pos.getY());
        assertEquals(30,nnpos.getX());
        assertEquals(50,nnpos.getY());
    }
    @Test
    public void testOverZeroPoint()throws Exception{
        Position pos0=new Position(1,1);
        Position pos1=new Position(1,-1);
        Position pos2=new Position(-1,-1);
        Position pos3=new Position(-1,1);
        Position pos4=new Position(0,0);
        assertTrue(pos0.overZeroPoint());
        assertFalse(pos1.overZeroPoint());
        assertFalse(pos2.overZeroPoint());
        assertFalse(pos3.overZeroPoint());
        assertFalse(pos4.overZeroPoint());
    }
    @Test
    public void testOneStepClose()throws Exception{
        Position pos0=new Position(10,10);
        Position pos1=new Position(10,11);
        Position pos2=new Position(8,10);
        Position pos3=new Position(9,10);
        Position pos4=new Position(10,20);
        assertTrue(Position.oneStepClose(pos0,pos1));
        assertTrue(Position.oneStepClose(pos0,pos3));
        assertFalse(Position.oneStepClose(pos0,pos2));
        assertFalse(Position.oneStepClose(pos0,pos4));
        assertTrue(Position.oneStepClose(pos2,pos3));
    }
    @Test
    public void testDistance()throws Exception{
        Position pos0=new Position(10,10);
        Position pos1=new Position(10,11);
        Position pos2=new Position(8,10);
        Position pos3=new Position(9,10);
        Position pos4=new Position(10,20);
        assertEquals(Position.distance(pos0,pos1),1);
        assertEquals(Position.distance(pos1,pos2),3);
        assertEquals(Position.distance(pos4,pos1),9);
        assertEquals(Position.distance(pos2,pos4),12);
    }
    @Test
    public void testFormation()throws Exception{
        assertEquals(Formation.ARROW.getUnitNum(),9);
        assertEquals(Formation.CRESCENT.getUnitNum(),7);
        assertEquals(Formation.SQUARE.getUnitNum(),8);
        assertEquals(Formation.FISHSCALE.getUnitNum(),12);
    }
}
```
## 使用的程序设计方法和技术
- #### 数据封装，面向对象的基础
- #### Exception异常处理
- #### 泛型程序设计
- #### 注解，annotation
- #### 文件操作
- #### javaFX GUI设计
- #### Maven
- #### 多线程设计，为每个单位创建一个线程进行进攻
- #### 单元测试用例，对一些方法进行测试






