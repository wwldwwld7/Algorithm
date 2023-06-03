import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] loc = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}// 입력 끝 

		Arrays.sort(loc); //가장 왼쪽부터 테이프로 막기 위해 정렬
		int cnt=0;
		boolean[] checked = new boolean[loc[N-1]+1];
		for(int i=0 ; i<N ; i++) {
			if(!checked[loc[i]]) {
				cnt++;
				for(int j=0 ; j<L ; j++) {
					if(loc[i]+j <= loc[N-1])
						checked[loc[i]+j] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}