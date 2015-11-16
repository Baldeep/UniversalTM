import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TMReader {
	
	public static String readTM(File f) throws FileNotFoundException{
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		Scanner sc = new Scanner(br);
		
		String in = sc.next();
		System.out.println(in);
		
		return in;
	}
}
