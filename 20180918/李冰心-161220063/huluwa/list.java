package huluwa;
import java.util.Collections;
import java.util.Vector;

public class list {

	private Vector<huluwa> boys;
	
	public list()
	{
		boys=new Vector<huluwa>();
		
		for(int i=1;i<8;i++)
		{
			boys.addElement(new huluwa(i));
		}
	}
	
	public void start()
	{
		Collections.shuffle(boys);
	}
	
	public void swap(int i,int j)
	{
		boys.elementAt(i).printNo();
		System.out.println(" : "+i+"-->"+j);
		boys.elementAt(j).printNo();
		System.out.println(" : "+j+"-->"+i);
		
		
		huluwa tmp=boys.elementAt(i);
		boys.setElementAt(boys.elementAt(j), i);
		boys.setElementAt(tmp, j);
	}
	
	public void back(int i)
	{
		int v=i+1;
		boys.elementAt(i).printNo();
		System.out.println(" : "+i+"-->"+v);
		
		huluwa tmp=boys.elementAt(i);
		boys.setElementAt(tmp, v);
	}
	
	public void Bsort()
	{
		for(int i=0;i<6;i++)
			for(int j=0;j<6-i;j++)
			{
				if( boys.elementAt(j).ifLess(boys.elementAt(j+1)) )
					continue;
				swap(j,j+1);
			}
	}
	
	public void BIsort()
	{
		for(int i=1;i<7;i++)
		{
			int low=0 , high=i-1,mid=-1;
			
			while(low<=high)
			{
				mid=low+(high-low)/2;
				if(boys.elementAt(i).ifLess(boys.elementAt(mid) ))
					high=mid-1;
				else
					low=mid+1;
			}
			huluwa tmp=boys.elementAt(i);
			
			for(int j=i-1;j>=low;j--)
			{
				back(j);
			}
			
			tmp.printNo();
			System.out.println(" : "+ i +"-->"+low);
			
			boys.setElementAt(tmp, low);
			
		}
	}
	
	public void printNo()
	{
		for(int i=0;i<7;i++)
		{
			boys.elementAt(i).printNo();
			System.out.print(",");
		}
		System.out.println("");
	}
	
	public void printColor()
	{
		for(int i=0;i<7;i++)
		{
			boys.elementAt(i).printColor();
			System.out.print(",");
		}
		System.out.println("");
	}
}
