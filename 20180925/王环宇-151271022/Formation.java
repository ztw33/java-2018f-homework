import java.util.ArrayList;
import java.io.*;

public class Formation implements FormationInterface{
	/*
	 * 阵型类，保存双方的阵型信息
	 * Variables: ArrayList<int[][]> book1, ArrayList<int[][]> book1;
	 * Methods: initialization(), getForm(), convert();
	 * 	从文件中读取阵型
	 * */
	private static ArrayList<int[][]> book1;
	private static ArrayList<int[][]> book2;
	private static ArrayList<String> name;
	
	public static void initialization() {
		book1 = new ArrayList<int[][]>();
		book2 = new ArrayList<int[][]>();
		name = new ArrayList<String>();
		readFromFile();	
	}
	
	public static int[][] getForm(int m, int team){
		if (team == 1)
			return book1.get(m);
		else
			return book2.get(m);
	}
	private static int[][] convert(int[][] xx){
		int[][] y = new int[8][2];
		for (int i=0; i<7; i++) {
			y[i][1] = 14 - xx[i][1];
			y[i][0] = xx[i][0];
		}
		y[7][1] = 14 - xx[7][1];
		y[7][0] = xx[7][0];
		return y;
	}
	
	
	public static void readFromFile() {
		
		String fileName="/Users/huanyu_wang/eclipse-workspace/JavaHomework/src/formation.txt";
		ArrayList<String> arrayList = new ArrayList<>();
		int[][] books = new int[8][2];
		try
		{
			FileReader file = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(file);
			String str;
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			file.close();
		} 
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
		for(String file_string:arrayList) {
			if(file_string.isEmpty()) continue;
			String[] str = file_string.split(" ");
			name.add(str[0]);
			System.out.println(str[0]);
			for(int i=1; i < str.length; i++) {
				int temp = i/2;
				books[temp][0] = Integer.parseInt(str[i++]);
				books[temp][1] = Integer.parseInt(str[i]);
			}
			book1.add(books);
			book2.add(convert(books));	
		}
	}
	
	public static void show() {
		System.out.println("************双方战士上场**************");
		System.out.println("*********请选择妖精上场的阵型**********");
		for(int i=0; i<name.size(); i++) {
			System.out.println("**********"+ i +"----------"+name.get(i)+"**********");
		}
	}
	
	
}