import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //도감에 수록되어 있는 포켓몬의 개수
		int M = Integer.parseInt(str[1]); //내가 맞춰야 하는 문제 개수
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		for(int i=0 ; i<N ; i++) {
			String name = br.readLine();
			map.put(i+1, name);
			map2.put(name, i+1);
		}
		for(int tc=0 ; tc<M ; tc++) {
			String pb = br.readLine();
			if(pb.charAt(0)=='1' || pb.charAt(0)=='2' || pb.charAt(0)=='3' || pb.charAt(0)=='4' || pb.charAt(0)=='5' || pb.charAt(0)=='6' || pb.charAt(0)=='7' || pb.charAt(0)=='8' || pb.charAt(0)=='9') {
				System.out.println(map.get(Integer.parseInt(pb)));
			}
			else{
				System.out.println(map2.get(pb));
			}
		}
	}
}