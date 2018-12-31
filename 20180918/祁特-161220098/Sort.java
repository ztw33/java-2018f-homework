package cala;
import java.util.Arrays;
import java.util.Random;
public class Sort {
	
	static CalabashBrothers[] bros=new CalabashBrothers[7];
	static CalabashBrothers brother1= new CalabashBrothers("老大",1,Color.red);
	static CalabashBrothers brother2= new CalabashBrothers("老二",2,Color.orange);
	static CalabashBrothers brother3= new CalabashBrothers("老三",3,Color.yellow);
	static CalabashBrothers brother4= new CalabashBrothers("老四",4,Color.green);
	static CalabashBrothers brother5= new CalabashBrothers("老五",5,Color.cyan);
	static CalabashBrothers brother6= new CalabashBrothers("老六",6,Color.blue);
	static CalabashBrothers brother7= new CalabashBrothers("老七",7,Color.purple);
	
	
	
	
	
	
    private static Random rand = new Random();

    public static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }


    public static void main(String[] args) {
    	bros[0]=brother1;
    	bros[1]=brother2;
    	bros[2]=brother3;
    	bros[3]=brother4;
    	bros[4]=brother5;
    	bros[5]=brother6;
    	bros[6]=brother7;
    	shuffle(bros);
    	  //int[] numbers = {1012,203,15,40,6,7,2,51,-5,55,-111};
          System.out.print("冒泡排序前：");
          printName(bros);
          bubbleSort(bros);
          System.out.print("冒泡排序后：");
          printName(bros);
          shuffle(bros);
          System.out.print("二分排序前：");
          printColor(bros);
          binarySort(bros);
          System.out.print("二分排序后：");
          printColor(bros);

    }
    public static void binarySort(CalabashBrothers[] source)
    {     int i, j;    
    	int high, low, mid;     
    	CalabashBrothers temp =new CalabashBrothers();     
    	for (i = 1; i < source.length; i++)
    	{        
    		low = 0;             
    		high = i - 1;        
    		temp = source[i];       
    		while (low <= high) 
    		{           
    			// 
    			mid = (low + high) / 2;         
    			mid = (low + high) >> 1;         
    		  
    	
    		if (temp.color.compareTo(source[mid].color)<0 ) {           
           
    			high = mid - 1;         
    			} 
    		else {           
        
    			low = mid + 1;        
    			}       
    		}        
      
    		for (j = i - 1; j >=low; j--) {         
    			source[j + 1] = source[j];    
    			
            	System.out.println(source[j].name+":"+j+"->"+(j+1));
    			}       
      
    		source[low] = temp;      
    		System.out.println(temp.name+":"+i+"->"+low);
   
    			}   
    	} 
    		
    		
    	

	private static void bubbleSort(CalabashBrothers[] numbers) {
		// TODO Auto-generated method stub
		CalabashBrothers temp=new CalabashBrothers();
		int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
        for(int j = 0 ;j < size-1-i ; j++)
        {
            if(numbers[j].index > numbers[j+1].index)  
            {
            	System.out.println(numbers[j].name+":"+j+"->"+(j+1));
        	System.out.println(numbers[j+1].name+":"+(j+1)+"->"+j);
            	swap(numbers,j,j+1);
 
            }
        }
        }
		
	}
	private static void printColor(CalabashBrothers[] bro) {
		// TODO Auto-generated method stub
        for(int i = 0 ; i < bro.length ; i ++ )
        {
        System.out.print(bro[i].color + ",");
        }
        System.out.println("");
		
	}
	private static void printName(CalabashBrothers[] bro) {
		// TODO Auto-generated method stub
        for(int i = 0 ; i < bro.length ; i ++ )
        {
        System.out.print(bro[i].name + ",");
        }
        System.out.println("");
		
	}

}


