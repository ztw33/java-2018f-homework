package renyi2;

public class ThirdBattlearray implements Battlearray {          //衝軛
    @Override
    public void createbattlearray(Field f, boolean ifhelp) {
        Creature one;
        int N=f.N;
        int numbers=1;
        f.resetfield();
        for(int i=-3;i<4;i++)
            f.setposition(N/2+i,N/3,one=new Brothers(numbers++,N/2+i,N/3));
        f.setposition(N/2,2*N/3,one=new Scorpion(N/2,2*N/3));
        f.setposition(N/2-2,2*N/3,one=new Orchin(N/2-2,2*N/3));
        f.setposition(N/2+2,2*N/3,one=new Orchin(N/2+2,2*N/3));
        f.setposition(N/2-1,2*N/3-1,one=new Orchin(N/2-1,2*N/3-1));
        f.setposition(N/2+1,2*N/3-1,one=new Orchin(N/2+1,2*N/3-1));
        f.setposition(N/2-3,2*N/3-1,one=new Orchin(N/2-3,2*N/3-1));
        f.setposition(N/2+3,2*N/3-1,one=new Orchin(N/2+3,2*N/3-1));
        if(ifhelp==true)
        {
            f.setposition(0,0,one=new Grandpa(0,0));
            f.setposition(N-1,N-1,one=new Snake_essence(N-1,N-1));
        }
    }
}
