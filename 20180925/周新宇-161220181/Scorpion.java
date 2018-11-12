public class Scorpion extends Living {
    Scorpion()
    {
        myName = new String("蝎子精");
        myCamp = CAMP.MO;
        myFamilyRank = 1;

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
