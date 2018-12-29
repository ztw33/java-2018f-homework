import javax.swing.*;
import java.util.zip.CRC32;

public class CalaBrothers extends Creature{

    CalaBrothers(int rank,String color,String name,char symbol){
        super(name,Global.CALABROS,Global.NORMARL,symbol);
        this.rank = rank;
        this.color = color;
        if(rank == 1)
            this.indentity = Global.LEADER;
    }

    private  int rank;
    private  String color;
    public int site;
    public static CalaBrothers CalaBros[] = new CalaBrothers[7];

    public static void Init_Array_Bros(){
        CalaBros[0] = new CalaBrothers(1,"red","大娃",'1');
        CalaBros[1] = new CalaBrothers(2,"orange","二娃",'2');
        CalaBros[2] = new CalaBrothers(3,"yellow","三娃",'3');
        CalaBros[3] = new CalaBrothers(4,"green","四娃",'4');
        CalaBros[4] = new CalaBrothers(5,"cyan","五娃",'5');
        CalaBros[5] = new CalaBrothers(6,"blue","六娃",'6');
        CalaBros[6] = new CalaBrothers(7,"purple","七娃",'7');
        for(int i = 0;i < 7; i++){
            CalaBros[i].site = i;
        }
    }

    public int GetRank() {
        return this.rank;
    }

    public void Number_Off(CalaBrothers bro){
        System.out.print(this.name);
        System.out.print(this.site);
        System.out.print("->");
        System.out.println(bro.site);
    }

    public void Color_Call(){
        System.out.println(this.color);
    }

}
