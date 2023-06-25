import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	String str = br.readLine();
        	if(str != null)
        		System.out.println(str);
        	else break;
        }
    }
}