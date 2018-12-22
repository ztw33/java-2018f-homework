//package qt;

public class BattleField {
	private Creature[][] board;
	private int m,n;
	public BattleField(int m,int n) {
		board=new Creature[m][n];
		this.m=m;
		this.n=n;
	}
	public int getM() {
		return m;
	}
	public int getN() {
		return n;
	}
	public Position getEmptyPosition(boolean left) {
		int base=left?0:5*n/8;
		for(int i=m/8;i<m;i++) {
			for(int j=n/8+base;j<n/4+base;j++) {
				if(board[i][j]==null) {
					return new Position(i,j);
				}
			}
		}
		return null;
	}
	public void set(Creature creature,Position position) {
		board[position.getX()][position.getY()]=creature;
	}
	public void reset(boolean left) {
		for(int i=0;i<m;i++) {
			for(int j=(left?0:n/2-3);j<(left?n/2-3:n);j++) {
				board[i][j]=null;
			}
		}
	}
//	public Creature get(Position position) {
//		return board[position.getX()][position.getY()];
//	}
	public void printBattleField() {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]!=null)
					System.out.print(board[i][j]);
				else
					System.out.print('.');
			}
			System.out.println();
		}
		System.out.println();
	}
}
