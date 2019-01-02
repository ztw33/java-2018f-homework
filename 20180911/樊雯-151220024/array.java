package work1;


//FanWen 151220024
public class array {
	public static void main(String[] args){
		int numberlist[] ={3,46,12,90,21,52,67,73};
		for(int i = 0; i < numberlist.length-1; i++){
			int place = i;
			for(int j = i+1; j<numberlist.length;j++){
				if(numberlist[j]>numberlist[place]){
					place = j;
				}
			}
			if(place != i){
				
				int tempnumber = numberlist[i];
				numberlist[i]= numberlist[place];
				numberlist[place] = tempnumber;
			}
		}
		for(int i = 0; i < numberlist.length; i++){
			System.out.println(numberlist[i]);
			System.out.println(" ");		
		}
	}
}
