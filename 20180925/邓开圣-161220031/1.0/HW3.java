//References:
//https://blog.csdn.net/incyanggan/article/details/9819005
//https://www.cnblogs.com/frankliiu-java/archive/2010/12/07/1898721.html
//https://blog.csdn.net/liboom/article/details/68488279
//https://www.cnblogs.com/opangle/p/4082692.html
//https://blog.csdn.net/ytuglt/article/details/47312543
//http://maven.outofmemory.cn/org.fusesource.jansi/jansi/1.11/
//https://jingyan.baidu.com/article/ca41422fc76c4a1eae99ed9f.html
//https://blog.csdn.net/u010889616/article/details/51477037
//https://blog.csdn.net/nvliba/article/details/53520611
//https://blog.csdn.net/magi1201/article/details/42212537
//http://blog.51cto.com/dongdong1314/79385

package code;
import java.io.*;
import java.util.*;
//打印信息的接口
interface printinfo{
	void printout();
}
//用枚举类型定义七个葫芦娃
enum Calabash implements printinfo{
	//实例化
	Red("红色","老大",1),
	Orange("橙色","老二",2),
	Yellow("黄色","老三",3),
	Green("绿色","老四",4),
	Cyan("青色","老五",5),
	Blue("蓝色","老六",6),
	Purple("紫色","老七",7);
	//数据成员
	private String color;
	private String name;
	private int rank;
	//成员函数
	private Calabash(String color,String name,int rank) {
		this.color=color;
		this.name=name;
		this.rank=rank;
	}
	public String getname() {
		return this.name;
	}
	public String getcolor() {
		return this.color;
	}
	public int getrank() {
		return this.rank;
	}
	
	@ Override
	public void printout() {
		System.out.print(this.rank);
	}
	
}
//空缺(数量不定)
class Blank implements printinfo{
	private char sym='-';
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}
//小喽啰类(数量不定)
class Monster implements printinfo{
	private char sym='v';
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}
//以下三个类有且仅有一个对象
//蛇精
class Snack implements printinfo{
	public static Snack snack=new Snack();
	private char sym;
	private Snack() {
		this.sym='&';
	}
	@ Override
	public void printout() {
		System.out.print(sym);
	}
	
}
//蝎子精
class Crab implements printinfo{
	public static Crab crab=new Crab();
	private char sym;
	private Crab() {
		this.sym='%';
	}
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}
//老爷爷
class Elder implements printinfo{
	public static Elder elder=new Elder();
	private char sym;
	private Elder() {
		this.sym='o';
	}
	@ Override
	public void printout() {
		System.out.print(sym);
	}
}

public class HW3 {
	//范围的大小
	public static final int size=20;
	//阵型的种类数量
	public static final int num_shapes=7;
	//每种阵型的名称
	public static final String[] shape_names=
		{"鹤翼","雁行","衡轨","鱼鳞","方门","偃月","锋矢"};
	public static int shape_code;
	//定义一个Object类型的二维数组
	public static final Object [][] grid=new Object[size] [size];
	//存储各种阵型
	public static char [][][] shapes=new char [num_shapes][size/2][size];
	// 获取当前路径	
	private static final String wd=System.getProperty("user.dir");
	//存储阵型的配置文件名
	private static final String filename=wd+"\\shape_list.txt";
	//将grid全部初始化为Blank	
	public static void cleargrid() {

		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				Blank b=new Blank();
				grid[i][j]=b;
			}
		}
	}
	//根据传入的阵型设置方阵内容
	public static void setgrid(int shape_code) {
		//字符串数组拷贝
		char [][] get_shape=shapes[shape_code].clone();
		//上一半的矩阵用来排列妖怪阵营
		for(int i=0;i<size/2;i++) {
			for(int j=0;j<size;j++) {
				//System.out.print(get_shape[i][j]);
				switch(get_shape[i][j]) {
				case '-':	//空缺
					Blank b=new Blank();
					grid[i][j]=b;
					break;
				case 'v':	//小喽啰
					Monster m=new Monster();
					grid[i][j]=m;
					break;
				case '%':	//蝎子精
					grid[i][j]=Crab.crab;
					break;
				default:
						break;
				}
			}
			//System.out.println("");
		}
		//放置葫芦娃
		int cala_row=size/2;
		for(Calabash c:Calabash.values()) {
			grid[cala_row][9]=c;
			cala_row++;
		}
		
		Random r=new Random();
		//放置蛇精
		int snack_x,snack_y;
		do {
			snack_x=r.nextInt(size/2);
			snack_y=r.nextInt(size);
		}while(!(grid[snack_x][snack_y] instanceof Blank));
		grid[snack_x][snack_y]=Snack.snack;
		
		//System.out.println("");
		//printgrid();
		//放置老爷爷
		int elder_x,elder_y;
		do {
			elder_x=r.nextInt(size/2)+size/2;
			elder_y=r.nextInt(size);
		}while(!(grid[elder_x][elder_y] instanceof Blank));
		grid[elder_x][elder_y]=Elder.elder;
	}
	//扫描并打印方阵内容
	public static void printgrid(int shape_code) {
		System.out.println("当前阵型: "+shape_names[shape_code]);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				//子类对象向接口转型
				((printinfo) grid[i][j]).printout();
			}
			System.out.println("");
		}
	}

	//读取文件并将阵型配置存储在shapes数组中
	public static void read_shapelist() {
		try {
			File file=new File(filename);
			FileInputStream inputStream=new FileInputStream(file);
			BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
			String tmp=null;
			
			int count_shapes=0,count_rows=0;
			do {
				tmp=bf.readLine();
				if(tmp==null)
					break;
				if(!tmp.equals("")) {
					shapes[count_shapes][count_rows]=tmp.toCharArray();
					/*for(int i=0;i<size;i++) {
						System.out.print(shapes[count_shapes][count_rows][i]);
					}
					System.out.println("");*/
					
					count_rows++;					
				}
				else {
					count_rows=0;
					count_shapes++;
					//System.out.println("");
				}
			}while(tmp!=null);
			
			bf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//测试代码:输出shapes三维矩阵
		/*for(int i=0;i<shapes.length;i++) {
			for(int j=0;j<shapes[i].length;j++) {
				for(int k=0;k<shapes[i][j].length;k++) {
					System.out.print(shapes[i][j][k]);
				}
				System.out.println("");
			}
			System.out.println("");
		}*/
	}
	//返回变换阵型在配置文件中的序号
	//传入当前阵型的编号,保证下一个阵型与当前不同
	public static int change_shape_code(int current) {
		Random r=new Random();
		int get;
		do {
			get=r.nextInt(num_shapes);
		}while(get==current);
		return get;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(filename);
		read_shapelist();
		Random r=new Random();
		shape_code=r.nextInt(num_shapes);
		cleargrid();
		setgrid(shape_code);
		printgrid(shape_code);
		//用try...catch语句捕获IO异常
		try {
			//使用 System.in 创建 BufferedReader 
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("输入change变换1次阵型,或输入数字n变换n次阵型,输入end结束...");
				//从控制台读入字符串
				String str=br.readLine();
				if(str.equals("change")) {
					cleargrid();
					shape_code=change_shape_code(shape_code);
					setgrid(shape_code);
					printgrid(shape_code);
				}
				else if(str.equals("end")) {
					break;
				}
				else {
					//这里的try...catch语句捕获字符串转数字的异常
					try {
						//字符串转数字
						int x=Integer.parseInt(str);
						for(int i=0;i<x;i++) {
							cleargrid();
							shape_code=change_shape_code(shape_code);
							setgrid(shape_code);
							printgrid(shape_code);
						}
					} catch (NumberFormatException e) {
						System.out.println("指令无法识别,请重新输入...");						
					}
				}
			}while(true);

			System.out.println("结束");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
