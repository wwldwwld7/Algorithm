import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, min;
	static int[][] map;
	static int[][] copy;
	static int[] command;
	static boolean[] check;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		K = Integer.parseInt(st.nextToken());
		command = new int[K];
		check = new boolean[K];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		} //입력 끝
		min = Integer.MAX_VALUE;
		list = new ArrayList<int[]>();
		for(int n=0 ; n<K ; n++) { 
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[] {r, c, s});
		}
		perm(0); //수열구하기
		System.out.println(min);
	}

	static void perm(int idx) {
		if(idx == K) {
			rotate(command); //수열 구했으면돌리기
			return;
		}
		for(int i=0 ; i<K ; i++) {
			if(!check[i]) {
				check[i] = true;
				command[idx] = i;
				perm(idx+1);
				check[i] = false;
			}
		}
	}
	
	static void rotate(int[] command) {
		for(int k=0 ; k<K ; k++) {
			int r = list.get(command[k])[0];
			int c = list.get(command[k])[1];
			int s = list.get(command[k])[2];
			for(int q=1 ; q<=s ; q++) { //얘가 s값
				int startR = r-q;
				int startC = c-q;
				int tmp = map[startR+1][startC];
				for(int e=0 ; e<8*q ; e++) {
					int tmp2 = map[startR][startC];
					if(startC == c-q && startR != r+q) {
						map[startR][startC] = tmp;
						if(startR == r-q) startC++;
						else startR--;
					}
					else if(startC == c+q && r != r-q) {
						map[startR][startC] = tmp;
						if(startR == r+q) startC--;
						else startR++;
					}
					else if(startR == r-q && startC != c-q) {
						map[startR][startC] = tmp;
						if(startC == c+q) startR++;
						else startC++;
					}
					else if(startR == r+q && startC != c+q) {
						map[startR][startC] = tmp;
						if(startC == c-q) startR--;
						else startC--;
					}
					tmp = tmp2;
				}
			}
		}
		for(int i=0 ; i<N ; i++) {
			int sum = 0;
			for(int j=0 ; j<M ; j++) {
				sum += map[i][j];
			}
			if(min > sum) min = sum;
		}
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = copy[i][j];
			}
		}
		
	}
}