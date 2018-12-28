package controller;

import annotation.AuthorAnno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
@AuthorAnno(time = "2018.12.20",version = "2.0")

public class GourdboysController {
    @FXML private Slider batSlider;
    @FXML private Slider centipedeSlider;
    @FXML private Slider toadSlider;
    @FXML private Text batText;
    @FXML private Text centipedeText;
    @FXML private Text toadText;
    @FXML public CheckBox secondChosen;
    @FXML public CheckBox thirdChosen;
    @FXML public CheckBox fourthChosen;
    @FXML public CheckBox fifthChosen;
    @FXML public CheckBox sixthChosen;
    @FXML public CheckBox seventhChosen;

    private static int selectedGourdboys[] = new int[3];
    private static int batNumber;
    private static int centipedeNumber;
    private static int toadNumber;
    private boolean[] chosen;
    private int chooseNumber;

    @FXML public void initialize(){
        chooseNumber = 0;
        chosen = new boolean[6];
        batNumber = (int)batSlider.getValue();
        centipedeNumber = (int)centipedeSlider.getValue();
        toadNumber = (int)toadSlider.getValue();
        batText.setText(Integer.toString(batNumber));
        centipedeText.setText(Integer.toString(centipedeNumber));
        toadText.setText(Integer.toString(toadNumber));
    }
    //被选择时
    private void checkNumber(int index,CheckBox checkBox){
        if(checkBox.isSelected()){
            chooseNumber++;
            chosen[index] = true;
        }else {
            chooseNumber--;
            chosen[index] = false;
        }
        if(chooseNumber>3){
            chooseNumberOutOfBounds();
            chooseNumber--;
            chosen[index] = false;
            checkBox.setSelected(false);
        }
    }
    //选择超过3个葫芦娃的时候
    private void chooseNumberOutOfBounds() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("葫芦娃选择错误");
        alert.setHeaderText(null);
        alert.setContentText("最多只能选择3个葫芦娃！");
        alert.showAndWait();
    }
    //选择不足3个葫芦娃的时候
    private void chooseNumberLessThanBounds(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("葫芦娃选择错误");
        alert.setHeaderText(null);
        alert.setContentText("大娃孤军奋战很危险，一定要选择三个葫芦娃帮忙！");
        alert.showAndWait();
    }


    public void secondChosen() {
        checkNumber(0,secondChosen);
    }
    public void thirdChosen() {
        checkNumber(1,thirdChosen);
    }
    public void fourthChosen() {
        checkNumber(2,fourthChosen);
    }
    public void fifthChosen() {
        checkNumber(3,fifthChosen);
    }
    public void sixthChosen() {
        checkNumber(4,sixthChosen);
    }
    public void seventhChosen() {
        checkNumber(5,seventhChosen);
    }


    public void gourdBoysChosen() {
        if(chooseNumber < 3){
            chooseNumberLessThanBounds();
        }else {
            int index = 0;
            for (int i = 0; i < 6; i++) {
                if (chosen[i]) {
                    selectedGourdboys[index++] = i+2;
                }
            }
            Stage stage = (Stage) secondChosen.getScene().getWindow();
            stage.close();
        }
    }

    public static int[] getSelectedGourdboys() {
        return selectedGourdboys;
    }
    public static int getBatNumber() {
        return batNumber;
    }
    public static int getCentipedeNumber() {
        return centipedeNumber;
    }
    public static int getToadNumber() {
        return toadNumber;
    }
    static void setSelectedGourdboys(boolean[] chosenFlag){
        int index = 0;
        for (int i = 0; i < 6; i++) {
            if (chosenFlag[i]) {
                selectedGourdboys[index++] = i+2;
            }
        }
    }
    static void setMinionsNumber(int[] chosenNumber){
        batNumber = chosenNumber[0];
        centipedeNumber = chosenNumber[1];
        toadNumber = chosenNumber[2];
    }

    public void centipedeNumberChange() {
        centipedeNumber = (int)centipedeSlider.getValue();
        centipedeText.setText(Integer.toString(centipedeNumber));
    }
    public void toadNumberChange() {
        toadNumber = (int)toadSlider.getValue();
        toadText.setText(Integer.toString(toadNumber));
    }
    public void batNumberChange() {
        batNumber = (int)batSlider.getValue();
        batText.setText(Integer.toString(batNumber));
    }
}
