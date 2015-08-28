
import java.io.*;
import java.util.Properties;
public class DemoResources {
	
	@SuppressWarnings("unused")
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
	private InputStream getResources(){
		
		InputStream inputStream = getClass().getResourceAsStream("/resources/config.properties");
		//String s =getStringFromInputStream(inputStream);
		
		return inputStream;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DemoResources obj = new DemoResources();
		Properties prop = new Properties();
		
		try{
		InputStream inputStream = 	obj.getResources();
		prop.load(inputStream);
		obj.getResources();
		System.out.println(prop.getProperty("HOST"));
		System.out.println(prop.getProperty("RABBIT_QUEUE"));
	}
	catch(IOException e){
		e.printStackTrace();
		
	}
	}

}
