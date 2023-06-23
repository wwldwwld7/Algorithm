import java.io.*;
import java.util.*;


public class Main {
	public static class node{
		public String data;
		public String left;
		public String right;
		public node() {
		}
	}
	
	static int N;
	static node[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new node[N];
		for(int i=0 ; i<N ; i++) {
			tree[i] = new node();
			String[] str = br.readLine().split(" ");
			tree[i].data = str[0];
			tree[i].left = str[1];
			tree[i].right = str[2];
		}
		
		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");
		
	}
	static void preOrder(String root) {
		for(int i=0 ; i<N ; i++) {
			if(tree[i].data.equals(root)) {
				System.out.print(root);
				preOrder(tree[i].left);
				preOrder(tree[i].right);
				break;
			}
		}
	}
	static void inOrder(String root) {
		for(int i=0 ; i<N ; i++) {
			if(tree[i].data.equals(root)) {
				inOrder(tree[i].left);
				System.out.print(root);
				inOrder(tree[i].right);
				break;
			}
		}
	}
	static void postOrder(String root) {
		for(int i=0 ; i<N ; i++) {
			if(tree[i].data.equals(root)) {
				postOrder(tree[i].left);
				postOrder(tree[i].right);
				System.out.print(root);
				break;
			}
		}
	}
}