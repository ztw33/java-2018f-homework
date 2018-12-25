import java.awt.*;

public class Formation {
    private int formation_number;
    private int size;
    private int soldier_num;
    Formation(int number,BattleField battleField,int size,int soldier_num){
        this.formation_number=number;
        this.size=size;
        this.soldier_num=soldier_num;
        battleField.set_one(size/2,0,1);
        battleField.set_one(size/2+1,0,2);
        battleField.set_one(size/2-1,0,3);
        battleField.set_one(size/2+2,0,4);
        battleField.set_one(size/2-2,0,5);
        battleField.set_one(size/2+3,0,6);
        battleField.set_one(size/2-3,0,7);
        battleField.set_one(size/2,2,8);
        battleField.set_one(size/2,size/2,9);
        battleField.set_one(size/2,size/2+1,10);
        switch (formation_number){
            case 1:formaion1(battleField);break;
            case 2:formaion2(battleField);break;
            case 3:formaion3(battleField);break;
            case 4:formaion4(battleField);break;
            case 5:formaion5(battleField);break;
            case 6:formaion6(battleField);break;
            default:break;
        }
    }
    private void formaion1(BattleField battleField){
        System.out.println("鹤形");
        int last_x=0;int last_y=0;
        for(int i=0;i<soldier_num;i++){
            if(i%2==0) {
                battleField.set_one(size / 2+last_x, size / 2 + 3+last_y, 11 + i);
                last_x++;last_y++;
            }
            else {
                battleField.set_one(size / 2-last_x, size / 2 + 3+last_y, 11 + i);
            }
        }
    }
    private void formaion2(BattleField battleField){
        System.out.println("雁形");
        int last_x=0;int last_y=0;
        for(int i=0;i<soldier_num;i++){
            if(i%2==0) {
                battleField.set_one(size / 4+last_x, size / 2 + 3+last_y, 11 + i);
                last_x++;last_y++;
            }
            else {
                battleField.set_one(size / 4+last_x, size / 2 + 3+last_y, 11 + i);
                last_x++;last_y++;
            }
        }
    }
    private void formaion3(BattleField battleField){
        System.out.println("蛇形");
        int last_x=size/2-soldier_num/2;int last_y=0;
        for(int i=0;i<soldier_num;i++){
            if(i%2==0) {
                battleField.set_one(last_x, size-1-last_y, 11 + i);
                last_y=1;last_x++;
            }
            else {
                battleField.set_one(last_x, size-1-last_y, 11 + i);
                last_y=0;last_x++;
            }
        }
    }
    private void formaion4(BattleField battleField){
        System.out.println("Z字形");
        int last_x=0;int last_y=0;
        for(int i=0;i<soldier_num;i++){
            if(i%2==0) {
                battleField.set_one(size / 2+last_x, size -1-last_y, 11 + i);
                last_x++;last_y=1;
            }
            else {
                battleField.set_one(size / 2-last_x, size -1-last_y, 11 + i);
                last_x++;last_y=0;
            }
        }
    }
    private void formaion5(BattleField battleField){
        System.out.println("箭头形");
        int last_x=1,last_y=size;
        for(int i=0;i<soldier_num;i++){
            if(i<5) {
                last_y--;
                battleField.set_one(size/2,last_y,11+i);
            }
            else if(i%2==0) {
                battleField.set_one(size / 2+last_x, last_y, 11 + i);
                last_x++;
            }
            else {
                last_y++;
                battleField.set_one(size / 2-last_x, last_y, 11 + i);
            }
        }
    }
    private void formaion6(BattleField battleField){
        System.out.println("凹形");
        int last_x=0;int last_y=size-1;
        for(int i=0;i<soldier_num;i++){
            if(i==0){
                battleField.set_one(size / 2, last_y, 11 + i);
            }
            else if(i%2==0) {
                battleField.set_one(size / 2+last_x, last_y, 11 + i);
            }
            else {
                battleField.set_one(size / 2-last_x, last_y, 11 + i);
            }
            last_x=1;
            if(i>=2&&i%2==0)
                last_y--;
        }
    }
}
