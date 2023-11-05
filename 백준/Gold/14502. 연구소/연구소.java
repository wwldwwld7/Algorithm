import java.util.*;
import java.io.*;

public class Main {
    static int N, M, count, result;
    static int[][] map, copy;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = sc.nextInt();
                copy[i][j] = map[i][j];
            }
        } //입력 끝
        //벽 세개 세워야 함. 1은 벽. 2는 바이러스

        result=0;
        block(0);
        System.out.println(result);
    }
    static void block(int cnt){
        if(cnt==3){
            count=0;
            virus();
            for(int i=0 ; i<N ; i++) {
                for (int j=0 ; j < M; j++) {
                    if(map[i][j] == 0){
                        count++;
                    }
                }
            }
            reset();
            result = Math.max(result, count);
            return;
        }
        for(int i=0 ; i<N ; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    copy[i][j] = 1;
                    block(cnt+1);
                    map[i][j] = 0;
                    copy[i][j] = 0;
                }
            }
        }
    }
    static void virus(){ //바이러스 전파 시작 dfs
        Queue<int[]> q = new LinkedList<>();

        for(int i=0 ; i<N ; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] qq = q.poll();
            for(int d=0 ; d<4 ; d++){
                int nr = qq[0]+dr[d];
                int nc = qq[1]+dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==1 || map[nr][nc]==2) continue;

                if(map[nr][nc] == 0){
                    map[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    static void reset(){
        for(int i=0 ; i<N ; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }
}