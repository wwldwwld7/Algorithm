import java.util.*;
import java.io.*;
//14500 테트로미노
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //입력 끝

        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                int sum = 0;
                if(j+2<M) { //가로 세개
                    sum = map[i][j] + map[i][j+1] + map[i][j+2];
                    if(j+3<M){ //가로로 4개
                        max = Math.max(max, sum+map[i][j+3]);
                    }
                    if(i+1<N){
                        max = Math.max(max, sum+map[i+1][j]);
                        max = Math.max(max, sum+map[i+1][j+1]);
                        max = Math.max(max, sum+map[i+1][j+2]);
                    }
                    if(i-1>=0){
                        max = Math.max(max, sum+map[i-1][j]);
                        max = Math.max(max, sum+map[i-1][j+1]);
                        max = Math.max(max, sum+map[i-1][j+2]);
                    }
                }
                if(i+2<N){ //세로 세개
                    sum = map[i][j] + map[i+1][j] + map[i+2][j];
                    if(i+3<N){ //가로로 4개
                        max = Math.max(max, sum+map[i+3][j]);
                    }
                    if(j+1<M){
                        max = Math.max(max, sum+map[i][j+1]);
                        max = Math.max(max, sum+map[i+1][j+1]);
                        max = Math.max(max, sum+map[i+2][j+1]);
                    }
                    if(j-1>=0){
                        max = Math.max(max, sum+map[i][j-1]);
                        max = Math.max(max, sum+map[i+1][j-1]);
                        max = Math.max(max, sum+map[i+2][j-1]);
                    }
                }
                if(j+1<M){ //가로 두개
                    sum = map[i][j] + map[i][j+1];
                    if(i+1<N){
                        max = Math.max(max, sum+map[i+1][j]+map[i+1][j+1]);
                        if(j-1>=0) max = Math.max(max, sum+map[i+1][j-1]+map[i+1][j]);
                        if(j+2<M) max = Math.max(max, sum+map[i+1][j+1]+map[i+1][j+2]);
                    }
                }
                if(i+1<N){ //세로 두개
                    sum = map[i][j] + map[i+1][j];
                    if(j+1<M){
                        max = Math.max(max, sum+map[i][j+1]+map[i+1][j+1]);
                        if(i-1>=0) max = Math.max(max, sum+map[i-1][j+1]+map[i][j+1]);
                        if(i+2<N) max = Math.max(max, sum+map[i+1][j+1]+map[i+2][j+1]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}