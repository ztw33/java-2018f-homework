package world.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import world.*;
import world.util.*;

/**
 *	实现战斗记录xml文件的导入
 *
 *	@author Mirror
 *
 *	@see #XMLRecordReader(String)
 *	@see #initEntitiesByElement()
 *	@see #setEntityByRound(Entity, int)
 */
public class XMLRecordReader extends XMLRecordStructure {

	/**	文档	*/
	private Document doc = null;
	/**	根元素	*/
	private Element root = null;
	
	/**	构造函数，从文件filename读取	*/
	public XMLRecordReader(String filename) {
		super();
		try {
			// 使用SAXReader读取文档
			SAXReader reader = new SAXReader();
			doc = reader.read(new File(filename));
            System.out.println("读取对战过程自“" + filename + "”");
			// 获取根元素
			root = doc.getRootElement();
			// 初始化entities集合
			initEntitiesByElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**	向entities写入
	 *	从root中解析出所有实体对象初始值（即第0回合）并保存到entities集合	*/
	private void initEntitiesByElement() {
		// 先移除以前entities集合的全部实体
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        // 加入读取的Entity对象
		List<Element> entityEleList = root.elements();
		for (Element entityEle: entityEleList) {
			String istr = entityEle.getName();
			// 截取entityEle的name的后4位
			int i = Integer.parseInt(istr.substring(istr.length() - 4, istr.length()));
			CreatureType ct = toCreatureType(entityEle.attributeValue(ctype));
			int orgr = Integer.parseInt(entityEle.attributeValue(r));
			int orgc = Integer.parseInt(entityEle.attributeValue(c));
			Entity en = new Entity(i, ct, orgr, orgc);
			CoreWorld.entities.put(en.id, en);
		}
		System.out.println("数据读取中 · · · · · · 完成");
		System.out.println("准备回放");
	}
	
	/**	向entity写入
	 *	从root中解析出实体对象entity的第n回合的值并重设	*/
	public void setEntityByRound(Entity en, int n) {
		// 使用此函数需确保entities集合不为空
		Element roundEle = root.element(entity + en.id).element(round + n);
		if (roundEle != null) {
			EntityState st = toEntityState(roundEle.attributeValue(state));
			int pr = Integer.parseInt(roundEle.attributeValue(posr));
			int pc = Integer.parseInt(roundEle.attributeValue(posc));
			int movr = Integer.parseInt(roundEle.attributeValue(dr));
			int movc = Integer.parseInt(roundEle.attributeValue(dc));
			Entity ene = toEnemy(roundEle.attributeValue(enemy));
			boolean w = toBoolean(roundEle.attributeValue(win));
			en.resetEntity(st, pr, pc, movr, movc, ene, w);
			// 判断战斗是否结束
			if (root.element(entity + en.id).element(round + (n + 1)) == null)
				Global.battleEnd = true;
		}
	}
}
