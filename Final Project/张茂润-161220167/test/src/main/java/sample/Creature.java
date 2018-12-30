package sample;

import javafx.application.Platform;

import java.io.*;

public class Creature implements Runnable{
    @Edit(editor = "zmr", time = "20181202")
    protected boolean alive;
    protected int cor_x;
    protected int cor_y;
    protected int attack;
    protected String name;
    protected Field field;
    protected  boolean isBattling;
    protected int index;
    protected Thread thread ;
    protected File file;
    protected FileOutputStream output ;

    public volatile boolean exit = false;

    public Creature(){
        alive = true;
        cor_x = cor_y = 0;
        attack = 0;
        isBattling = false;
        index = -1;
        try{
            file = new File("record.txt");
            output = new FileOutputStream(file, true);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean getAlive(){
        return alive;
    }
    public int getCor_x(){
        return cor_x;
    }
    public int getCor_y(){
        return cor_y;
    }
    public int getAttack(){
        return attack;
    }
    public void dead(){
        alive = false;
    }
    public String getName(){
        return name;
    }
    public int getIndex() { return index; }
    public void setBattling(boolean b) { isBattling = b; }
    public boolean getBattling()    { return isBattling; }

    public synchronized void moveTo(int x, int y){
        if(getAlive() && x >= 0 && x <= 7 && y >= 0 && y <= 7 && !field.inquireField(x, y))
        {
            field.move(this, cor_x, cor_y, x, y);
            if(LoLo.class.isInstance(this)) {
                String str = (name + index + " moves from (" + cor_x + ", " + cor_y + ") to (" + x + ", " + y + ")"+ "\r\n");
                System.out.print(str);
                field.print(str);
                try {
                    byte[] bytes = ("move " + name + index + " " + cor_x + " " + cor_y + " " + x + " " + y + "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }else {
                String str = (name + " moves from (" + cor_x + ", " + cor_y + ") to (" + x + ", " + y + ")"+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ( "move " + name + " " + cor_x + " " + cor_y + " " + x + " " + y + "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            cor_x = x;
            cor_y = y;
            Platform.runLater(new Runnable() {
                public void run() {
                    field.controller.refresh();
                }
            });

        }
    }

    public synchronized void battle(Creature enemy){
        if(!getAlive() && !enemy.getAlive())
            return;
        //isBattling = true;
        setBattling(true);
        enemy.setBattling(true);
        int enemyAttack = enemy.getAttack();
        float winRate = (float)attack / (attack + enemyAttack);
        float randomNumber = (float)Math.random();
        if(randomNumber <= winRate){
            enemy.dead();
            if(!LoLo.class.isInstance(this) && !LoLo.class.isInstance(enemy)) {
                String str = (name + " defeated " + enemy.getName()+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + name + " " + enemy.getName() + "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(LoLo.class.isInstance(this) && !LoLo.class.isInstance(enemy)) {
                String str = (name + index + " defeated " + enemy.getName()+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + name + index + " " + enemy.getName()+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(!LoLo.class.isInstance(this) && LoLo.class.isInstance(enemy)) {
                String str = (name + " defeated " + enemy.getName() + enemy.getIndex()+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + name + " " + enemy.getName() + enemy.getIndex()+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(LoLo.class.isInstance(this) && LoLo.class.isInstance(enemy)) {
                String str = (name + index + " defeated " + enemy.getName() + enemy.getIndex()+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + name + index + " " + enemy.getName() + enemy.getIndex()+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        else{
            dead();
            if(!LoLo.class.isInstance(this) && !LoLo.class.isInstance(enemy)) {
                String str = (enemy.getName() + " defeated " + name+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + enemy.getName() + " " + name+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(LoLo.class.isInstance(this) && !LoLo.class.isInstance(enemy)) {
                String str = (enemy.getName() + " defeated " + name + index+ "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + enemy.getName() + " " + name + index+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(!LoLo.class.isInstance(this) && LoLo.class.isInstance(enemy)) {
                String str = (enemy.getName() + enemy.getIndex() + " defeated " + name + "\r\n");
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + enemy.getName() + enemy.getIndex() + " " + name+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(LoLo.class.isInstance(this) && LoLo.class.isInstance(enemy)) {
                String str = enemy.getName() + enemy.getIndex() + " defeated " + name + index + "\r\n";
                System.out.print(str);
                field.print(str);
                try{
                    byte[] bytes = ("defeat " + enemy.getName() + enemy.getIndex() + " " + name + index+ "\r\n").getBytes();
                    output.write(bytes);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
            try{
                thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            if(exit == false)
                field.gameOver();
        }
    }

    public boolean memOfHulu(){
        if(HuluBro.class.isInstance(this) || Grandpa.class.isInstance(this))
            return true;
        else
            return false;
    }

    public boolean memOfSnake(){
        return !memOfHulu();
    }

    public synchronized void run(){
        if(HuluBro.class.isInstance(this) || Grandpa.class.isInstance(this)){
            /*葫芦娃阵营*/
            //System.out.println("葫芦娃阵营成员");
            while(!exit && getAlive() && field.countAliveOfHulu() != 0 && field.countAliveofSnake() != 0 && cor_x < 7) {
                if(getBattling())
                    continue;
                boolean waitingForBattle = false;
                if(field.inquireField(cor_x+1, cor_y) && field.inquireAlive(cor_x+1, cor_y) && field.creature[cor_y][cor_x+1].memOfSnake()){
                    /* 正前方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y][cor_x+1].getBattling()) {
                        battle(field.creature[cor_y][cor_x+1]);
                        if(getAlive()){
                            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try{
                                thread.sleep(1000);
                            }
                            catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        }
                        else {
                            field.creature[cor_y][cor_x+1].setBattling(false);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }
                if(cor_y-1>=0 && field.inquireField(cor_x+1,cor_y-1) && field.inquireAlive(cor_x+1, cor_y-1) && field.creature[cor_y-1][cor_x+1].memOfSnake()){
                    /* 前上方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y-1][cor_x+1].getBattling()) {
                        battle(field.creature[cor_y - 1][cor_x + 1]);
                        if(getAlive()){
                            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try{
                                thread.sleep(1000);
                            }
                            catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        }
                        else{
                            field.creature[cor_y-1][cor_x+1].setBattling(false);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }
                if(cor_y+1<=7 && field.inquireField(cor_x+1, cor_y+1) && field.inquireAlive(cor_x+1, cor_y+1) && field.creature[cor_y+1][cor_x+1].memOfSnake()){
                    /* 前下方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y+1][cor_x+1].getBattling()) {
                        battle(field.creature[cor_y + 1][cor_x + 1]);
                        if (getAlive()) {
                            if (field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try {
                                thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        } else {
                            field.creature[cor_y+1][cor_x+1].setBattling(true);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }
                if(!waitingForBattle) {
                    int newx = cor_x;
                    while (newx < 7) {
                        newx += 1;
                        if (!field.inquireField(newx, cor_y)) {
                            moveTo(newx, cor_y);
                            break;
                        }
                        else{
                            if(field.creature[cor_y][newx].getAlive() && field.creature[cor_y][newx].memOfSnake() && !field.creature[cor_y][newx].getBattling()){
                                battle(field.creature[cor_y][newx]);
                                //isBattling = false;
                                setBattling(false);
                                field.creature[cor_y][newx].setBattling(false);
                                break;
                            }
                            else if(field.creature[cor_y][newx].memOfHulu()){
                                break;
                            }
                        }
                    }
                }
                if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0)
                    field.gameOver();
                try{
                    thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            setBattling(false);
            while(cor_x == 7 && getAlive() && field.countAliveofSnake() != 0){
                Creature enemy = field.findAliveOfSnake();
                if(!getBattling() && enemy != null && !enemy.getBattling()){
                    battle(enemy);
                    //isBattling = false;
                    setBattling(false);
                    //enemy.isBattling = false;
                    enemy.setBattling(false);
                }
            }
            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0)
                field.gameOver();
        }
        else{   /*蛇精阵营*/
            //System.out.println("蛇精阵营成员");
            while(!exit && getAlive() && field.countAliveOfHulu() != 0 && field.countAliveofSnake() != 0 && cor_x > 0){
                if(getBattling())
                    continue;
                boolean waitingForBattle = false;
                if(field.inquireField(cor_x-1, cor_y) && field.inquireAlive(cor_x-1, cor_y) && field.creature[cor_y][cor_x-1].memOfHulu()){
                    /* 正前方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y][cor_x-1].getBattling()){
                        battle(field.creature[cor_y][cor_x-1]);
                        if(getAlive()){
                            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try{
                                thread.sleep(1000);
                            }
                            catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        }
                        else {
                            field.creature[cor_y][cor_x-1].setBattling(false);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }

                if(cor_y > 0 && field.inquireField(cor_x-1, cor_y-1) && field.inquireAlive(cor_x-1, cor_y-1) && field.creature[cor_y-1][cor_x-1].memOfHulu()){
                    /* 前上方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y-1][cor_x-1].getBattling()) {
                        battle(field.creature[cor_y - 1][cor_x - 1]);
                        if (getAlive()) {
                            if (field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try {
                                thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        } else {
                            field.creature[cor_y-1][cor_x-1].setBattling(false);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }
                if(cor_y < 7 && field.inquireField(cor_x-1,cor_y+1) && field.inquireAlive(cor_x-1,cor_y+1) && field.creature[cor_y+1][cor_x-1].memOfHulu()){
                    /* 前下方有活的敌人 */
                    if(!getBattling() && !field.creature[cor_y+1][cor_x-1].getBattling()){
                        battle(field.creature[cor_y+1][cor_x-1]);
                        if(getAlive()){
                            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0) {
                                field.gameOver();
                                break;
                            }
                            try{
                                thread.sleep(1000);
                            }
                            catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            //isBattling = false;
                            setBattling(false);
                            continue;
                        }
                        else {
                            field.creature[cor_y+1][cor_x-1].setBattling(false);
                            break;
                        }
                    }
                    else
                        waitingForBattle = true;
                }
                if(!waitingForBattle){
                    int new_x = cor_x;
                    while(new_x>0){
                        new_x -= 1;
                        if(!field.inquireField(new_x, cor_y)){
                            moveTo(new_x, cor_y);
                            break;
                        }
                        else{
                            if(field.creature[cor_y][new_x].getAlive() && field.creature[cor_y][new_x].memOfHulu() && !field.creature[cor_y][new_x].getBattling()){
                                battle(field.creature[cor_y][new_x]);
                                //isBattling = false;
                                setBattling(false);
                                field.creature[cor_y][new_x].setBattling(false);
                                break;
                            }
                            else if(field.creature[cor_y][new_x].memOfSnake())
                                break;
                        }
                    }
                }
                if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0)
                    field.gameOver();
                try{
                    thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            setBattling(false);
            while(cor_x == 0 && getAlive() && field.countAliveOfHulu() != 0){
                Creature enemy = field.findAliveOfHulu();
                if(!getBattling() && enemy != null && !enemy.getBattling()){
                    battle(enemy);
                    //isBattling = false;
                    //enemy.isBattling = false;
                    setBattling(false);
                    enemy.setBattling(false);
                }
            }
            if(field.countAliveOfHulu() == 0 || field.countAliveofSnake() == 0)
                field.gameOver();
        }
    }

    public void start(){
        exit = false;
        thread = new Thread(this);
        thread.start();
        //System.out.println("Thread starts running");
    }

    public void stop(){
        exit = true;
    }
}
