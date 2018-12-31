import java.util.*;
public class CalabashGroup{
    public CalabashGroup(){
        group = new CalabashBrother[7];
        for(int i = 0; i < group.length; i++){
            group[i] = new CalabashBrother(i);
        }
    }
    public Creature[] getFormationCreatrue(){
        return (Creature[])group;
    }
    public void getMoveOut(int src){
        previousPlace = src;
        temp = group[src];
    }
    public void getMoveOrder(int dest){
        group[dest] = temp;
        System.out.println(temp.getName()+':'+(previousPlace+1)+"->"+(dest+1));
    }
    public void getExchangeOrder(int pos1, int pos2){
        System.out.println(group[pos1].getName()+':'+(pos1+1)+"->"+(pos2+1));
        System.out.println(group[pos2].getName()+':'+(pos2+1)+"->"+(pos1+1));
        CalabashBrother copy = group[pos1];
        group[pos1] = group[pos2];
        group[pos2] = copy;
    }
    public class QuickSort implements SortAlgorithm {
        // 快速排序找spilit point
        private int partition(Integer[] queue, int start, int end) {
            int pivot = queue[end];
            int i = start - 1;
            for (int j = start; j <= end - 1; j++) {
                if (queue[j] < pivot) {
                    i = i + 1;
                    if(i != j){
                        getExchangeOrder(i, j);
                        Integer temp = queue[i];
                        queue[i] = queue[j];
                        queue[j] = temp;
                    }
                }
            }

            if(i+1 != end) {
                //exchangePlace(i+1, end);
                getExchangeOrder(i+1, end);
                Integer temp = queue[i+1];
                queue[i+1] = queue[end];
                queue[end] = temp;
            }
            return i + 1;
        }
        // 快速排序
        private void quickSort(Integer[] array, int start, int end) {
            if (start < end) {
                int spilitPoint = partition(array, start, end);
                quickSort(array, start, spilitPoint - 1);
                quickSort(array,spilitPoint + 1, end);
            }
        }
        public void sort(Object[] array){
            quickSort((Integer[]) array, 0, array.length - 1);
        }
    }
    public QuickSort getQuickSort(){
        return new QuickSort();
    }
    public Integer[] getRank(){
        Integer[] rankArray = new Integer[group.length];
        for(int i = 0; i < group.length; i++){
            rankArray[i] = group[i].getRank();
        }
        return rankArray;
    }
    public void shuffle(){
        ArrayList<CalabashBrother>queue = new ArrayList<CalabashBrother>(Arrays.asList(group));
        Collections.shuffle(queue);
        int size = queue.size();
        group = queue.toArray(new CalabashBrother[size]);
    }
    public void print(){
        for (int i = 0; i < group.length; i++){
            System.out.print(group[i].getName()+',');
        }
        System.out.println();
    }
    private CalabashBrother[] group;
    private CalabashBrother temp;
    private int previousPlace;
}
interface SortAlgorithm{
    public void sort(Object[] array);
}
class CalabashBrother extends Creature{
    public enum Color{
        RED("老大","红色"),ORANGE("老二","橙色"),YELLOW("老三","黄色"),GREEN("老四","绿色"),
        CYAN("老五","青色"),BLUE("老六","蓝色"),PURPLE("老七","紫色");
        private final String name;
        private final String color;
        private Color(String name, String color){
            this.color = color;
            this.name = name;
        }
        public String getColor(){
            return color;
        }
        public String getName(){
            return name;
        }
    }
    private Color selfColor;
    public CalabashBrother(int i){
        selfColor = Color.values()[i];
    }
    public void setColor(int i){
        selfColor = Color.values()[i];
    }
    public void toldColor(){
        System.out.println(selfColor.getColor());
    }
    public void toldName(){
        System.out.println(selfColor.getName());
    }
    public String getName(){
        return selfColor.getName();
    }
    public int getRank(){
        return selfColor.ordinal();
    }
    @Override
    public void toldCreatureCategoryAndName() {
        System.out.println("Calabashbrother:" + selfColor.getName());
    }
    @Override
    public void toldCreature(){
        System.out.print("|"+selfColor.getName()+"  " );
    }
}


