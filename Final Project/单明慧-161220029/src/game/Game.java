package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;

import spritecontroller.*;
import battlefield.*;
import form.*;
import bullet.*;

public class Game implements Runnable{
	private CalabashBrothers sevenBro;
	private Grandpa oneGrandpa;
	private ArrayList<Underlyings> severalUnderlying;
	private Snake oneSnake;
	private Scorpion oneScorpion;
	private BattleField battlefield;
	private Form formController;
	private int underSize;
	public ArrayList<Thread> allthreads;
	private ArrayList<Bullet> allBullets;
	private ArrayList<String> instr;
	private File save;
	private FileOutputStream out;
	FileReader reader;
	BufferedReader br;
	
	public Game(int formation){
		try {
		 save = new File("161220029.huluwa");
		 save.createNewFile();
         out=new FileOutputStream(save, true);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sevenBro = new CalabashBrothers();
		oneGrandpa = new Grandpa();
		severalUnderlying = new ArrayList<Underlyings>();
		oneSnake = new Snake();
		oneScorpion = new Scorpion();
		battlefield = new BattleField();
		formController = new Form();
		underSize = 0;	
		allthreads = new ArrayList<Thread>();
		allBullets = new ArrayList<Bullet>();
		
		formForCalabash();
		formForBad(formation%7 + 1);
		enterBattleField();
		for(int i = 0; i < 7; i++) {
			sevenBro.sevenBro[i].observeEnemy(severalUnderlying, oneScorpion, oneSnake, battlefield);
			sevenBro.sevenBro[i].getBullList(allBullets);
			sevenBro.sevenBro[i].getOut(out);
			sevenBro.sevenBro[i].getFile(save);
		}
		oneScorpion.observeEnemy(sevenBro, oneGrandpa, battlefield);
		oneScorpion.getBullList(allBullets);
		oneScorpion.getOut(out);
		oneScorpion.getFile(save);
		for(int i = 0; i < severalUnderlying.size(); i++) {
			severalUnderlying.get(i).observeEnemy(sevenBro, oneGrandpa, battlefield);
			severalUnderlying.get(i).getBullList(allBullets);
			severalUnderlying.get(i).getOut(out);
			severalUnderlying.get(i).getFile(save);
		}
		sevenBro.getThreads(allthreads);
		oneScorpion.getThread(allthreads);
		for(int i = 0; i < severalUnderlying.size(); i++) {
			severalUnderlying.get(i).getThread(allthreads);
		}
		oneSnake.observeEnemy(sevenBro, oneGrandpa, battlefield);
		oneSnake.getBullList(allBullets);
		oneSnake.getThread(allthreads);
		oneSnake.getOut(out);
		oneSnake.getFile(save);
		
		oneGrandpa.observeEnemy(severalUnderlying, oneScorpion, oneSnake, battlefield);
		oneGrandpa.getBullList(allBullets);
		oneGrandpa.getThread(allthreads);
		oneGrandpa.getOut(out);
		oneGrandpa.getFile(save);
	}
	public Game(File file) {
		instr = new ArrayList<String>();
		
		sevenBro = new CalabashBrothers();
		oneGrandpa = new Grandpa();
		severalUnderlying = new ArrayList<Underlyings>();
		oneSnake = new Snake();
		oneScorpion = new Scorpion();
		battlefield = new BattleField();
		formController = new Form();
		underSize = 0;	
		allthreads = new ArrayList<Thread>();
		allBullets = new ArrayList<Bullet>();
		try{		
			reader = new FileReader(file);
			br = new BufferedReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	public void showReload(GraphicsContext gc, Pane p) {
		battlefield.show(gc);
		for(int i = 0; i < 7; i++) {
			if(!sevenBro.sevenBro[i].isDead)
				sevenBro.sevenBro[i].render(gc ,p);
		}
		if(!oneGrandpa.isDead)
			oneGrandpa.render(gc, p);
		if(!oneSnake.isDead)
			oneSnake.render(gc, p);
		if(!oneScorpion.isDead)
			oneScorpion.render(gc, p);
		for(int i = 0; i < severalUnderlying.size(); i++) {
			if(!severalUnderlying.get(i).isDead)
				severalUnderlying.get(i).render(gc, p);
		}	
		for(Bullet b : allBullets) {
			if(!b.isDone)
				b.renderReload(p);
		}
	}
	
	public void show(GraphicsContext gc, Pane p) {
		battlefield.show(gc);
		for(int i = 0; i < 7; i++) {
			sevenBro.sevenBro[i].render(gc ,p);
		}
		oneGrandpa.render(gc, p);
		oneSnake.render(gc, p);
		oneScorpion.render(gc, p);
		for(int i = 0; i < severalUnderlying.size(); i++) {
			severalUnderlying.get(i).render(gc, p);
		}
		showBullet(p);
	}
	
	public void showBullet(Pane p) {
		for(Bullet b : allBullets) {
			if(!b.isDone)
				b.render(p);
		}
	}
	
	protected void enterBattleField() {
		for(int i = 0; i < 7 ;i++) {
			battlefield.standOn(sevenBro.sevenBro[i]);
		}
		battlefield.standOn(oneGrandpa);
		battlefield.standOn(oneScorpion);
		battlefield.standOn(oneSnake);
		for(int i = 0 ; i < severalUnderlying.size();i++) {
			battlefield.standOn(severalUnderlying.get(i));
		}
	}
	
	protected void formForCalabash() {
		formController.formForGood(sevenBro, oneGrandpa);
	}
	
	protected void formForBad(int type) {
		switch(type) {
		case 1:underSize = formController.HE_YI(oneScorpion, oneSnake, severalUnderlying);break;
		case 2:underSize = formController.YAN_XING(oneScorpion, oneSnake, severalUnderlying);break;
		case 3:underSize = formController.HENG_E(oneScorpion, oneSnake, severalUnderlying);break;
		case 4:underSize = formController.YU_LIN(oneScorpion, oneSnake, severalUnderlying);break;
		case 5:underSize = formController.FANG_YUAN(oneScorpion, oneSnake, severalUnderlying);break;
		case 6:underSize = formController.YAN_YUE(oneScorpion, oneSnake, severalUnderlying);break;
		case 7:underSize = formController.FENG_SHI(oneScorpion, oneSnake, severalUnderlying);break;
		default:break;
		}
	}
	public void saveNow() throws IOException {
		@SuppressWarnings("resource")
		FileWriter w =new FileWriter(save, true);
		//w.write("\n");
		w.write(underSize + "\n");
		for(int i = 0; i < 7; i++) {
			int tmp = 0;
			if(sevenBro.sevenBro[i].isDead) {
				tmp = 1;
			}else {
				tmp = 0;
			}
			w.write(tmp + " " + sevenBro.sevenBro[i].getHp() + " " +sevenBro.sevenBro[i].x() +" "+ sevenBro.sevenBro[i].y() + "\n");
		}
		int tmp = 0;
		if(oneGrandpa.isDead) {
			tmp = 1;
		}else {
			tmp = 0;
		}
		w.write(tmp + " " + oneGrandpa.getHp() + " " + oneGrandpa.x() + " "+ oneGrandpa.y() + "\n");
		if(oneScorpion.isDead) {
			tmp = 1;
		}else {
			tmp = 0;
		}
		w.write(tmp + " " + oneScorpion.getHp() + " " + oneScorpion.x() +" "+ oneScorpion.y() + "\n");
		if(oneSnake.isDead) {
			tmp = 1;
		}else {
			tmp = 0;
		}
		w.write(tmp + " " + oneSnake.getHp() + " " + oneSnake.x() + " "+oneSnake.y() + "\n");
		for(int i = 0; i < underSize; i++) {
			tmp = 0;
			if(severalUnderlying.get(i).isDead) {
				tmp = 1;
			}else {
				tmp = 0;
			}
			w.write(tmp + " " + severalUnderlying.get(i).getHp() + " " +severalUnderlying.get(i).x() +" "+severalUnderlying.get(i).y() + "\n");
		}
		int tsize = allBullets.size();
		w.write(tsize + "\n");
		for(int i = 0; i <tsize; i++) {
			tmp = 0;
			if( allBullets.get(i).isDone) {
				tmp = 1;
			}else {
				tmp = 0;
			}
			w.write(tmp + " " + allBullets.get(i).posX +" "+ allBullets.get(i).posY +" " +allBullets.get(i).type+ "\n");
		}
		w.close();
		
	}
	public void getNow() {
			try{				
				
	            String line;
	            if ((line = br.readLine()) != null) {
	            	underSize = Integer.parseInt(line);
	                for(int i = 0; i < 7; i++) {   	
	                	line = br.readLine();
	                	//System.out.println("葫芦娃" + i + line);
	                	String[] tmp = line.split(" ");
	                	int isdead = Integer.parseInt(tmp[0]);
	                	if(isdead == 0) {
	                		sevenBro.sevenBro[i].isDead = false;
	                	}else {
	                		sevenBro.sevenBro[i].isDead = true;
	                	}
	                	sevenBro.sevenBro[i].currentHp = Integer.parseInt(tmp[1]);
	                	sevenBro.sevenBro[i].posX = Integer.parseInt(tmp[2]);
	                	sevenBro.sevenBro[i].posY = Integer.parseInt(tmp[3]);
	                }
	                line = br.readLine();
	               // System.out.println("老爷爷" + line);
	                String[] tmp = line.split(" ");
	                int isdead = Integer.parseInt(tmp[0]);
                	if(isdead == 0) {
                		oneGrandpa.isDead = false;
                	}else {
                		oneGrandpa.isDead = true;
                	}
                	oneGrandpa.currentHp = Integer.parseInt(tmp[1]);
                	oneGrandpa.posX = Integer.parseInt(tmp[2]);
                	oneGrandpa.posY = Integer.parseInt(tmp[3]);
                	
                	 line = br.readLine();
                	// System.out.println("蝎子精" + line);
 	                 tmp = line.split(" ");
 	                 isdead = Integer.parseInt(tmp[0]);
                 	if(isdead == 0) {
                 		oneScorpion.isDead = false;
                 	}else {
                 		oneScorpion.isDead = true;
                 	}
                 	oneScorpion.currentHp = Integer.parseInt(tmp[1]);
                 	oneScorpion.posX = Integer.parseInt(tmp[2]);
                 	oneScorpion.posY = Integer.parseInt(tmp[3]);
                 	
                 	 line = br.readLine();
                 	//System.out.println("蛇精" + line);
 	                 tmp = line.split(" ");
 	                 isdead = Integer.parseInt(tmp[0]);
                 	if(isdead == 0) {
                 		oneSnake.isDead = false;
                 	}else {
                 		oneSnake.isDead = true;
                 	}
                 	oneSnake.currentHp = Integer.parseInt(tmp[1]);
                 	oneSnake.posX = Integer.parseInt(tmp[2]);
                 	oneSnake.posY = Integer.parseInt(tmp[3]);
                 	//severalUnderlying.clear();
             	 for(int i = 0; i < underSize; i++) {
                	line = br.readLine();
                	//System.out.println("小喽啰" + i + " " + line);
                	if(severalUnderlying.size() < underSize)
                		severalUnderlying.add(new Underlyings(i));
                	tmp = line.split(" ");
                	isdead = Integer.parseInt(tmp[0]);
                	if(isdead == 0) {
                		severalUnderlying.get(i).isDead = false;		
                	}else {
                		severalUnderlying.get(i).isDead = true;
                	}
                	severalUnderlying.get(i).currentHp = Integer.parseInt(tmp[1]);
                	severalUnderlying.get(i).posX = Integer.parseInt(tmp[2]);
                	severalUnderlying.get(i).posY = Integer.parseInt(tmp[3]);
                }
                 	 
             	  line = br.readLine();
             	  allBullets.clear();
             	  int bsize = Integer.parseInt(line);
             	  int c = 0;
             	  for(int i = 0; i < bsize; i++) {
             		 line = br.readLine();
             		//System.out.println("子弹" + i + " " + line);
                 	tmp = line.split(" ");
                 	int isdone = Integer.parseInt(tmp[0]);
                 	if(isdone == 0) {
                 		allBullets.add(new Bullet(Integer.parseInt(tmp[3])));
                 		c++;
                 		allBullets.get(c-1).posX = Double.parseDouble(tmp[1]);
                     	allBullets.get(c-1).posY = Double.parseDouble(tmp[2]);
                 	}
             	  }         
	            }else {
	            	br.close();
	            	br = null;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public Thread tl = new Thread(this);
	@Override
	public void run() {
		while(br != null){
		getNow();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
