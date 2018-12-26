public class second {

    public static void main(String args[]){
        GourdBoys[] gbs = {GourdBoys.老大,GourdBoys.老三,GourdBoys.老七,GourdBoys.老六,GourdBoys.老四,GourdBoys.老二,GourdBoys.老五};
        Coordinator.randomArrange(gbs);
        System.out.println("排序前：");
        for(GourdBoys gb:gbs){
            System.out.print(gb.toString()+" ");
        }
        System.out.print("\n");
        Coordinator.bubbleSort(gbs);
        Coordinator.randomArrange(gbs);
        System.out.println("随机打乱后：");
        for(GourdBoys gb:gbs){
            System.out.print(gb.toString()+" ");
        }
        System.out.print("\n");
        Coordinator.biInsertSort(gbs);
    }
}
