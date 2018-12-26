
import java.util.Random;

public class CalabashSorter {
	private CalabashBro[] calabashList;
	public CalabashSorter() {
		calabashList=CalabashBro.values();
	}
	public void randomList() {
		Random random=new Random();
		for(int i=0;i<7;i++)
		{
			int ranPos=random.nextInt(7);
			CalabashBro temp=calabashList[i];
			calabashList[i]=calabashList[ranPos];
			calabashList[ranPos]=temp;
		}
	}
	public void reportName() {
		for(int i=0;i<7;i++)
			calabashList[i].tellName();
		System.out.println();
	}
	public void reportColor() {
		for(int i=0;i<7;i++)
			calabashList[i].tellColor();
		System.out.println();
	}
	public void bubbleSort() {
		for(int i=6;i>0;i--)
			for(int j=0;j<i;j++)
				if(calabashList[j].getOrder()>calabashList[j+1].getOrder())
				{
					calabashList[j].tellPosEx(j, j+1);
					calabashList[j+1].tellPosEx(j+1, j);
					CalabashBro temp=calabashList[j];
					calabashList[j]=calabashList[j+1];
					calabashList[j+1]=temp;
				}
	}
	public void binarySort() {
		for(int i=0;i<7;i++) {
			CalabashBro tempBro=calabashList[i];
			int l=0,r=i-1;
			while(l<=r) {
				int m=(l+r)/2;
				if(tempBro.getOrder()<calabashList[m].getOrder())
					r=m-1;
				else	
					l=m+1;
			}
			for(int j=i-1;j>=l;j--)
			{
				calabashList[j+1]=calabashList[j];
				calabashList[j].tellPosEx(j, j+1);
			}
			if(i!=l)
				tempBro.tellPosEx(i, l);
			calabashList[l]=tempBro;
		}
	}
}
