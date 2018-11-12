package com.homework3.output;

import com.homework3.battle.BattleField;
import com.homework3.common.CartoonTransition;

import javax.swing.*;
import java.awt.*;

/**
 * @Description 基本输出函数，包括控制台输出和GUI输出
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleFieldDisplay{

    public static final int DISPLAY_DELAY = 1000;
    private JFrame frame;

    public  BattleFieldDisplay()
    {
        frame = new JFrame();
        frame.setSize(BattleField.FIELD_SIZE * (BattleField.ICON_SIZE + 2 * BattleField.BORDER_THICKNESS),
                BattleField.FIELD_SIZE * (BattleField.ICON_SIZE + 2 * BattleField.BORDER_THICKNESS) + 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(BattleField battleField)
    {
        consoleDisplay(battleField);
        graphicsDisplay(battleField);
    }

    private void consoleDisplay(BattleField battleField)
    {
        for (int k = 0; k < BattleField.FIELD_SIZE + 2; k++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < BattleField.FIELD_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < BattleField.FIELD_SIZE; j++) {
                System.out.printf("%s", CartoonTransition.cartoonCharacterToANSI(battleField.getBattleFieldLattice(i, j)
                        .getCartoonCharacter()));
            }
            System.out.print("|");
            System.out.println();
        }
        for (int k = 0; k < BattleField.FIELD_SIZE + 2; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void graphicsDisplay(BattleField battleField)
    {
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new BorderLayout());
        panel.removeAll();

        for(int i = 0; i < BattleField.FIELD_SIZE ; i++)
        {
            for(int j = 0; j < BattleField.FIELD_SIZE; j++)
            {
                ImageIcon icon = new ImageIcon(BattleField.class.getResource(
                        "" + CartoonTransition.cartoonCharacterToImage(
                                battleField.getBattleFieldLattice(i, j).getCartoonCharacter())));
                icon.setImage(icon.getImage().getScaledInstance(BattleField.ICON_SIZE, BattleField.ICON_SIZE, Image.SCALE_DEFAULT));

                JLabel label = new JLabel(icon);
                label.setBorder(BorderFactory.createLineBorder(Color.black, BattleField.BORDER_THICKNESS));
                label.setBounds(j * BattleField.ICON_SIZE,i * BattleField.ICON_SIZE, BattleField.ICON_SIZE, BattleField.ICON_SIZE);
                frame.add(label);
            }
        }

        frame.add(new JLabel());//处于某种不确定的原因，最后一个frame在panel.setLayout的参数不为null的时候会无法加入frame
        frame.setVisible(true);

        try {
            Thread.sleep(DISPLAY_DELAY);
        } catch (Exception e) {
            System.out.println("[ERROR] In BattleGoOn()");
            System.exit(0);//退出程序
        }
    }


}
