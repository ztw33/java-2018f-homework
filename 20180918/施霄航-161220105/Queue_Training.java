package njuics.java2018.cb;

class Calabash_Brother{
	//名字，颜色，位置
	private String name;
	private int no;
	private String color;
	private int pos;
	
	Calabash_Brother(String Name, String Color, int No ){
		name = Name;
		color = Color;
		no = No;
	}
	
	public void init_pos(int Pos) {
		pos = Pos;
	}
	
	public void tell_number() {
		System.out.println(name);
	}
	
	public void tell_color() {
		System.out.println(color);
	}
	
	public void reset_pos(int newPos) {	
		//为了操作简单起见，newPos有可能与pos相同，所以报告位置变化前要先做判断
		if(pos != newPos)
			System.out.println(name + ":" + pos + "->" + newPos);
		pos = newPos;
	}
	
	public int my_no() {
		return no;
	}
}


class CB_queue{
	private Calabash_Brother cb[] = {
		new Calabash_Brother("老大", "赤", 1),
		new Calabash_Brother("老二", "橙", 2),
		new Calabash_Brother("老三", "黄", 3),			
		new Calabash_Brother("老四", "绿", 4),
		new Calabash_Brother("老五", "青", 5),				
		new Calabash_Brother("老六", "蓝", 6),
		new Calabash_Brother("老七", "紫", 7),
	};
	
	private Calabash_Brother Array[] = new Calabash_Brother[7];
	
	public void init1() {
		//随机排列初始化
		cb[0].init_pos(7);Array[6]=cb[0];
		cb[1].init_pos(5);Array[4]=cb[1];
		cb[2].init_pos(3);Array[2]=cb[2];
		cb[3].init_pos(1);Array[0]=cb[3];
		cb[4].init_pos(4);Array[3]=cb[4];
		cb[5].init_pos(6);Array[5]=cb[5];
		cb[6].init_pos(2);Array[1]=cb[6];
				
	}
	
	
	public void init2() {
		//随机排列初始化
		cb[0].init_pos(5);Array[4]=cb[0];
		cb[1].init_pos(3);Array[2]=cb[1];
		cb[2].init_pos(1);Array[0]=cb[2];
		cb[3].init_pos(4);Array[3]=cb[3];
		cb[4].init_pos(2);Array[1]=cb[4];
		cb[5].init_pos(6);Array[5]=cb[5];
		cb[6].init_pos(7);Array[6]=cb[6];
	}
	
	public void Bubblesort() {
		//冒泡
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 6 - i; j++) {
				if(Array[j].my_no() > Array[j+1].my_no()) {
		          Array[j].reset_pos(j+2);
		          Array[j+1].reset_pos(j+1);
		          Calabash_Brother temp = Array[j];
		          Array[j] = Array[j + 1];
		          Array[j + 1] = temp;
		        //System.out.println(j);		          
		        }
			}
				
		for(int i = 0; i < 7; i++) 
			Array[i].tell_number();
	}
	
	
	public void Binaryinsertionsort() {

		//二分插入
		 for (int i = 1; i < 7; i++) {
			 Calabash_Brother temp = Array[i];
		     int low = 0, high = i - 1;
		     int mid = -1;
		     while (low <= high) {            
		    	 mid = low + (high - low) / 2;            
		    	 if (Array[mid].my_no() > temp.my_no())                
		    		 high = mid - 1;    
		         else  
		             low = mid + 1;                    
		     }        
		     for(int j = i - 1; j >= low; j--) {            
		    	 Array[j + 1] = Array[j];
		         Array[j].reset_pos(j+2);
		     }        
		     Array[low] = temp;   
		     temp.reset_pos(low+1);
		 	}
			
		 for(int i = 0; i < 7; i++) 
			Array[i].tell_color();
		
	}
	
}




public class Queue_Training {
	public static void main(String[] args) {
		
		CB_queue cbq = new CB_queue();
		cbq.init1();
		cbq.Bubblesort();
		cbq.init2();
		cbq.Binaryinsertionsort();
				
	}
}
