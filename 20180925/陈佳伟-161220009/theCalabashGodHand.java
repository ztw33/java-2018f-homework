package Homework.CalabashBrothers_2;


public class theCalabashGodHand {
    
    private final int MAX_CALABASH_BOYS_COUNT = 7;

    public CalabashBoy[] createCalabashBoyArray(){
        int randomArray[] = {4,5,2,6,7,1,3};
        CalabashBoy[] CalabashBoyArray = new CalabashBoy[MAX_CALABASH_BOYS_COUNT];
        for(int i = 0; i < MAX_CALABASH_BOYS_COUNT; i++)
            CalabashBoyArray[i] = CalabashBoy.values()[randomArray[i]-1];
        return CalabashBoyArray;
    }

    private void countOff(CalabashBoy boy, int i, int j){
        System.out.print(boy.name+":"+ i+1 +"->"+ j+1 +"\n");
    }
    
    public CalabashBoy[] nameSort(){                    //按葫芦兄弟的名字排序
        CalabashBoy[] CalabashBoyArray = createCalabashBoyArray();
        for(int i = 0; i < MAX_CALABASH_BOYS_COUNT; i++){
            for(int j = MAX_CALABASH_BOYS_COUNT-1; j > i; j--){
                if(!CalabashBoyArray[j].compareWith(CalabashBoyArray[j-1])){
                    //countOff(CalabashBoyArray[j],j,j-1);
                    CalabashBoy temp = CalabashBoyArray[j];
                    CalabashBoyArray[j] = CalabashBoyArray[j-1];
                    CalabashBoyArray[j-1] = temp;
                }
            }
        }
       /* for(int i = 0 ;i<MAX_CALABASH_BOYS_COUNT; i++){
            CalabashBoyArray[i].tellname();
        }*/
        return CalabashBoyArray;
    }

    public void BattlefieldLayout(){
        CalabashBoy[] CalabashBoysArray;
        Battlefield newBattle = new Battlefield();

        FormationMaker singleLineBattleArrayFormationMaker = new FormationMaker();
        FormationMaker crescentMoonArrayFormationMaker = new FormationMaker();
        FormationMaker fangRArrayFormationMaker = new FormationMaker();

        CalabashBoysArray = nameSort();
        singleLineBattleArrayFormationMaker.singleLineBattleArray(CalabashBoysArray);
        crescentMoonArrayFormationMaker.crescentMoonArray();
        fangRArrayFormationMaker.fangRArray();
        // b.showBattlefield();

        newBattle.init();
        newBattle.setFormation(2, 10, singleLineBattleArrayFormationMaker);
        newBattle.setFormation(1, 25, crescentMoonArrayFormationMaker);
        newBattle.setFormation(5, 4, "老爷爷".toCharArray());
        newBattle.setFormation(5, 37, "蛇精".toCharArray());
        newBattle.showBattlefield();

        newBattle.init();
        newBattle.setFormation(2, 10, singleLineBattleArrayFormationMaker);
        newBattle.setFormation(3, 25, fangRArrayFormationMaker);
        newBattle.setFormation(5, 4, "老爷爷".toCharArray());
        newBattle.setFormation(5, 31, "蛇精".toCharArray());
        newBattle.showBattlefield();
    }


    private void quickSort(CalabashBoy[] CalabashBoyArray, int first, int last){           //快排
        if(first >= last)
            return ;
        int index = first;
        CalabashBoy flag = CalabashBoyArray[first],temp;
        for(int i = first+1; i <= last; i++){
            if(CalabashBoyArray[i].compareWith(flag)) {
                index++;
                if(index!=i) {
                    countOff(CalabashBoyArray[i], i, index);
                    temp = CalabashBoyArray[i];
                    CalabashBoyArray[i] = CalabashBoyArray[index];
                    CalabashBoyArray[index] = temp;
                }
            }
        }
        if(first!=index){
            countOff(CalabashBoyArray[first], first, index);
            CalabashBoyArray[first] = CalabashBoyArray[index];
            CalabashBoyArray[index] = flag;
        }
        quickSort(CalabashBoyArray, first, index-1);
        quickSort(CalabashBoyArray, index+1, last);
    }

    public void colorSort(){//按葫芦兄弟的颜色排序
        CalabashBoy[] CalabashBoysArray = createCalabashBoyArray();
        quickSort(CalabashBoysArray, 0, MAX_CALABASH_BOYS_COUNT-1);
        for(CalabashBoy i:CalabashBoysArray){
            i.tellcolor();
        }
    }
}
