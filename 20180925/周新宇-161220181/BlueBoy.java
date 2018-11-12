public class BlueBoy extends CalabashBrothers {
    BlueBoy()
    {
        myName = new String("六娃");
        myCamp = CAMP.CB;
        myColor = COLOR.blue;
        myFamilyRank = 6;

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