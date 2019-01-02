public class Brothers_line_up {
    Brothers brothers;
    Brothers_line_up(){
        brothers = new Brothers();
    }
    public static void main(String[] args){
        Brothers_line_up training = new Brothers_line_up();

        training.brothers.randStand();
        System.out.print("随意站队：");
        training.brothers.speakName();
        training.brothers.lineByName();
        System.out.print("按排行排序后：");
        training.brothers.speakName();

        training.brothers.randStand();
        System.out.print("随意站队：");
        training.brothers.speakColor();
        training.brothers.lineByColor();
        System.out.print("按颜色排序后：");
        training.brothers.speakColor();

    }
}
