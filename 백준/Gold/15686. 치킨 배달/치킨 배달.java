import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N, M, result;
	static int[][] map;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); //크기
		M = Integer.parseInt(str[1]); //최대 치킨집 개수
		map = new int[N][N];
		list = new ArrayList<>();
		for(int i=0 ; i<N ; i++) {
			String[] str2 = br.readLine().split(" ");
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				if(map[i][j]==2) {
					list.add(new int[] {i, j});
					map[i][j]=-1;
				}
				else if(map[i][j]==1) map[i][j] = Integer.MAX_VALUE;
			}
		} //입력 끝
		
		boolean[] chickenVisited = new boolean[list.size()];
		result = Integer.MAX_VALUE;
		chicken(0, 0, chickenVisited);
		System.out.println(result);
	}
	static void chicken(int cnt, int chicken, boolean[] chickenVisited) {
		if(cnt==M) {
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(map[i][j]>0) {
						for(int k=0 ; k<list.size() ; k++) {
							if(chickenVisited[k]) {
								map[i][j] = Math.min(map[i][j], Math.abs(list.get(k)[0]-i)+Math.abs(list.get(k)[1]-j));
							}
						}
					}
				}
			}
			int sum=0;
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(map[i][j]>0) {
						sum += map[i][j];
						map[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			result = Math.min(result, sum);
			return;
		}
		for(int i=chicken ; i<list.size() ; i++) {
				chickenVisited[i] = true;
				chicken(cnt+1, i+1, chickenVisited);
				chickenVisited[i] = false;
		}
	}
}