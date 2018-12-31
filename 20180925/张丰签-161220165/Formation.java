public class Formation {
    private int n;
    private int num;
    private int people_num;
    BattleField battlefield;
    private int cur_NO;
    Formation(int N,int team,int number,BattleField x){
        n=N;//阵型大小
        num=number;  //阵型号
        people_num=team;//人数
        battlefield=x;
        cur_NO=11;
    }
    public void change_formaion(){
        switch (num){
            case 1:formaion1();break;
            case 2:formaion2();break;
            case 3:formaion3();break;
            case 4:formaion4();break;
            case 5:formaion5();break;
            case 6:formaion6();break;
            default:break;
        }
    }
    private void formaion1(){//鹤形
        cur_NO=11;
        int last_x=0,last_y=0;
        for(int i=0;i<people_num;i++){
            if(i==0){
                battlefield.set_one(n/2,n-1,cur_NO);
                last_x=1;last_y=1;
                cur_NO++;
            }
            else if(i%2==1){
                battlefield.set_one(n/2+last_x,n-1-last_y,cur_NO);
                cur_NO++;
            }
            else{
                battlefield.set_one(n/2-last_x,n-1-last_y,cur_NO);
                last_x++;last_y++;
                cur_NO++;
            }
        }
        cur_NO=11;
    }
    private void formaion2(){//雁形
        cur_NO=11;
        int last_x=n/2+people_num/2,last_y=n-1;
        for(int i=0;i<people_num;i++){
            battlefield.set_one(last_x,last_y,cur_NO);
            cur_NO++;
            last_x--;last_y--;
        }
        cur_NO=11;
    }
    private void formaion3(){//阵型3
        cur_NO=11;
        int last_x=n/2-people_num/2,last_y=0;
        for(int i=0;i<people_num;i++){
            battlefield.set_one(last_x,n-1-last_y,cur_NO);
            cur_NO++;
            last_x++;
            if(last_y==0)
                last_y=1;
            else
                last_y=0;
        }
        cur_NO=11;
    }
    private void formaion4(){
        cur_NO=11;
        int last_x=n/2-people_num/2,last_y=n-1;
        for(int i=0;i<people_num;i++){
            battlefield.set_one(last_x,last_y,cur_NO);
            cur_NO++;
            last_x++;
        }
        cur_NO=11;
    }
    private void formaion5(){
        cur_NO=11;
        int last_x=0,last_y=n-1;
        for(int i=0;i<people_num;i++){
            if(i==0) {
                battlefield.set_one(n / 2 , last_y, cur_NO);
            }
            else if(i%2!=0){
                battlefield.set_one(n / 2 + last_x, last_y, cur_NO);
            }
            else
                battlefield.set_one(n / 2 - last_x, last_y, cur_NO);
        last_x=1;
        if(i>=2&&i%2==0){
            last_y--;
        }
            cur_NO++;
        }
        cur_NO=11;
    }
    private void formaion6(){
        cur_NO=11;
        int last_x=1,last_y=n;
        for(int i=0;i<people_num;i++){
            if(i<5){
                last_y--;
                battlefield.set_one(n/2,last_y,cur_NO);
                cur_NO++;
            }
            else if(i%2==1){
                last_y++;
                battlefield.set_one(n/2+last_x,last_y,cur_NO);
                cur_NO++;
            }
            else{
                battlefield.set_one(n/2-last_x,last_y,cur_NO);
                cur_NO++;
                last_x++;
            }
        }
        cur_NO=11;
    }
}
