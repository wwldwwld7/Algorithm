import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr, result;
	static int L, R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//병합정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} //입력 끝
		result = new int[N];
		L=0;
		R=N-1;
		mergeSort(L, R);
		for(int i=0 ; i<N ; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
	static void mergeSort(int l, int r) {
		if(l>=r) return;
		int mid = (l+r)/2;
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		merge(l, mid, r);
	}
	static void merge(int l, int mid, int r) {
		int idx = l;
		int L = l;
		int R = r;
		int m = mid+1;
		while(L<=mid && m<=R) {
			if(arr[L]<=arr[m]) result[idx++] = arr[L++];
			else result[idx++] = arr[m++];
		}
		if(L<=mid) {
			for(int i=L ; i<=mid ; i++) {
				result[idx++] = arr[i];
			}
		}
		else {
			for(int i=m ; i<=R ; i++) {
				result[idx++] = arr[i];
			}
		}
		
		for(int i=l ; i<=r ; i++) {
			arr[i] = result[i];
		}
	}
}