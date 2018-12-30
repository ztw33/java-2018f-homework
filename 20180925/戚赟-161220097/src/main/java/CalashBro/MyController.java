package CalashBro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;

public class MyController implements Initializable {

    @FXML
    private Canvas mycanvas;
    @FXML
    private MenuBar mymenu;
    @FXML
    private MenuItem change;
    private int i;
    private Confront confront;

    public void initialize(URL location, ResourceBundle resources) {
        //进行初始化操作

        confront = new Confront(); //开始新的战斗
        confront.initGrandfather();
        confront.initMonster();
        confront.initHuluwa();
        i = 0;
        confront.printThefield(this.mycanvas);
    }

    public void set_queue(ActionEvent event) {
        //进行初始化操作
        this.mycanvas.getGraphicsContext2D().clearRect(0,0,1000,500);
        confront.makeChangeofMonster(FormationName.values()[i]);
        confront.printThefield(this.mycanvas);
        i++;
        i = i % 8;
    }

}