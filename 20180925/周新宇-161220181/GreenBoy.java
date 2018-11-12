public class GreenBoy extends CalabashBrothers {
    GreenBoy()
    {
        myName = new String("四娃");
        myCamp = CAMP.CB;
        myColor = COLOR.green;
        myFamilyRank = 4;

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
