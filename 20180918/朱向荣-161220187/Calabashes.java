import java.util.*;

public class Calabashes{
    public static Map<Color,String> colormap = new HashMap<>();
    public static Map<Sequence,String> seqmap = new HashMap<>();
    private List<Calabash> bros;
    //private int bro_num;
    Calabashes() {
        bros = new ArrayList<Calabash>();
        //bro_num = 7;
    }

    public void initialize(){

        colormap.put(Color.uni,"未知");
        colormap.put(Color.red,"红色");
        colormap.put(Color.orange,"橙色");
        colormap.put(Color.yellow,"黄色");
        colormap.put(Color.green,"绿色");
        colormap.put(Color.cyan,"青色");
        colormap.put(Color.blue,"蓝色");
        colormap.put(Color.purple,"紫色");

        seqmap.put(Sequence.uni,"未知");
        seqmap.put(Sequence.one,"老大");
        seqmap.put(Sequence.two,"老二");
        seqmap.put(Sequence.three,"老三");
        seqmap.put(Sequence.four,"老四");
        seqmap.put(Sequence.five,"老五");
        seqmap.put(Sequence.six,"老六");
        seqmap.put(Sequence.seven,"老七");

        bros.add(Calabash.Redbro);
        bros.add(Calabash.Orangebro);
        bros.add(Calabash.Yellowbro);
        bros.add(Calabash.Greenbro);
        bros.add(Calabash.Cyanbro);
        bros.add(Calabash.Bluebro);
        bros.add(Calabash.Purplebro);
    }

    public void shuffle(){
        Collections.shuffle(bros);
    }

    public void show_by_seq(){
        for(int i=0 ; i<bros.size() ; ++i) bros.get(i).tell_seq();
        System.out.println();
    }

    public void show_by_color(){
        for(int i=0 ; i<bros.size() ; ++i) bros.get(i).tell_color();
        System.out.println();
    }

    public void sort_bubble(){
        for(int i=0 ; i<bros.size() ; ++i){
            for(int j=i+1 ; j<bros.size() ; ++j){
                if(bros.get(i).get_seq().ordinal()>bros.get(j).get_seq().ordinal()){
                    Calabash temp = Calabash.Unibro;
                    //System.out.println(seqmap.get(bros.get(i).seq)+':'+i+"->"+j);
                    bros.get(i).tell_change(i,j);
                    temp = bros.get(i);
                    bros.set(i,bros.get(j));
                    bros.set(j,temp);
                }
            }
        }
    }

    public void sort_binaryinsert(){
        for(int i=0 ; i<bros.size() ; ++i){
            Calabash temp = bros.get(i);
            int left = 0;
            int right = i-1;
            int middle = 0;
            while(left<=right){
                middle = (left+right)/2;
                if(temp.get_color().ordinal()<bros.get(middle).get_color().ordinal()){
                    right = middle -1;
                }
                else{
                    left = middle + 1;
                }
            }
            for(int j=i-1 ; j>=left ; j--){
                //System.out.println(seqmap.get(bros.get(j).seq)+':'+j+"->"+(j+1));
                bros.get(j).tell_change(j,j+1);
                bros.set(j+1,bros.get(j));
            }
            if(left!=i){
                //System.out.println(seqmap.get(temp.seq)+':'+i+"->"+left);
                temp.tell_change(i,left);
                bros.set(left,temp);
            }
        }
    }
}
