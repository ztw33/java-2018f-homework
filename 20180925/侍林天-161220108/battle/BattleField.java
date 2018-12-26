package battle;
import sort.HuluWaBubbleSort;
import space.*;
import group.*;
import formation.*;
import creature.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;



public class BattleField {
    public TwoDimensionSpace<Creature> space;
    public HuluBrothers huluBrothers;
    public Monsters monsters;
    public BattleField(){
        monsters = new Monsters(7);
        huluBrothers = new HuluBrothers();
        space = new TwoDimensionSpace<>(15);
    }
    public static void main(String[] args){
        //BattleField field = new BattleField(20);
        //field.displayBattleField();
        /*JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setSize(600, 300);
        frame.setVisible(true);
        try{
        TimeUnit.SECONDS.sleep(1);}
        catch (Exception e)
        {
            ;
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("world");
            }
        });
        label.setText("change");*/

        /*TwoDimensionSpace<Creature> space = new TwoDimensionSpace<>(15);
        MainWindow window = new MainWindow(space);
        HuluBrothers huluBrothers = new HuluBrothers();
        Monsters monsters = new Monsters(7);

        huluBrothers.random();
        huluBrothers.generateFormation(new ChangsheFormation(), space, 7, 6, 0);

        window.refresh();
        run(window, 800, 700);
        space.displaySpace();
        System.out.println();

        huluBrothers.sort(new HuluWaBubbleSort());
        huluBrothers.generateFormation(new ChangsheFormation(), space, 7, 6, 0);
        window.refresh();
        space.displaySpace();

        monsters.generateFormation(new ChangsheFormation(), space, 7,8, 1);
        window.refresh();
        space.displaySpace();

        monsters.generateFormation(new HeyiFormation(), space, 7, 14, 1);
        window.refresh();
        space.displaySpace();

        huluBrothers.generateFormation(new HeyiFormation(), space, 7, 2, 0);
        window.refresh();
        space.displaySpace();

        monsters.generateFormation(new YanhangFormation(), space, 7, 8, 1);
        window.refresh();
        space.displaySpace();

        huluBrothers.generateFormation(new HengeFormation(), space, 7, 6, 0);
        window.refresh();
        space.displaySpace();

        monsters.generateFormation(new FangmenFormation(), space, 7, 8, 1);
        window.refresh();
        space.displaySpace();

        monsters.generateFormation(new FengshiFormation(), space, 7, 8, 1);
        window.refresh();
        space.displaySpace();

        huluBrothers.generateFormation(new YulinFormation(), space, 7, 7, 0);
        window.refresh();
        space.displaySpace();
        /*field.huluBrothers.random();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.prioritySort();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.random();
        field.huluBrothers.generateChangshe(field.space, 10, 8, 0);
        field.displayBattleField();
        field.huluBrothers.prioritySort();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.generateChangshe(field.space, 10, 8, 0);
        field.displayBattleField();*/
    }
}