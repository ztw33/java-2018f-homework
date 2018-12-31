package calabashbrothersVSmonsters;
import java.io.*;
import java.util.Random;

enum Formation{
	CRANEWING("鹤翼阵",new CraneWing()),WILDGOOSEROW("雁行阵",new WildGooseRow()),CROSSBAR("衡軛阵",new CrossBar()),SERPENT("长蛇阵",new SerpentArray()),FISHSCALE("鱼鳞阵",new FishScale()),SQUARECIRCLE("方圆阵",new SquareCircle()),CRESCENTMOON("偃月阵",new CrescentMoon()),ARROW("锋矢阵",new Arrow());
	String name;
	Stance stance;
	static final int number=8;
	Formation(String name,Stance stance){
		this.name=name;
		this.stance=stance;
	}
	public String toString() {
		return name;
	}
}

public class Array {
	private FrameShow fs;
	private Formation form;
	private final int dimension=Stance.dimension;
	Array() throws IOException{
		fs=new FrameShow();
		fs.clearout();
	}
	Array(Formation form) throws IOException{
		fs=new FrameShow();
		this.form=form;
		fs.setformationname(form.toString());
	}
	void resetformation(Formation form) {
		this.form=form;
		fs.setformationname(form.toString());
	}
	void addcreatures(Creature... c) throws InterruptedException {
		if(form==null) {
			System.out.println("还未设置阵形!");
			return;
		}
		int len=c.length;
		int sequence=0;
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				if(form.stance.station[i][j]==0)
					continue;
				for(int k=0;k<len;k++) {
					if(form.stance.station[i][j]==c[k].symbol) {
						sequence++;
						if(sequence==1) {
							c[k].talk();
						}
						fs.place(c[k].image, i, j);
						Thread.sleep(500);
						break;
					}
				}
			}
		}
	}
	Formation setrandomplace() {
		Random r=new Random();
		int randomnumber=r.nextInt(Formation.number-1);
		while(randomnumber==3)
			randomnumber=r.nextInt(Formation.number-1);
		form=Formation.values()[randomnumber];
		fs.setformationname(form.toString());
		return form;
	}
}
