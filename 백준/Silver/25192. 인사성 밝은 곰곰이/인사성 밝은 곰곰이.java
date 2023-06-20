import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int cnt=0;
		for(int i=0 ; i<N ; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				set.clear();
				continue;
			}
			if(!set.contains(str)) {
				set.add(str);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}