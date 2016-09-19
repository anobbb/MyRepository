package ch15.exam04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String path = null;
		Locale currentLocal = Locale.getDefault();
		if(currentLocal == Locale.KOREA){
			path = PropertiesExample.class.getResource("ko.properties").getPath();
			//System.out.println(path);
		} else if(currentLocal == Locale.US){
			path = PropertiesExample.class.getResource("en.properties").getPath();
		}
		
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		
		String apptitle = properties.getProperty("apptitle");
		String btnJoin = properties.getProperty("btnJoin");
		String btnLogin = properties.getProperty("btnLogin");
		String btnCancel = properties.getProperty("btnCancel");
		
		System.out.println(apptitle);
		System.out.println(btnJoin);
		System.out.println(btnLogin);
		System.out.println(btnCancel);
	}
}
