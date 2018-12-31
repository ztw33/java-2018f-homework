import java.util.*;


public class GourdBrothers {
    private enum Gourd{
        RED("老大", "赤", 0), ORANGE("老二", "橙", 1), YELLOW("老三", "黄", 2),
        GREEN("老四", "绿", 3), CYAN("老五", "青", 4), BLUE("老六", "蓝", 5), PURPLE("老七", "紫", 6);
        private String name,color;
        private int rank;
        private Gourd(String name, String color, int rank){
            this.rank = rank;
            this.name = name;
            this.color = color;
        }
    }

    private Gourd gourd;

    public GourdBrothers(int rank) {
        this.gourd = Gourd.values()[rank];
    }
    public String tellName(){
        return this.gourd.name;
    }
    public String tellColor(){
        return this.gourd.color;
    }

    public int tellRank(){
        return this.gourd.rank;
    }
    public void report(int src, int dst){
        System.out.println(this.gourd.name + ": " + src + "->" + dst);
    }

    public static void main(String[] args) {
        ArrayList <GourdBrothers> gourdBrothersList = new ArrayList <>(7);
        for(int i = 0; i < 7; i++) {
            gourdBrothersList.add(new GourdBrothers(i));
        }

        //stage 1
        Instructor.randomize(gourdBrothersList);
        Instructor.bubbleSort(gourdBrothersList);
        Instructor.displayInRank(gourdBrothersList);
        //stage 2
        Instructor.randomize(gourdBrothersList);
        Instructor.mergeSort(gourdBrothersList, 0, gourdBrothersList.size() - 1);
        Instructor.displayInColor(gourdBrothersList);
    }

}