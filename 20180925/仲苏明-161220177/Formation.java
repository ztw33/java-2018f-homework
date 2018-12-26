package calabashbrothers;

public class Formation {
	public static int Fid;//阵型编号
	public static String name;
	public static int num;//阵型人数
	public static int[] x;
	public static int[] y;
	public static int sx;
	public static int sy;
	public void formachose(){
		switch(Fid) {
		case 1:
			name="";
			num=7;
			x=new int[]{4,5,6,7,6,5,4};
			y=new int[]{6,7,8,9,10,11,12};
			sx=8;
			sy=7;
			break;
		case 2:
			name="";
			num=5;
			x=new int[]{7,6,5,4,3};
			y=new int[]{7,8,9,10,11};
			sx=8;
			sy=6;
			break;
		case 3:
			name="";
			num=6;
			x=new int[]{3,4,5,6,7,8};
			y=new int[]{8,9,8,9,8,9};
			sx=6;
			sy=7;
			break;
		case 4:
			name="";
			num=5;
			x=new int[]{4,5,6,7,8};
			y=new int[]{8,8,8,8,8};
			sx=6;
			sy=7;
			break;
		case 5:
			name="";
			num=11;
			x=new int[]{5,6,7,7,7,8,8,8,8,8,9};
			y=new int[]{8,9,7,8,9,6,7,8,9,10,8};
			sx=6;
			sy=7;
			break;
		case 6:
			name="";
			num=8;
			x=new int[]{6,5,4,5,6,7,8,7};
			y=new int[]{6,7,8,9,10,9,8,7};
			sx=6;
			sy=8;
			break;
		case 7:
			name="";
			num=19;
			x=new int[]{5,6,7,4,5,6,7,8,3,4,5,6,7,8,9,2,3,9,10};
			y=new int[]{7,7,7,8,8,8,8,8,9,9,9,9,9,9,9,10,10,10,10};
			sx=6;
			sy=6;
			break;
		case 8:
			name="";
			num=13;
			x=new int[]{3,4,4,4,5,5,5,6,6,6,7,8,9};
			y=new int[]{9,8,9,10,7,9,11,6,9,12,9,9,9};
			sx=2;
			sy=9;
			break;
		}
	}
}
