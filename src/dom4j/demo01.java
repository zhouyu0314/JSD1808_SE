package dom4j;

//import java.io.File;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;

/**
// * 	  	<dependency>
//		    <groupId>dom4j</groupId>
//		    <artifactId>dom4j</artifactId>
//		    <version>1.6.1</version>
//		</dependency>
 * dom4j的用法详解
 * @author zy
 *
 */
public class demo01 {
	//实例化
//	SAXReader reader = new SAXReader();
//	//读取文件（将文件装入流）
//	Document doc = reader.read(new File("conf/web.xml"));
//	//或者用反射也可以获得流
//	InputStream in = getClass().getClassLoader().getResourceAsStream("smartmvc.xml");
//	//读取配置文件的内容,dom4j会依据xml文件的内容，
//	//构造一棵对应的树。
//	Document doc = reader.read(in);
//	//找出根节点
//	Element root = doc.getRootElement();
//	//找出根节点的所有子节点
//	List<Element> elements = root.elements();
//	//或者可以获取所有指定名字的子节点
//	List<Element> mimeList = root.elements("mime-mapping");
//	//获取子节点里class的值
//	String className = ele.attributeValue("class");
//	//获取子节点的文本内容
//	String key = mimeEle.elementText("extension");
}
