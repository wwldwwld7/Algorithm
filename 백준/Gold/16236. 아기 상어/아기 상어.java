import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int[][] map;
	static int N;
	static int result = 0;
	static int size = 2; //처음 아기상어 크기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int startR = 0; int startC = 0;
		for(int i=0 ; i<N ; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] == 9) {
					map[i][j] = 0;
					startR = i;
					startC = j;
				}
			}
		}//입력 끝
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if(o1[2]==o2[2]) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
			else return o1[2]-o2[2];
		});
		q.add(new int[] {startR, startC, 0, 0}); //[2] 물고기 까지 거리, [3] 먹은 물고기 수
		while(!q.isEmpty()) {
			int[] temp = q.poll();
//			visited[temp[0]][temp[1]] = true;
//			System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+"나온다");
			int len = temp[2];
			int eat = temp[3];
			
			if(map[temp[0]][temp[1]] <= size) {
				if(map[temp[0]][temp[1]]<size && map[temp[0]][temp[1]]>0) {
					for(int i=0 ; i<N ; i++) {
						for(int j=0 ; j<N ; j++) {
							visited[i][j] = false;
						}
					}
//					visited = new boolean[N][N];
//					System.out.println(temp[0]+" "+temp[1]+"먹을거");
					map[temp[0]][temp[1]] = 0;
					eat++;
//						System.out.println(eat+"늘어나나?");
					result += len;
					len=1;
					q.clear();
					if(eat==size) { //아기 상어 크기만큼 먹으면 아기상어++
						size++;
						eat=0;
//						System.out.println(size+"으라차차");
					}
					if(!check()) break;
					
				}
				else {
					len++;
				}
			}			
			
			for(int d=0 ; d<4 ; d++) {
				int nr = temp[0]+dr[d];
				int nc = temp[1]+dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]>size || visited[nr][nc]) continue; 
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, len, eat});
			}
		}
		
		System.out.println(result);
	}
	static boolean check() { //더이상 먹을 물고기 없으면(false) 엄마상어 부르기
		for(int i=0; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(map[i][j] < size && map[i][j] > 0) {
					return true;
				}
			}
		}
		return false;
	}
}