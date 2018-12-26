import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] n = new int[8];
        for(int i = 0; i<8;i++){
            n[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(Arrays.toString(n));
        for (int i = 0; i<8;i++){
            for(int j = i + 1; j<8;j++){
                if(n[j]<n[i]){
                    int temp = n[j];
                    n[j] = n[i];
                    n[i] =temp;
                }
            }
        }
        for(int i = 0; i<8;i++){
            System.out.print(n[i] + " ");
        }
    }
}




