public class HuluWa {
    private int priority;
    private COLOR color;
    private String huluwaName;
    public HuluWa(int huluwaNumber){
        switch (huluwaNumber){
            case 1:
                huluwaName = "老大";
                priority = 1;
                color = COLOR.RED;
                break;
            case 2:
                huluwaName = "老二";
                priority = 2;
                color = COLOR.ORANGE;
                break;
            case 3:
                huluwaName = "老三";
                priority = 3;
                color = COLOR.YELLOW;
                break;
            case 4:
                huluwaName = "老四";
                priority = 4;
                color = COLOR.GREEN;
                break;
            case 5:
                huluwaName = "老五";
                priority = 5;
                color = COLOR.CYAN;
                break;
            case 6:
                huluwaName = "老六";
                priority = 6;
                color = COLOR.BLUE;
                break;
            case 7:
                huluwaName = "老七";
                priority = 7;
                color = COLOR.PURPLE;
                break;
            default:
                System.out.println("error:there is only 7 HuluWas");
                break;
        }

    }
    public void swapHuluWa(HuluWa swapTarget, int src, int dest){

        System.out.println(huluwaName+":"+(src+1)+"->"+(dest+1));
        System.out.println(swapTarget.getName()+":"+(dest+1)+"->"+(src+1));
    }
    public void shoutOutName(){
        System.out.print(huluwaName);
    }
    public void shoutOutColor(){
        System.out.print(color.colorInChinese);
    }
    public int getPriority(){
        return priority;
    }
    public COLOR getColor(){
        return color;
    }
    public String getName(){
        return huluwaName;
    }

    public boolean comparePriority(HuluWa compareTarget){
        //if priority is smaller than compareTarget return true
        if (priority < compareTarget.getPriority()){
            return true;
        } else {
            return false;
        }
    }

    public int compareColor(HuluWa compareTarget){
        return color.ordinal() - compareTarget.getColor().ordinal();
    }

}

