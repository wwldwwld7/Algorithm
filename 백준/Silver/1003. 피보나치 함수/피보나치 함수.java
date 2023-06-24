import java.io.*;
import java.util.*;

public class Main {
	static Integer[][] dp;
	static int N, zero, one;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new Integer[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int tc=0  ; tc<T ; tc++) {
			N = Integer.parseInt(br.readLine());
			Integer[] result = fib(N);
			System.out.println(result[0]+" "+result[1]);
			
		}
	}
	static Integer[] fib(int n) {
		if(dp[n][0]==null || dp[n][1]==null) {
			dp[n][0] = fib(n-1)[0]+fib(n-2)[0];
			dp[n][1] = fib(n-1)[1]+fib(n-2)[1];
		}
		return dp[n];
	}
}