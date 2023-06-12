import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //컴퓨터의 수
		int M = sc.nextInt(); //컴퓨터 쌍의 수
		ArrayList<Integer> list[] = new ArrayList[N+1];
		for(int i=1 ; i<=N ; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=0 ; i<list[num].size() ; i++) {
				if(!visited[list[num].get(i)]) {
					visited[list[num].get(i)] = true;
					q.add(list[num].get(i));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}