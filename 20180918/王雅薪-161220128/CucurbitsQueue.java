package Assignment2;

public class CucurbitsQueue {
	
	public static void main(String[] args) {
		Cucurbit[] CU= {new Cucurbit(2,Color.ORANGE),new Cucurbit(6,Color.BLUE),new Cucurbit(1,Color.RED),new Cucurbit(3,Color.YELLOW),new Cucurbit(4,Color.GREEN),
				new Cucurbit(7,Color.PURPLE),new Cucurbit(5,Color.CYAN)};  //initialize cucurbit.
		
		int N = 7;
		MySort Sort = new MySort();
		Sort.BubbleS(CU, N);
		Sort.RandomS(CU, N);
		Sort.DichotomyS(CU, N);
	}

}

