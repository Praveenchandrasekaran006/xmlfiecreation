package xmlfilecreation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


class CarDetails
{
	String speed;
	String colour;
	public void setValue(String speed,String colour)
	{
		this.speed = speed;
		this.colour = colour;
	}
	public String getValueSpeed()
	{
		return this.speed;
	}
	public String getValueColour()
	{
		return this.colour;
	}
}

public class XmlFileRead extends CarDetails {

	public static void main(String args[]) throws Exception
	{
		File fr = new File("C:\\Users\\prave\\git\\xmlfilecreation\\xmlfilecreation\\xmlfile1.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(fr);
		
		document.getDocumentElement().normalize();
		//System.out.println("The Root element is: " + document.getDocumentElement().getNodeName()); 
		
		
		NodeList nodeList = document.getElementsByTagName("Bucati");  
		
		List<CarDetails> l = new ArrayList<CarDetails>();
		
		for(int i=0; i<nodeList.getLength(); i++)
		{
			Node n = nodeList.item(i);
			Element e = (Element) n;
			
			CarDetails cd = new CarDetails();
			cd.setValue(e.getElementsByTagName("Speed").item(0).getTextContent(),e.getElementsByTagName("Colour").item(0).getTextContent());
			l.add(cd);		
		}
		
		for(int i=0; i<l.size(); i++)
		{
			System.out.println("The value of car "+(i+1)+" is: ");
			System.out.println("Speed: "+l.get(i).getValueSpeed());
			System.out.println("Colour: "+l.get(i).getValueColour());
		}
		
	}
}
