import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

interface SortAlgorithm{
    public void sort(Object[] array);
}

public class Coordinate{
    public class QuickSort implements SortAlgorithm{
        // 快速排序找spilit point
        private int partition(Integer[] queue, int start, int end) {
            int pivot = queue[end];
            int i = start - 1;
            for (int j = start; j <= end - 1; j++) {
                if (queue[j] < pivot) {
                    i = i + 1;
                    if(i != j){
                        calabashqueue.getExchangeOrder(i, j);
                        Integer temp = queue[i];
                        queue[i] = queue[j];
                        queue[j] = temp;
                    }
                }
            }

            if(i+1 != end) {
                //exchangePlace(i+1, end);
                calabashqueue.getExchangeOrder(i+1, end);
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
    public class BubbleSort implements  SortAlgorithm{
        // 冒泡排序
        public void bubbleSort(Integer[] queue){
            for(int i = 0; i < queue.length; i++){
                for(int j = 0; j < queue.length-i-1; j++){
                    if(queue[j] > queue[j+1]){
                        calabashqueue.getExchangeOrder(j, j+1);
                        Integer temp = queue[j];
                        queue[j] = queue[j+1];
                        queue[j+1] = temp;
                    }
                }
            }
            //System.out.println();
        }
        public void sort(Object[] array){
            bubbleSort((Integer[])array);
        }
    }
    public class BinarySort implements SortAlgorithm{
        private void binarySort(Integer[] queue){
            for(int i = 0; i < queue.length; i++){
                //CalabashBrother temp = queue[i];
                Integer temp = queue[i];
                calabashqueue.getMoveOut(i);
                int left = 0;
                int right = i-1;
                int middle = 0;
                while(left <= right){
                    middle = (left + right)/2;
                    if(temp < queue[middle]){
                        right = middle - 1;
                    }
                    else{
                        left = middle + 1;
                    }
                }
                for(int j = i-1; j >= left; j--){
                    //movePlace(j, j+1);
                    //queue[j].getMoveOrder(j+1);
                    calabashqueue.getMoveOrder(j, j+1);
                    queue[j+1] = queue[j];
                }
                if(i != left){
                    //movePlace(temp, i, left);
                    //temp.getMoveOrder(left);
                    calabashqueue.getMoveOrder(left);
                    queue[left] = temp;
                }
            }
        }
        public void sort(Object[] array){
            binarySort((Integer[]) array);
        }
    }
    public QuickSort getQuickSort(){
        return new QuickSort();
    }
    public BubbleSort getBubbleSort(){
        return new BubbleSort();
    }
    public BinarySort getBinarySort(){
        return new BinarySort();
    }
    private static CalabashGroup calabashqueue = new CalabashGroup();
    public static void main(String[] args) {
        Coordinate coordinator =  new Coordinate();
        BubbleSort myBubbleSort = coordinator.getBubbleSort();
        BinarySort myBinarySort = coordinator.getBinarySort();
        calabashqueue.shuffle();
        System.out.println("shuffled");
        Integer[] queue = calabashqueue.getRank();
        calabashqueue.toldName();
        myBubbleSort.sort(queue);
        calabashqueue.toldName();

        calabashqueue.shuffle();
        System.out.println("shuffled");
        queue = calabashqueue.getRank();
        calabashqueue.toldName();
        myBinarySort.sort(queue);
        calabashqueue.toldColor();
    }
}
class CalabashGroup{
    private CalabashBrother[] array;
    private CalabashBrother temp;
    private int previousPlace;
    public CalabashGroup(){
        array = CalabashBrother.values();
    }
    public void shuffle(){
        ArrayList<CalabashBrother>queue = new ArrayList<CalabashBrother>(Arrays.asList(array));
        Collections.shuffle(queue);
        int size = queue.size();
        array = queue.toArray(new CalabashBrother[size]);
    }
    public Integer[] getRank(){
        Integer[] rankArray = new Integer[array.length];
        for(int i = 0; i < array.length; i++){
            rankArray[i] = array[i].ordinal();
        }
        return rankArray;
    }
    public void getMoveOrder(int src, int dest){
        array[dest] = array[src];
        System.out.println(array[src].getName()+':'+(src+1)+"->"+(dest+1));
    }
    public void getMoveOut(int src){
        previousPlace = src;
        temp = array[src];
    }
    public void getMoveOrder(int dest){
        array[dest] = temp;
        System.out.println(temp.getName()+':'+(previousPlace+1)+"->"+(dest+1));
    }
    public void getExchangeOrder(int pos1, int pos2){
        System.out.println(array[pos1].getName()+':'+(pos1+1)+"->"+(pos2+1));
        System.out.println(array[pos2].getName()+':'+(pos2+1)+"->"+(pos1+1));
        CalabashBrother copy = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = copy;
    }
    public void toldColor(){
        for(int i = 0; i < array.length; i++){
            array[i].toldColor();
        }
    }
    public void toldName(){
        for(int i = 0; i < array.length; i++){
            array[i].toldName();
        }
    }
}
/*
public class CalabashBrothers {
    private ArrayList brothers = new ArrayList();
    private void exchangePlace(int i, int j){
        System.out.print(((Calabash) brothers.get(i)).getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        System.out.print(((Calabash) brothers.get(j)).getName()+':'+ (j+1) + "->" + (i+1) + ' ');
        Calabash temp = (Calabash) brothers.get(i);
        brothers.set(i, brothers.get(j));
        brothers.set(j, temp);
    }
    private void movePlace(int i, int j){
        System.out.print(((Calabash) brothers.get(i)).getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        brothers.set(j, brothers.get(i));
    }
    private void movePlace(Calabash temp, int i, int j){
        System.out.print(temp.getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        brothers.set(j, temp);
    }
    // 快速排序找spilit point
    private int partition(int start, int end, GetKey getKey) {
        int pivot = getKey.key(brothers.get(end));
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (getKey.key(brothers.get(j)) < pivot) {
                i = i + 1;
                if(i != j){
                    exchangePlace(i, j);
                }
            }
        }

        if(i+1 != end) {
            exchangePlace(i+1, end);
        }
        return i + 1;
    }
    // 快速排序
    public void quickSort(int start, int end, GetKey getKey) {
        if (start < end) {
            int spilitPoint = partition(start, end, getKey);
            quickSort(start, spilitPoint - 1, getKey);
            quickSort(spilitPoint + 1, end, getKey);
        }
    }
    // 二分排序
    public void binarySort(GetKey getKey){
        for(int i = 0; i < brothers.size(); i++){
            Calabash temp = new Calabash((Calabash)brothers.get(i));
            int left = 0;
            int right = i-1;
            int middle = 0;
            while(left <= right){
                middle = (left + right)/2;
                if(getKey.key(temp) < getKey.key(brothers.get(middle))){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
            for(int j = i-1; j >= left; j--){
                movePlace(j, j+1);
            }
            if(i != left)
                movePlace(temp, i, left);
        }
    }
    // 冒泡排序
    public void bubbleSort(GetKey getKey){
        for(int i = 0; i < brothers.size(); i++){
            for(int j = 0; j < brothers.size()-i-1; j++){
                if(getKey.key(brothers.get(j)) > getKey.key(brothers.get(j+1))){
                    exchangePlace(j, j+1);
                }
            }
        }
        //System.out.println();
    }
    // 获取用于排序的属性的方法
    private class getAge extends GetKey{
        public int key(Object input){
            input = (Calabash)input;
            return ((Calabash) input).getOrder();
        }
    }
    private class getColor extends GetKey{
        public int key(Object input){
            input = (Calabash)input;
            return ((Calabash) input).getSelfColor().ordinal();
        }
    }
    // 初始化葫芦兄弟
    public CalabashBrothers(){
        brothers.add(new Calabash(Color.RED,"老大"));
        brothers.add(new Calabash(Color.PURPLE,"老七"));
        brothers.add(new Calabash(Color.CYAN,"老五"));
        brothers.add(new Calabash(Color.ORANGE,"老二"));
        brothers.add(new Calabash(Color.GREEN,"老四"));
        brothers.add(new Calabash(Color.YELLOW,"老三"));
        brothers.add(new Calabash(Color.BLUE,"老六"));
    }
    public void CalabashBubbleSort(){
        bubbleSort(new getAge());
        System.out.println();
        toldColor();
    }
    public void CalabashBinarySort(){
        binarySort(new getColor());
        System.out.println();
        toldName();
    }
    public void CalabashQuickSort(){
        quickSort(0, brothers.size()-1, new getColor());
        System.out.println();
        toldName();
    }

    public static void main(String[] args) {
        CalabashBrothers mybrothers = new CalabashBrothers();
        //System.out.println(mybrothers.brothers.toString());
        //mybrothers.CalabashBinarySort();
        //System.out.println(mybrothers.brothers.toString());
        mybrothers.CalabashBubbleSort();
    }
}
*/