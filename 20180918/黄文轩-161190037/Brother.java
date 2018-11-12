enum Name{
    老大,老二,老三,老四,老五,老六,小七
}
enum Color{
   赤,橙,黄,绿,青,蓝,紫
}

public enum Brother {
    大娃(Name.老大,Color.赤),二娃(Name.老二,Color.橙),三娃(Name.老三,Color.黄),
    四娃(Name.老四,Color.绿),五娃(Name.老五,Color.青),六娃(Name.老六,Color.蓝),七娃(Name.小七,Color.紫);

    private Name name;
    private Color color;

    Brother(Name name,Color color){
        this.name = name;
        this.color = color;
    }

    public String speakName(){
        return this.name.toString();
    }

    public String speakColor(){
        return this.color.toString();
    }

    public Name getEnumName(){
        return this.name;
    }

    public Color getEnumColor(){
        return this.color;
    }

}
