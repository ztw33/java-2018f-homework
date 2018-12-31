public class OrangeBoy extends CalabashBrothers {
    OrangeBoy()
    {
        myName = new String("二娃");
        myCamp = CAMP.CB;
        myColor = COLOR.orange;
        myFamilyRank = 2;

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