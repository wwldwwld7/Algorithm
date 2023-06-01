import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);

		int[][] dp = new int[K+1][N+1];
		dp[0][0]=1;
		for(int i=1 ; i<=K ; i++) {
			for(int j=0 ; j<=N ; j++) {
				for(int l=0 ; l<=j ; l++) {
					dp[i][j] += dp[i-1][j-l];
					dp[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(dp[K][N]);
	}
}