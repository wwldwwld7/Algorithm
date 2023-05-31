import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] ladder;
	static int[][] snake;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //사다리 수
		M = Integer.parseInt(st.nextToken()); //뱀의 수
		ladder = new int[N][2]; //작은수에서 큰수로
		snake = new int[M][2]; //큰수에서 작은수로
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());//출발
			ladder[i][1] = Integer.parseInt(st.nextToken());//도착
		}
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		} //입력 끝
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1]-o2[1];
		});
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[101];
		q.add(new int[] {1, 0}); //[위치, 주사위던진 횟수]
		
		int result=0;
		while(!q.isEmpty()) {
			int[] qq = q.poll();
			int loc = qq[0];
			int cnt = qq[1];

			if(visited[loc]) continue;
			visited[loc] = true;
			
			if(loc==100) {
				result = cnt;
				break;
			}
			
			
			for(int i=1 ; i<=6 ; i++) {
				if(loc+i>100) continue;
				if(ladderCheck(loc+i) != 0)
					q.add(new int[] {ladderCheck(loc+i), cnt+1});
				if(snakeCheck(loc+i) != 0)
					q.add(new int[] {snakeCheck(loc+i), cnt+1});
				if(ladderCheck(loc+i)==0 && snakeCheck(loc+i)==0)
					q.add(new int[] {loc+i, cnt+1});
			}
			
		}
		System.out.println(result);
	}
	static int ladderCheck(int loc) {
		for(int i=0 ; i<N ; i++) {
			if(ladder[i][0]==loc) return ladder[i][1];
		}
		return 0;
	}
	static int snakeCheck(int loc) {
		for(int i=0 ; i<M ; i++) {
			if(snake[i][0]==loc) return snake[i][1];
		}
		return 0;
	}
}