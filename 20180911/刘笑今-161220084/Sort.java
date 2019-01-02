import java.util.*;

public class Sort {
    public static void sortArray(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            int mindex=i;
            for(int j=i;j<arr.size();j++){
                if(arr.get(j)<arr.get(mindex))
                    mindex=j;
            }
            if(mindex != i){
                int tmp=arr.get(mindex);
                arr.set(mindex,arr.get(i));
                arr.set(i,tmp);
            }
        }
    }
    public static void main(String args[]){
        System.out.println("Please input an Array of integer, whose elements are separated by spaces. ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<Integer>();
        String ss=sc.nextLine();
        String[] sstr = ss.trim().split(" ");
        int index=0;
        while(index<sstr.length){
            int tmp=Integer.parseInt(sstr[index++]);
            arr.add(tmp);
        }

        sortArray(arr);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i));
            System.out.print(" ");
        }
    }
}
