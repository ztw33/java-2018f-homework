package sample;

import creature.Creature;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView[][] allImageView=new ImageView[10][20];
    public void setCreature(int x, int y, Creature creature){
        allImageView[x][y].setImage(creature.getImage());
    }
    public void setNull(int x,int y){
        allImageView[x][y].setImage(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allImageView[0][0]=imageView0_0;
        allImageView[0][1]=imageView0_1;
        allImageView[0][2]=imageView0_2;
        allImageView[0][3]=imageView0_3;
        allImageView[0][4]=imageView0_4;
        allImageView[0][5]=imageView0_5;
        allImageView[0][6]=imageView0_6;
        allImageView[0][7]=imageView0_7;
        allImageView[0][8]=imageView0_8;
        allImageView[0][9]=imageView0_9;
        allImageView[0][10]=imageView0_10;
        allImageView[0][11]=imageView0_11;
        allImageView[0][12]=imageView0_12;
        allImageView[0][13]=imageView0_13;
        allImageView[0][14]=imageView0_14;
        allImageView[0][15]=imageView0_15;
        allImageView[0][16]=imageView0_16;
        allImageView[0][17]=imageView0_17;
        allImageView[0][18]=imageView0_18;
        allImageView[0][19]=imageView0_19;
        allImageView[1][0]=imageView0_0;
        allImageView[1][1]=imageView1_1;
        allImageView[1][2]=imageView1_2;
        allImageView[1][3]=imageView1_3;
        allImageView[1][4]=imageView1_4;
        allImageView[1][5]=imageView1_5;
        allImageView[1][6]=imageView1_6;
        allImageView[1][7]=imageView1_7;
        allImageView[1][8]=imageView1_8;
        allImageView[1][9]=imageView1_9;
        allImageView[1][10]=imageView1_10;
        allImageView[1][11]=imageView1_11;
        allImageView[1][12]=imageView1_12;
        allImageView[1][13]=imageView1_13;
        allImageView[1][14]=imageView1_14;
        allImageView[1][15]=imageView1_15;
        allImageView[1][16]=imageView1_16;
        allImageView[1][17]=imageView1_17;
        allImageView[1][18]=imageView1_18;
        allImageView[1][19]=imageView1_19;
        allImageView[2][0]=imageView2_0;
        allImageView[2][1]=imageView2_1;
        allImageView[2][2]=imageView2_2;
        allImageView[2][3]=imageView2_3;
        allImageView[2][4]=imageView2_4;
        allImageView[2][5]=imageView2_5;
        allImageView[2][6]=imageView2_6;
        allImageView[2][7]=imageView2_7;
        allImageView[2][8]=imageView2_8;
        allImageView[2][9]=imageView2_9;
        allImageView[2][10]=imageView2_10;
        allImageView[2][11]=imageView2_11;
        allImageView[2][12]=imageView2_12;
        allImageView[2][13]=imageView2_13;
        allImageView[2][14]=imageView2_14;
        allImageView[2][15]=imageView2_15;
        allImageView[2][16]=imageView2_16;
        allImageView[2][17]=imageView2_17;
        allImageView[2][18]=imageView2_18;
        allImageView[2][19]=imageView2_19;
        allImageView[3][0]=imageView3_0;
        allImageView[3][1]=imageView3_1;
        allImageView[3][2]=imageView3_2;
        allImageView[3][3]=imageView3_3;
        allImageView[3][4]=imageView3_4;
        allImageView[3][5]=imageView3_5;
        allImageView[3][6]=imageView3_6;
        allImageView[3][7]=imageView3_7;
        allImageView[3][8]=imageView3_8;
        allImageView[3][9]=imageView3_9;
        allImageView[3][10]=imageView3_10;
        allImageView[3][11]=imageView3_11;
        allImageView[3][12]=imageView3_12;
        allImageView[3][13]=imageView3_13;
        allImageView[3][14]=imageView3_14;
        allImageView[3][15]=imageView3_15;
        allImageView[3][16]=imageView3_16;
        allImageView[3][17]=imageView3_17;
        allImageView[3][18]=imageView3_18;
        allImageView[3][19]=imageView3_19;
        allImageView[4][0]=imageView4_0;
        allImageView[4][1]=imageView4_1;
        allImageView[4][2]=imageView4_2;
        allImageView[4][3]=imageView4_3;
        allImageView[4][4]=imageView4_4;
        allImageView[4][5]=imageView4_5;
        allImageView[4][6]=imageView4_6;
        allImageView[4][7]=imageView4_7;
        allImageView[4][8]=imageView4_8;
        allImageView[4][9]=imageView4_9;
        allImageView[4][10]=imageView4_10;
        allImageView[4][11]=imageView4_11;
        allImageView[4][12]=imageView4_12;
        allImageView[4][13]=imageView4_13;
        allImageView[4][14]=imageView4_14;
        allImageView[4][15]=imageView4_15;
        allImageView[4][16]=imageView4_16;
        allImageView[4][17]=imageView4_17;
        allImageView[4][18]=imageView4_18;
        allImageView[4][19]=imageView4_19;
        allImageView[5][0]=imageView5_0;
        allImageView[5][1]=imageView5_1;
        allImageView[5][2]=imageView5_2;
        allImageView[5][3]=imageView5_3;
        allImageView[5][4]=imageView5_4;
        allImageView[5][5]=imageView5_5;
        allImageView[5][6]=imageView5_6;
        allImageView[5][7]=imageView5_7;
        allImageView[5][8]=imageView5_8;
        allImageView[5][9]=imageView5_9;
        allImageView[5][10]=imageView5_10;
        allImageView[5][11]=imageView5_11;
        allImageView[5][12]=imageView5_12;
        allImageView[5][13]=imageView5_13;
        allImageView[5][14]=imageView5_14;
        allImageView[5][15]=imageView5_15;
        allImageView[5][16]=imageView5_16;
        allImageView[5][17]=imageView5_17;
        allImageView[5][18]=imageView5_18;
        allImageView[5][19]=imageView5_19;
        allImageView[6][0]=imageView6_0;
        allImageView[6][1]=imageView6_1;
        allImageView[6][2]=imageView6_2;
        allImageView[6][3]=imageView6_3;
        allImageView[6][4]=imageView6_4;
        allImageView[6][5]=imageView6_5;
        allImageView[6][6]=imageView6_6;
        allImageView[6][7]=imageView6_7;
        allImageView[6][8]=imageView6_8;
        allImageView[6][9]=imageView6_9;
        allImageView[6][10]=imageView6_10;
        allImageView[6][11]=imageView6_11;
        allImageView[6][12]=imageView6_12;
        allImageView[6][13]=imageView6_13;
        allImageView[6][14]=imageView6_14;
        allImageView[6][15]=imageView6_15;
        allImageView[6][16]=imageView6_16;
        allImageView[6][17]=imageView6_17;
        allImageView[6][18]=imageView6_18;
        allImageView[6][19]=imageView6_19;
        allImageView[7][0]=imageView7_0;
        allImageView[7][1]=imageView7_1;
        allImageView[7][2]=imageView7_2;
        allImageView[7][3]=imageView7_3;
        allImageView[7][4]=imageView7_4;
        allImageView[7][5]=imageView7_5;
        allImageView[7][6]=imageView7_6;
        allImageView[7][7]=imageView7_7;
        allImageView[7][8]=imageView7_8;
        allImageView[7][9]=imageView7_9;
        allImageView[7][10]=imageView7_10;
        allImageView[7][11]=imageView7_11;
        allImageView[7][12]=imageView7_12;
        allImageView[7][13]=imageView7_13;
        allImageView[7][14]=imageView7_14;
        allImageView[7][15]=imageView7_15;
        allImageView[7][16]=imageView7_16;
        allImageView[7][17]=imageView7_17;
        allImageView[7][18]=imageView7_18;
        allImageView[7][19]=imageView7_19;
        allImageView[8][0]=imageView8_0;
        allImageView[8][1]=imageView8_1;
        allImageView[8][2]=imageView8_2;
        allImageView[8][3]=imageView8_3;
        allImageView[8][4]=imageView8_4;
        allImageView[8][5]=imageView8_5;
        allImageView[8][6]=imageView8_6;
        allImageView[8][7]=imageView8_7;
        allImageView[8][8]=imageView8_8;
        allImageView[8][9]=imageView8_9;
        allImageView[8][10]=imageView8_10;
        allImageView[8][11]=imageView8_11;
        allImageView[8][12]=imageView8_12;
        allImageView[8][13]=imageView8_13;
        allImageView[8][14]=imageView8_14;
        allImageView[8][15]=imageView8_15;
        allImageView[8][16]=imageView8_16;
        allImageView[8][17]=imageView8_17;
        allImageView[8][18]=imageView8_18;
        allImageView[8][19]=imageView8_19;
        allImageView[9][0]=imageView9_0;
        allImageView[9][1]=imageView9_1;
        allImageView[9][2]=imageView9_2;
        allImageView[9][3]=imageView9_3;
        allImageView[9][4]=imageView9_4;
        allImageView[9][5]=imageView9_5;
        allImageView[9][6]=imageView9_6;
        allImageView[9][7]=imageView9_7;
        allImageView[9][8]=imageView9_8;
        allImageView[9][9]=imageView9_9;
        allImageView[9][10]=imageView9_10;
        allImageView[9][11]=imageView9_11;
        allImageView[9][12]=imageView9_12;
        allImageView[9][13]=imageView9_13;
        allImageView[9][14]=imageView9_14;
        allImageView[9][15]=imageView9_15;
        allImageView[9][16]=imageView9_16;
        allImageView[9][17]=imageView9_17;
        allImageView[9][18]=imageView9_18;
        allImageView[9][19]=imageView9_19;
    }

    @FXML
    ImageView imageView0_0;
    @FXML
    ImageView imageView0_1;
    @FXML
    ImageView imageView0_2;
    @FXML
    ImageView imageView0_3;
    @FXML
    ImageView imageView0_4;
    @FXML
    ImageView imageView0_5;
    @FXML
    ImageView imageView0_6;
    @FXML
    ImageView imageView0_7;
    @FXML
    ImageView imageView0_8;
    @FXML
    ImageView imageView0_9;
    @FXML
    ImageView imageView0_10;
    @FXML
    ImageView imageView0_11;
    @FXML
    ImageView imageView0_12;
    @FXML
    ImageView imageView0_13;
    @FXML
    ImageView imageView0_14;
    @FXML
    ImageView imageView0_15;
    @FXML
    ImageView imageView0_16;
    @FXML
    ImageView imageView0_17;
    @FXML
    ImageView imageView0_18;
    @FXML
    ImageView imageView0_19;
    @FXML
    ImageView imageView1_0;
    @FXML
    ImageView imageView1_1;
    @FXML
    ImageView imageView1_2;
    @FXML
    ImageView imageView1_3;
    @FXML
    ImageView imageView1_4;
    @FXML
    ImageView imageView1_5;
    @FXML
    ImageView imageView1_6;
    @FXML
    ImageView imageView1_7;
    @FXML
    ImageView imageView1_8;
    @FXML
    ImageView imageView1_9;
    @FXML
    ImageView imageView1_10;
    @FXML
    ImageView imageView1_11;
    @FXML
    ImageView imageView1_12;
    @FXML
    ImageView imageView1_13;
    @FXML
    ImageView imageView1_14;
    @FXML
    ImageView imageView1_15;
    @FXML
    ImageView imageView1_16;
    @FXML
    ImageView imageView1_17;
    @FXML
    ImageView imageView1_18;
    @FXML
    ImageView imageView1_19;
    @FXML
    ImageView imageView2_0;
    @FXML
    ImageView imageView2_1;
    @FXML
    ImageView imageView2_2;
    @FXML
    ImageView imageView2_3;
    @FXML
    ImageView imageView2_4;
    @FXML
    ImageView imageView2_5;
    @FXML
    ImageView imageView2_6;
    @FXML
    ImageView imageView2_7;
    @FXML
    ImageView imageView2_8;
    @FXML
    ImageView imageView2_9;
    @FXML
    ImageView imageView2_10;
    @FXML
    ImageView imageView2_11;
    @FXML
    ImageView imageView2_12;
    @FXML
    ImageView imageView2_13;
    @FXML
    ImageView imageView2_14;
    @FXML
    ImageView imageView2_15;
    @FXML
    ImageView imageView2_16;
    @FXML
    ImageView imageView2_17;
    @FXML
    ImageView imageView2_18;
    @FXML
    ImageView imageView2_19;
    @FXML
    ImageView imageView3_0;
    @FXML
    ImageView imageView3_1;
    @FXML
    ImageView imageView3_2;
    @FXML
    ImageView imageView3_3;
    @FXML
    ImageView imageView3_4;
    @FXML
    ImageView imageView3_5;
    @FXML
    ImageView imageView3_6;
    @FXML
    ImageView imageView3_7;
    @FXML
    ImageView imageView3_8;
    @FXML
    ImageView imageView3_9;
    @FXML
    ImageView imageView3_10;
    @FXML
    ImageView imageView3_11;
    @FXML
    ImageView imageView3_12;
    @FXML
    ImageView imageView3_13;
    @FXML
    ImageView imageView3_14;
    @FXML
    ImageView imageView3_15;
    @FXML
    ImageView imageView3_16;
    @FXML
    ImageView imageView3_17;
    @FXML
    ImageView imageView3_18;
    @FXML
    ImageView imageView3_19;
    @FXML
    ImageView imageView4_0;
    @FXML
    ImageView imageView4_1;
    @FXML
    ImageView imageView4_2;
    @FXML
    ImageView imageView4_3;
    @FXML
    ImageView imageView4_4;
    @FXML
    ImageView imageView4_5;
    @FXML
    ImageView imageView4_6;
    @FXML
    ImageView imageView4_7;
    @FXML
    ImageView imageView4_8;
    @FXML
    ImageView imageView4_9;
    @FXML
    ImageView imageView4_10;
    @FXML
    ImageView imageView4_11;
    @FXML
    ImageView imageView4_12;
    @FXML
    ImageView imageView4_13;
    @FXML
    ImageView imageView4_14;
    @FXML
    ImageView imageView4_15;
    @FXML
    ImageView imageView4_16;
    @FXML
    ImageView imageView4_17;
    @FXML
    ImageView imageView4_18;
    @FXML
    ImageView imageView4_19;
    @FXML
    ImageView imageView5_0;
    @FXML
    ImageView imageView5_1;
    @FXML
    ImageView imageView5_2;
    @FXML
    ImageView imageView5_3;
    @FXML
    ImageView imageView5_4;
    @FXML
    ImageView imageView5_5;
    @FXML
    ImageView imageView5_6;
    @FXML
    ImageView imageView5_7;
    @FXML
    ImageView imageView5_8;
    @FXML
    ImageView imageView5_9;
    @FXML
    ImageView imageView5_10;
    @FXML
    ImageView imageView5_11;
    @FXML
    ImageView imageView5_12;
    @FXML
    ImageView imageView5_13;
    @FXML
    ImageView imageView5_14;
    @FXML
    ImageView imageView5_15;
    @FXML
    ImageView imageView5_16;
    @FXML
    ImageView imageView5_17;
    @FXML
    ImageView imageView5_18;
    @FXML
    ImageView imageView5_19;
    @FXML
    ImageView imageView6_0;
    @FXML
    ImageView imageView6_1;
    @FXML
    ImageView imageView6_2;
    @FXML
    ImageView imageView6_3;
    @FXML
    ImageView imageView6_4;
    @FXML
    ImageView imageView6_5;
    @FXML
    ImageView imageView6_6;
    @FXML
    ImageView imageView6_7;
    @FXML
    ImageView imageView6_8;
    @FXML
    ImageView imageView6_9;
    @FXML
    ImageView imageView6_10;
    @FXML
    ImageView imageView6_11;
    @FXML
    ImageView imageView6_12;
    @FXML
    ImageView imageView6_13;
    @FXML
    ImageView imageView6_14;
    @FXML
    ImageView imageView6_15;
    @FXML
    ImageView imageView6_16;
    @FXML
    ImageView imageView6_17;
    @FXML
    ImageView imageView6_18;
    @FXML
    ImageView imageView6_19;
    @FXML
    ImageView imageView7_0;
    @FXML
    ImageView imageView7_1;
    @FXML
    ImageView imageView7_2;
    @FXML
    ImageView imageView7_3;
    @FXML
    ImageView imageView7_4;
    @FXML
    ImageView imageView7_5;
    @FXML
    ImageView imageView7_6;
    @FXML
    ImageView imageView7_7;
    @FXML
    ImageView imageView7_8;
    @FXML
    ImageView imageView7_9;
    @FXML
    ImageView imageView7_10;
    @FXML
    ImageView imageView7_11;
    @FXML
    ImageView imageView7_12;
    @FXML
    ImageView imageView7_13;
    @FXML
    ImageView imageView7_14;
    @FXML
    ImageView imageView7_15;
    @FXML
    ImageView imageView7_16;
    @FXML
    ImageView imageView7_17;
    @FXML
    ImageView imageView7_18;
    @FXML
    ImageView imageView7_19;
    @FXML
    ImageView imageView8_0;
    @FXML
    ImageView imageView8_1;
    @FXML
    ImageView imageView8_2;
    @FXML
    ImageView imageView8_3;
    @FXML
    ImageView imageView8_4;
    @FXML
    ImageView imageView8_5;
    @FXML
    ImageView imageView8_6;
    @FXML
    ImageView imageView8_7;
    @FXML
    ImageView imageView8_8;
    @FXML
    ImageView imageView8_9;
    @FXML
    ImageView imageView8_10;
    @FXML
    ImageView imageView8_11;
    @FXML
    ImageView imageView8_12;
    @FXML
    ImageView imageView8_13;
    @FXML
    ImageView imageView8_14;
    @FXML
    ImageView imageView8_15;
    @FXML
    ImageView imageView8_16;
    @FXML
    ImageView imageView8_17;
    @FXML
    ImageView imageView8_18;
    @FXML
    ImageView imageView8_19;
    @FXML
    ImageView imageView9_0;
    @FXML
    ImageView imageView9_1;
    @FXML
    ImageView imageView9_2;
    @FXML
    ImageView imageView9_3;
    @FXML
    ImageView imageView9_4;
    @FXML
    ImageView imageView9_5;
    @FXML
    ImageView imageView9_6;
    @FXML
    ImageView imageView9_7;
    @FXML
    ImageView imageView9_8;
    @FXML
    ImageView imageView9_9;
    @FXML
    ImageView imageView9_10;
    @FXML
    ImageView imageView9_11;
    @FXML
    ImageView imageView9_12;
    @FXML
    ImageView imageView9_13;
    @FXML
    ImageView imageView9_14;
    @FXML
    ImageView imageView9_15;
    @FXML
    ImageView imageView9_16;
    @FXML
    ImageView imageView9_17;
    @FXML
    ImageView imageView9_18;
    @FXML
    ImageView imageView9_19;
}
