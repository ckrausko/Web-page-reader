import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class HomePageREader {

	public static void main(String[] args) {
		
		
		try{
			Socket socketObject = new Socket("www.yahoo.com", 80);
				try{
					
					OutputStream outStream = socketObject.getOutputStream();
					String str = "GET / HTTP/1.0\n\n";
					outStream.write(str.getBytes());
					InputStream inStream = socketObject.getInputStream();
					Scanner reader = new Scanner(inStream);
					while(reader.hasNextLine()){
						String line = reader.nextLine();
						System.out.println(line);
						
					}
				}finally{
					socketObject.close();
				}
		}catch (Exception e){
			e.printStackTrace();
		}
			

	}

}
