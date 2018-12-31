public class FishScaleArray extends Formation {
    public FishScaleArray(int row, int column) {
        super(row,column);
    }
    public char[][] embattle(Role[] roles){
        Role[] newRoles=new Role[12];
        if(roles.length<12){
            for(int i=0;i<roles.length;i++){
                newRoles[i]=roles[i];
            }
            for(int i=roles.length;i<12;i++){
                newRoles[i]=roles[roles.length-1];
            }
        }else{
            for (int i = 0; i < 12; i++) {
                newRoles[i] = roles[i];
            }
        }
        if(row<5 || column<5){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancyRow = (row - 5) / 2;
            int vacancyColumn = (column - 5) / 2;
            queue[vacancyRow][vacancyColumn+2]=newRoles[0].getSymbol();
            queue[vacancyRow+1][vacancyColumn+2]=newRoles[1].getSymbol();
            queue[vacancyRow+1][vacancyColumn+3]=newRoles[2].getSymbol();
            queue[vacancyRow+2][vacancyColumn+1]=newRoles[3].getSymbol();
            queue[vacancyRow+2][vacancyColumn+2]=newRoles[4].getSymbol();
            queue[vacancyRow+2][vacancyColumn+3]=newRoles[5].getSymbol();
            for(int i=0;i<5;i++){
                queue[vacancyRow+3][vacancyColumn+i]=newRoles[6+i].getSymbol();
            }
            queue[vacancyRow+4][vacancyColumn+2]=newRoles[11].getSymbol();
        }
        return queue;
    }
}
