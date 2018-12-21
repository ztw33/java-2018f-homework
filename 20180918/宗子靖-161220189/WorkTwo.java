public class WorkTwo {
    public static void main(String args[]) {
        CalabashBros calabashBro=new CalabashBros();
        calabashBro.bubbleSort();
        calabashBro.reArrange();
        calabashBro.dichotomySort();
    }
}
interface SortingMethods{
    public void bubbleSort();
    public void dichotomySort();
}
class CalabashBros implements SortingMethods{
    CalabashKid [] calabashBros=new CalabashKid[7];
    CalabashBros(){
        calabashBros[0]=CalabashKid.CYAN;
        calabashBros[1]=CalabashKid.GREEN;
        calabashBros[2]=CalabashKid.YELLOW;
        calabashBros[3]=CalabashKid.PURPLE;
        calabashBros[4]=CalabashKid.RED;
        calabashBros[5]=CalabashKid.ORANGE;
        calabashBros[6]=CalabashKid.BLUE;
    }
    void reArrange(){
        calabashBros[0]=CalabashKid.CYAN;
        calabashBros[1]=CalabashKid.GREEN;
        calabashBros[2]=CalabashKid.YELLOW;
        calabashBros[3]=CalabashKid.PURPLE;
        calabashBros[4]=CalabashKid.RED;
        calabashBros[5]=CalabashKid.ORANGE;
        calabashBros[6]=CalabashKid.BLUE;
        System.out.print("\nRearrange Complete!\n\n");
    }
    public void bubbleSort(){
        System.out.println("Bubble Sorting:");
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++) {
                if(calabashBros[j].ordinal()>calabashBros[j+1].ordinal()){
                    changeAndPrint(j,j+1);
                }
            }
        }
        System.out.println("Bubble Sort Complete!");
        printName();
    }
    public void dichotomySort(){
        System.out.println("Dichotomy Sorting:");
        for(int i=1;i<7;i++){
            dichotomySortEach(0,i-1,i);
        }
        System.out.println("Dichotomy Sorting Complete!");
        printColor();
    }
    private void dichotomySortEach(int start, int end, int pos){//find the right place to insert calabashBros[pos]
        if(start==end){
            if(calabashBros[pos].ordinal()>calabashBros[start].ordinal()){
                dichotomySortInsert(start+1,pos);
            }else{
                dichotomySortInsert(start,pos);
            }
        }else{
            int mid=(start+end)/2;
            if(calabashBros[pos].ordinal()>calabashBros[mid].ordinal()){
                dichotomySortEach(mid+1,end,pos);
            }else{
                dichotomySortEach(start,mid,pos);
            }
        }
    }
    private void dichotomySortInsert(int start, int pos){//insert the kid at calabashBros[pos] to calabashBros[start]
        CalabashKid tempKid=calabashBros[pos];
        while(pos>start){
            changeAndPrint(pos,pos-1);
            pos--;
        }
    }
    public void printName(){//print kids' names in array's sequence
        System.out.println("Names:");
        for(int i=0;i<7;i++){
            System.out.println("the no."+i+" kid's name is "+calabashBros[i].getName());
        }
    }
    public void printColor(){//print kids' color in array's sequence
        System.out.println("Colors:");
        for(int i=0;i<7;i++){
            System.out.println("the no."+i+" kid's color is "+calabashBros[i].getColor());
        }
        System.out.print("\n");
    }
    private void changeAndPrint(int i, int j){//switch two kids' position and show the change
        System.out.println(calabashBros[i].getName()+" at pos "+i+" <-> "+calabashBros[j].getName()+" at pos "+j);
        CalabashKid tempKid=calabashBros[i];
        calabashBros[i]=calabashBros[j];
        calabashBros[j]=tempKid;
    }
}
enum CalabashKid{
    RED("红色","老大"),ORANGE("橙色","老二"),YELLOW("黄色","老三"),GREEN("绿色","老四"),CYAN("青色","老五"),BLUE("蓝色","老六"),PURPLE("紫色","老七");
    private String color;
    private String name;
    CalabashKid(String color, String name){
        this.color=color;
        this.name=name;
    }
    String getName(){//get kid's name
        return name;
    }
    String getColor(){//get kid's color
        return color;
    }
}



