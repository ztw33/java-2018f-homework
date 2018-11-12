public class Land {
    boolean isUsed;
    String userName;
    Land()
    {
        isUsed = false;
        userName = new String("unknownName");
    }
    public void SitHere(String name)
    {
        if(!isUsed) {
            userName = name;
            isUsed = true;
        }
        else
            System.out.println("There is someone here!");
    }
    public void GoAway()
    {
        isUsed = false;
        userName = new String("unknownName");
    }
    public boolean isUsedUp()
    {
        return isUsed;
    }
    public String GetUserName()
    {
        return userName;
    }
    public void GetSimpleName()
    {
        switch (userName)
        {
            case "unknownName":System.out.print("U");break;
            case "大娃":System.out.print("R");break;
            case "二娃":System.out.print("O");break;
            case "三娃":System.out.print("Y");break;
            case "四娃":System.out.print("G");break;
            case "五娃":System.out.print("C");break;
            case "六娃":System.out.print("B");break;
            case "七娃":System.out.print("P");break;
            case "爷爷":System.out.print("@");break;
            case "蝎子精":System.out.print("S");break;
            case "蛇精":System.out.print("&");break;
            case "小喽啰":System.out.print("M");break;
            default:System.out.print("*");break;
        }
    }
}
