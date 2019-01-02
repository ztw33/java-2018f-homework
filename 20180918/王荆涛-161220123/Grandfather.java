import java.util.Random;

public class Grandfather {
    int[] position = new int[7];
    //static int[] nowPosition = new int[7];
    HuluBrother[] huluBrothers = new HuluBrother[7];
    int huluCount = 0;

    Grandfather(){
        for(int i = 0; i < 7; i++){
            HuluBrother temp = new HuluBrother(i, Color.values()[i].toString(), Name.values()[i].toString());
            huluBrothers[i] = temp;
        }
    }


    void initPosition(){

        Random index = new Random();
        int i = 0;
        huluCount = 0;
        while(huluCount < 7) {
            position[i] = index.nextInt(7);
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (position[j] == position[i]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                huluCount++;
                i++;
            }
        }

        for(int j = 0; j < 7; j++)
            huluBrothers[position[j]].initialPosition = j;
    }

    void BinarySort(int[] array){
        for(int i = 0; i < array.length; i++){
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid = -1;

            while(left <= right){
                mid = (left + right) / 2;
                if(array[mid] < temp)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            for(int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
                huluBrothers[array[j]].exchangeMyPosition(j, j + 1);
            }
            if(left != i) {
                array[left] = temp;
                huluBrothers[temp].exchangeMyPosition(i, left);
            }
        }
    }

    void BubbleSort(int[] array){
        for(int j = 1; j < array.length; j++){
            for(int i = 0; i < array.length - j; i++){
                if(array[i]  > array[i + 1]){

                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    huluBrothers[array[i + 1]].exchangeMyPosition(i,i + 1);
                    huluBrothers[array[i]].exchangeMyPosition(i + 1,i);
                }
            }
        }
    }

    void sortByName(){
        BubbleSort(position);
        System.out.println("报数：");
        for(int i = 0; i < 7 ;i ++){
            huluBrothers[position[i]].speakMyName();
        }
    }

    void sortByColor(){
        BinarySort(position);
        System.out.println("报数：");
        for(int i = 0; i < 7 ;i ++){
            huluBrothers[position[i]].speakMyColor();
        }
    }

}
