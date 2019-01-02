package Javahomework;
public class firsthomework {
	public static void main(String[] args) 
	{
		int []a= {2,4,56,7,48,35,75,89,77,90,12};
    int i=0,j=0,temp=0;
    for(i=0;i<a.length-1;i++)
    {
    	for(j=i+1;j<a.length;j++)
    	{
    		if(a[i]>a[j])
    		{
    			temp=a[i];
    			a[i]=a[j];
    			a[j]=temp;
    		}
    	}
    }
    for(i=0;i<a.length;i++)
    {
    	System.out.print(a[i]+" ");
    }

}
}
