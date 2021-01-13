import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.DocumentCSS;

public class UsersInfo {

	public static void main(String[] args) throws Exception {
		//
		int i = 0;
		boolean check = false;
		File xmlFile = new File("//home//vaishnavi//Desktop//Web Technology Lab//WT//src//users.xml");
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(xmlFile);
		
		Element element = document.getDocumentElement();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter User Id: ");
		String id = bufferedReader.readLine();
		
		NodeList nodeList = document.getElementsByTagName("user");
		System.out.println("USERS INFORMATION");
		System.out.println("====================================================");
		for(i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element2 = (Element) node;
				if(element2.getElementsByTagName("userId").item(0).getTextContent().equals(id)) {
					System.out.println("User Id: " + element2.getElementsByTagName("userId").item(0).getTextContent());
					System.out.println("User Name: " + element2.getElementsByTagName("userName").item(0).getTextContent());
					System.out.println("User Email: " + element2.getElementsByTagName("userEmail").item(0).getTextContent());
					check = true;
				}
			}
		}
		if(!check) {
			System.out.println("USER NOT FOUND!");
		}
		
		
		
		

	}

}
