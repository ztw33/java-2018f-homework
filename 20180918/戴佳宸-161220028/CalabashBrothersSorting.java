import java.awt.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
enum hulubrother{
	RED(1,"老大","红色"),ORANGE(2,"老二","橙色"),YELLOW(3,"老三","黄色"),GREEN(4,"老四","绿色"),INDIGO(5,"老五","青色"),BLUE(6,"老六","蓝色"),PURPLE(7,"老七","紫色");
private int num;
String rank;
private String color;
private hulubrother(int num, String rank, String color) {
    this.num = num;
    this.rank = rank;
    this.color = color;
}

public void NumberOff() {
    System.out.print(rank+" ");
}

public int getNum() {
    return num;
}

public void ColorOff() {
    System.out.print(color+" ");
}

public void move(int i, int j) {
    System.out.println(rank + "：" + (i+1) + "->" + (j+1));
}
}


public class CalabashBrothersSorting {
	private static hulubrother[] brothers=hulubrother.values();
	
	private static void swap(hulubrother[] brothers,int x,int y)
	{
		brothers[x].move(x, y);
		brothers[y].move(y, x);
		hulubrother temp=brothers[x];
		brothers[x]=brothers[y];
		brothers[y]=temp;
	}
    public static void myBubbleSort(hulubrother[] brothers) {

        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 6-i;j++) {
                if(brothers[j].getNum() > brothers[j+1].getNum())
                    swap(brothers,j,j+1);
            }
        }
        System.out.println("冒泡排序结束，报数：");
        for(int i=0;i<7;i++) {
        	brothers[i].NumberOff();
        }
    }
    public static void binarySort(hulubrother[] brothers) {

    	 for (int i = 1; i < 7; i++) {
    	        hulubrother temp = brothers[i];
    	        int low = 0, high = i - 1;
    	        int mid = -1;
    	        while (low <= high) {            
    	            mid = low + (high - low) / 2;            
    	            if (brothers[mid].getNum() > temp.getNum()) {               
    	                high = mid - 1;            
    	            } else { // 元素相同时，也插入在后面的位置                
    	                low = mid + 1;            
    	            }        
    	        }
    	        brothers[i].move(i, low);
    	        for(int j = i - 1; j >= low; j--) {
    	        	brothers[j+1].move(j+1, j);
    	            brothers[j + 1] = brothers[j];
    	        }        
    	        brothers[low] = temp;
    	        }
         System.out.println("二分排序结束，报颜色：");
         for(int i=0;i<7;i++) {
         	brothers[i].ColorOff();}
    }
    public static void random() {
    	java.util.List<hulubrother> list = Arrays.asList(brothers);
    	Collections.shuffle(list);
        for(int i=0;i<7;i++) {
        	brothers[i].NumberOff();
        }
    }
	public static void main(String[] args) {
    		System.out.println("打乱顺序，先报一次数：");
	        random();
	        System.out.println();
	        System.out.println("按照排行进行冒泡排序：");
	        myBubbleSort(brothers);
    		System.out.println("重新打乱顺序，再报一次数：");
	        random();
	        System.out.println();
	        System.out.println("按照排行进行二分排序：");
	        binarySort(brothers);
}
	}