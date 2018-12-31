package calabash;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {	
	public void bubbleSort(ArrayList<CalabashBrothers> bros) {
		for(int i = 0; i < bros.size(); i++) {
			for(int j = i + 1; j < bros.size(); j++) {
				if(bros.get(i).getRank() > bros.get(j).getRank()) {
					Collections.swap(bros, i, j);
				}
			}
		}
	}	
}
