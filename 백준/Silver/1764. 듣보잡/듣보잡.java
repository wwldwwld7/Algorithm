import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		Set<String> set = new HashSet<>();
		List<String> result = new ArrayList<String>();
		for(int i=0 ; i<N ; i++) {
			set.add(br.readLine());
		}
		for(int i=0 ; i<M ; i++) {
			String temp = br.readLine();
			if(set.contains(temp)) {
				result.add(temp);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0 ; i<result.size() ; i++) {
			System.out.println(result.get(i));
		}
	}
}