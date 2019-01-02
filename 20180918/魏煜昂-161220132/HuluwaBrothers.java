import java.util.ArrayList;
import java.util.Collections;

public class HuluwaBrothers {
    private Huluwa[] huluwateam;
    private int total;
    public HuluwaBrothers(){
        this.total=7;
        huluwateam =new Huluwa[total+1];
        for (int i=1;i<=total;i++) {
            huluwateam[i] = new Huluwa(i);
            huluwateam[i].setLocation(i);
        }
    }

    public void randomOrder(){
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        c.add(7);
        Collections.shuffle(c);
        for (int i=0;i<c.size();i++){
            huluwateam[i+1]=new Huluwa(c.get(i));
            huluwateam[i+1].setLocation(i+1);
        }
    }

    public void bubbleSort(){
        for (int i=1;i<total+1;i++)
            for (int j=1;j<total+1-i;j++){
                if (huluwateam[j].getRank()> huluwateam[j+1].getRank()){
                   changeLocation(j,j+1);
                }
            }

    }

    private void changeLocation(int i, int j){
        Huluwa temp= huluwateam[i];
        huluwateam[i]= huluwateam[j];
        huluwateam[i].tellChange();
        huluwateam[i].setLocation(i);
        huluwateam[i].tellLocation();
        System.out.println();

        huluwateam[j]=temp;
        huluwateam[j].tellChange();
        huluwateam[j].setLocation(j);
        huluwateam[j].tellLocation();
        System.out.println();

    }

    public void binarySort(){
        for (int i=1;i<total+1;i++){
            int start=1;
            int end=i;
            int mid=1;
            while (start<=end){
                mid=(start+end)/2;
                if (huluwateam[i].getColor().compareTo(huluwateam[mid].getColor())>0){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            Huluwa temp= huluwateam[i];
            for (int j=i-1;j>=start;j--){
                huluwateam[j+1]= huluwateam[j];
                huluwateam[j+1].tellChange();
                huluwateam[j+1].setLocation(j+1);
                huluwateam[j+1].tellLocation();
            }
            if (huluwateam[start]==temp);
            else {
                huluwateam[start] = temp;
                huluwateam[start].tellChange();
                huluwateam[start].setLocation(start);
                huluwateam[start].tellLocation();
                System.out.println();
            }

        }
    }

    public void reportLocation(){
        for (int i=1;i<total+1;i++)
            System.out.print(huluwateam[i].getLocation()+" ");
        System.out.println();
    }

    public void reportName(){
        for (int i=1;i<total+1;i++)
            System.out.print(huluwateam[i].getName()+" ");
        System.out.println();
    }

    public void reportColor(){
        for (int i=1;i<total+1;i++)
            huluwateam[i].tellColor();
        System.out.println();
    }

}
