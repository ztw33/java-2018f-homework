public class CrescentMoonArray extends Formation {
    public CrescentMoonArray(int row, int column) {
        super(row,column);
    }
    public char[][] embattle(Role[] roles) {
        Role[] newRoles=new Role[18];
        if(roles.length<18){
            for(int i=0;i<roles.length;i++){
                newRoles[i]=roles[i];
            }
            for(int i=roles.length;i<18;i++){
                newRoles[i]=roles[roles.length-1];
            }
        }else{
            for(int i=0;i<18;i++){
                newRoles[i]=roles[i];
            }
        }
        if (row < 7 || column < 4) {
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        } else {
            int vacancyRow = (row - 7) / 2;
            int vacancyColumn = (column - 4) / 2;
            for(int i=0;i<3;i++){
                queue[vacancyRow+2+i][vacancyColumn]=newRoles[i].getSymbol();
                queue[vacancyRow+2+i][vacancyColumn+1]=newRoles[3+i].getSymbol();
            }
            for(int i=0;i<5;i++){
                queue[vacancyRow+1+i][vacancyColumn+2]=newRoles[6+i].getSymbol();
            }
            for(int i=0;i<7;i++){
                queue[vacancyRow+i][vacancyColumn+3]=newRoles[11+i].getSymbol();
            }
        }
        return queue;
    }
}
