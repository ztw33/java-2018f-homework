package calabash;

public final class Grandpa extends Creature implements Cheer {
	Grandpa(){
		name = "爷爷";
		type = 0;
	}
	
	Grandpa(int ix, int iy){
		name = "爷爷";
		x = ix;
		y = iy;
	}
	
	@Override
    public void cheer() {
        
    }
}
