package homework;
//数组偶数项存储横坐标，奇数项存储纵坐标
public class TechnologyOfBattleArray {
	//鹤翼阵
	public int[] reuilly(int numberOfLackeys) {
		int i;
		int k;
		int[] location = new int[2 * numberOfLackeys + 2];
		location[0] = 10;
		location[1] = 10;
		for(i = 1; i <= (numberOfLackeys/2); i++) {
			location[i * 2] = 10 + i;
			location[i * 2 + 1] = 10 + i; 
		}
		for(k = i + 1; k <= numberOfLackeys; k++) {
			location[k * 2] = 10 + k - i;
			location[k * 2 + 1] = 10 - k + i;
		}
		return location;
	}
	//雁行阵
	public int[] echelons(int numberOfLackeys) {
		int i;
		int k;
		int[] location = new int[2 * numberOfLackeys + 2];
		location[0] = 14;
		location[1] = 10;
		for(i = 1; i <= (numberOfLackeys/2); i++) {
			location[i*2] = 14 + i;
			location[i*2+1] = 10 + i;
		}
		for(k = i + 1; k <= numberOfLackeys; k++) {
			location[k*2] = 14 + k - i;
			location[k*2+1] = 10 - k + i;
		}
		return location;
	}
	//车轨阵
	public int[] wheel(int numberOfLackeys) {
		int i;
		int k;
		int l;
		int j;
		int[] location = new int[2 * numberOfLackeys + 2];
		location[0] = 14;
		location[1] = 10;
		location[2] = 15;
		location[3] = 11;
		for(i = 1; i <= (numberOfLackeys/4); i++) {
			location[i * 2] = 14;
			location[i*2+1] = 10 + 2 * i;
		}
		for(k = i + 1; k <= (numberOfLackeys/2); k++) {
			location[k*2] = 14;
			location[k*2+1] = 10 - 2 * (k - i);
		}
		for(l = k + 1; l <= k + i; l++) {
			location[l*2] = 15;
			location[l*2+1] = 11 + 2 * (l - k);
		}
		for(j = l; j <= numberOfLackeys; j++) {
			location[j*2] = 15;
			location[j*2+1] = 11 - 2 * (j - l);
		}
		return location;
	}
	//鱼鳞阵
	public int[] scale() {
		int[] location = new int[20];
		location[0] = 10;
		location[1] = 10;
		location[2] = 11;
		location[3] = 10;
		location[4] = 9;
		location[5] = 10;
		location[6] = 8;
		location[7] = 9;
		location[8] = 9;
		location[9] = 9;
		location[10] = 10;
		location[11] = 9;
		location[12] = 11;
		location[13] = 9;
		location[14] = 10;
		location[15] = 8;
		location[16] = 8;
		location[17] = 11;
		location[18] = 7;
		location[19] = 12;
		return location;
	}
	//锋矢阵
	public int[] arrow(int numberOfLackeys) {
		int i, k, j;
		int[] location = new int[2*numberOfLackeys+2];
		location[0] = 10;
		location[1] = 10;
		for(i = 1; i <= numberOfLackeys/2; i++) {
			location[i*2] = 10 + i;
			location[i*2+1] = 10;
		}
		for(k = i + 1; k <= i + numberOfLackeys/4; k++) {
			location[k*2] = 10 + k -i;
			location[k*2+1] = 10 + k - i;
		}
		for(j = k + 1; j <= numberOfLackeys; j++) {
			location[j*2] = 10 - j + k;
			location[j*2+1] = 10 - j + k;
		}
		return location;
	}
	//偃月阵
	public int[] moon() {
		int[] location = new int[38];
		location[0] = 10;
		location[1] = 10;
		location[2] = 11;
		location[3] = 10;
		location[4] = 12;
		location[5] = 10;
		for(int i = 0; i < 2; i++) {
			location[6+i*6] = location[0];
			location[6+i*6+1] = (int) (location[1] + Math.pow(-1,i));
			location[6+i*6+2] = location[2];
			location[6+i*6+3] = location[6+i*6+1];
			location[6+i*6+4] = location[4];
			location[6+i*6+5] = location[6+i*6+1];
		}
		location[18] = 12;
		location[19] = 12;
		location[20] = 13;
		location[21] = 13;
		location[22] = 13;
		location[23] = 12;
		location[24] = 14;
		location[25] = 13;
		location[26] = 15;
		location[27] = 14;
		location[28] = 12;
		location[29] = 8;
		location[30] = 13;
		location[31] = 7;
		location[32] = 13;
		location[33] = 8;
		location[34] = 14;
		location[35] = 7;
		location[36] = 15;
		location[37] = 6;
		return location;
	}
	//方阵
	public int[] square() {
		int[] location = new int[16];
		location[0] = 10;
		location[1] = 10;
		location[2] = 11;
		location[3] = 11;
		location[4] = 12;
		location[5] = 12;
		location[6] = 13;
		location[7] = 11;
		location[8] = 14;
		location[9] = 10;
		location[10] = 11;
		location[11] = 9;
		location[12] = 12;
		location[13] = 8;
		location[14] = 13;
		location[15] = 9;
		return location;
	}
}
