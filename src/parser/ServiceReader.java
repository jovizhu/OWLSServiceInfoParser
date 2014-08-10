
package parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class ServiceReader {

	/**
	 * Empty constructor.
	 */
	public ServiceReader() {
	}

	/**
	 * Parses the service file of the owl-description and build an internal data
	 * @return 
	 */
	public static ServiceInfo readService(String fileName) {

		ServiceInfo serviceInfo = new ServiceInfo();
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			File file = new File(fileName);
			System.out.println(file.getPath() + "  " + file.getName() + "  "
					+ file.getAbsolutePath());
			Document doc = docBuilder.parse(file);

			// normalize text representation
			doc.getDocumentElement().normalize();

			// Get the Profile Name
			NodeList listOfProfile = doc
					.getElementsByTagName("profile:Profile");
			Node profileNode = listOfProfile.item(0);
			Element profileElement = (Element) profileNode;

			NodeList serviceNameList = profileElement
					.getElementsByTagName("profile:serviceName");
			Element serviceNameElement = (Element) serviceNameList.item(0);
			NodeList textFNList = serviceNameElement.getChildNodes();
			System.out.println("profile:serviceName : "
					+ ((Node) textFNList.item(0)).getNodeValue().trim());
			serviceInfo.setServiceName(((Node) textFNList.item(0)).getNodeValue().trim());

			NodeList textDescriptionList = profileElement
					.getElementsByTagName("profile:textDescription");
			Element textDescriptionElement = (Element) textDescriptionList
					.item(0);
			textFNList = textDescriptionElement.getChildNodes();
			System.out.println("profile:txtDescription : "
					+ ((Node) textFNList.item(0)).getNodeValue().trim());
			serviceInfo.setServiceDescription(((Node) textFNList.item(0)).getNodeValue().trim());

			// Get the IOPE
			NodeList ListOfOutput = doc.getElementsByTagName("process:Output");

			int totalOutput = ListOfOutput.getLength();

			for (int i=0; i< totalOutput; i++) {
				Node outputNode = ListOfOutput.item(i);
				Element outputElement = (Element) outputNode;

				NodeList outputParameterTypeList = outputElement
						.getElementsByTagName("process:parameterType");
				Element outputParameterTypeElement = (Element) outputParameterTypeList
						.item(0);
				textFNList = outputParameterTypeElement.getChildNodes();
				System.out.println("Output parameterType : "
						+ ((Node) textFNList.item(0)).getNodeValue().trim());
				IONode ioNode = new IONode();
				ioNode.setIONodeType(((Node) textFNList.item(0)).getNodeValue().trim().split("#")[1]);
				serviceInfo.addServiceOutput(ioNode);
			}
			// Get the IOPE
			NodeList ListOfInput = doc.getElementsByTagName("process:Input");

			int totalInput = ListOfInput.getLength();

			for (int i=0; i< totalInput; i++) {

				Node inputNode = ListOfInput.item(i);
				Element inputElement = (Element) inputNode;

				NodeList inputParameterTypeList = inputElement
						.getElementsByTagName("process:parameterType");
				Element inputParameterTypeElement = (Element) inputParameterTypeList
						.item(0);
				textFNList = inputParameterTypeElement.getChildNodes();
				System.out.println("Input parameterType : "
						+ ((Node) textFNList.item(0)).getNodeValue().trim());
				
				IONode ioNode = new IONode();
				ioNode.setIONodeType(((Node) textFNList.item(0)).getNodeValue().trim().split("#")[1]);
				serviceInfo.addServiceInput(ioNode);
			}
			
			// Get the IOPE
			NodeList ListOfLocal = doc.getElementsByTagName("process:Local");

			int totalLocal = ListOfLocal.getLength();

			for (int i=0; i< totalLocal; i++) {

				Node localNode = ListOfLocal.item(i);
				Element localElement = (Element) localNode;

				NodeList inputParameterTypeList = localElement
						.getElementsByTagName("process:parameterType");
				Element inputParameterTypeElement = (Element) inputParameterTypeList
						.item(0);
				textFNList = inputParameterTypeElement.getChildNodes();
				System.out.println("Local parameterType : "
						+ ((Node) textFNList.item(0)).getNodeValue().trim());

				IONode ioNode = new IONode();
				ioNode.setIONodeType(((Node) textFNList.item(0)).getNodeValue().trim().split("#")[1]);
				serviceInfo.addServiceLocal(ioNode);
			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		// System.exit (0);
		return serviceInfo;
	}
}
