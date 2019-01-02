package backstage.creature.fighter;

import backstage.creature.Creature;

public class GourdBoy extends Creature {

    public int getRank(){
        return this.attribute.getRank();
    }
    Attribute attribute;

    //constructor
    public GourdBoy(Attribute attribute){
        this.attribute = attribute;
        name = this.attribute.getName();
        switch (attribute.getRank()){
            case 1: imageUrl = "/common/images/fighter/gourdboys/firstChild.jpg"; break;
            case 2: imageUrl = "/common/images/fighter/gourdboys/secondChild.jpg"; break;
            case 3: imageUrl = "/common/images/fighter/gourdboys/thirdChild.jpg"; break;
            case 4: imageUrl = "/common/images/fighter/gourdboys/fourthChild.jpg"; break;
            case 5: imageUrl = "/common/images/fighter/gourdboys/fifthChild.jpg"; break;
            case 6: imageUrl = "/common/images/fighter/gourdboys/sixthChild.jpg"; break;
            case 7: imageUrl = "/common/images/fighter/gourdboys/seventhChild.jpg"; break;
        }

    }
}
