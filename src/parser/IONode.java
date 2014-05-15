package parser;

public class IONode {

	private String IONodeName;
	private String IONodeType;
	
	
	public IONode(String iONodeName, String iONodeType) {
		super();
		IONodeName = iONodeName;
		IONodeType = iONodeType;
	}
	
	public IONode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIONodeName() {
		return IONodeName;
	}
	public void setIONodeName(String iONodeName) {
		IONodeName = iONodeName;
	}
	public String getIONodeType() {
		return IONodeType;
	}
	public void setIONodeType(String iONodeType) {
		IONodeType = iONodeType;
	}

}
