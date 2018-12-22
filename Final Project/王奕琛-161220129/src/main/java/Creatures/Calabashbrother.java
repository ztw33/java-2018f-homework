package Creatures;

public class Calabashbrother {
    //MARK:Properties
    Calabash[] calabashes;

    //MARK:Initialize
    public Calabashbrother(){
        calabashes = new Calabash[7];
        for(int i = 0; i < 7; i++){
            calabashes[i] = new Calabash(i);
        }
    }

    //MARK:function
    public Calabash getCalabash(int i){
        if(i > 7)
            return null;
        return  calabashes[i-1];
    }



}
