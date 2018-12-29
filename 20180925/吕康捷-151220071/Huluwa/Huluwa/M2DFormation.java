package Huluwa;

public class M2DFormation extends MFormation{
    //2D阵型
    public M2DFormation(MPoint2D startPoint,int length){
        this.startPoint = startPoint;
        pointset = new MPoint2D[length];
        numOfPoint = length;
    }

    public void generateDefaultFormation(){

        for(int i = 0;i < numOfPoint;i++)
        {
            pointset[i] = new MPoint2D(((MPoint2D)startPoint).getX()+i,((MPoint2D)startPoint).getY());
        }
    }

    public void generateChangSheFormation(){
        generateDefaultFormation();
    }

    public void generateHeYiFormation(){

        MPoint2D startPoint2 = (MPoint2D)startPoint;
        pointset[0] = new MPoint2D(startPoint2.getX(),startPoint2.getY());

        for(int i = 1;i < pointset.length;i = i+2)
        {
            pointset[i] = new MPoint2D(startPoint2.getX()-((i-1)/2+1),startPoint2.getY()-((i-1)/2+1));
            if(i == pointset.length - 1)
                break;
            pointset[i+1] = new MPoint2D(startPoint2.getX()-((i-1)/2+1),startPoint2.getY()+((i-1)/2+1));
        }
    }

    public void generateFangYuanFormation(){

        MPoint2D startPointX = (MPoint2D)startPoint;
        pointset[0] = new MPoint2D(startPointX.getX(),startPointX.getY());

        int caseChoose = (pointset.length - 1)/4 + 1; // 2
        int halfCase = (caseChoose * 4 -1)/2;
        int i;
        for(i = 1;i <= caseChoose *2 ;i = i+2)
        {
            pointset[i] = new MPoint2D(startPointX.getX()+((i-1)/2+1),startPointX.getY()-((i-1)/2+1));
            pointset[i+1] = new MPoint2D(startPointX.getX()+((i-1)/2+1),startPointX.getY()+((i-1)/2+1));
        }
        for(i = caseChoose *2 + 1; i < ((pointset.length-1)/2)*2 + 1 ;i = i+2)
        {
            pointset[i] = new MPoint2D(startPointX.getX()+((i-1)/2+1),((MPoint2D)pointset[2*halfCase-i]).getY());
            if(i == pointset.length - 1)
                break;
            pointset[i+1] = new MPoint2D(startPointX.getX()+((i-1)/2+1),((MPoint2D)pointset[2*halfCase+1-i]).getY());
        }
        if(pointset.length > i)
        {
            pointset[i] = new MPoint2D(startPointX.getX()+((i-1)/2+1),((MPoint2D)pointset[0]).getY());

        }
    }


}
