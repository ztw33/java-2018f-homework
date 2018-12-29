package jchan.calabash.calabashworld;

public class Cell {
    protected Thing thing;
    protected boolean exist;
    protected Background background;
    protected Cell(){
        exist = false;
        background = Background.BLANK;
    }
    protected Cell(Background background){
        exist = false;
        this.background = background;
    }
    protected Cell(int i){
        exist = false;
        switch (i){
            case 0:this.background = Background.BLANK;break;
            case 1:this.background = Background.MOUNTAIN;break;
            case 2:this.background = Background.VALLEY;break;
            default:this.background = Background.BLANK;
        }
    }
    //protected for extending
    public char whoami(){
        if(background == Background.BLANK)
            return  ' ';
        else if(background == Background.MOUNTAIN)
            return 'm';
        else if(background == Background.VALLEY)
            return '~';
        return ' ';
    }

    public Thing getThing() {
        return thing;
    }

    public Background getBackground() {
        return background;
    }

    public boolean isExist() {
        return exist;
    }
}