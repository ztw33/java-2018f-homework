import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleField {//战场，保存了每一个单位和棋盘信息
    public enum Status{
        UNSTARTED,UNPROCESSING,PROCESSING,ENDED,REPLAYING
    }
    public Status status;
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
    public void lPressed(Window stage){
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
    public void spacePressed(){
        System.out.println("status="+status.toString());
        if(status==Status.UNSTARTED){
            status=Status.UNPROCESSING;
            startBattle();
        }
        else if(status==Status.UNPROCESSING||status==Status.REPLAYING||status==Status.ENDED){
            board.spacePressed();
        }
    }
    public void randomRearrange(boolean debug){//随机选择一个阵形并在场上随机放置
        calabashRearrange(debug);
        mobsRearrange(debug);
        printBattleField();
        board.printFile(pw);
    }
    private void calabashRearrange(boolean debug){//在战场左半边随机选择位置并放置葫芦娃
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
    private void grandpaRearrange(){//在左边半场没有葫芦娃的地方放置爷爷
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
    public void mobsRearrange(boolean debug){//在右边半场放置怪物
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
    private void queenRearrange(){
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
    public synchronized void printBattleField(){
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
    public void changeMobFormation(Formation formation){
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
        for(int i=0;i<mobNum;i++){//随机放置蝎子精或小喽啰
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
    public void startBattle(){
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
    private void nextStep()throws Exception {
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
    /*void printInfo(){
        for(int i=0;i<calabashBros.getBroNum();i++)
            System.out.println(calabashBros.getCalabashKid(i).name+" at pos "+
                    calabashBros.getCalabashKid(i).getPos().getX()+","+calabashBros.getCalabashKid(i).getPos().getY()+
                    (calabashBros.getCalabashKid(i).isAlive()?" alive":"dead"));
        System.out.println(grandpa.name+" at pos "+grandpa.getPos().getX()+","+grandpa.getPos().getY()+
                (grandpa.isAlive()?" alive":"dead"));
        for(int i=0;i<mobsFormation.getUnitNum();i++)
            System.out.println(mobs[i].name+" at pos "+mobs[i].getPos().getX()+","+mobs[i].getPos().getY()+
                    (mobs[i].isAlive()?" alive":"dead"));
        System.out.println(snakeQueen.name+" at pos "+snakeQueen.getPos().getX()+","+snakeQueen.getPos().getY()+
                (snakeQueen.isAlive()?" alive":"dead"));
    }*/
    private boolean goodBeingAlive(){
        if(grandpa.isAlive())
            return true;
        for(int i=0;i<calabashBros.getBroNum();i++) {
            if (calabashBros.getCalabashKid(i).isAlive())
                return true;
        }
        return false;
    }
    private boolean evilBeingAlive(){
        if(snakeQueen.isAlive())
            return true;
        for(int i=0;i<mobsFormation.getUnitNum();i++) {
            if (mobs[i].isAlive())
                return true;
        }
        return false;
    }
    private EvilBeing getNextAliveEvil(GoodBeing goodBeing) {
        ArrayList<EvilBeing> list = new ArrayList<EvilBeing>();
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
    private GoodBeing getNextAliveGood(EvilBeing evilBeing) {
        ArrayList<GoodBeing> list = new ArrayList<GoodBeing>();
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
    private void moveForward(Being a,Being b)throws Exception{
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
    public void loadFile(File file)throws Exception{
        try {
            if(list!=null&&!list.isEmpty()){
                for(Being being:list)
                    pane.getChildren().remove(being.view);
            }
            st=new SequentialTransition();
            FileReader fr = new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String str;
            str=br.readLine();
            if(!str.equalsIgnoreCase("board")) {
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
                    if(!strs[j].equalsIgnoreCase("*")){
                        //System.out.println(strs[j]);
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
            while(str!=null){
                String strs[]=str.split(" ");
                if(strs.length==3){
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
                else if(strs.length==5){
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
            //st.play();
        }
        catch(Exception e){
            System.out.println("load file failed");
            e.printStackTrace();
        }
    }
    public void printFile(PrintWriter pw){
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
    public void stop(){
        if(st!=null&&st.getStatus()== Animation.Status.RUNNING)
            st.stop();
    }
    public void spacePressed(){
        //System.out.println("board.space");
        if(st.getStatus()== Animation.Status.RUNNING)
            st.pause();
        else if(st.getStatus()== Animation.Status.PAUSED||st.getStatus()==Animation.Status.STOPPED)
            st.play();
    }
    public void play(){
        st.play();
    }
    private void setCordinate(ImageView view, int x, int y){
        //System.out.println("set cordinate"+view);
        view.setX(x*picWidth);
        view.setY(y*picHeight+50);
    }
    private void moveCordinate(Being being, int x, int y){
        TranslateTransition ttx=new TranslateTransition(Duration.millis(300),being.view);
        Position pos=being.getPos();
        //System.out.println(pos.getX()+","+pos.getY()+" to "+x+","+y);
        ttx.setByX(picWidth*(x-pos.getX()));
        ttx.setByY(picHeight*(y-pos.getY()));
        st.getChildren().add(ttx);
    }
    public void addBeing (int x, int y, Being being)throws Exception{
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
    public Being getBeing(int x, int y){
        return beings[y][x];
    }
    public Being getBeing(Position position){
        return beings[position.getY()][position.getX()];
    }
    public Being deleteBeing(Position pos){
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
    private void deleteBeingView(ImageView view){
        FadeTransition ft=new FadeTransition(Duration.millis(300),view);
        ft.setFromValue(1);
        ft.setToValue(0);
        st.getChildren().add(ft);
    }
    /*public void clearBoard() {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                beings[i][j]=null;
                if(beings[i][j]!=null)
                    pane.getChildren().remove(beings[i][j].view);
            }
        }
    }*/
    public void changePos(Being being,Position pos)throws Exception{
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
    public void fightAndChangePos(Being being,Being enemy)throws Exception{
        if(being==null||enemy==null)
            throw new Exception("null being, cant change pos");
        Position pos=enemy.getPos();
        if(pos.getX()>=maxColumn||pos.getY()>=maxRow||pos.getY()<0||pos.getX()<0)
            throw new Exception("position out of bound");

        Random rand=new Random();
        Position oPos=being.getPos();
        double r=rand.nextDouble();
        double prob=(double)being.strength/((double)enemy.strength+(double)being.strength);
        System.out.println(being.getName()+" fight "+enemy.getName()+" chance is "+prob+" result is "+r);
        if(prob>r){
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
        else{
            System.out.println(enemy.getName()+" wins");
            pw.println(oPos.getX()+" "+oPos.getY()+" killed");
            deleteBeing(oPos);
            being.kill();
        }
    }
}