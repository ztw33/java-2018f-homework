class Line{
    public Line(){

    }
    public void Changshe(Creature[] hulubrothers,String[][] ground){
        for(int i=0;i<7;i++) {
            hulubrothers[i].movetoline(ground,(Battle.N)/2+i-3,(Battle.N)/2-7);
        }
    }
    public void Heyi(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+3);
        monsters[1].movetoline(ground, (Battle.N)/2, (Battle.N)/2+4);
        monsters[2].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+6);
        monsters[3].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+5);
        monsters[4].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+1);
        monsters[5].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2);
        monsters[6].movetoline(ground, (Battle.N)/2, (Battle.N)/2+2);
    }
    public void Yanxing(Creature[] monsters,String[][] ground){
        for(int i=0;i<5;i++){
            monsters[i].movetoline(ground,(Battle.N-1)/2+1-i,(Battle.N-1)/2+3+i);
        }
    }
    public void Chonge(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground, (Battle.N)/2, (Battle.N)/2+3);
        monsters[1].movetoline(ground,(Battle.N)/2-2,(Battle.N)/2+3);
        monsters[2].movetoline(ground,(Battle.N)/2+2,(Battle.N)/2+3);
        monsters[3].movetoline(ground,(Battle.N)/2-3,(Battle.N)/2+4);
        monsters[4].movetoline(ground,(Battle.N)/2-1,(Battle.N)/2+4);
        monsters[5].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+4);
    }
    public void Yulin(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground, (Battle.N)/2, (Battle.N)/2+3);
        monsters[1].movetoline(ground,(Battle.N)/2,(Battle.N)/2+1);
        monsters[2].movetoline(ground,(Battle.N)/2,(Battle.N)/2+5);
        monsters[3].movetoline(ground,(Battle.N)/2-1,(Battle.N)/2+4);
        monsters[4].movetoline(ground,(Battle.N)/2-2,(Battle.N)/2+3);
        monsters[5].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2);
        monsters[6].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+2);
        monsters[7].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+4);
        monsters[8].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+6);
        monsters[9].movetoline(ground,(Battle.N)/2+2,(Battle.N)/2+3);
    }
    public void Fangyuan(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground, (Battle.N)/2, (Battle.N)/2+3);
        monsters[1].movetoline(ground,(Battle.N)/2-1,(Battle.N)/2+4);
        monsters[2].movetoline(ground,(Battle.N)/2-1,(Battle.N)/2+6);
        monsters[3].movetoline(ground,(Battle.N)/2-2,(Battle.N)/2+5);
        monsters[4].movetoline(ground,(Battle.N)/2,(Battle.N)/2+7);
        monsters[5].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+4);
        monsters[6].movetoline(ground,(Battle.N)/2+1,(Battle.N)/2+6);
        monsters[7].movetoline(ground,(Battle.N)/2+2,(Battle.N)/2+5);
    }
    public void Yanyue(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground, (Battle.N)/2, (Battle.N)/2+3);
        monsters[1].movetoline(ground, (Battle.N)/2, (Battle.N)/2+5);
        monsters[2].movetoline(ground, (Battle.N)/2, (Battle.N)/2+7);
        monsters[3].movetoline(ground, (Battle.N)/2+1, (Battle.N)/2+3);
        monsters[4].movetoline(ground, (Battle.N)/2+1, (Battle.N)/2+5);
        monsters[5].movetoline(ground, (Battle.N)/2+1, (Battle.N)/2+7);
        monsters[6].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+3);
        monsters[7].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+5);
        monsters[8].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+7);
        monsters[9].movetoline(ground, (Battle.N)/2+2, (Battle.N)/2+6);
        monsters[10].movetoline(ground, (Battle.N)/2+2, (Battle.N)/2+8);
        monsters[11].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+6);
        monsters[12].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+8);
        monsters[13].movetoline(ground, (Battle.N)/2+3, (Battle.N)/2+7);
        monsters[14].movetoline(ground, (Battle.N)/2+3, (Battle.N)/2+9);
        monsters[15].movetoline(ground, (Battle.N)/2-3, (Battle.N)/2+7);
        monsters[16].movetoline(ground, (Battle.N)/2-3, (Battle.N)/2+9);
        monsters[17].movetoline(ground, (Battle.N)/2+4, (Battle.N)/2+10);
        monsters[18].movetoline(ground, (Battle.N)/2-4, (Battle.N)/2+10);
    }
    public void Fengshi(Creature[] monsters,String[][] ground){
        monsters[0].movetoline(ground, (Battle.N)/2-3, (Battle.N)/2+5);
        monsters[1].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+5);
        monsters[2].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+5);
        monsters[3].movetoline(ground, (Battle.N)/2, (Battle.N)/2+5);
        monsters[4].movetoline(ground, (Battle.N)/2+1, (Battle.N)/2+5);
        monsters[5].movetoline(ground, (Battle.N)/2+2, (Battle.N)/2+5);
        monsters[6].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+4);
        monsters[7].movetoline(ground, (Battle.N)/2-2, (Battle.N)/2+6);
        monsters[8].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+3);
        monsters[9].movetoline(ground, (Battle.N)/2-1, (Battle.N)/2+7);
        monsters[10].movetoline(ground, (Battle.N)/2, (Battle.N)/2+2);
        monsters[11].movetoline(ground, (Battle.N)/2, (Battle.N)/2+8);
    }
}
