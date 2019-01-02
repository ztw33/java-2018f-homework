import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Commander {

    private int row;
    private int col;
    private static ArrayList<ArrayList<Creature>> creatures;

    private int[][] CalabashLocation = new int[7][2];
    private int[][] MinionLocation = new int[20][2];
    private int[][] ScorpionLocation = new int[1][2];
    private int MinionNum;

    private JFrame battleField;

    private Commander() {
        row = 12;
        col = 13;
        creatures = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            creatures.add(new ArrayList<>());
            for(int j = 0; j < col - 1; j++) {
                Creature creature = new Creature();
                creatures.get(i).add(creature);
            }
        }
        battleField = new JFrame("葫芦娃大战蝎子精");
    }

    public static void main(String[] argv) {
        Commander commander = new Commander();
        commander.placeGrandpa();
        commander.placeSnake();
        commander.placeCalabash();
        commander.battleArray(6);
        commander.setBattleField();
    }

    private void placeGrandpa() {
        creatures.get(11).set(0, new Grandpa());
    }

    private void placeSnake() {
        creatures.get(11).set(11, new Snake());
    }

    private void placeCalabash() {
        int CalabashTemp[][] = {{2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}};
        Huluwa[] huluwas = Huluwa.values();
        for(int i = 0; i < 7; i++) {
            CalabashLocation[i][0] = CalabashTemp[i][0];
            CalabashLocation[i][1] = CalabashTemp[i][1];
            creatures.get(CalabashLocation[i][0]).set(CalabashLocation[i][1], new Calabash(huluwas[i]));
        }

    }

    private void deleteArray() {
        creatures.get(ScorpionLocation[0][0]).set(ScorpionLocation[0][1], new Creature());
        for(int i = 0; i < MinionNum; i++) {
            creatures.get(MinionLocation[i][0]).set(MinionLocation[i][1], new Creature());
        }
    }

    private void chooseArray(int n) {
        switch(n) {
            case 1:
                this.HeYi(); break;
            case 2:
                this.YanXing(); break;
            case 3:
                this.ChongE(); break;
            case 4:
                this.YuLin(); break;
            case 5:
                this.FangYuan(); break;
            case 6:
                this.YanYue(); break;
            case 7:
                this.FengShi(); break;
            default:
                break;
        }
    }

    private void battleArray() {
        this.deleteArray();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入阵型：1鹤翼，2雁行，3冲轭，4鱼鳞，5方圆，6偃月，7锋矢。");
        int n = input.nextInt();
        this.chooseArray(n);
        creatures.get(ScorpionLocation[0][0]).set(ScorpionLocation[0][1], new Scorpion());
        for(int i = 0; i < MinionNum; i++)
            creatures.get(MinionLocation[i][0]).set(MinionLocation[i][1], new Minion());
    }

    private void battleArray(int n) {
        this.deleteArray();
        this.chooseArray(n);
        creatures.get(ScorpionLocation[0][0]).set(ScorpionLocation[0][1], new Scorpion());
        for(int i = 0; i < MinionNum; i++)
            creatures.get(MinionLocation[i][0]).set(MinionLocation[i][1], new Minion());
    }

    private void HeYi() {
        ScorpionLocation[0][0] = 7;
        ScorpionLocation[0][1] = 8;
        MinionNum = 6;
        int MinionTemp[][] = {{6, 7}, {5, 6}, {4, 5}, {6, 9}, {5, 10}, {4, 11}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YanXing() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 6;
        int MinionTemp[][] = {{6, 7}, {7, 6}, {8, 5}, {4, 9}, {3, 10}, {2, 11}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void ChongE() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 9;
        MinionNum = 6;
        int MinionTemp[][] = {{4, 8}, {3, 9}, {2, 8}, {6, 8}, {7, 9}, {8, 8}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YuLin() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 10;
        int MinionTemp[][] = {{5, 7}, {5, 9}, {6, 6}, {6, 7}, {6, 8}, {6, 9}, {6, 10}, {7, 8}, {4, 8}, {3, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void FangYuan() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 8;
        MinionNum = 8;
        int MinionTemp[][] = {{3, 8}, {4, 9}, {5, 10}, {6, 9}, {7, 8}, {6, 7}, {5, 6}, {4, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void YanYue() {
        ScorpionLocation[0][0] = 5;
        ScorpionLocation[0][1] = 6;
        MinionNum = 18;
        int MinionTemp[][] = {{5, 5}, {6, 5}, {6, 6}, {6, 7}, {5, 7}, {4, 7}, {4, 6}, {4, 5}, {3, 6}, {3, 7}, {7, 6}, {7, 7}, {2, 7}, {2, 8}, {8, 7}, {8, 8}, {1, 9}, {9, 9}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    private void FengShi() {
        ScorpionLocation[0][0] = 2;
        ScorpionLocation[0][1] = 7;
        MinionNum = 12;
        int MinionTemp[][] = {{3, 6}, {4, 5}, {5, 4}, {3, 8}, {4, 9}, {5, 10}, {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}, {8, 7}};
        for(int i = 0; i < MinionNum; i++) {
            MinionLocation[i][0] = MinionTemp[i][0];
            MinionLocation[i][1] = MinionTemp[i][1];
        }
    }

    public void setBattleField() {
        battleField.getContentPane().removeAll();
        battleField.setLayout(new GridLayout(row, col));
        battleField.setSize(col * 80, row * 60);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col - 1; j++) {
                JButton jButton = new JButton();
                jButton.setBounds(0, 0, 80, 60);
                setImage(creatures.get(i).get(j).getType(), jButton);
                battleField.add(jButton);
            }
            JButton jButton = new JButton();
            switch (i) {
                case 1:
                    jButton.setText("鹤翼");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(1);
                            setBattleField();
                        }
                    });
                    break;
                case 2:
                    jButton.setText("雁行");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(2);
                            setBattleField();
                        }
                    });
                    break;
                case 3:
                    jButton.setText("冲轭");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(3);
                            setBattleField();
                        }
                    });
                    break;
                case 4:
                    jButton.setText("鱼鳞");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(4);
                            setBattleField();
                        }
                    });
                    break;
                case 5:
                    jButton.setText("方圆");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(5);
                            setBattleField();
                        }
                    });
                    break;
                case 6:
                    jButton.setText("偃月");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(6);
                            setBattleField();
                        }
                    });
                    break;
                case 7:
                    jButton.setText("锋矢");
                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleArray(7);
                            setBattleField();
                        }
                    });
                    break;
                default: break;
            }
            battleField.add(jButton);
        }
        //battleField.pack();
        battleField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleField.setVisible(true);
    }

    private void setImage(int type, JButton jButton) {
        String imagePath = "src/image/";
        switch (type) {
            case 2: imagePath += "grandpa.jpg"; break;
            case 3: imagePath += "scorpion.jpg"; break;
            case 4: imagePath += "snake.jpg"; break;
            case 5: imagePath += "minion.jpg"; break;
            case 11: imagePath += "calabash_1st.jpg"; break;
            case 12: imagePath += "calabash_2nd.jpg"; break;
            case 13: imagePath += "calabash_3rd.jpg"; break;
            case 14: imagePath += "calabash_4th.jpg"; break;
            case 15: imagePath += "calabash_5th.jpg"; break;
            case 16: imagePath += "calabash_6th.jpg"; break;
            case 17: imagePath += "calabash_7th.jpg"; break;
            default: imagePath = null; break;
        }

        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image temp = imageIcon.getImage().getScaledInstance(jButton.getWidth(), jButton.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
        imageIcon = new ImageIcon(temp);
        jButton.setIcon(imageIcon);
    }
}
