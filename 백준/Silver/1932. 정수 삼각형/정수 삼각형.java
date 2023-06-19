import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=1 ; i<=N ; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0 ; j<i ; j++) {
				arr[i-1][j] = Integer.parseInt(str[j]);
				if(i-2>=0) {
					if(j==0) {
						arr[i-1][j] += arr[i-2][0];
					}
					else if(j==i-1) {
						arr[i-1][j] += arr[i-2][i-2];
					}
					else
						arr[i-1][j] += Math.max(arr[i-2][j-1], arr[i-2][j]);
				}
			}
		} //입력 끝
		int result = 0;
		for(int i=0 ; i<N ; i++) {
			if(arr[N-1][i] > result) result = arr[N-1][i];
		}
		System.out.println(result);
	}
}