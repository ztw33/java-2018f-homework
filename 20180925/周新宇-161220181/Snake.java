public class Snake extends Living {
    Snake()
    {
        myName = new String("蛇精");
        myCamp = CAMP.MO;
        myFamilyRank = 0;

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
