package world;

/**	
 *	主宰世界的动向，然而是个甩手掌柜
 *
 *	@author Mirror
 *	
 *	@see GUIWindow
 *	@see CharWindow
 */
public class God {
	
	public static void main(String[] args) {
		CharWindow cWin = new CharWindow();
		new GUIWindow(cWin);
	}
}
