package creature;

import map.Map;

//众喽啰；会变换不同的站位以适应阵型的需要
public class MonsterQue{
    private Monster[] monsters;

    public MonsterQue(){
        monsters = new Monster[7];
        for(int i = 0; i < 7; i++){
            monsters[i] = new Monster();
        }
    }

    public void queue1(Map map){
        for(int i = 0; i < 3; i++){
            monsters[i].standOn(map,i+3,i+11);
        }
        for(int i = 3; i < 7; i++){
            monsters[i].standOn(map,9-i,i+11);
        }
    }

    public void queue2(Map map){
        for(int i = 0; i < 7; i++){
            monsters[i].standOn(map,7-i,i+11);
        }
    }

    public void queue3(Map map){
        for(int i = 0; i < 7; i+=2){
            monsters[i].standOn(map,i+1,13);
        }
        for(int i = 1; i < 7; i+=2){
            monsters[i].standOn(map,i+1,14);
        }
    }

    public void queue4(Map map){
        for(int i = 0; i < 7; i++){
            monsters[i].standOn(map,i+1,13);
        }
    }

    public void queue5(Map map){
        monsters[0].standOn(map,1,14);
        for(int i = 1; i < 3; i++){
            monsters[i].standOn(map,3,2*i+11);
        }
        monsters[3].standOn(map,5,12);
        monsters[4].standOn(map,5,14);
        monsters[5].standOn(map,5,16);
        monsters[6].standOn(map,7,14);
    }

    public void queue6(Map map){
        monsters[0].standOn(map,1,14);
        for(int i = 1; i < 3; i++){
            monsters[i].standOn(map,3,2*i+11);
        }
        monsters[3].standOn(map,5,12);
        monsters[4].standOn(map,7,13);
        monsters[5].standOn(map,5,16);
        monsters[6].standOn(map,7,15);
    }

    public void queue7(Map map){
        monsters[0].standOn(map,3,18);
        monsters[1].standOn(map,4,17);
        monsters[2].standOn(map,5,16);
        monsters[3].standOn(map,6,17);
        monsters[4].standOn(map,7,18);
        monsters[5].standOn(map,4,15);
        monsters[6].standOn(map,6,15);
    }

    public void queue8(Map map){
        monsters[0].standOn(map,1,14);
        monsters[1].standOn(map,2,13);
        monsters[2].standOn(map,2,15);
        monsters[3].standOn(map,3,12);
        monsters[4].standOn(map,3,16);
        monsters[5].standOn(map,4,14);
        monsters[6].standOn(map,5,14);
    }
}