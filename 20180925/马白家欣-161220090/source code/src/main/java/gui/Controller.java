package gui;


import battle.BattleCoordinator;
import battle.BattleFieldLattice;
import battle.BattleGoOn;
import common.CartoonTransition;
import common.CommonMath;
import common.Delay;
import formation.FormationType;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    /*常量*/
    public static final String BACKGROUND_IMAGE_PATH = "/background.jpg";
    public static final int FIELD_WIDTH = 20;
    public static final int FIELD_HEIGHT = 15;
//    public static final int DELAY_TIME = 500;
    public static final Color LATTICE_FILL_COLOR = Color.rgb(200, 200, 200, 0.5);
    public static final Color LATTICE_STROKE_COLOR = Color.BLACK;
//    public final static double LATTICE_STROKE_WIDTH = 3;
    /*FXML相关变量*/
    @FXML
    private Canvas mainCanvas;

    /*private变量*/
    private GraphicsContext mainGraphicsContext;
    private Image backgroundImage;
    private Rectangle backgroundImageRectangle;
    private List<Rectangle> latticeRectangleList;

    /*public方法*/
    @FXML
    public void initialize() {
        this.initGraphicsContext();
        this.initBackground();
        this.initLattice();
    }

    @FXML
    public void buttonStartHandler() {
        this.initialize();
    }

    @FXML
    public void buttonRandomOneHandler() {
        this.buttonStartHandler();
        BattleGoOn battleGoOn = new BattleCoordinator();
        List<BattleFieldLattice> battleFieldLatticeList = battleGoOn.oneRandomFormation();
        this.displayImage(FIELD_HEIGHT, FIELD_WIDTH, battleFieldLatticeList);
    }

    @FXML
    public void buttonFormationHeYiHandler() {
        this.specifiedFormation(FormationType.HeYi);
    }

    @FXML
    public void buttonFormationYanXingHandler() {
        this.specifiedFormation(FormationType.YanXing);
    }

    @FXML
    public void buttonFormationChangSheHandler() {
        this.specifiedFormation(FormationType.ChangShe);
    }

    @FXML
    public void buttonFormationYuLinHandler() {
        this.specifiedFormation(FormationType.YuLin);
    }

    @FXML
    public void buttonFormationFangYuanHandler() {
        this.specifiedFormation(FormationType.FangYuan);
    }

    @FXML
    public void buttonFormationYanYueHandler() {
        this.specifiedFormation(FormationType.YanYue);
    }

    @FXML
    public void buttonFormationFengShiHandler() {
        this.specifiedFormation(FormationType.FengShi);
    }

    @FXML
    public void buttonFormationChongEHandler() {
        this.specifiedFormation(FormationType.ChongE);
    }

//    @FXML
//    public void buttonRandomGroupHandler() {
//        this.buttonStartHandler();
//        BattleGoOn battleGoOn = new BattleCoordinator();
//        List<List<BattleFieldLattice>> formationGroup = battleGoOn.groupRandomFormation();
//        for (int loopCount = 0; loopCount < formationGroup.size(); loopCount++) {
//            List<BattleFieldLattice> battleFieldLatticeList = formationGroup.get(loopCount);
//            this.displayImage(FIELD_HEIGHT, FIELD_WIDTH, battleFieldLatticeList);
//            Delay.delay(DELAY_TIME);
//            this.buttonStartHandler();
//        }
//    }


    /*private方法*/
    private void initBackground() {
        this.backgroundImage = new Image(BACKGROUND_IMAGE_PATH);
        double maxWidthHeightProportion= CommonMath.max(
                this.backgroundImage.getWidth()/this.mainCanvas.getWidth(),
                this.backgroundImage.getHeight()/this.mainCanvas.getHeight());
        this.backgroundImageRectangle = new Rectangle(
                (this.mainCanvas.getWidth() - backgroundImage.getWidth()/maxWidthHeightProportion) / 2,
                (this.mainCanvas.getHeight() - backgroundImage.getHeight()/maxWidthHeightProportion) / 2,
                backgroundImage.getWidth()/maxWidthHeightProportion,
                backgroundImage.getHeight()/maxWidthHeightProportion
        );

        this.mainGraphicsContext.drawImage(backgroundImage,
                this.backgroundImageRectangle.getX(), this.backgroundImageRectangle.getY(),
                this.backgroundImageRectangle.getWidth(), this.backgroundImageRectangle.getHeight());
    }

    private void initGraphicsContext() {
        mainGraphicsContext = mainCanvas.getGraphicsContext2D();
    }

    private void initLattice() {
        this.latticeRectangleList = new ArrayList<>();
        double doubleLatticeSize = (CommonMath.min(
                this.backgroundImageRectangle.getWidth() / FIELD_WIDTH,
                this.backgroundImageRectangle.getHeight() / FIELD_HEIGHT));
        int latticeSize = (int) doubleLatticeSize;
        double halfWidthRedundancy = (this.backgroundImageRectangle.getWidth() - latticeSize * FIELD_WIDTH) / 2;
        double halfHeightRedundancy = (this.backgroundImageRectangle.getHeight() - latticeSize * FIELD_HEIGHT) / 2;
        assert halfWidthRedundancy >= 0 && halfHeightRedundancy >= 0;
        for (int row = 0; row < FIELD_HEIGHT; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                Rectangle rectangle = new Rectangle(
                        this.backgroundImageRectangle.getX() + halfWidthRedundancy + col * latticeSize,
                        this.backgroundImageRectangle.getY() + halfHeightRedundancy + row * latticeSize,
                        latticeSize, latticeSize);
                this.latticeRectangleList.add(rectangle);
                rectangle.setStroke(LATTICE_STROKE_COLOR);
                rectangle.setFill(LATTICE_FILL_COLOR);
                this.drawRectangle(this.mainGraphicsContext, rectangle);
            }
        }
    }

    private void drawRectangle(GraphicsContext gc, Rectangle rect){
        gc.setFill(rect.getFill());
        gc.setStroke(rect.getStroke());
        gc.strokeRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    private void displayImage(int maxRow, int maxCol, List<BattleFieldLattice> battleFieldLatticeList){
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                String imagePath = CartoonTransition.cartoonCharacterToImage(
                        battleFieldLatticeList.get(row * FIELD_WIDTH + col).getCartoonCharacter());
                if (imagePath != "") {
                    Image image = new Image(imagePath);
                    mainGraphicsContext.drawImage(image,
                            this.latticeRectangleList.get(row * FIELD_WIDTH + col).getX(),
                            this.latticeRectangleList.get(row * FIELD_WIDTH + col).getY(),
                            this.latticeRectangleList.get(row * FIELD_WIDTH + col).getWidth(),
                            this.latticeRectangleList.get(row * FIELD_WIDTH + col).getHeight());
                }
            }
        }
    }

    private void specifiedFormation(FormationType formationType) {
        this.buttonStartHandler();
        BattleGoOn battleGoOn = new BattleCoordinator();
        List<BattleFieldLattice> battleFieldLatticeList = battleGoOn.oneSpecifiedFormation(formationType);
        this.displayImage(FIELD_HEIGHT, FIELD_WIDTH, battleFieldLatticeList);
    }
}
