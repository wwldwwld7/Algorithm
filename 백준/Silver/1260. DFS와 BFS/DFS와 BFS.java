import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //정점의 개수
		int M = Integer.parseInt(str[1]); //간선의 개수
		int V = Integer.parseInt(str[2]); //탐색을 시작할 정점 번호
		
		ArrayList<Integer> list[] = new ArrayList[N+1];
		for(int i=0 ; i<N ; i++) {
			list[i+1] = new ArrayList<>();
		}
		for(int i=0 ; i<M ; i++) {
			String[] str2 = br.readLine().split(" ");
			list[Integer.parseInt(str2[0])].add(Integer.parseInt(str2[1]));
			list[Integer.parseInt(str2[1])].add(Integer.parseInt(str2[0]));
		}
		for(int i=1 ; i<=N ; i++) {
			Collections.sort(list[i]);
		}
		boolean[] Dvisited = new boolean[N+1];
		boolean[] Bvisited = new boolean[N+1];
		DFS(list, V, Dvisited);
		System.out.println();
		BFS(list, V, Bvisited);
	}
	
	static void DFS(ArrayList<Integer> list[], int v, boolean[] Dvisited) {
		System.out.print(v+" ");
		Dvisited[v] = true;
		for(int i=0 ; i<list[v].size() ; i++) {
			if(!Dvisited[list[v].get(i)])
				DFS(list, list[v].get(i), Dvisited);
		}
	}
	
	static void BFS(ArrayList<Integer> list[], int v, boolean[] Bvisited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		Bvisited[v] = true;
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num+" ");
			for(int i=0 ; i<list[num].size() ; i++) {
				if(!Bvisited[list[num].get(i)]) {
					q.add(list[num].get(i));
					Bvisited[list[num].get(i)] = true;
				}
			}
		}
	}
}