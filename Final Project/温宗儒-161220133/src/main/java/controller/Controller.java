package controller;
import annotation.AuthorAnno;
import backstage.battleGround.GameType;
import backstage.battleGround.Space;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
@AuthorAnno(time = "2018.12.20",version = "2.0")
public class Controller  {

    @FXML private Pane creaturePane;
    @FXML private Text text;
    @FXML public void initialize(){
        Space.setCreaturePane(creaturePane);
        Space.setText(text);
    }



    //开始游戏，初始化
    public void startGame() throws IOException {
        Space space = Space.getInstance();//初始化space，葫芦娃、蛇精、爷爷就位
        final Stage chooseStage = new Stage();
        chooseStage.setWidth(853);
        chooseStage.setHeight(790);
        chooseStage.setTitle("布置葫芦娃");
        Parent rootTest = FXMLLoader.load(getClass().getResource("../gourdboys.fxml"));
        Scene chooseScene = new Scene(rootTest);
        chooseStage.setScene(chooseScene);
        chooseStage.setResizable(false);
        chooseStage.initModality(Modality.APPLICATION_MODAL);
        final boolean[] initFlag = {true};
        chooseStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                initFlag[0] = false;
            }
        });
        chooseStage.showAndWait();

        if(initFlag[0]){
            space.initialize(GameType.CREATE);
        }

    }

    public void startGameKeyboard(KeyEvent keyEvent) throws IOException {
        if (" ".equals(keyEvent.getCharacter())) {
            startGame();
        } else if ("l".equals(keyEvent.getCharacter())) {
            fileChoose();
        }
    }

    public void fileLoad(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择游戏文件");
        File file = fileChooser.showOpenDialog(stage);
        if(file == null){return;}
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString = reader.readLine();
            String[] chosenString = tempString.split(",");
            checkChosen(chosenString);
            System.out.println(Arrays.toString(chosenString));
            tempString = reader.readLine();
            String[] numbers = tempString.split(",");
            checkMinionsNumber(numbers);
            System.out.println(Arrays.toString(numbers));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        Space.getInstance().initialize(GameType.LOAD);
    }

    private void fileChoose(){
        fileLoad();
    }


    private void error( String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("文件读取错误");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void checkChosen(String[] chosenString){
        boolean chosenFlag[] = new boolean[6];
        if(chosenString.length != 6){
            error("葫芦娃选择出错，文件损坏，请选择正确的文件");
        }else {
            int trueNumber = 0;
            for(int i=0;i<6;i++){
                if(chosenString[i].equals("1")){
                    trueNumber++;
                    chosenFlag[i] = true;
                }else if(!chosenString[i].equals("0")){
                    error("葫芦娃选择出错，文件损坏，请选择正确的文件");
                }
            }
            if(trueNumber!=3){
                error("选择葫芦娃时出错，葫芦娃选中数目不是3，请选择正确的文件");
            }
        }
        GourdboysController.setSelectedGourdboys(chosenFlag);
    }

    private void checkMinionsNumber(String[] numbers) {
        int chosenNum[] = new int[3];
        if(numbers.length != 3){
            error("小怪选择出错，文件损坏，请选择正确的文件");
        }else {
            for(int i=0; i<3; i++){
                int number = Integer.valueOf(numbers[i]);
                if(number >=1 && number<=200){
                    chosenNum[i] = number;
                }else {
                    error("小怪数目范围出错，文件损坏，请选择正确的文件");
                }
            }
        }
        GourdboysController.setMinionsNumber(chosenNum);
    }

}