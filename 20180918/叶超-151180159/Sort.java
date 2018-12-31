package huluwa;
import huluwa.Huluwa;
import java.util.*;

public class Sort {
	Huluwa[] list;
	Sort(Huluwa[] list){
		this.list=list;
	}
    private void swap(int i, int j) {
        Huluwa tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
        System.out.println(list[j].get_name() + ": "+ i + "->" + j);
}
	public void randomSort(Huluwa[] list){
		Collections.shuffle(Arrays.asList(list));
	}
	public void bubbleSort(){
        System.out.println("---------- bubbleSort ----------");
        //sort by enum_ordinal
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (list[i].ordinal() > list[j].ordinal()) {
                    swap(i, j);
                }
            }
}
	}
	
    private int partition(int begin, int end) {
        Huluwa pivot = list[begin];
        int pivotpos = begin;
        //sort by color_ordinal
        for (int i = begin + 1; i <= end; i++) {
            if (list[i].get_color_ordinal() < pivot.get_color_ordinal()) {
                pivotpos++;
                if (pivotpos != i)
                    swap(pivotpos, i);
            }
        }
        if(begin != pivotpos) {
            System.out.println(list[begin].get_name() + ": " + begin + "->" + pivotpos);
            list[begin] = list[pivotpos];
            list[pivotpos] = pivot;
        }
        return pivotpos;
    }

    private void qSort(int begin, int end) {
        if (begin <= end) {
            int pivot = partition(begin, end);
            qSort(0, pivot - 1);
            qSort(pivot + 1, end);
        }
}
    
	public void quickSort(){
		System.out.println("---------- quickSort ----------");
		qSort(0,6);
	}
}
