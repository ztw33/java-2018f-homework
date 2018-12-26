package homework;

public class CucurbitSort {
	 SomerSaultCloud cloudA = new SomerSaultCloud(Cucurbit.RED);
	 SomerSaultCloud cloudB = new SomerSaultCloud(Cucurbit.ORANGE);
	 SomerSaultCloud cloudC = new SomerSaultCloud(Cucurbit.YELLOW);
	 SomerSaultCloud cloudD = new SomerSaultCloud(Cucurbit.GREEN);
	 SomerSaultCloud cloudE = new SomerSaultCloud(Cucurbit.BLUE);
	 SomerSaultCloud cloudF = new SomerSaultCloud(Cucurbit.INDIGO);
	 SomerSaultCloud cloudG = new SomerSaultCloud(Cucurbit.PURPLE);
	
	 public void showStatus(int[] cucurbit) {
		 for(int i = 0; i < cucurbit.length; i++) {
			 switch(cucurbit[i]) {
			 case 0 : System.out.print(" " + cloudA.cucurbit.getIndetity()); break;
			 case 1 : System.out.print(" " + cloudB.cucurbit.getIndetity()); break;
			 case 2 : System.out.print(" " + cloudC.cucurbit.getIndetity()); break;
			 case 3 : System.out.print(" " + cloudD.cucurbit.getIndetity()); break;
			 case 4 : System.out.print(" " + cloudE.cucurbit.getIndetity()); break;
			 case 5 : System.out.print(" " + cloudF.cucurbit.getIndetity()); break;
			 case 6 : System.out.print(" " + cloudG.cucurbit.getIndetity()); break;
			 }
		System.out.println();
		 }
	 }
	 
	 public void showColor(int[] cucurbit) {
		 for(int i = 0; i < cucurbit.length; i++) {
			 switch(cucurbit[i]) {
			 case 0 : System.out.print(" " + cloudA.cucurbit.name()); break;
			 case 1 : System.out.print(" " + cloudB.cucurbit.name()); break;
			 case 2 : System.out.print(" " + cloudC.cucurbit.name()); break;
			 case 3 : System.out.print(" " + cloudD.cucurbit.name()); break;
			 case 4 : System.out.print(" " + cloudE.cucurbit.name()); break;
			 case 5 : System.out.print(" " + cloudF.cucurbit.name()); break;
			 case 6 : System.out.print(" " + cloudG.cucurbit.name()); break;
			 }
		System.out.println();
		 }
	 }
	 
	 public static void main(String[] args) {
		 CucurbitSort cucurbitSort = new CucurbitSort();
		 RandomNumber randN = new RandomNumber();
		 int[] cucurbit1 = randN.randNumber(7);
		 
		 cucurbitSort.showStatus(TechnologyOfSort.bubleSort(cucurbit1));
		 
		 int[] cucurbit2 = randN.randNumber(7);
		 cucurbitSort.showColor(TechnologyOfSort.binarySearchSort(cucurbit2));
		 
	 }
}
