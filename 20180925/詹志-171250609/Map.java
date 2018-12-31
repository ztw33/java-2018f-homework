package homework;

public class Map {
	String[][] map;
	TheBigBattle battle = new TheBigBattle();
	public Map() {
		map = new String[20][20];
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				map[i][j] = "blank";
		map[2][5] = "GRADNPA";
		map[10][15] = "SNACK";
	}
	public void printMap(int[] cucurbitArray, int[] animalLocation) {
		map[animalLocation[0]][animalLocation[1]] = "SCORPOIN";
		for(int i = 1; i < (animalLocation.length/2); i++)
			map[animalLocation[2*i]][animalLocation[2*i+1]] = "LACKEY";
		for(int i = 0; i < 7; i++) {
			switch(cucurbitArray[i]) {
			case 0 : map[5][7+i] = battle.cloudA.cucurbit.name();
			break;
			case 1 : map[5][7+i] = battle.cloudB.cucurbit.name();
			break;
			case 2 : map[5][7+i] = battle.cloudC.cucurbit.name();
			break;
			case 3 : map[5][7+i] = battle.cloudD.cucurbit.name();
			break;
			case 4 : map[5][7+i] = battle.cloudE.cucurbit.name();
			break;
			case 5 : map[5][7+i] = battle.cloudF.cucurbit.name();
			break;
			case 6 : map[5][7+i] = battle.cloudG.cucurbit.name();
			}
		}
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				System.out.print(" " + map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
