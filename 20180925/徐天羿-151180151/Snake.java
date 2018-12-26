package calabash;

public final class Snake extends Monsters implements Cheer {
	Snake(){
		name = "蛇精";
		type = 1;
	}
	
	Snake(int ix, int iy){
		name = "蛇精";
		x = ix;
		y = iy;
	}
	
	@Override
    public void cheer(){
        
    }
}
