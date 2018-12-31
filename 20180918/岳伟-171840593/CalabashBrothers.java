package hello;
import java.util.ArrayList;
import java.util.Random;
public enum  CalabashBrothers //定义枚举类：葫芦兄弟
{
	R("老大",1,"红色"),O("老二",2,"橙色"),Y("老三",3,"黄色"),G("老四",4,"绿色"),C("老五",5,"青色"),B("老六",6,"蓝色"),P("老七",7,"紫色"),;
    public int rank;//葫芦娃的序号
    public String colour;//葫芦娃的颜色
	public String name;//葫芦娃的名字
    private CalabashBrothers(String name,int rank,String colour)//构造函数
   {
	this.name=name;
	this.rank=rank;
	this.colour=colour;
   }  
    public void report_name(CalabashBrothers[] bros,int x)//本葫芦娃汇报自己的名字
    {
    	System.out.println(bros[x].name);
    }
    public void report_colour(CalabashBrothers[] bros,int x)//本葫芦娃汇报自己的颜色
    {
    	System.out.println(bros[x].colour);
    }
    public void swap_position(CalabashBrothers[] bros,int x,int y)//本葫芦娃和另一个葫芦娃交换彼此的位置
    {
    	CalabashBrothers temp;
    	temp=bros[x];
		bros[x]=bros[y];
		bros[y]=temp;
    }
    public void report_change_of_position(CalabashBrothers[] bros,int x,int y)//葫芦娃汇报自己位置的改变
    {
    	System.out.println(bros[x].name+":"+(x+1)+"->"+(y+2));
    }
    
	public static void main(String[] args) 
	{
		CalabashBrotherssort sort=new CalabashBrotherssort();
		Queue queue=new Queue();
		CalabashBrothers[] bros= {R,O,Y,G,C,B,P};
		sort.shuffle(bros,7);
		queue.show_all_the_names(bros,7,"排序前：");
		sort.bubblesort(bros,7);
		queue.show_all_the_names(bros,7,"排序后：");
		sort.shuffle(bros,7);
		queue.show_all_the_names(bros,7,"排序前：");
		sort.binarysort(bros,7);
		queue.show_all_the_colours(bros,7,"排序后：");
	}
}

class CalabashBrotherssort
{
	public void bubblesort(CalabashBrothers []bros,int number)//冒泡排序
    {
	System.out.println("冒泡排序：");
     int i=0,j=0;
     for(i=0;i<number-1;i++)
     {
    	 for(j=0;j<number-1-i;j++)
    	 {
    		 if(bros[j].rank>bros[j+1].rank)
    		 {
    			System.out.print(bros[j].name+":");
    			bros[j].report_change_of_position(bros, j, j+1);
    			bros[j].swap_position(bros,j,j+1);
    		 }
    	 }
     }
    }
    public void binarysort(CalabashBrothers[] bros,int number)//二分法排序

    {
    	System.out.println("二分法排序：");
        for (int i = 1; i < number; i++) 
        {   
        	int temp = bros[i].rank;
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) 
            {            
                mid = low + (high - low) / 2;            
                if (bros[mid].rank > temp) 
                {               
                    high = mid - 1;            
                } else 
                { // 元素相同时，也插入在后面的位置                
                    low = mid + 1;            
                }        
            }        
            CalabashBrothers change=bros[i];
            for(int j = i - 1; j >= low; j--) 
            {            
                bros[j + 1]= bros[j];        
            }        
            bros[low]=change;   
            bros[i].report_change_of_position(bros,i,low);
        }
    }
    public void shuffle(CalabashBrothers []bros,int number)//打乱葫芦兄弟的位置
    {
		Random random = new Random();
        for(int i=0;i<7;i++)
        {
        	int index=random.nextInt(7);
        	CalabashBrothers temp;
        	temp=bros[i];
        	bros[i]=bros[index];
        	bros[index]=temp;
        }
	}

}

class Queue
{
	public void show_all_the_names(CalabashBrothers []bros,int number,String s)
	{
		System.out.println(s);
		for(int i=0;i<number-1;i++)
		{
			System.out.print(bros[i].name+" ");
		}
		System.out.println(bros[number-1].name+" ");
	}
	public void show_all_the_colours(CalabashBrothers []bros,int number,String s)
	{
		System.out.println(s);
		for(int i=0;i<number-1;i++)
		{
			System.out.print(bros[i].colour+" ");
		}
		System.out.println(bros[number-1].colour+" ");
	}
}











