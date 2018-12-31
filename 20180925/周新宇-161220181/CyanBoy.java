public class CyanBoy extends CalabashBrothers {
    CyanBoy()
    {
        myName = new String("五娃");
        myCamp = CAMP.CB;
        myColor = COLOR.cyan;
        myFamilyRank = 5;

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