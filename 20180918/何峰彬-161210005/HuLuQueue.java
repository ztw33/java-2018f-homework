package homework2;

import java.util.Random;

public class HuLuQueue {
    private HuLuBro[] queue;
    int length;

    public HuLuQueue(){
        queue = HuLuBro.values();
        length = queue.length;
        randomQueue();
    }

    public void randomQueue(){
        Random random1 = new Random();
        Random random2 = new Random();
        for (int i = 0; i < 1000; i++) {
            int m = random1.nextInt(length - 1), n = random2.nextInt(length - 1);
            HuLuBro temp = queue[m];
            queue[m] = queue[n];
            queue[n] = temp;
        }
    }

    public void reportName(){
        for(int i = 0; i < length; i ++){
            queue[i].tellName();
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void reportColor(){
        for(int i = 0; i < length; i ++){
            queue[i].tellColor();
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void sortByColor(){
        for(int i = 1; i < length; i ++){
            HuLuBro key = queue[i];

            int left = 0, right = i - 1;
            while(left<=right){
                int mid = (left + right) / 2;
                if(key.compareColorTo(queue[mid]) < 0){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }

            tellPositionChange(i, left);
            for(int j = i - 1; j >= left; j --){
                tellPositionChange(j, j + 1);
                queue[j + 1] = queue[j];
            }
            queue[left] = key;
        }
    }

    public void sortByName(){
        for(int i = length - 1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(queue[j].compareNameTo(queue[j + 1]) > 0){
                    tellPositionChange(j, j + 1);
                    tellPositionChange(j + 1, j);
                    HuLuBro temp = queue[j];
                    queue[j] = queue[j+1];
                    queue[j + 1] = temp;
                }
            }
        }
    }


    //位置i报告换到位置j
    private void tellPositionChange(int i, int j){
        if(i == j)
            return;
        queue[i].tellName();
        System.out.print(": " + i + "->" + j + "\n");
    }
}
