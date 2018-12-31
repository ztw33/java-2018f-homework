/* XuXiang 161220153 2018/9/11 18:21 */
public class Sort {
    public static void main(String[] args){
        int numbers[] = new int[] {11, 55, 37, 97, 109, 25, 78, 22, 88, 6};
        for(int i=0;i<10;i++){
            int min = numbers[i];
            int min_pos = i;
            for(int j=i+1;j<10;j++){
                if(min>numbers[j]){
                    min = numbers[j];
                    min_pos = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[min_pos];
            numbers[min_pos] = temp;
        }
        // Print out the result
        for(int i=0;i<10;i++){
            System.out.print(numbers[i]);
            System.out.print('\t');
        }
    }
}
