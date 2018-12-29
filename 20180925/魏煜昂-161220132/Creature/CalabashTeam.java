package Creature;

import Map.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class CalabashTeam {
    private Calabash[] calabashteam;
    private Grandpa grandpa;
    private int num;

    public CalabashTeam() {
        grandpa=new Grandpa();
        num = 7;
        calabashteam = new Calabash[num + 1];
        for (int i = 1; i <= num; i++) {
            calabashteam[i] = new Calabash(i);
        }
    }


    public int getNum(){
        return this.num;
    }
    public void randomOrder() {
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        c.add(7);
        Collections.shuffle(c);
        for (int i = 0; i < c.size(); i++) {
            calabashteam[i + 1] = new Calabash(c.get(i));
            calabashteam[i + 1].setPosition(i + 1);
        }
    }

    public void bubbleSort() {
        for (int i = 1; i < num + 1; i++)
            for (int j = 1; j < num + 1 - i; j++) {
                if (calabashteam[j].getRank() > calabashteam[j + 1].getRank()) {
                    Calabash temp = calabashteam[i];
                    calabashteam[i] = calabashteam[j];
                    calabashteam[i].setPosition(i);
                    calabashteam[j] = temp;
                    calabashteam[j].setPosition(j);
                }

            }
    }

    public void calabashLinedUp(Graph graph, int type){
        bubbleSort();
        switch (type){
            case 1:{
                calabashteam[1].setLocation(graph,7,5);
                calabashteam[2].setLocation(graph,6,4);
                calabashteam[3].setLocation(graph,5,3);
                calabashteam[4].setLocation(graph,4,2);
                calabashteam[5].setLocation(graph,6,6);
                calabashteam[6].setLocation(graph,5,7);
                calabashteam[7].setLocation(graph,4,8);
                grandpa.setLocation(graph,4,5);
            }break;
            case 2:{
                calabashteam[1].setLocation(graph,2,8);
                calabashteam[2].setLocation(graph,3,7);
                calabashteam[3].setLocation(graph,4,6);
                calabashteam[4].setLocation(graph,5,5);
                calabashteam[5].setLocation(graph,6,4);
                calabashteam[6].setLocation(graph,7,3);
                calabashteam[7].setLocation(graph,8,2);
                grandpa.setLocation(graph,5,2);

            }break;
            case 3:{
                calabashteam[1].setLocation(graph,2,5);
                calabashteam[2].setLocation(graph,3,4);
                calabashteam[3].setLocation(graph,4,5);
                calabashteam[4].setLocation(graph,5,4);
                calabashteam[5].setLocation(graph,6,5);
                calabashteam[6].setLocation(graph,7,4);
                calabashteam[7].setLocation(graph,8,5);
                grandpa.setLocation(graph,5,3);

            }break;
            case 4:{
                int y=graph.getSize()/2;
                int start_x=(graph.getSize()-num)/2;
                for(int i=1;i<=num;i++){
                    calabashteam[i].setLocation(graph,i+start_x,y);
                }
                grandpa.setLocation(graph,5,4);

            }break;
        }
    }
}
