package world.xml;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import world.*;

/**
 *	实现战斗记录xml文件的导出
 *
 *	@author Mirror
 *
 *	@see #XMLRecordWriter()
 *	@see #addEntityElements()
 *	@see #addRoundElements(int)
 */
public class XMLRecordWriter extends XMLRecordStructure {
	
	/**	文档	*/
	private Document doc = null;
	/**	根元素	*/
	private Element root = null;
	
	public XMLRecordWriter() {
		super();
		// 创建一个Document对象表示一个空文档
		doc = DocumentHelper.createDocument();
		if (root != null)
			removeAll();
		root = doc.addElement(records);
	}

	/**	删除根节点以下所有节点	*/
	private void removeAll() {
		List<Element> entityEleList = root.elements();
		for (Element entityEle: entityEleList) {
			root.remove(entityEle);
		}
	}
	
	/**	从entities读出
	 *	暂时存储entities集合初始值（即第0回合）	*/
	public void addEntityElements() {
		// 先清空临时存储区
		removeAll();
		// 遍历entities并存储
		for (Entity en: CoreWorld.entities.values()) {
			Element entityEle = root.addElement(entity + en.id);
			entityEle.addAttribute(ctype, en.creature.getType().label);
			entityEle.addAttribute(r, String.valueOf(en.position.row()));
			entityEle.addAttribute(c, String.valueOf(en.position.col()));
		}
	}
	
	/**	从entities读出
	 *	暂时存储第n回合结束后entities集合的值	*/
	public void addRoundElements(int n) {
		// 遍历entities并存储
		for (Entity en: CoreWorld.entities.values()) {
			Element roundEle = root.element(entity + en.id).addElement(round + n);
			roundEle.addAttribute(state, en.state.label);
			roundEle.addAttribute(posr, String.valueOf(en.position.row()));
			roundEle.addAttribute(posc, String.valueOf(en.position.col()));
			roundEle.addAttribute(dr, String.valueOf(en.direction.row()));
			roundEle.addAttribute(dc, String.valueOf(en.direction.col()));
			roundEle.addAttribute(enemy, toEntityLabel(en.enemy));
			roundEle.addAttribute(win, toBooleanLabel(en.hasWined));
		}
	}
	
	/**	保存至文件filename	*/
	public void saveRecord(String filename) {
		try{
			// 创建XmlWriter对象
            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            FileOutputStream fos = new FileOutputStream(filename);
            writer.setOutputStream(fos);
            // 导出
            writer.write(doc);
            System.out.println("对战过程保存至“" + filename + "”");
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
	}
}
