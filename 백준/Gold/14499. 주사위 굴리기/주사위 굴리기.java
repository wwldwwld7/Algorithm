import java.util.*;
import java.io.*;
//14499 주사위굴리기
public class Main {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dice = new int[6];
        //   0
        // 2 1 3
        //   5
        //   4
        int[][] map = new int[N][M]; //  서2 북3 동1 남4
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int e = 3;
        int w = 2;
        int n = 0;
        int s = 5;
        int up = 1;
        int down = 4;
        st = new StringTokenizer(br.readLine());
        for(int k=0 ; k<K ; k++){
            int dir = Integer.parseInt(st.nextToken())-1;
            int tmp = -1;
            if(r+dr[dir]>=N || r+dr[dir]<0 || c+dc[dir]>=M || c+dc[dir]<0) continue;
            r += dr[dir];
            c += dc[dir];
            if(dir == 0){ // 동
                tmp = e;
                e = up;
                up = w;
                w = down;
                down = tmp;
            }
            else if(dir == 1){ //서
                tmp = w;
                w = up;
                up = e;
                e = down;
                down = tmp;
            }
            else if(dir ==2){ //북
                tmp = n;
                n = up;
                up = s;
                s = down;
                down = tmp;
            }
            else{ //남
                tmp = s;
                s = up;
                up = n;
                n = down;
                down = tmp;
            }
            if(map[r][c] == 0){
                map[r][c] = dice[down];
            }else{
                dice[down] = map[r][c];
                map[r][c] = 0;
            }
            System.out.println(dice[up]);
        }

    }
}