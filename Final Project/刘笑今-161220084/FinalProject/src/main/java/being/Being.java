package being;

import position.Position;
import output.Output;

public abstract class Being {
    private Position position;
    private String name;
    private char identifier;

    //true: justice; false: evil
    private boolean faction;

    //use lambda statement to initialize
    public Being(Position position, String name, char identifier, boolean faction){
        this.position = position;
        this.name=name;
        this.identifier=identifier;
        this.faction=faction;
    }

    public Position getPosition() {
        return position;
    }
    public char getIdentifier() {
        return identifier;
    }
    public String getName() {
        return name;
    }
    public boolean getFaction(){
        return faction;
    }

    private void setPosition(Position position) {
        this.position = position;
    }

    public void moveToPosition(Position position){
        setPosition(position);
        Output.outputInformation(name + " has moved to location: ("+position.getX()+","+position.getY()+").");
    }
}
