package world;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import world.gui.GUIBorder;
import world.gui.GUIWindow;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	/**	“舞台”，顶层容器	*/
	public static Stage worldStage;
	/**	显示菜单栏	*/
    private BorderPane worldBorder;
    /**	显示内容（背景+人物）以及监听键盘	*/
    private StackPane worldWindow;
    /**	核心世界	*/
    private CoreWorld cWrd;
    /**	对应于WorldWindow.fxml	*/
    private GUIWindow gWin;
    /**	对应于WorldBorder.fxml	*/
    private GUIBorder gFrame;
	
	@Override
	public void start(Stage primaryStage) {
		// 初始化CoreWorld
		cWrd = new CoreWorld();
		cWrd.showWorld();
		try { // 初始化GUI
			primaryStage.setTitle("葫芦娃大战妖怪");
			primaryStage.getIcons().add(new Image("file:img/icon.png"));
			primaryStage.setWidth(Global.winWidth);
			primaryStage.setHeight(Global.winHeight);
			primaryStage.setResizable(false); // 禁止窗口缩放
			worldStage = primaryStage;
			initGUIWorld();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**	初始化GUI	*/
	private void initGUIWorld() {
        try {
	        // 从WorldWindow.fxml加载StackPane
            FXMLLoader windowLoader = new FXMLLoader();
            windowLoader.setLocation(Main.class.getResource("gui/WorldWindow.fxml"));
	        worldWindow = (StackPane)windowLoader.load();
	        // 初始化GUIWindow
	        gWin = (GUIWindow)windowLoader.getController();
	        if (gWin != null)
	        	gWin.setWin(cWrd);
	        else System.out.println("error@Main: 加载GUIWindow失败");

            // 从WorldBorder.fxml加载BorderPane
            FXMLLoader borderLoader = new FXMLLoader();
            borderLoader.setLocation(Main.class.getResource("gui/WorldBorder.fxml"));
            worldBorder = (BorderPane)borderLoader.load();
	        // 初始化GUIBorder
	        gFrame = (GUIBorder)borderLoader.getController();
	        if (gFrame != null)
	        	gFrame.setWin(gWin);
	        else System.out.println("error@Main: 加载GUIBorder失败");
	        
	        // 显示worldWindow内的场景
	        worldBorder.setCenter(worldWindow);
            // 显示worldBorder内的场景
            Scene scene = new Scene(worldBorder);
            worldStage.setScene(scene);
            worldStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**	显示打开文件的文件选择器	*/
	public static File showOpenXMLChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("打开战斗记录");
		fileChooser.setInitialDirectory(new File(Global.defaultPath)); // 默认路径
        FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(xmlFilter); // 文件类型限制
        File xmlFile = fileChooser.showOpenDialog(worldStage);
        //System.out.println(xmlFile.getPath());
        return xmlFile;
	}

	/**	显示保存文件的文件选择器	*/
	public static File showSaveXMLChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("保存战斗记录至");
		fileChooser.setInitialDirectory(new File(Global.defaultPath)); // 默认路径
        FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(xmlFilter); // 文件类型限制
        File xmlFile = fileChooser.showSaveDialog(worldStage);
        //System.out.println(xmlFile.getPath());
        return xmlFile;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
