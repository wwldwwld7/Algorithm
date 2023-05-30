import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, sheep, wolf;
	static char[][] map;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new char[R][C];
		for(int i=0 ; i<R ; i++) {
			String str2 = br.readLine();
			for(int j=0 ; j<C ; j++) {
				map[i][j] = str2.charAt(j);
			}
		}//입력 끝
		visited = new boolean[R][C];
		
		int resheep=0;
		int rewolf=0;
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {//모든 칸을 돌면서 양이나 늑대가 있으면 dfs시작
				if(!visited[i][j] && map[i][j]=='v') { //늑대 1마리 부터 시작
					sheep=0; wolf=1;
					dfs(i, j);
					if(sheep>wolf) resheep += sheep;
					else rewolf += wolf;
				}
				else if(!visited[i][j] && map[i][j]=='o') { //양 1마리 부터 시작
					sheep=1; wolf=0;
					dfs(i, j);
					if(sheep>wolf) resheep += sheep;
					else rewolf += wolf;
				}
			}
		}
		System.out.println(resheep+" "+rewolf);
	}
	
	static void dfs(int r, int c) {
		visited[r][c]=true;
		for(int d=0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]=='#') continue;
			if(!visited[nr][nc] && map[nr][nc]=='v') {
				wolf++;
				dfs(nr, nc);
			}
			else if(!visited[nr][nc] && map[nr][nc]=='o') {
				sheep++;
				dfs(nr, nc);
			}
			else if(!visited[nr][nc] && map[nr][nc]=='.') dfs(nr, nc);
		}
	}
}