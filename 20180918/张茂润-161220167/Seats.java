package Homework2;

public class Seats {
    private boolean is_empty[] = new boolean[7];

    Seats(){
        for(int i = 0; i < 7; i++){
            is_empty[i] = true;
        }
    }
    public boolean getInfo(int i){
        return is_empty[i-1];
    }
    public void set(int i){
        is_empty[i-1] = false;
    }
}
