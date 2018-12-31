package map;

import creature.*;


public class MonsterCamp {
    //妖怪阵营，含蛇精，蝎精和众喽啰；有不同的阵型；
    private MonsterQue monsterQue;
    private Scorpion scorpion;
    private  Snake snake;

    public MonsterCamp(){
        monsterQue = new MonsterQue();
        scorpion = new Scorpion();
        snake = new Snake();
    }

    public void queue1(Map map){
        map.initMonster();
        monsterQue.queue1(map);
        scorpion.standOn(map,1,13);
        snake.standOn(map,1,15);
    }

    public void queue2(Map map){
        map.initMonster();
        monsterQue.queue2(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }

    public void queue3(Map map){
        map.initMonster();
        monsterQue.queue3(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }

    public void queue4(Map map){
        map.initMonster();
        monsterQue.queue4(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }

    public void queue5(Map map){
        map.initMonster();
        monsterQue.queue5(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }

    public void queue6(Map map){
        map.initMonster();
        monsterQue.queue6(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }

    public void queue7(Map map){
        map.initMonster();
        monsterQue.queue7(map);
        scorpion.standOn(map,4,14);
        snake.standOn(map,6,14);
    }

    public void queue8(Map map){
        map.initMonster();
        monsterQue.queue8(map);
        scorpion.standOn(map,3,18);
        snake.standOn(map,5,18);
    }
}
