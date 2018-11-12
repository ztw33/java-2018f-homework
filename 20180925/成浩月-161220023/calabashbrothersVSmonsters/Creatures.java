package calabashbrothersVSmonsters;
import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;

import java.applet.AudioClip;
import java.net.URI;
import java.net.URL;
import javax.swing.JApplet;


class Creature {
	char symbol;
	Image image;
	String wholepath=new String("\\src\\calabashbrothersVSmonsters\\additions");
	Creature() throws IOException{
		File directory = new File("");
        String tmp = directory.getCanonicalPath();
        wholepath=tmp+wholepath;
	}
	void talk() {};
}

class CalabashBrother extends Creature{
	enum CalabashRank{
		FIRST("\\c1.jpg"),SECOND("\\c2.jpg"),THIRD("\\c3.jpg"),FOURTH("\\c4.jpg"),FIFTH("\\c5.jpg"),SIXTH("\\c6.jpg"),SEVENTH("\\c7.jpg");
		String imagepath;
		CalabashRank(String imagepath){
			this.imagepath=imagepath;
		}
	}
	static final int number=7;
	private CalabashRank status;
	private static String musicpath="\\calabashbrothers.wav";
	private static File musicfile;
	private static AudioClip ac;
	CalabashBrother(int number) throws IOException{
		if(number<1||number>7){
			System.out.println("error!this calabashbrother isn't existent!");
			return;
		}
		symbol=(char)number;
		status=CalabashRank.values()[number-1];
		try {
			image=ImageIO.read(new File(wholepath+status.imagepath));
			musicfile=new File(wholepath+musicpath);
		}catch(IOException e) {
			System.out.println("error "+e);
		}
		URI uri=musicfile.toURI();
		URL url=uri.toURL();
		ac=JApplet.newAudioClip(url);
	}
	void talk() {
		try {
			ac.play();
		}
		catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}

class Human extends Creature{
	private static final String imagepath="\\grandparent.jpg";
	Human() throws IOException{
		symbol=8;
		wholepath=wholepath+imagepath;
		try {
		image=ImageIO.read(new File(wholepath));
		}catch(IOException e) {
			System.out.println("error "+e);
		}
	}
}

class Serpent extends Creature{
	private static final String imagepath="\\serpent.jpg";
	Serpent()throws IOException{
		symbol='s';
		wholepath=wholepath+imagepath;
		try {
			image=ImageIO.read(new File(wholepath));
			}catch(IOException e) {
				System.out.println("error "+e);
			}
	}
}

class Scorpion extends Creature{
	private static final String imagepath="\\scorpion.jpg";
	private static String musicpath="\\monsters.wav";
	private static File musicfile;
	private static AudioClip ac;
	Scorpion()throws IOException{
		symbol='y';
		try {
			image=ImageIO.read(new File(wholepath+imagepath));
			musicfile=new File(wholepath+musicpath);
		}catch(IOException e) {
			System.out.println("error "+e);
		}
		URI uri=musicfile.toURI();
		URL url=uri.toURL();
		ac=JApplet.newAudioClip(url);
	}
	void talk() {
		try {
			ac.play();
		}
		catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}

class Toad extends Creature{
	private static final String imagepath="\\toad.jpg";
	Toad()throws IOException{
		symbol='a';
		wholepath=wholepath+imagepath;
		try {
			image=ImageIO.read(new File(wholepath));
			}catch(IOException e) {
				System.out.println("error "+e);
			}
	}
}

public class Creatures{
	public static void main(String[] args) throws IOException, InterruptedException {
		Formation form=Formation.SERPENT;
		Array array=new Array(form);
		CalabashBrother[] cala=new CalabashBrother[CalabashBrother.number];
		for(int i=0;i<7;i++)
			cala[i]=new CalabashBrother(i+1);
		Human grandpa=new Human();
		Scorpion y=new Scorpion();
		Serpent s=new Serpent();
		Toad a=new Toad();
		//添加葫芦娃到长蛇阵
		array.addcreatures(cala);
		

		//换一个阵形,添加妖精
		Thread.sleep(5000);
		array.setrandomplace();
		form=array.setrandomplace();
		array.addcreatures(y);
		array.addcreatures(a);
		
		//添加葫芦娃
		Thread.sleep(3000);
		array.addcreatures(cala);
		
		//添加啦啦队
		array.addcreatures(grandpa,s);
		
		//换一个队形
		Thread.sleep(5000);
		form=array.setrandomplace();
		array.addcreatures(y);
		array.addcreatures(a);
		Thread.sleep(3000);
		array.addcreatures(cala);
		array.addcreatures(grandpa,s);
	}
}