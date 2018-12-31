package Huluwa;

public class Position {

    //位置处于一个点上
    private MPoint point;
    private Creature people;
    private boolean empty;

    public Position(MPoint point){
        this.point = point;
        empty = true;
    }

    public MPoint getPoint(){
        return point;
    }
    public Creature GetPeople(){
        return people;
    }

    public void SetPeople(Creature newPeople)
    {
        people = newPeople;
        people.setPosition(this);
        empty = false;
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public void LetPeopleLeave()
    {
        //让该位置上的人离开
        if(people != null)
            people.leavePosition();
        empty = true;
        people = null;
    }
}
