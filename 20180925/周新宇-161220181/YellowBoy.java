public class YellowBoy extends CalabashBrothers {
    YellowBoy()
    {
        myName = new String("三娃");
        myCamp = CAMP.CB;
        myColor = COLOR.yellow;
        myFamilyRank = 3;

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
