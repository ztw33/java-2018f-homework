package sample;

import javafx.application.Platform;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Field {
    @Edit(editor = "zmr", time = "20181203")
    private boolean field[][] = new boolean[8][8];      //true: exists culture
    public Creature creature[][] = new Creature[8][8];
    public HuluBro brothers[] = new HuluBro[7];
    public Grandpa grandpa;
    public Snake snake;
    public Scropion scropion;
    public LoLo LoLo[];
    int formation;
    public int numLoLo = 4;
    public Controller controller;
    private boolean gameOver;

    File file;
    FileOutputStream output ;

    public Field(int f, Controller c, File fl, FileOutputStream fos){
        controller = c;
        file = fl;
        output = fos;
        gameOver = false;
        try{
            file = new File("record.txt");
            /*if(file.exists()){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.flush();
                fileWriter.close();
            }*/
            if(!file.exists())
                file.createNewFile();
            output = new FileOutputStream(file);
            byte[] bytes = ("formation " + formation + "\r\n").getBytes();
            output.write(bytes);
            //output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                field[i][j] = false ;

        for(int i = 0; i < 7; i++){
            HuluBro tmp = new HuluBro(i+1, this, file, output);
            brothers[i] = tmp;
            int x = brothers[i].getCor_x();
            int y = brothers[i].getCor_y();
            creature[y][x] = brothers[i];
            field[y][x] = true;
        }
        grandpa = new Grandpa(this, file, output);
        int x = grandpa.getCor_x();
        int y = grandpa.getCor_y();
        creature[y][x] = grandpa;
        field[y][x] = true;

        snake = new Snake(this, file, output);
        x = snake.getCor_x();
        y = snake.getCor_y();
        creature[y][x] = snake;
        field[y][x] = true;

        scropion = new Scropion(this, file, output);
        x = scropion.getCor_x();
        y = scropion.getCor_y();
        creature[y][x] = scropion;
        field[y][x] = true;

        formation = f;
        switch (formation){
            case 1: //鹤翼
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                LoLo Lo1 = new LoLo(3,2, this, 0, file, output);
                LoLo Lo2 = new LoLo(4,3, this, 1, file, output);
                LoLo Lo3 = new LoLo(6,3, this, 2, file, output);
                LoLo Lo4 = new LoLo(7,2, this, 3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3 ;
                LoLo[3] = Lo4;
                break;
            case 2: //雁行
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(3,6, this,0, file, output);
                Lo2 = new LoLo(4,5, this,1, file, output);
                Lo3 = new LoLo(6,2, this,2, file, output);
                Lo4 = new LoLo(7,1, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 3: //衡轭
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,2, this,0, file, output);
                Lo2 = new LoLo(5,1, this,1, file, output);
                Lo3 = new LoLo(4,5, this,2, file, output);
                Lo4 = new LoLo(5,6, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 4: //长蛇
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(5,1, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(5,5, this,2, file, output);
                Lo4 = new LoLo(5,6, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 5: //鱼鳞
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,1, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(4,3, this,2, file, output);
                Lo4 = new LoLo(6,3, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 6: //方块
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,3, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(6,3, this,2, file, output);
                Lo4 = new LoLo(7,3, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 7: //偃月
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(6,2, this,0, file, output);
                Lo2 = new LoLo(6,4, this,1, file, output);
                Lo3 = new LoLo(7,1, this,2, file, output);
                Lo4 = new LoLo(7,5, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 8:
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(5,2, this,0, file, output);
                Lo2 = new LoLo(4,3, this,1, file, output);
                Lo3 = new LoLo(6,3, this,2, file, output);
                Lo4 = new LoLo(5,5, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
        }
        for(int i = 0; i < numLoLo; i++){
            x = LoLo[i].getCor_x();
            y = LoLo[i].getCor_y();
            creature[y][x] = LoLo[i];
            field[y][x] = true;
        }
    }

    public boolean inquireField(int x, int y){
        //System.out.print(creature[y][x].name);
        assert (0<=x && x <=7 && 0<=y && y<=7);
        return field[y][x];
    }

    public boolean inquireAlive(int x, int y){
        assert (field[y][x]);
        return creature[y][x].alive;
    }

    public synchronized void move(Creature c, int old_x, int old_y, int new_x, int new_y){
        field[old_y][old_x] = false;
        field[new_y][new_x] = true;
        creature[new_y][new_x] = c;
    }

    public void show(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(field[i][j])
                    System.out.print(creature[i][j].name + " ");
                else
                    System.out.print("无人 ");
            }
            System.out.println();
        }
    }

    public int countAliveOfHulu(){
        int count = 0;
        if(grandpa.getAlive())
            count++;
        for(int i = 0; i < 7; i++){
            if(brothers[i].getAlive())
                count++;
        }
        return count;
    }
    public int countAliveofSnake(){
        int count = 0;
        if(snake.getAlive())
            count++;
        if(scropion.getAlive())
            count++;
        for(int i = 0; i < numLoLo; i++){
            if(LoLo[i].getAlive())
                count++;
        }
        return count;
    }

    public Creature findAliveOfHulu(){
        for(int i = 0; i < 7; i++)
        {
            if(brothers[i].alive)
                return brothers[i];
        }
        if(grandpa.alive)
            return grandpa;
        else
            return null;
    }
    public Creature findAliveOfSnake(){
        for(int i = 0; i < numLoLo; i++){
            if(LoLo[i].alive)
                return LoLo[i];
        }
        if(scropion.alive)
            return scropion;
        else if(snake.alive)
            return snake;
        else
            return null;
    }
    public void gameOver(){
        if(gameOver == true)
            return;
        if(countAliveOfHulu() == 0 && countAliveofSnake() > 0){
            gameOver = true;
            System.out.println("Winner is Snake!");
            controller.printMessage("Game is over!\r\nWinner is Snake!\r\n");
            byte[] bytes = "Winner Snake".getBytes();
            try {
                output.write(bytes);
                output.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            Platform.runLater(new Runnable() {
                public void run() {
                    controller.refresh();
                }
            });
        }
        else if(countAliveofSnake() == 0 && countAliveOfHulu() > 0){
            gameOver = true;
            System.out.println("Winner is HuluBrothers!");
            controller.printMessage("Game is over!\r\nWinner is HuluBrothers!\r\n");
            byte[] bytes = "Winner HuluBrothers".getBytes();
            try{
                output.write(bytes);
                output.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            Platform.runLater(new Runnable() {
                public void run() {
                    controller.refresh();
                }
            });
        }
        for(int i = 0; i < 7; i++)
            brothers[i].stop();
        grandpa.stop();
        snake.stop();
        scropion.stop();
        for(int i = 0; i < numLoLo; i++)
            LoLo[i].stop();
    }

    public void print(String str){
        controller.printMessage(str);
    }

    public void changeFormation(int newFormation){
        formation = newFormation;
        int x, y;
        switch (formation){
            case 1: //鹤翼
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                LoLo Lo1 = new LoLo(3,2, this, 0, file, output);
                LoLo Lo2 = new LoLo(4,3, this, 1, file, output);
                LoLo Lo3 = new LoLo(6,3, this, 2, file, output);
                LoLo Lo4 = new LoLo(7,2, this, 3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3 ;
                LoLo[3] = Lo4;
                break;
            case 2: //雁行
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(3,6, this,0, file, output);
                Lo2 = new LoLo(4,5, this,1, file, output);
                Lo3 = new LoLo(6,2, this,2, file, output);
                Lo4 = new LoLo(7,1, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 3: //衡轭
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,2, this,0, file, output);
                Lo2 = new LoLo(5,1, this,1, file, output);
                Lo3 = new LoLo(4,5, this,2, file, output);
                Lo4 = new LoLo(5,6, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 4: //长蛇
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(5,1, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(5,5, this,2, file, output);
                Lo4 = new LoLo(5,6, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 5: //鱼鳞
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,1, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(4,3, this,2, file, output);
                Lo4 = new LoLo(6,3, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 6: //方块
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(4,3, this,0, file, output);
                Lo2 = new LoLo(5,2, this,1, file, output);
                Lo3 = new LoLo(6,3, this,2, file, output);
                Lo4 = new LoLo(7,3, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 7: //偃月
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(6,2, this,0, file, output);
                Lo2 = new LoLo(6,4, this,1, file, output);
                Lo3 = new LoLo(7,1, this,2, file, output);
                Lo4 = new LoLo(7,5, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
            case 8:
                numLoLo = 4;
                LoLo = new LoLo[numLoLo];
                Lo1 = new LoLo(5,2, this,0, file, output);
                Lo2 = new LoLo(4,3, this,1, file, output);
                Lo3 = new LoLo(6,3, this,2, file, output);
                Lo4 = new LoLo(5,5, this,3, file, output);
                LoLo[0] = Lo1;
                LoLo[1] = Lo2;
                LoLo[2] = Lo3;
                LoLo[3] = Lo4;
                break;
        }
        for(int i = 0; i < numLoLo; i++){
            x = LoLo[i].getCor_x();
            y = LoLo[i].getCor_y();
            creature[y][x] = LoLo[i];
            field[y][x] = true;
        }
    }

    public Creature getObjByName(String name){
        if(name.equals("Hulu1") || name.equals("老大")){
            return brothers[0];
        }
        if(name.equals("Hulu2") || name.equals("老二")){
            return brothers[1];
        }
        if(name.equals("Hulu3") || name.equals("老三")){
            return brothers[2];
        }
        if(name.equals("Hulu4") || name.equals("老四")){
            return brothers[3];
        }
        if(name.equals("Hulu5") || name.equals("老五")){
            return brothers[4];
        }
        if(name.equals("Hulu6") || name.equals("老六")){
            return brothers[5];
        }
        if(name.equals("Hulu7") || name.equals("老七")){
            return brothers[6];
        }
        if(name.equals("Grandpa") || name.equals("老爷爷"))
            return grandpa;
        if(name.equals("Snake") || name.equals("蛇精"))
            return snake;
        if(name.equals("Scropion") || name.equals("蝎子精"))
            return scropion;
        char c = name.charAt(name.length()-1);
        System.out.println(name + " " + c);
        return LoLo[c-'0'];
    }

    public void display(File file){
        new Runnable() {
            Thread thread;
            @Override
            public void run() {
                BufferedReader br;
                try {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));
                }
                catch(FileNotFoundException e){
                    br = null;
                    e.printStackTrace();
                }
                String operate = null;
                //Thread thread = new Thread();
                while(true) {
                    try {
                        operate = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    if (operate == null)
                        break;
                    String[] splited = operate.split("\\s+");
                    switch (splited[0]) {
                        case "formation":
                            formation = Integer.parseInt(splited[1]);
                            //controller.refresh();
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    controller.refresh();
                                }
                            });
                            break;
                        case "move":
                            String name = splited[1];
                            int old_x, old_y, new_x, new_y;
                            old_x = Integer.parseInt(splited[2]);
                            old_y = Integer.parseInt(splited[3]);
                            new_x = Integer.parseInt(splited[4]);
                            new_y = Integer.parseInt(splited[5]);
                            getObjByName(name).moveTo(new_x, new_y);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    controller.refresh();
                                }
                            });
                            break;
                        case "defeat":
                            String winner = splited[1];
                            String loser = splited[2];
                            getObjByName(loser).alive = false;
                            getObjByName(loser).dead();
                            //controller.changeIcon();
                            String str;
                            if(!LoLo.class.isInstance(winner) && !LoLo.class.isInstance(loser))
                                str = winner + " defeated " + loser + "\r\n";
                            else if(!LoLo.class.isInstance(winner) && LoLo.class.isInstance(loser))
                                str = winner + " defeated " + loser + getObjByName(loser).index+ "\r\n";
                            else if(LoLo.class.isInstance(winner) && !LoLo.class.isInstance(loser))
                                str = winner + getObjByName(winner).index + " defeated " + loser+ "\r\n";
                            else
                                str = winner + getObjByName(winner).index + " defeated " + loser + getObjByName(loser).index+ "\r\n";
                            print(str);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    controller.refresh();
                                }
                            });
                            break;
                        case "Winner":
                            String win = splited[1];
                            gameOver();
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    controller.refresh();
                                }
                            });
                            break;
                        default:
                            break;
                    }
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            //@Override
            public void start(){
                thread = new Thread(this);
                thread.start();
            }
        }.start();
    }
}
