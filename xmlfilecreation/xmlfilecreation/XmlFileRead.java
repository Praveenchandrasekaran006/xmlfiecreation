package xmlfilecreation;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;


public class XmlFileRead {

	public static void main(String args[]) throws Exception
	{
		File fr = new File("C:\\Users\\prave\\eclipse-workspace\\xmlfilecreation\\xmlfile1.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(fr);
		
		document.getDocumentElement().normalize();
		System.out.println("The Root element is: " + document.getDocumentElement().getNodeName()); 
		
		NodeList nodeList = document.getElementsByTagName("Bucati");  
		
		for(int i=0; i<nodeList.getLength(); i++)
		{
			Node n = nodeList.item(i);
			System.out.println("The node name is: "+n.getNodeName());
			Element e = (Element) n;
			
			System.out.println("Speed: "+ e.getElementsByTagName("Speed").item(0).getTextContent());
			System.out.println("Colour: "+ e.getElementsByTagName("Colour").item(0).getTextContent());
			
		}
		  
		 
	}
}
