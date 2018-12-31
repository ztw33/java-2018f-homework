public class PurpleBoy extends CalabashBrothers {
    PurpleBoy()
    {
        myName = new String("七娃");
        myCamp = CAMP.CB;
        myColor = COLOR.purple;
        myFamilyRank = 7;

        if(!myMount.AskForOwner())
        {
            myMount.PickUp(myName,MountType.LOTUS);
            hasMount = true;
        }
        else
            System.out.println(myName + " can not pick up a mount!");
    }
    // my abilities...
}