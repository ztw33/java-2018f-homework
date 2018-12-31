public class RedBoy extends CalabashBrothers {

    RedBoy()
    {
        myName = new String("大娃");
        myCamp = CAMP.CB;
        myColor = COLOR.red;
        myFamilyRank = 1;

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
