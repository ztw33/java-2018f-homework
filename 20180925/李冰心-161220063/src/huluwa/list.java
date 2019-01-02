package huluwa;
import java.util.*;

public class list {
	public static void changshe (tree all,Vector<? extends lives> arr,int x0,int y0)
	{
		if(arr.isEmpty())
			return;
		
		where[][] ts=all.getSpace();
		
		for(int i=0;i<arr.size();i++)
		{
			arr.elementAt(i).set(ts[x0+i][y0]);
			//arr.elementAt(i).newX(x0);
			//arr.elementAt(i).newY(y0+i);
		}
	}
	
	public static void heyi (tree all,Vector<? extends lives> arr,int x0,int y0)
	{
		if(arr.isEmpty())
			return;
		where[][] ts=all.getSpace();
		int l;
		l=arr.size();
		int i=0,j=0;
		for( ;i<l/2;i++)
		{
			arr.elementAt(i).set(ts[x0+i][y0+i]);
		}
		for(j=0 ;i+j<l;j++)
		{	
			arr.elementAt(i+j).set(ts[x0+i-j][y0+i+j]);
		}
	}
	
	public static void yanxing (tree all,Vector<? extends lives> arr,int x0,int y0)
	{
		if(arr.isEmpty())
			return;
		where[][] ts=all.getSpace();
		for(int i=0;i<arr.size();i++)
		{
			arr.elementAt(i).set(ts[x0-i][y0+i]);
		}
	}
	
	

}
