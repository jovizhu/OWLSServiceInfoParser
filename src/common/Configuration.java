package common;

import java.io.File;
import java.util.ArrayList;

public class Configuration {

	public static String servicePath = null;
	public static ArrayList<String> serviceList = new ArrayList <String> ();
	

	public static void load(String servicePath) {
		Configuration.servicePath = servicePath;

		File folder = new File(Configuration.servicePath);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("ServiceFile " + listOfFiles[i].getName());
				serviceList.add(listOfFiles[i].getName());

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

	}
}
