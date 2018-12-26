package creature;
import map.Map;

import java.util.Random;

//葫芦兄弟，会根据阵型的需要变换队列；
public class CalaBrother {
    private Calabash[] calabashes;

    public CalaBrother(){
        calabashes = new Calabash[7];
        for(int i = 0; i < 7; i++)
            calabashes[i] = new Calabash(i);
    }

    public void swapLoc(int i, int j){
        Calabash temp = calabashes[i];
        calabashes[i] = calabashes[j];
        calabashes[j] = temp;
    }

    public void randomQue(){
        Random random = new Random();
        for(int i = 0; i < 7; i++){
            int temp = random.nextInt(7);
            swapLoc(i,temp);
        }
    }

    public void sort(){
        for(int i = 0; i < 7; i++){
            for(int j = i+1; j < 7; j++){
                if(calabashes[i].getNum() > calabashes[j].getNum()){
                    swapLoc(i,j);
                }
            }
        }
    }

    public void queue1(Map map){
        for(int i = 0; i < 3; i++){
            calabashes[i].standOn(map,i+3,i+2);
        }
        for(int i = 3; i < 7; i++){
            calabashes[i].standOn(map,9-i,i+2);
        }
    }

    public void queue2(Map map){
        for(int i = 0; i < 7; i++){
            calabashes[i].standOn(map,7-i,i+2);
        }
    }

    public void queue3(Map map){
        for(int i = 0; i < 7; i+=2){
            calabashes[i].standOn(map,i+1,4);
        }
        for(int i = 1; i < 7; i+=2){
            calabashes[i].standOn(map,i+1,5);
        }
    }

    public void queue4(Map map){
        for(int i = 0; i < 7; i++){
            calabashes[i].standOn(map,i+1,4);
        }
    }

    public void queue5(Map map){
        calabashes[0].standOn(map,1,4);
        for(int i = 1; i < 3; i++){
            calabashes[i].standOn(map,3,2*i+1);
        }
        calabashes[3].standOn(map,5,2);
        calabashes[4].standOn(map,5,4);
        calabashes[5].standOn(map,5,6);
        calabashes[6].standOn(map,7,4);
    }

    public void queue6(Map map){
        calabashes[0].standOn(map,1,4);
        for(int i = 1; i < 3; i++){
            calabashes[i].standOn(map,3,2*i+1);
        }
        calabashes[3].standOn(map,7,3);
        calabashes[4].standOn(map,5,2);
        calabashes[5].standOn(map,5,6);
        calabashes[6].standOn(map,7,5);
    }

    public void queue7(Map map){
        calabashes[0].standOn(map,3,8);
        calabashes[1].standOn(map,4,7);
        calabashes[2].standOn(map,5,6);
        calabashes[3].standOn(map,6,7);
        calabashes[4].standOn(map,7,8);
        calabashes[5].standOn(map,4,5);
        calabashes[6].standOn(map,6,5);
    }

    public void queue8(Map map){
        calabashes[0].standOn(map,1,4);
        calabashes[1].standOn(map,2,3);
        calabashes[2].standOn(map,2,5);
        calabashes[3].standOn(map,3,2);
        calabashes[4].standOn(map,3,6);
        calabashes[5].standOn(map,4,4);
        calabashes[6].standOn(map,5,4);
    }
}
