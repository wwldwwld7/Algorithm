import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i=0 ; i<N ; i++) {
        	arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[0]*arr[N-1]);
    }
}