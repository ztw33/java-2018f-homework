public class Calabash {
    public static void bubble_sort(Brother []brother_list) {
        for(int i = 0;i < brother_list.length; i++) {
            for(int j = 0;j < brother_list.length - i - 1; j++) {
                if(brother_list[j].rank > brother_list[j + 1].rank) {
                    brother_list[j].exchange_place(j, j+1);
                    brother_list[j + 1].exchange_place(j+1, j);
                    Brother temp = brother_list[j];
                    brother_list[j] = brother_list[j + 1];
                    brother_list[j + 1] = temp;
                }
            }
        }
    }
    public static void get_random(Brother []boy_list) {
        boy_list[0] = new Brother(4);
        boy_list[1] = new Brother(2);
        boy_list[2] = new Brother(6);
        boy_list[3] = new Brother(1);
        boy_list[4] = new Brother(5);
        boy_list[5] = new Brother(7);
        boy_list[6] = new Brother(3);
    }

    public static void binary_sort(Brother []brother_list) {
        int left;
        for(int i = 1; i < brother_list.length; i++) {
            left = 0;
            int right = i - 1;
            Brother temp = brother_list[i];
            int pivot;
            while (left <= right) {
                pivot = (left + right) / 2;
                if(brother_list[pivot].get_color_rank() < temp.get_color_rank()) {
                    left = pivot + 1;
                }
                else
                    right = pivot - 1;
            }
            for(int j = i; j > left; j--) {
                brother_list[j - 1].exchange_place(j - 1, j);
                brother_list[j] = brother_list[j - 1];
            }
            if(left != i)
                temp.exchange_place(i, left);
            brother_list[left] = temp;
        }
    }

    public static void main(String []argv) {
        Brother []boy_list = new Brother[7];
        // sort according to
        get_random(boy_list);
        bubble_sort(boy_list);
        for(int i = 0;i < boy_list.length; i++)
            boy_list[i].report_name();
        System.out.println();
        // sort according to color
        get_random(boy_list);
        binary_sort(boy_list);
        for(int i = 0; i < boy_list.length; i++)
            boy_list[i].report_color();
        return;

    }
}

