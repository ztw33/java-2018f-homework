public enum Role {
    First("大娃",'*'),
    Second("二娃",'*'),
    Third("三娃",'*'),
    Fourth("四娃",'*'),
    Fifth("五娃",'*'),
    Sixth("六娃",'*'),
    Seventh("七娃",'*'),
    Grandpa("老爷爷",'&'),
    Minions("小喽啰",'#'),
    Scorpion("蝎子精",'%'),
    Snake("蛇精",'$');

    private String name;
    private char symbol;

    Role(String name, char symbol){
        this.name=name;
        this.symbol=symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}
