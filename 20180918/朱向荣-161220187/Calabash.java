enum Color{uni,red,orange,yellow,green,cyan,blue,purple}
enum Sequence{uni,one,two,three,four,five,six,seven}

//葫芦娃个体枚举类型
public enum Calabash{
    Unibro(Sequence.uni, Color.uni),Redbro(Sequence.one, Color.red),Orangebro(Sequence.two,Color.orange), Yellowbro(Sequence.three, Color.yellow),Greenbro(Sequence.four, Color.green),
    Cyanbro(Sequence.five, Color.cyan),Bluebro(Sequence.six, Color.blue),Purplebro(Sequence.seven, Color.purple);
    private Sequence seq;
    private Color color;
    Calabash(){
        seq = Sequence.uni;
        color = Color.uni;
    }
    Calabash(Sequence s, Color c) {
        seq = s;
        color = c;
    }

    public Sequence get_seq(){
        return seq;
    }

    public Color get_color(){
        return color;
    }

    //各种报数方法
    public void tell_seq(){
        System.out.print(Calabashes.seqmap.get(seq)+' ');
    }
    public void tell_color(){
        System.out.print(Calabashes.colormap.get(color)+' ');
    }
    public void tell_change(int i,int j){
        System.out.println(Calabashes.seqmap.get(seq)+':'+i+"->"+j);
    }
}
