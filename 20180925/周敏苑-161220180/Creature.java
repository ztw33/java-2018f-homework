import java.util.Random;
public class Creature {
    protected int x,y;
    protected char name;

    Creature(){
        name = '*';
    }

    public void setName(char name){
        this.name = name;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int Getx(){
        return this.x;
    }
    public int Gety(){
        return this.y;
    }
    public char GetName(){
        return this.name;
    }
    public static Calabash calabash[] = new Calabash[7];
    static Random p = new Random();
    public static int num = p.nextInt(15);
    public static Soldier soldier[] = new Soldier[num];
    public static Grandpa grand_pa = new Grandpa();
    public static Snaker snaker_ = new Snaker();
    public static Crab crab = new Crab();
}

class Grandpa extends Creature{
    Grandpa(){
        name = 'G';
        x = 9;
        y = 18;
    }
    void Lead_calabash(){
        for(int i = 0; i < 7; i++){
            calabash[i] = new Calabash(i + 1);
        }
        //  calabash[0].setName('1');
        // calabash[1].setName('2');
        //calabash[2].setName('3');
        // calabash[3].setName('4');
        //calabash[4].setName('5');
        // calabash[5].setName('6');
        // calabash[6].setName('7');
        calabash[0].setPosition(3,3);
        calabash[1].setPosition(5,3);
        calabash[2].setPosition(7,3);
        calabash[3].setPosition(9,3);
        calabash[4].setPosition(11,3);
        calabash[5].setPosition(13,3);
        calabash[6].setPosition(15,3);
    }
}

class Calabash extends Creature{
    Calabash(int i){
        name = (char)(i + '0');
    }
}

class Soldier extends Creature{
    Soldier(){
        name = 's';
    }
}

class Snaker extends Creature{
    Snaker(){
        name = 'S';
        x = 11;
        y = 18;
    }

    void arrow_formation(){
        int No = 0;
        int a,b;         //保证b是偶数,排成锋矢形
        if(num % 2 != 0){
            if((num / 2) %2 !=0){
                a = num/2;
                b = num - a;
            }
            else{
                b = num/2;
                a = num -b;
            }
        }
        else{
            if((num/2)%2!=0){
                a = num/2 -1;
                b =num -a;
            }
            else{
                a = num/2 ;
                b = num/2;
            }
        }
        for(No=0; No < a;No++){
            soldier[No].setPosition(10,9+No);
        }
        for(No = a;No<a+b/2;No++){
            soldier[No].setPosition(9-No+a,10+No-a);
        }
        for(No = a + b/2;No<a + b;No++){
            soldier[No].setPosition(11+No-a-b/2,10+No-a-b/2);
        }
    }
    void goose_formation(){
        int No = 0;
        int num1;
        if (num > 15){
            for(No = 0 ; No <15;No++){
                soldier[No].setPosition(17-No,5+No);
            }
            for(No = 15; No < num;No++){
                soldier[No].setPosition(17-No+15,6+No-15);
            }
        }
        else{
            for(No = 0; No<num;No++){
                soldier[No].setPosition(10+num/2-No,11-num/2+No);
            }
        }
    }
    void Lead_soldier(String name){
        for(int i = 0 ;i <num;i++){
            soldier[i] = new Soldier();
        }
        for(int i = 0; i<5;i++) {
            switch (name) {
                case "arrow":
                    arrow_formation();
                    break;
                case "goose":
                    goose_formation();
                    break;
            }
        }
        crab.x = 10;
        crab.y = 8;
    }


}

class Crab extends Creature{
    Crab (){
        name = 'C';
    }
}
