public class Grandpa extends Creature {
    Grandpa() {
        this.name = "爷爷";
        this.x = this.y = 0;
        this.number = 8;
        this.type=CreatureType.GRANDPA;
    }

    Grandpa(int get_x, int get_y) {
        this.name = "爷爷";
        this.x = get_x;
        this.y = get_y;
        this.number = 8;
        this.type=CreatureType.GRANDPA;
    }

    public void Cheer() {
        System.out.println("Cheer! (from 爷爷)");
    }
}
