public class Individual {
    Coordinate pos;
    boolean side;
    char symbol;

    public Individual() {
        symbol = '.';
    }

    public Individual(Coordinate pos, boolean side) {
        this.pos = pos;
        this.side = side;
    }

    public void moveTo(Coordinate newPos) {
        this.pos = newPos;
        //BattleField revise
    }
}


class Calabash extends Individual {
    CalabashBrother calabashCategory;

    public Calabash(CalabashBrother calabashCategory) {
        this.calabashCategory = calabashCategory;
        symbol = 'O';
        side = true;
    }



}

class Grandpa extends Individual {
    public Grandpa() {
        side = true;
        symbol = '#';
    }

}

class Scorpion extends Individual {

    public Scorpion() {
        side = false;
        symbol = '%';
    }

}

class Snake extends Individual {
    public Snake() {
        side = false;
        symbol = '&';
    }


}

class Goblin extends Individual {
    public Goblin() {
        side = false;
        symbol = '!';
    }
}