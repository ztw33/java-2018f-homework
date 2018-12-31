public class CbFormation {
    public static Brother[] CbList;
    CbFormation() {
        CbList = new Brother[7];
        CbList[0] = new Brother("老四", "绿色", '④', 4);
        CbList[1] = new Brother("老二", "橙色", '②', 2);
        CbList[2] = new Brother("老六", "蓝色", '⑥', 6);
        CbList[3] = new Brother("老大", "红色", '①', 1);
        CbList[4] = new Brother("老五", "青色", '⑤', 5);
        CbList[5] = new Brother("老七", "紫色", '⑦', 7);
        CbList[6] = new Brother("老三", "黄色", '③', 3);
    }
    public static void CbSetLongLineArray() {
        BubbleSort(CbList);
        int start_loc = 10 - CbList.length / 2;
        int col = 4;
        for(int i = 0; i < CbList.length; i++) {
            CbList[i].set_position(start_loc, col);
            start_loc ++;
        }
    }
    public static void BubbleSort(Brother []brother_list) {
        for(int i = 0;i < brother_list.length; i++) {
            for(int j = 0;j < brother_list.length - i - 1; j++) {
                if(brother_list[j].get_rank() > brother_list[j + 1].get_rank()) {
                    //brother_list[j].exchange_place(j, j+1);
                    //brother_list[j + 1].exchange_place(j+1, j);
                    Brother temp = brother_list[j];
                    brother_list[j] = brother_list[j + 1];
                    brother_list[j + 1] = temp;
                }
            }
        }
    }
}
