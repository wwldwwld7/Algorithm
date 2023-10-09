import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보드의 크기
		int[][] map = new int[N][N];
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 사과의 총 개수
		for (int i = 0; i < K; i++) { // map이 1이면 사과있음
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken()); // 총 방향 전환 횟수
		int a = 0;
		int b = 1; // 처음에는 오른쪽으로
		map[0][0] = 3; // 3은 뱀의 몸
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 0, 0 });
		int[] head = { 0, 0 };
		int[] tail = { 0, 0 };
		int cnt = 0;
		int Lcnt=0;
		outer: while (true) {
			Lcnt++;
			int n = cnt+1;
			if (Lcnt<=L) {
				// 반시계 회전 (a,b) -> (-b,a)
				// 시계 회전 (a,b) -> (b,-a)
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
			}
			int c = cnt;
			for (int j = 0; j < n - c; j++) {
				cnt++;
				head[0] += a;
				head[1] += b;
				list.add(new int[] { head[0], head[1] });
				if (head[0] < 0 || head[0] >= N || head[1] < 0 || head[1] >= N || map[head[0]][head[1]] == 3)
					break outer;
				if(map[head[0]][head[1]] == 0) {
					map[tail[0]][tail[1]] = 0;
					list.remove(0);
					tail[0] = list.get(0)[0];
					tail[1] = list.get(0)[1];
				}
				map[head[0]][head[1]] = 3;
			}
			if (Lcnt<=L) {
				if (st.nextElement().equals("L")) {
					int tmp = a;
					a = -b;
					b = tmp;
				} else {
					int tmp = a;
					a = b;
					b = -tmp;
				}
			}
		}
		System.out.println(cnt);
	}
}