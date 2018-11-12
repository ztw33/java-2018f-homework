package creature;

public class Being {
    private String name;
    private char symbol;
    public Being(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }
    public String getName(){
        return this.name;
    }
    public char getSymbol(){
        return this.symbol;
    }
}
