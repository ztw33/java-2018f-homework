public class Creature {
    Creature(){;}
    Creature(String name, int camp, int id, char symbol){
        this.name = name;
        this.camp = camp;
        this.indentity = id;
        this.symbol = symbol;
        this.sitex = -1;
        this.sitey = -1;
    }

    public int camp;
    public int indentity;
    public String name;
    public char symbol;
    public int sitex;
    public int sitey;

    public void Name_Call(){
        System.out.println(this.name);
    }
    public void Symbol_Call(){ System.out.println(this.symbol); }

    public int GetSitex(){
        return this.sitex;
    }
    public int GetSitey(){
        return this.sitey;
    }

    public void GetToSite(int x, int y){
        Map.SetSite(this,x,y);
    }

    public void ExchangeSite(Creature anyone){
        int tempx = this.sitex;
        int tempy = this.sitey;
        this.sitex = anyone.sitex;
        this.sitey = anyone.sitey;
        anyone.sitex = tempx;
        anyone.sitey = tempy;
    }

    public char GetSymbol(){
        return this.symbol;
    }
}
