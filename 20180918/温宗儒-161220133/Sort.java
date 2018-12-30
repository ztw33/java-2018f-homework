import java.util.Scanner;

public class Sort {
    private static void bubbleSort(Car[] cars){
        for(int i=0; i<7; i++){
            for(int j=i+1; j<7; j++){
                if(cars[i].getGourdBoy().attribute.getRank() > cars[j].getGourdBoy().attribute.getRank()){
                    cars[i].move(i+1,j+1);
                    cars[j].move(j+1,i+1);
                    Car temp = cars[i];
                    cars[i] = cars[j];
                    cars[j] = temp;
                }
            }
        }

        for(Car car : cars){
            System.out.print(car.getGourdBoy().attribute.getName() + "\t");
        }
        System.out.println();
    }

    private static void binaryInsertSort(Car[] cars){
        int start,end,mid,j;
        Car temp;

        for(int i=1;i<7;i++){
            start=0;
            end = i-1;
            temp = cars[i];

            while (start<=end){
                mid = (start + end)/2;
                if(temp.getGourdBoy().attribute.getRank() < cars[mid].getGourdBoy().attribute.getRank()){
                    end = mid-1;
                }else {
                    start = mid + 1;
                }
            }

            for(j = i-1;j>=start;j--){
                cars[j].move(j+1,j+2);
//                System.out.println(cars[j].getGourdBoy().attribute.getName()+":"+(j+1)+"->"+(j+2));
                cars[j+1] = cars[j];
            }
            temp.move(i+1, start+1);
//            System.out.println(temp.getGourdBoy().attribute.getName()+":"+(i+1)+"->"+(start+1));
            cars[start] = temp;
        }

        for(Car car : cars){
            System.out.print(car.getGourdBoy().attribute.getColor() + "\t");
        }
        System.out.println();

    }

    public static void main(String[] args){
        Car[] cars = new Car[7];
//        GourdBoy[] gourdBoys = new GourdBoy[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入葫芦七兄弟的随意排队(用1代表大娃，2代表二娃...):");
        int[] queuedArray = new int[7];
        for(int i=0; i<7; i++){ queuedArray[i] = scanner.nextInt(); }
        for(int i=0; i<7; i++){
            Attribute newAttribute = Attribute.values()[queuedArray[i]-1];
            cars[i] = new Car(new GourdBoy(newAttribute));
        }
        bubbleSort(cars);

        System.out.println("请重新输入葫芦七兄弟的随意排队(用1代表大娃，2代表二娃...):");
        for(int i=0; i<7; i++){ queuedArray[i] = scanner.nextInt(); }
        for(int i=0; i<7; i++){
            Attribute newAttribute = Attribute.values()[queuedArray[i]-1];
            cars[i] = new Car(new GourdBoy(newAttribute));
        }
        binaryInsertSort(cars);

    }
}
