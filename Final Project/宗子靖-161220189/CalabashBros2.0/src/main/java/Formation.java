public enum Formation {//阵形，规定阵形的规格（长和宽），每一个点代表阵形中的一个人
    CRANEWINGS(new Position[]{new Position(0,3),
            new Position(1,2), new Position(1,4),
            new Position(2,1), new Position(2,5),
            new Position(3,0), new Position(3,6)
    }),GEESE(new Position[]{new Position(0,0),
            new Position(1,1),new Position(2,2),
            new Position(3,3),new Position(4,4)
    }),YOKE(new Position[]{new Position(0,0),
            new Position(1,1),new Position(0,2),
            new Position(1,3),new Position(0,4),
            new Position(1,5),
    }),LONGSNAKE(new Position[]{new Position(0, 0),
            new Position(0, 1), new Position(0, 2),
            new Position(0, 3), new Position(0, 4),
            new Position(0, 5), new Position(0, 6),
    }),FISHSCALE(new Position[]{new Position(0, 2),
            new Position(1, 1), new Position(1, 2),
            new Position(1, 3), new Position(2, 0),
            new Position(2, 1), new Position(2, 2),
            new Position(2, 3), new Position(2, 4),
            new Position(3, 1), new Position(3, 2),
            new Position(3, 3)
    }),SQUARE(new Position[]{new Position(0, 2),
            new Position(1, 1), new Position(1, 3),
            new Position(2, 4), new Position(2, 0),
            new Position(3, 1), new Position(3, 3),
            new Position(4, 2)
    }),CRESCENT(new Position[]{new Position(0, 2),
            new Position(0, 3), new Position(0, 4),
            new Position(1, 1), new Position(1, 5),
            new Position(2, 0), new Position(2, 6)
    }),ARROW(new Position[]{new Position(0, 2),
            new Position(1, 1), new Position(1, 2),
            new Position(1, 3), new Position(2, 0),
            new Position(2, 2), new Position(2, 4),
            new Position(3, 2), new Position(4, 2)
    }),;
    private int maxRow;
    private int maxColumn;
    private int unitNum;
    private Position[] formation;
    Formation(Position[] formation){
        this.formation=formation;
        unitNum=formation.length;
        int row=0;
        int column=0;
        for(int i=0;i<unitNum;i++){
            if(formation[i].getX()>column)
                column=formation[i].getX();
            if(formation[i].getY()>row)
                row=formation[i].getY();
        }
        maxRow=row+1;
        maxColumn=column+1;
    }
    public int getUnitNum() {
        return unitNum;
    }
    public int getMaxRow(){
        return maxRow;
    }
    public int getMaxColumn(){
        return maxColumn;
    }
    public final Position[] getFormation(){
        Position[] newformation=new Position[unitNum];
        for(int i=0;i<unitNum;i++){
            newformation[i]=new Position(formation[i]);
        }
        return newformation;
    }
    public final Position getPosition(int num){
        Position pos=new Position(formation[num]);
        return pos;
    }
}