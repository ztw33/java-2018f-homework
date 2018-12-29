public class Main {



    void sort(int[] n){
        for(int i = 0;i < n.length - 1;i++){
            for(int j = 0;j < n.length - i - 1;j++){
                if(n[j] > n[j + 1]){
                    int temp = n[j+1];
                    n[j+1] = n[j];
                    n[j] = temp;
                }
            }
        }
        System.out.print("排序后的数组：" );
        for(int i = 0;i <n.length;i++){



            System.out.print(n[i] + " ");

        }
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println("world:"+ 8);
        System.out.println("Integer: " + Integer.SIZE/8);           // 4
        System.out.println("Short: " + Short.SIZE/8);               // 2
        System.out.println("Long: " + Long.SIZE/8);                 // 8
        System.out.println("Byte: " + Byte.SIZE/8);                 // 1
        System.out.println("Character: " + Character.SIZE/8);       // 2
        System.out.println("Float: " + Float.SIZE/8);               // 4
        System.out.println("Double: " + Double.SIZE/8);
        System.out.println("word:"+8);
        int[] arrat1 = new int [20];
        System.out.print("排序前的数组：" );
        for(int i = 0;i <arrat1.length;i++){
            int temp = (int)(Math.random()*100);
            arrat1[i] = temp;

            System.out.print(arrat1[i] + " ");
        }
        System.out.println();
        Main m = new Main();
        m.sort(arrat1);









    }
}
