import java.util.Random;

public class Formation {
    public Hulu Hulus[];
    public Creature Mons[];
    public Map map;
    Formation(){
        Hulus = new Hulu[7];
        for(int i = 0;i< 7;i++){
            Hulus[i] = new Hulu(i+1);
        }

        Mons = new Creature[8];
        Mons[0] = new MonScorpion();
        for(int i = 1;i< 8;i++){
            Mons[i] = new MonRetinue(1);
        }

        map = new Map();
    }

    public void getRandHulu(){
        Random random = new Random();
        for(int i=0;i<7;i++){
            int p = random.nextInt(i+1);
            Hulu tmp = Hulus[i];
            Hulus[i] = Hulus[p];
            Hulus[p] = tmp;
        }
    }

    public void sortHulu(){
        for(int i = 0;i<7;i++){
            for(int j = 0;j<7-i-1;j++){
                if (Hulus[j].ranking > Hulus[j+1].ranking){
                    Hulu tmp = Hulus[j];
                    Hulus[j] = Hulus[j+1];
                    Hulus[j+1] = tmp;
                }
            }
        }
    }
    public void printHulus(){
        for(int i = 0;i< 7;i++){
            System.out.println(Hulus[i].color.getColor()+' ');
        }
        System.out.println();
    }

    public void addHuluToMap(){
        for(int i = 0;i<7;i++) {
            map.set(i,0,Hulus[i]);
        }
    }

    public void FENGSHIAddMonsToMap(){
        map.set(4,6,Mons[0]);
        map.set(4,7,Mons[1]);
        map.set(4,8,Mons[2]);
        map.set(4,9,Mons[3]);
        map.set(3,7,Mons[4]);
        map.set(2,8,Mons[5]);
        map.set(5,7,Mons[6]);
        map.set(6,8,Mons[7]);
    }

    public void YANYUEAddMonsToMap(){
        map.set(4,7,Mons[0]);
        map.set(4,8,Mons[1]);
        map.set(5,7,Mons[2]);
        map.set(5,8,Mons[3]);
        map.set(3,8,Mons[4]);
        map.set(3,9,Mons[5]);
        map.set(6,8,Mons[6]);
        map.set(6,9,Mons[7]);
    }

}
