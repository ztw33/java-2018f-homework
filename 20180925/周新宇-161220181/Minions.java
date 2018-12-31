public class Minions extends Living {
    Minions()
    {
        myName = new String("小喽啰");
        myCamp = CAMP.MO;
        myFamilyRank = 2;

        if(!myMount.AskForOwner())
        {
            myMount.PickUp(myName,MountType.FOOT);
            hasMount = true;
        }
        else
            System.out.println(myName + " can not pick up a mount!");
    }
    // my abilities...
}
