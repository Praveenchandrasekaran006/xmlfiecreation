package xmlfilecreation;
import java.io.File;
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
public class XmlDemo {
	public static String xmlFileLocation = "C:\\Users\\prave\\eclipse-workspace\\xmlfilecreation\\xmlfile1.xml";
	
	public static void main(String args[]) throws ParserConfigurationException, TransformerException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		Element root = document.createElement("car");
		document.appendChild(root);
		
		//car1		
		Element car_name = document.createElement("Bucati");
		root.appendChild(car_name);
		
		Element speed = document.createElement("Speed");
        speed.appendChild(document.createTextNode("320"));
        car_name.appendChild(speed);
		
        Element colour = document.createElement("Colour");
        colour.appendChild(document.createTextNode("Blue"));
        car_name.appendChild(colour);
		
		
		//car2
		Element car_name1 = document.createElement("Bucati");
		root.appendChild(car_name1);
		
		Element speed1 = document.createElement("Speed");
        speed1.appendChild(document.createTextNode("290"));
        car_name1.appendChild(speed1);
		
        Element colour1 = document.createElement("Colour");
        colour1.appendChild(document.createTextNode("Black"));
        car_name1.appendChild(colour1);
		
		//car3 250 yellow
		Element car_name2 = document.createElement("Bucati");
		root.appendChild(car_name2);
		
		Element speed2 = document.createElement("Speed");
        speed2.appendChild(document.createTextNode("250"));
        car_name2.appendChild(speed2);
		
        Element colour2 = document.createElement("Colour");
        colour2.appendChild(document.createTextNode("Yellow"));
        car_name2.appendChild(colour2);
		
		
		//car4
		Element car_name3 = document.createElement("Bucati");
		root.appendChild(car_name3);
			
		Element speed3 = document.createElement("Speed");
        speed3.appendChild(document.createTextNode("280"));
        car_name3.appendChild(speed3);
		
        Element colour3 = document.createElement("Colour");
        colour3.appendChild(document.createTextNode("Red"));
        car_name3.appendChild(colour3);
		
		    
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        
        StreamResult streamResult = new StreamResult(new File(xmlFileLocation));
        
        transformer.transform(domSource, streamResult);
        
        System.out.println("Done creating XML File");
        
	}
}
