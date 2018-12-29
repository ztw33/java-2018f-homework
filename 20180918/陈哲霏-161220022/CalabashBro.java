public enum CalabashBro {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7);
    private int broNum;
    private String broName;
    private String broColor;
    CalabashBro(int num){
        switch(num){
            case 1:
                broNum = 1; broName = "老大"; broColor = "赤"; break;
            case 2:
                broNum = 2; broName = "老二"; broColor = "橙"; break;
            case 3:
                broNum = 3; broName = "老三"; broColor = "黄"; break;
            case 4:
                broNum = 4; broName = "老四"; broColor = "绿"; break;
            case 5:
                broNum = 5; broName = "老五"; broColor = "青"; break;
            case 6:
                broNum = 6; broName = "老六"; broColor = "蓝"; break;
            case 7:
                broNum = 7; broName = "老七"; broColor = "紫"; break;
//            default: System.out.println("葫芦娃只有七个！num应在1-7之间"); break;
        }
    }
    int getBroNum(){
        return broNum;
    }
    String getBroName(){
        return broName;
    }
    String getBroColor(){
        String color;
        switch(broColor){
            case "赤": color = "红色"; break;
            case "橙": color = "橙色"; break;
            case "黄": color = "黄色"; break;
            case "绿": color = "绿色"; break;
            case "青": color = "青色"; break;
            case "蓝": color = "蓝色"; break;
            case "紫": color = "紫色"; break;
            default: color = "颜色错误"; break;
        }
        return color;
    }
}
