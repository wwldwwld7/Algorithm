import java.io.*;
import java.util.*;

//2573 빙산
public class Main {
	static int N, M;
	static int[][] ice;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ice = new int[N][M];
			int[][] melt = new int[N][M];
			int result = 0;
			int islandCnt = 0;
			int water = 0;

			for(int n=0 ; n<N ; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0 ; m<M ; m++) {
					ice[n][m] = Integer.parseInt(st.nextToken());
					melt[n][m] = ice[n][m];
				}
			}//입력 끝
			
			while(true) {
				//섬 개수 구하기
				islandCnt = 0;
				visited = new boolean[N][M];
				for(int i=1 ; i<N-1 ; i++) {
					for(int j=1 ; j<M-1 ; j++) {
						if(ice[i][j]!=0 && !visited[i][j]) {
							check(i, j);
							islandCnt++;
						}
					}
				}
				if(islandCnt > 1) break;
				
				//녹기
				for(int i=1 ; i<N-1 ; i++) {
					for(int j=1 ; j<M-1 ; j++) {
						if(ice[i][j] != 0) {
							water = 0;
							if(ice[i-1][j] == 0) water++;
							if(ice[i][j-1] == 0) water++;
							if(ice[i+1][j] == 0) water++;
							if(ice[i][j+1] == 0) water++;
							melt[i][j] = water;
						}
					}
				}
				for(int i=1 ; i<N-1 ; i++) {
					for(int j=1 ; j<M-1 ; j++) {
						if(ice[i][j] != 0) {
							ice[i][j] = ice[i][j] - melt[i][j] <= 0 ? 0 : ice[i][j] - melt[i][j];
						}
					}
				}
				result++;
				if(zero()) {
					result = 0;
					break;
				}
			}
			
			System.out.println(result);
	}
	
	public static void check(int r, int c) {
		visited[r][c] = true;
		if(ice[r-1][c]!=0 && !visited[r-1][c]) check(r-1, c);
		if(ice[r][c-1]!=0 && !visited[r][c-1]) check(r, c-1);
		if(ice[r+1][c]!=0 && !visited[r+1][c]) check(r+1, c);
		if(ice[r][c+1]!=0 && !visited[r][c+1]) check(r, c+1);
		return;
	}
	
	public static boolean zero() {
		for(int i=1 ; i<N-1 ; i++) {
			for(int j=1 ; j<M-1 ; j++) {
				if(ice[i][j]!=0) return false;
			}
		}
		return true;
	}
}