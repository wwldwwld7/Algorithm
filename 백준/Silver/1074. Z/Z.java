import java.io.*;
import java.util.*;

public class Main {
	static int cnt=0;
	static int result=0;
	static int r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		r = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
		int n = (int) Math.pow(2, N);
		Z(n-1, n-1, n);
		System.out.println(result);
	}
	static void Z(int R, int C, int size) {
		if(size==2) {
			if(R-1==r && C-1==c) {
				result += cnt;
				return;
			}
			else if(R-1==r && C==c) {
				result += cnt+1;
				return;
			}
			else if(R==r && C-1==c) {
				result += cnt+2;
				return;
			}
			else if(R==r && C==c) {
				result += cnt+3;
				return;
			}
		}
		if(R-size/2>=r && R-size+1<=r && C-size/2>=c && C-size+1<=c) {
			Z(R-size/2, C-size/2, size/2);
		}
		if(R-size/2>=r && R-size+1<=r && C-size/2<c ) {
			result += (size/2) * (size/2);
			Z(R-size/2, C, size/2);
		}
		if(R-size/2<r && C-size/2>=c && C-size+1<=c) {
			result += (size/2) * (size/2) * 2;
			Z(R, C-size/2, size/2);
		}
		if(R-size/2<r && C-size/2<c) {
			result += (size/2) * (size/2) * 3;
			Z(R, C, size/2);
		}
	}
}