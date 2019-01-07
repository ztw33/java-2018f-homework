package work2_huluwa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sortchairs {
	//������
	public static void main(String [] args){
		Huluwa[] Hululist = new Huluwa[7];	
		//���Ұ�������鿴����һ������
		
		shuffle(Hululist);
		//�������һ����«�����У�˳���Ǵ��ҵġ�
		
		bubblesort(Hululist);//ð������
		
		printname(Hululist);//������
		
		shuffle(Hululist);//�ٴ��������
		
		quicksort(Hululist,0,Hululist.length-1);//��������
		
		printcolor(Hululist);//����ɫ
	} 
	
	public static void printname(Huluwa[] Hululist){
		for(int i = 0;i < 7;i++){ 
			Hululist[i].getname();
		}
		System.out.print("\n");
	}
	public static void printcolor(Huluwa[] Hululist){
		for(int i = 0;i < 7;i++){ 
			Hululist[i].getcolor();
		}
		System.out.print("\n");
	}

	public static void shuffle(Huluwa[] Hululist){    
		int[] x = {0,1,2,3,4,5,6};    
		List<Integer> list = new ArrayList<Integer> ();    
		for(int i = 0;i < x.length;i++){ 
			list.add(x[i]);    
		} 
	//	 System.out.println();
		 Collections.shuffle(list);   
		 for(int i = 0;i < 7;i++){ 
			 int p = list.get(i);
			 Hululist[i] = new Huluwa(p,i);
		} 
	}
	public static void bubblesort(Huluwa[] Hululist){
		for( int i = 0 ; i < 6;i++)
			for(int j = i+1; j <7;j++){
				if(Hululist[i].gettrue()>Hululist[j].gettrue()){
 					Hululist[i].changeplace(j);
					Hululist[j].changeplace(i);
					System.out.print("\n");
					//����
					
					Huluwa tmp = Hululist[i];
					Hululist[i] = Hululist[j];
					Hululist[j] = tmp;
					//ʵ���ϵĽ���λ��
				}
			}				
	}
    public static int divide(Huluwa[] H, int start, int end){
		//�����ұ�Ϊ��׼ֵ
		int base = H[end].gettrue();
		while(start < end){
			while(start < end && H[start].gettrue() <= base)
				//����߿�ʼ����
				start++;
			
			if(start < end){
				H[start].changeplace(end);
				H[end].changeplace(start);
				System.out.print("\n");
				//����
				Huluwa tmp = H[start];
				H[start] = H[end];
				H[end] = tmp;
				//ʵ���ϵĽ���λ��

				end--;
			}	
			while(start < end && H[end].gettrue() >= base)
				//���ұ߿�ʼ����
				end--;
			if(start < end){
				H[start].changeplace(end);
				H[end].changeplace(start);
				System.out.print("\n");
				//����
				Huluwa tmp = H[start];
				H[start] = H[end];
				H[end] = tmp;
				
				start++;
			}				
		}
		//��׼ֵ���ڵ�λ��
		return end;
	}
	public static void quicksort(Huluwa [] Hululist, int start, int end){
		if(start > end){
			//һ��Ԫ��
			return;
		} 
		else{
			//�ݹ�
			int partition = divide(Hululist, start, end);
			quicksort(Hululist, start, partition-1);
			quicksort(Hululist, partition+1, end);
		}
			
	}
	
}
