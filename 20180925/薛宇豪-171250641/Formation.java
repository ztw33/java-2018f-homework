public class Formation {
    int row;
    int column;
    char[][] queue;
    public Formation(int row,int column){
        this.row=row;
        this.column=column;
        queue=new char[row][column];
        for (int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                queue[i][j]='-';
            }
        }
    }
    public Formation(){
        this(20,6);
    }
    public char[][] embattle(Role[] roles) {
        return queue;
    }
}
