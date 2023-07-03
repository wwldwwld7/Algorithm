import java.io.*;
import java.util.*;

public class Main {
	static int N, X;
	static int[] go, back, dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2]); //파티장소
		List<int[]> list[] = new ArrayList[N+1];
		for(int i=1 ; i<=N ; i++) {
			list[i] = new ArrayList<int[]>();
		}
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0 ; i<M ; i++) {
			str = br.readLine().split(" ");
			list[Integer.parseInt(str[0])].add(new int[] {Integer.parseInt(str[1]), Integer.parseInt(str[2])});
		}//입력끝
		
		go = new int[N+1];
		back = new int[N+1];
		for(int j=1 ; j<=N ; j++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(j, list);
		} //X의 집에 갈 때
//		System.out.println(Arrays.toString(go));
//		System.out.println(Arrays.toString(back));
		
		int max=0;
		for(int i=1 ; i<=N ; i++) {
			if(go[i]+back[i] > max) {
				max = go[i]+back[i];
			}
		}
		System.out.println(max);
	}
	static void dijkstra(int start, List<int[]> list[]) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1] - o2[1];
		});
		boolean[] visited = new boolean[N+1];
		pq.add(new int[] {start, 0});
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int cur = temp[0];
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(int[] next : list[cur]) {
				if(dist[next[0]] > dist[cur]+next[1]) {
					dist[next[0]] = dist[cur]+next[1];
					pq.add(new int[] {next[0], dist[next[0]]});
				}
			}
			
		}
		
		if(start==X) {
			for(int i=1 ; i<=N ; i++) {
				back[i] = dist[i];
			}
		}
		go[start] = dist[X];
	}
}