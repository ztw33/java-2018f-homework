package Homework2;

public class Conductor {
    private HuluBrothers[] queue;
    private Seats seat;

    Conductor(){
        queue = HuluBrothers.values();
        seat = new Seats();
    }

    public void randomQueue(){
        for(int i = 0; i < 7; i++)
            queue[i].randomSit(seat);
    }

    public void bubbleSort(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6 - i; j++){
                if(queue[j].tellSeat() > queue[j+1].tellSeat()){
                    queue[j].exchangeSeat(queue[j+1]);
                }
            }
        }
    }

    public void selectSort(){
        for(int i = 0; i < 7; i++){
            int max = 0;
            for(int j = 0; j < 6-i; j++){
                if(queue[j].tellSeat() > queue[max].tellSeat())
                    max = j;
            }
            queue[max].exchangeSeat(queue[6-i]);
        }
    }

    public static void main(String[] args){
        Conductor c = new Conductor();
        c.randomQueue();
        c.selectSort();
        //c.bubbleSort();
    }
}
