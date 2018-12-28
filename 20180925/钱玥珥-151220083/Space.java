package square;

public class Space {
	Member [][]space; 
	Space(){
		space=new Member[N][N];
		clear();
	}

	public void clearSpace(){
		clear();
	}
	public void enter(Member member,Forces force) {
		int center_x;
		if(force==Forces.HULUWA) {
			center_x=N/4;
		}
		else {
			center_x=3*N/4;
		}
		while(true) {
			for(int i = 0;i<N/2;i++) {
				if(space[i+2][center_x]==Member.EMPTY);
				else if(i-1>=0) {
					space[i-1][center_x]=member;
					return;
				}
				else {
					center_x--;
					break;
				}
			}
		}
	}
	public void enterQueue(Member [][]queue,int row,int col,Forces force) {
		int center_x,center_y;
		center_y=N/2;
		if(force==Forces.HULUWA) {
			center_x=N/4;
		}
		else {
			center_x=3*N/4;
		}
		
		int start_x,start_y;
		start_x=center_x-col/2;
		start_y=center_y-row/2;
		
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				space[i+start_y][j+start_x]=queue[i][j];
			}
		}
	}

	private void clear() {
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				space[i][j]=Member.EMPTY;
			}
		}
	}
	public final int N =20;
	public Member locationOf(int x,int y) {
		return space[x][y];
	}
}
