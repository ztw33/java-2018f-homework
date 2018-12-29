public class ArraySort {
    public static void main(String[] args){
        int[] ar={2,6,4,50,19,-5,0,-10};
        rank(ar);
    }

    private static void rank(int[] ar) {
        for(int i=0;i<ar.length;i++){
            for(int j=i;j<ar.length;j++){
                if(ar[i]>ar[j]){
                    int temp=ar[i];
                    ar[i]=ar[j];
                    ar[j]=temp;
                }
            }
        }
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
}
