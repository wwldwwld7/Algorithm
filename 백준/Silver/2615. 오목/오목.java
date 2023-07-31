import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//검1, 흰2, 없0
		int[][] A = new int[19][19];
		for(int i=0 ; i<19 ; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0 ; j<19 ; j++) {
				A[i][j] = Integer.parseInt(str[j]);
			}
		}
		int[] dr = {0, 1, 1, 1}; //가로 세로 오아래 왼아래
		int[] dc = {1, 0, 1, -1};
		int cnt=0;
		int win=0;
		int row=-1;
		int column = -1;
		//가로
		for(int i=0 ; i<19 ; i++) {
			for(int j=0 ; j<19 ; j++) {
				if(j==0 && (A[i][j]==1 | A[i][j]==2)) { //j가 0일때
					int r=i; int c=j;
					while(c<19 && A[r][c]==A[i][j]) {
						r += dr[0];
						c += dc[0];
						cnt++;
					}
				}else if(j-1>=0 && (A[i][j]==1 | A[i][j]==2) && A[i][j]!=A[i][j-1])	{ //j가 0이 아니고 왼쪽에 같은 바둑돌이 없을 때
					int r=i; int c=j;
					while(c<19 && A[r][c]==A[i][j]) {
						r += dr[0];
						c += dc[0];
						cnt++;
					}
				}
				if(cnt==5) {
					win = A[i][j];
					row=i;
					column=j;
				}
				cnt=0;
			}
		}
		//세로
		for(int i=0 ; i<19 ; i++) {
			for(int j=0 ; j<19 ; j++) {
				if(j==0 && (A[j][i]==1 | A[j][i]==2)) { //j가 0일때
					int r=j; int c=i;
					while(r<19 && A[r][c]==A[j][i]) {
						r += dr[1];
						c += dc[1];
						cnt++;
					}
				}else if(j-1>=0 && (A[j][i]==1 | A[j][i]==2) && A[j][i]!=A[j-1][i])	{ //j가 0이 아니고 왼쪽에 같은 바둑돌이 없을 때
					int r=j; int c=i;
					while(r<19 && A[r][c]==A[j][i]) {
						r += dr[1];
						c += dc[1];
						cnt++;
					}
				}
				if(cnt==5) {
					win = A[j][i];
					row=j;
					column=i;
				}
				cnt=0;
			}
		}
		//오 아래
		for(int i=0 ; i<19 ; i++) {
			for(int j=0 ; j<19 ; j++) {
				if((A[i][j]==1 | A[i][j]==2)) {
					int r=i; int c=j;
					if(i==0 && j==0) {
						while(r<19 && c<19 && A[r][c]==A[i][j]) {
							r += dr[2];
							c += dc[2];
							cnt++;
						}
					}else if(i==0 && j!=0) {
						while(r<19 && c<19 && A[r][c]==A[i][j]) {
							r += dr[2];
							c += dc[2];
							cnt++;
						}
					}else if(i!=0 && j==0) {
						while(r<19 && c<19 && A[r][c]==A[i][j]) {
							r += dr[2];
							c += dc[2];
							cnt++;
						}
					}else if(A[i-1][j-1]!=A[i][j]){
						while(r<19 && c<19 && A[r][c]==A[i][j]) {
							r += dr[2];
							c += dc[2];
							cnt++;
						}
					}
					if(cnt==5) {
						win = A[i][j];
						row=i;
						column=j;
					}
				}
				cnt=0;
			}
		}
		//왼 아래
		for(int i=0 ; i<19 ; i++) {
			for(int j=0 ; j<19 ; j++) {
				if((A[i][j]==1 | A[i][j]==2)) {
					int r=i; int c=j;
					if(i==0 && j==18) {
						while(r<19 && c>=0 && A[r][c]==A[i][j]) {
							r += dr[3];
							c += dc[3];
							cnt++;
						}
					}else if(i==0 && j!=18) {
						while(r<19 && c>=0 && A[r][c]==A[i][j]) {
							r += dr[3];
							c += dc[3];
							cnt++;
						}
					}else if(i!=0 && j==18) {
						while(r<19 && c>=0 && A[r][c]==A[i][j]) {
							r += dr[3];
							c += dc[3];
							cnt++;
						}
					}else if(A[i-1][j+1]!=A[i][j]){
						while(r<19 && c>=0 && A[r][c]==A[i][j]) {
							r += dr[3];
							c += dc[3];
							cnt++;
						}
					}
					if(cnt==5) {
						win = A[i][j];
						row=i+4;
						column=j-4;
					}
				}
				cnt=0;
			}
		}
		if(win!=0) {
			System.out.println(win);
			System.out.println((row+1)+" "+(column+1));		
		}else System.out.println(win);
	}
}