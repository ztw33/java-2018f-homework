import java.util.*;
import Being.*;
public class CbFormation {
    public static List<Brother> CbList;
    CbFormation() {
        CbList = new ArrayList<>();
        CbList.add(new Brother("老四", "绿色", '④', 4));
        CbList.add(new Brother("老二", "橙色", '②', 2));
        CbList.add(new Brother("老六", "蓝色", '⑥', 6));
        CbList.add(new Brother("老大", "红色", '①', 1));
        CbList.add(new Brother("老五", "青色", '⑤', 5));
        CbList.add(new Brother("老七", "紫色", '⑦', 7));
        CbList.add(new Brother("老三", "黄色", '③', 3));
    }
    public static void CbSetLongLineArray() {
        BubbleSort(CbList);
        int start_loc = 10 - CbList.size() / 2;
        int col = 4;

        for(Iterator<Brother> it = CbList.iterator(); it.hasNext();) {
            it.next().set_position(start_loc, col);
            start_loc ++;
        }
    }
    public static void BubbleSort(List<Brother> brother_list) {
        for(int i = 0;i < brother_list.size(); i++) {
            for(int j = 0;j < brother_list.size() - i - 1; j++) {
                if(brother_list.get(j).get_rank() > brother_list.get(j + 1).get_rank()) {
                    //brother_list[j].exchange_place(j, j+1);
                    //brother_list[j + 1].exchange_place(j+1, j);
                    Brother temp = brother_list.get(j);
                    brother_list.set(j, brother_list.get(j + 1));
                    brother_list.set(j + 1, temp);
                }
            }
        }
    }
}
