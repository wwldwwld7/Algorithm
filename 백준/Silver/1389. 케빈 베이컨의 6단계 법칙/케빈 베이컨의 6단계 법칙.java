import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //유저 수
		int M = Integer.parseInt(str[1]); //관계 수
		int[][] fw = new int[N+1][N+1];
		for(int i=0 ; i<N+1 ; i++) {
			for(int j=0 ; j<N+1 ; j++) {
				if(i==j) continue;
				fw[i][j] = 101;
			}
		}
		for(int i=0 ; i<M ; i++) {
			String[] str2 = br.readLine().split(" ");
			int A = Integer.parseInt(str2[0]);
			int B = Integer.parseInt(str2[1]);
			fw[A][B] = 1;
			fw[B][A] = 1;
		}
		for(int k=1 ; k<=N ; k++) {
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					fw[i][j] = Math.min(fw[i][j], fw[i][k]+fw[k][j]);
				}
			}
		}
		int resultIdx=0;
		int min = Integer.MAX_VALUE;
		for(int j=0 ; j<=N ; j++) {
			int sum=0;
			for(int i=0 ; i<=N ; i++) {
				sum += fw[i][j];
			}
			if(min > sum) {
				min = sum;
				resultIdx = j;
			}
		}
		System.out.println(resultIdx);
	}
}