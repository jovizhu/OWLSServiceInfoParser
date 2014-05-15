package parser;

import java.util.ArrayList;
import java.util.Iterator;

import common.Configuration;
import common.ExcelWriter;

public class ServicesParser {
	
	public static ArrayList<ServiceInfo> serviceInfoList = new ArrayList<ServiceInfo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration.load("/Users/jovizhu/Sites/services/1.3/");
		
		Iterator<String> itr = Configuration.serviceList.iterator() ;
		
		while(itr.hasNext())
		{
			String filename = itr.next();
			serviceInfoList.add(ServiceReader.readService(Configuration.servicePath+filename));
		}
		
		ExcelWriter.writer("", serviceInfoList);
	}
	


}
