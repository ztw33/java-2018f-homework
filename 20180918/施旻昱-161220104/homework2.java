enum Calabash_color{
    red("红色", 0), orange("橙色", 1), yellow("黄色", 2), green("绿色", 3), blue("青色", 4), indigo("蓝色", 5), violet("紫色", 6);
    private String color_name;
    private int color_no;

    Calabash_color(String name, int no) {
        this.color_name = name;
        this.color_no = no;
    }

    public static int color_compare(String name1, String name2){
        int no1 = color_find(name1), no2 = color_find(name2);
        return Integer.compare(no1, no2);
    }

    public static int color_find(String name){
        for(Calabash_color s: Calabash_color.values())
            if(s.color_name == name)
                return s.color_no;
        return -1;
    }
}

enum Calabash_name {
    first("老大", 0), second("老二", 1), third("老三", 2), fourth("老四", 3), fifth("老五", 4), sixth("老六", 5), seventh("老七", 6);
    private String name;
    private int no;

    Calabash_name(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public static int name_compare(String name1, String name2) {
        int no1 = name_find(name1), no2 = name_find(name2);
        return Integer.compare(no1, no2);
    }

    public static int name_find(String name) {
        for (Calabash_name s : Calabash_name.values()) {
            if (s.name == name)
                return s.no;
        }
        return -1;
    }
}
enum Calabash {
        a("红色", "老大", 0), b("橙色", "老二", 1), c("黄色", "老三", 2), d("绿色", "老四", 3), e("青色", "老五", 4), f("蓝色", "老六", 5), g("紫色", "老七", 6);
        private String color;
        private String name;
        private int no;
        Calabash(String color, String name, int no){
            this.name = name;
            this.color = color;
            this.no = no;
        }
        public static String get_name(int no){
            String out_name = "";
            for(Calabash s : Calabash.values()){
                if(s.no == no)
                    out_name = s.name;
            }
            return out_name;
        }
        public static String get_color(int no){
            String out_color = "";
            for(Calabash s : Calabash.values()){
                if(s.no == no)
                    out_color = s.color;
            }
            return out_color;
        }
}

public class queue{
    static int[] order;

    public static void main(String[] args){
        order = initial();
        sort1();
        show_after_sort1();
        order = initial();
        sort2();
        show_after_sort2();
    }
    public static int[] initial(){
        int[] new_array = {5,2,1,0,3,6,4};
        return new_array;
    }
    public static void sort1(){//bubblesort
        for(int i = order.length - 1; i >= 0; i--)
            for(int j = 0; j <= i - 1; j++)
                //if(order[j] > order[j + 1]) {
                if(Calabash_name.name_compare(Calabash.get_name(order[j]), Calabash.get_name(order[j + 1])) > 0){
                    show(order[j], j, j + 1);
                    show(order[j + 1], j + 1, j);
                    change(j, j + 1);
                }

    }
    public static void show(int i, int before, int after) {
        String name = Calabash.get_name(i);
        System.out.println(name + ": " + before + "->" + after);
    }
    public static void change(int i, int j) {
        int temp = order[i];
        order[i] = order[j];
        order[j] = temp;
    }
    public static void sort2(){
        for(int i = 1; i < order.length; i++){
            int pos = mid_sort(order, i, 0, i);
            if(pos == i)
                continue;
            insert(i, pos, i);
        }
    }
    public static int mid_sort(int[] a, int i, int low, int high){
        while(low < high){
            int temp_pos = (low + high) / 2;
            if(Calabash_color.color_compare(Calabash.get_color(order[i]), Calabash.get_color(order[temp_pos])) > 0)
                return mid_sort(a, i, temp_pos + 1, high);
            else
                return mid_sort(a, i, low, temp_pos);
        }
        return low;
    }
    public static void insert(int number, int pos, int end){
        int temp_num = order[number];
        for(int i = end; i > pos; i--){
            show(order[i - 1], i - 1 , i);
            order[i] = order[i - 1];
        }
        show(temp_num, number, pos);
        order[pos] = temp_num;
    }
    public static void show_after_sort1() {
        for(int i = 0; i < order.length; i++){
            String name = Calabash.get_name(order[i]);
            System.out.print(name + ": " + name + " ");
        }
        System.out.print('\n');
    }
    public static void show_after_sort2() {
        for(int i = 0; i < order.length; i++){
            String name = Calabash.get_name(order[i]);
            String color = Calabash.get_color(order[i]);
            System.out.print(name + ": " + color + " ");
        }
        System.out.print('\n');
    }
}

