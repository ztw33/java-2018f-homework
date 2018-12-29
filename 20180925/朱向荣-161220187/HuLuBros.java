import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuLuBros {
    private List<HuLuWa> bros;
    HuLuBros(){
        bros = new ArrayList<HuLuWa>();
    }
    public void initialize(){
        HuLuWa temp = new HuLuWa("红娃",1);
        bros.add(temp);
        temp = new HuLuWa("橙娃",2);
        bros.add(temp);
        temp = new HuLuWa("黄娃",3);
        bros.add(temp);
        temp = new HuLuWa("绿娃",4);
        bros.add(temp);
        temp = new HuLuWa("青娃",5);
        bros.add(temp);
        temp = new HuLuWa("蓝娃",6);
        bros.add(temp);
        temp = new HuLuWa("紫娃",7);
        bros.add(temp);
    }
    public void shuffle(){
        Collections.shuffle(bros);
    }
    public void sort(){
        for(int i=0;i<bros.size();++i){
            for(int j=i+1 ; j<bros.size();++j){
                if(bros.get(i).getrank()>bros.get(j).getrank()){
                    HuLuWa temp = bros.get(i);
                    bros.set(i,bros.get(j));
                    bros.set(j,temp);
                }
            }
        }
    }
    public HuLuWa getbro(int i){
        return bros.get(i);
    }
    public Block[] HuLustand(int x,int y){
        Block[] HuLulist = new Block[7];
        for(int k=0 ; k<7 ; ++k){
            HuLulist[k] =new Block();
            HuLulist[k].xrows = x-k;
            HuLulist[k].ylines = y;
            HuLulist[k].creature = bros.get(k);
        }
        return HuLulist;
    }
}
