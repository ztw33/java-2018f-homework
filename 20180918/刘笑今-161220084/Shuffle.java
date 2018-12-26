public class Shuffle {
    public static int[] shuffleArray(int[] arr){
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int idx=(int)(Math.random()*(len-i));
            int tmp=arr[idx];
            arr[idx]=arr[len-i-1];
            arr[len-i-1]=tmp;
        }
        return arr;
    }
}
