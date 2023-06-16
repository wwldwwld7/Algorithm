import java.io.*;
//import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int len = 2*N-1; //한 줄의 길이
		char[][] arr = new char[N][len];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<len ; j++) {
				arr[i][j] = ' ';
			}
		}
		Star(0, len/2, N, arr);
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<2*N-1 ; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void Star(int r, int c, int N, char[][] arr) {
		if(N==3) {
			arr[r][c] = '*'; //별 하나
			arr[r+1][c-1] = arr[r+1][c+1] = '*'; //별 둘
			arr[r+2][c-2]=arr[r+2][c-1]=arr[r+2][c]=arr[r+2][c+1]=arr[r+2][c+2]='*'; //별 다섯
			return;
		}else {
			Star(r, c, N/2, arr); //위에 삼각형
			Star(r+N/2, c-N/2, N/2, arr); //아래 왼쪽
			Star(r+N/2, c+N/2, N/2, arr); //아래 왼쪽
		}
	}
}