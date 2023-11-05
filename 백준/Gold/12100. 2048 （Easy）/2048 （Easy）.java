import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int N;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        five(0);

        System.out.println(result);
    }
    static void five(int cnt){
        if(cnt==5){
            int max=0;
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if(map[i][j] >= max) max = map[i][j];
                }
            }
            result = Math.max(result, max);
            return;
        }
        int[][] copy = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                copy[i][j] = map[i][j];
            }
        }
        for(int d=0 ; d<4 ; d++){
            move(d);
            five(cnt+1);
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    map[i][j] = copy[i][j];
                }
            }
        }
    }
    static void move(int dir){
        int idx=0;
        int num=0;
        switch (dir){
            case 0: //위로
                for(int j=0 ; j<N ; j++){
                    idx = 0;
                    num = 0;
                    for(int i=0 ; i<N ; i++){
                        if(map[i][j]!=0){
                            if(num == map[i][j]){
                                map[i][j] = 0;
                                map[idx-1][j] = num * 2;
                                num = 0;
                            }
                            else{
                                num = map[i][j];
                                map[i][j] = 0;
                                map[idx][j] = num;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 1: //아래로
                for(int j=0 ; j<N ; j++){
                    idx = N-1;
                    num = 0;
                    for(int i=N-1 ; i>=0 ; i--){
                        if(map[i][j]!=0){
                            if(num == map[i][j]){
                                map[i][j] = 0;
                                map[idx+1][j] = num * 2;
                                num = 0;
                            }
                            else{
                                num = map[i][j];
                                map[i][j] = 0;
                                map[idx][j] = num;
                                idx--;
                            }
                        }
                    }
                }
                break;
            case 2: //왼쪽으로
                for(int i=0 ; i<N ; i++){
                    idx = N-1;
                    num = 0;
                    for(int j=N-1 ; j>=0 ; j--){
                        if(map[i][j]!=0){
                            if(num == map[i][j]){
                                map[i][j] = 0;
                                map[i][idx+1] = num * 2;
                                num = 0;
                            }
                            else{
                                num = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = num;
                                idx--;
                            }
                        }
                    }
                }
                break;
            case 3: //오른쪽으로
                for(int i=0 ; i<N ; i++){
                    idx = 0;
                    num = 0;
                    for(int j=0 ; j<N ; j++){
                        if(map[i][j]!=0){
                            if(num == map[i][j]){
                                map[i][j] = 0;
                                map[i][idx-1] = num * 2;
                                num = 0;
                            }
                            else{
                                num = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = num;
                                idx++;
                            }
                        }
                    }
                }
                break;

        }
    }
}